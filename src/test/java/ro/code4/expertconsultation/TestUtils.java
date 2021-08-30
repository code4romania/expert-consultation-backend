package ro.code4.expertconsultation;

import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.model.persistence.Comment;
import ro.code4.expertconsultation.document.model.DocumentState;
import ro.code4.expertconsultation.document.model.DocumentType;
import ro.code4.expertconsultation.document.model.dto.DocumentBlockDto;
import ro.code4.expertconsultation.document.model.persistence.Document;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.organization.model.OrganizationCategory;
import ro.code4.expertconsultation.organization.model.persistence.Organization;
import ro.code4.expertconsultation.user.model.persistence.User;

import java.sql.Timestamp;
import java.util.List;

public class TestUtils {

    public static String TIMESTAMP = "2021-08-29 10:28:52.1504313";

    public static String TEST_TEXT = "test";

    public Comment getCommentEntity() {

        Comment comment = Comment.builder()
                .content(TEST_TEXT)
                .creationTime(Timestamp.valueOf(TIMESTAMP))
                .documentBlock(getDocumentBlockEntity())
                .author(getUserEntity())
                .build();

        comment.setId(1L);
        return comment;
    }

    public CommentDto getCommentDto() {
        CommentDto commentDto = CommentDto.builder()
                .content(TEST_TEXT) //todo pull this in a constant as well
                .creationTime(Timestamp.valueOf(TIMESTAMP))
                .build();
        commentDto.setId(1L);
        return commentDto;
    }

    public DocumentBlock getDocumentBlockEntity() {

        DocumentBlock documentBlock = DocumentBlock.builder()
                .document(getDocumentEntity())
                .content(TEST_TEXT)
                .index(1)
                .build();

        documentBlock.setId(1L);
        return documentBlock;
    }

    public DocumentBlockDto getDocumentBlockDto() {
        DocumentBlockDto documentBlockDto = DocumentBlockDto.builder()
                .content(TEST_TEXT)
                .index(1)
                .comments(List.of(getCommentDto()))
                .build();

        documentBlockDto.setId(1L);
        return documentBlockDto;
    }

    public Document getDocumentEntity() {
        Document document = Document.builder()
                .state(DocumentState.DRAFT)
                .title(TEST_TEXT)
                .type(DocumentType.LEGE)
                .build();

        document.setId(1L); //todo pull id into constant
        return document;
    }

    public User getUserEntity() {
        User user = User.builder()
                .name("Test User")
                .email("test@test.com")
                .password("$2a$10$x7A2ascdJ1p5/3afgYMbgeyy5dNATmzJWT5xSdOVEJIIRnpQuKchy")
                .phoneNumber("0711111111")
                .organization(getOrganizationEntity())
                .build();

        user.setId(1L);
        return user;
    }

    public Organization getOrganizationEntity() {
        Organization organization = Organization.builder()
                .category(OrganizationCategory.NGO)
                .name("Test Org")
                .build();
        organization.setId(1L);
        return organization;
    }
}
