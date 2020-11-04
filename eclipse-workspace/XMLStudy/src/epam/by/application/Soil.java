package epam.by.application;


public enum Soil {
    PODZOLIC ("Подзолистая"),
    GROUND ("Грунтовая"),
    SOD_PODZOLIC ("Дерново-подзолистая");
  
    private String type;

    public String getType() {
        return type;
    }

    private Soil(String type) {
        this.type = type;
    }    
}
