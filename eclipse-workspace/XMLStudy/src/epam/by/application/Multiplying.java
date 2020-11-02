package epam.by.application;

public enum Multiplying {
    BYLEAVES ("листьями"), CUTTING ("черенками"), BYCEEDS ("семенами");
    private String type;

    public String getType() {
        return type;
    }

    private Multiplying(String type) {
        this.type = type;
    }
}
