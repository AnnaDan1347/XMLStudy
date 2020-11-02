package epam.by.application;

public abstract class AGrowingTips {
    private String name;
    private String tips;

    public AGrowingTips(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTips() {
        return tips;
    }
    public void setTips(String tips) {
        this.tips = tips;
    }
    public abstract void setValue(String value);

    public abstract String getValue();

    @Override
    public String toString() {
        return getValue();
    }


}
