public enum EnumSample {
    SOON("1"),
    NEXT("2");

    private final String value;

    EnumSample(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
