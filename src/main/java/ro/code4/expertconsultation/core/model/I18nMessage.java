package ro.code4.expertconsultation.core.model;

import lombok.Getter;
import java.util.List;

@Getter
public class I18nMessage {
    private final String i18nKey;
    private final List<String> i18nArgs;

    public I18nMessage(final String i18nKey, List<String> i18nArgs) {
        this.i18nKey = i18nKey;
        this.i18nArgs = i18nArgs;
    }

    public I18nMessage(String i18nKey) {
        this.i18nKey = i18nKey;
        this.i18nArgs = null;
    }
}
