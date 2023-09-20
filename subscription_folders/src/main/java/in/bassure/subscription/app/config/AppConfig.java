package in.bassure.subscription.app.config;

public class AppConfig {

    private final static int SUCCESS = 600;
    private final static int FIELD_VALIDATE = 601;
    private final static int SERVER_SEND_ERROR = 602;
    private final static int GEOFENCING = 603;
    private final static int USER_NOT_FOUND = 604;
    private final static int TOKEN_UPDATE = 605;
    private final static int TIME_OUT = 606;
    private final static int NO_DATA = 607;
    private final static int AUTHORIZE = 608;
    private final static int WRONG_END_POINT = 609;
    private final static int DUPLICATION = 610;
    private final static int SERVER_ERROR = 650;
    private final static int NO_NET_CONN = 651;

    private final static String SUCCESS_MESSAGE = "successfully";
    private final static String SERVER_ERROR_MESSAGE = "something went wrong";
    private final static String FIELD_VALIDATE_MESSAGE = "please check your input";
    private final static String NO_DATA_MESSAGE = "No data found";

    private final static String PRODUCT_NAME_NO_EMPTY_VAL_MES = "product name should not be empty";
    private final static int PRODUCT_NAME_MIN_LEN = 3;
    private final static int PRODUCT_NAME_MAX_LEN = 100;
    private final static String PRODUCT_NAME_LENGTH_VAL_MES = "product name length between 3 and 100";

    private final static String PRODUCT_TYPE_NO_EMPTY_VAL_MES = "prodcut type should not be empty";

    public static String getNO_DATA_MESSAGE() {
        return NO_DATA_MESSAGE;
    }

    private final static int DESC_MIN_LEN = 0;
    private final static int DESC_MAX_LEN = 500;
    private final static String DESC_LEN_VAL_MES = "description should not be more than 500 characters";

    private final static String TENANT_ID_NO_EMPTY_VAL_MES = "tenantId should not be empty";

    private final static String PRODUCT_STATUS_NO_EMPTY_VAL_MES = "status should not be empty";

    public static String getFIELD_VALIDATE_MESSAGE() {
        return FIELD_VALIDATE_MESSAGE;
    }

    public static String getPRODUCT_NAME_NO_EMPTY_VAL_MES() {
        return PRODUCT_NAME_NO_EMPTY_VAL_MES;
    }

    public static int getPRODUCT_NAME_MIN_LEN() {
        return PRODUCT_NAME_MIN_LEN;
    }

    public static int getPRODUCT_NAME_MAX_LEN() {
        return PRODUCT_NAME_MAX_LEN;
    }

    public static String getPRODUCT_NAME_LENGTH_VAL_MES() {
        return PRODUCT_NAME_LENGTH_VAL_MES;
    }

    public static String getPRODUCT_TYPE_NO_EMPTY_VAL_MES() {
        return PRODUCT_TYPE_NO_EMPTY_VAL_MES;
    }

    public static int getDESC_MIN_LEN() {
        return DESC_MIN_LEN;
    }

    public static int getDESC_MAX_LEN() {
        return DESC_MAX_LEN;
    }

    public static String getDESC_LEN_VAL_MES() {
        return DESC_LEN_VAL_MES;
    }

    public static String getTENANT_ID_NO_EMPTY_VAL_MES() {
        return TENANT_ID_NO_EMPTY_VAL_MES;
    }

    public static String getPRODUCT_STATUS_NO_EMPTY_VAL_MES() {
        return PRODUCT_STATUS_NO_EMPTY_VAL_MES;
    }

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public static int getFIELD_VALIDATE() {
        return FIELD_VALIDATE;
    }

    public static int getSERVER_SEND_ERROR() {
        return SERVER_SEND_ERROR;
    }

    public static int getGEOFENCING() {
        return GEOFENCING;
    }

    public static int getUSER_NOT_FOUND() {
        return USER_NOT_FOUND;
    }

    public static int getTOKEN_UPDATE() {
        return TOKEN_UPDATE;
    }

    public static int getTIME_OUT() {
        return TIME_OUT;
    }

    public static int getNO_DATA() {
        return NO_DATA;
    }

    public static int getAUTHORIZE() {
        return AUTHORIZE;
    }

    public static int getWRONG_END_POINT() {
        return WRONG_END_POINT;
    }

    public static int getDUPLICATION() {
        return DUPLICATION;
    }

    public static int getSERVER_ERROR() {
        return SERVER_ERROR;
    }

    public static int getNO_NET_CONN() {
        return NO_NET_CONN;
    }

    public static String getSUCCESS_MESSAGE() {
        return SUCCESS_MESSAGE;
    }

    public static String getSERVER_ERROR_MESSAGE() {
        return SERVER_ERROR_MESSAGE;
    }

}
