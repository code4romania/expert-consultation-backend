package ro.code4.expertconsultation.storage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.code4.expertconsultation.core.exception.ExpertConsultationException;
import ro.code4.expertconsultation.core.model.I18nMessage;
import ro.code4.expertconsultation.storage.service.StorageApi;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@Profile("dev")
public class FilesystemStorageService implements StorageApi {

    @Value("${storage.filesystem.directory}")
    private String customStoreDirPath;

    private File storeDir;

    @PostConstruct
    private void prepareStoreDir() {
        final String home = System.getProperty("user.home");
        storeDir = new File(home, customStoreDirPath);
        if (!storeDir.exists()) {
            if (!storeDir.mkdir()) {
                log.error("Unable to create directory, could be a permission issue: {}", storeDir.getName());
            }
        }
    }

    @Override
    public String storeFile(final MultipartFile document) throws IOException, IllegalStateException {
        // add a random string to each file in order to avoid duplicates
        final String fileName = StorageApi.resolveUniqueName(document);
        final Path filepath = Paths.get(storeDir.getAbsolutePath(), fileName);
        try {
            document.transferTo(filepath);
        } catch (IOException | IllegalStateException exception) {
            log.error("Error saving file to filesystem {}", fileName, exception);
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage("storage.upload.failed"))
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
        return filepath.toString();
    }

    @Override
    public byte[] loadFile(final String documentURI) {
        try {
            return Files.readAllBytes(Paths.get(documentURI));
        } catch (IOException e) {
            log.error("Loading file: {} failed.", documentURI, e);
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage("storage.load.failed"))
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @Override
    public void deleteFile(String documentURI) {
        try {
            Files.delete(Paths.get(documentURI));
        } catch (IOException e) {
            log.error("Deleting file: {} failed.", documentURI, e);
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage("storage.delete.failed"))
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
