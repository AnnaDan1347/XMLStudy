package epam.by.application;

public class AveragePlantSize extends AVisual{
    public AveragePlantSize() {
        super("средний размер растения");
    }

    private Integer size;

    @Override
    public void setValue(String value) {
        size = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(size);
    }

}
