package epam.by.application;

public class TemperatureDegree extends AGrowingTips{
    public TemperatureDegree() {
        super("Температура (в градусах)");
    }

    private Integer degree;

    @Override
    public void setValue(String value) {
        degree = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(degree);
    }

}
