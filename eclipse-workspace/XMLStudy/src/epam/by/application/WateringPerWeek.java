package epam.by.application;

public class WateringPerWeek extends AGrowingTips{

    public WateringPerWeek() {
        super("Полив (мл в неделю)");
    }
    private Integer watering;

    @Override
    public void setValue(String value) {
        watering = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(watering);
    }

}
