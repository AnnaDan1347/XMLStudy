package epam.by.application;

public enum Multiplying {
    BYLEAVES ("листьями"), CUTTING ("черенками"), BYSEEDS ("семенами");
    private String type;
    
    public String getType() {
        return type;
    }

    private Multiplying(String type) {
        this.type = type;
    }
}
