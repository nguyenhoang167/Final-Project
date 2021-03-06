package vn.edu.vnuk.ecommerce.constant;

public class Define {
    public static final Long ROLE_ADMIN = 1L;
    public static final String STR_ROLE_ADMIN = "ROLE_ADMIN";

    public static final Long ROLE_NORMAL_USER = 2L;
    public static final String STR_ROLE_NORMAL_USER = "ROLE_NORMAL_USER";

    public static final Long STATUS_ACTIVE_ACCOUNT = 0L;
    public static final Long STATUS_DEACTIVE_ACCOUNT = 1L;
    public static final Long STATUS_DELETED_ACCOUNT = 2L;

    public static final Long TIME_OF_TOKEN = 1209600L;
    public static final Long STATUS_CREATED_TOKEN = 0L;
    public static final Long STATUS_DELETED_TOKEN = 1L;

    public static final String[] EXCLUSION_URL_NEED_FILTER = {
            "/api/login",
            "/api/token"
    };
}
