package ro.code4.expertconsultation.utils;

import ro.code4.expertconsultation.utils.factory.*;

public class FactoryManager {

    public static String DATE_TIME = "2021-09-04T13:38:44.173941700";

    public static String TEST_TEXT = "test";

    public static CommentFactory commentFactory = new CommentFactory();

    public static DocumentBlockFactory documentBlockFactory = new DocumentBlockFactory();

    public static DocumentFactory documentFactory = new DocumentFactory();

    public static OrganizationFactory organizationFactory = new OrganizationFactory();

    public static UserFactory userFactory = new UserFactory();


}
