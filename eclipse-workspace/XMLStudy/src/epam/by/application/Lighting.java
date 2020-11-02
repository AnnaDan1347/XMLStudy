package epam.by.application;

public class Lighting extends AGrowingTips{

    public Lighting() {
        super("Освещение (светолюбиво либо нет)");
            }
    private Boolean lightRequiring;
    @Override
    public void setValue(String value) {
        lightRequiring = Boolean.parseBoolean(value);
        
    }
    @Override
    public String getValue() {
        return String.valueOf(lightRequiring);
    }
    

}

