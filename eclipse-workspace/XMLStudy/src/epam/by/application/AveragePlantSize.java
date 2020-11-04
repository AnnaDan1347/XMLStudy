package epam.by.application;

public class AveragePlantSize extends AVisual{
    public AveragePlantSize() {
        super("Cредний размер растения");
    }

    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public void setValue(String value) {
        size = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(size);
    }

}
