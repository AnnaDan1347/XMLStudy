package epam.by.application;

public enum Soil {
    PODZOLIC ("подзолистая"),
    GROUND ("грунтовая"),
    SOD_PODZOLIC ("дерново-подзолистая");
    
    private String type;

    public String getType() {
        return type;
    }

    private Soil(String type) {
        this.type = type;
    }
    

}
