package test.ftp;

public enum OperationCatEnum {
    CAT_TYPE_COUNTRY("1"),
    CAT_TYPE_CITY("2"),
    CAT_TYPE_SHOP("3");

    private final String value;
    OperationCatEnum(String value){this.value = value;}
    public String get() {
        return value;
    }
}