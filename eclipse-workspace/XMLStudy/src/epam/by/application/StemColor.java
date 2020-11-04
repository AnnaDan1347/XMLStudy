package epam.by.application;

public class StemColor extends AVisual {

    public StemColor() {
        super("Цвет стебля");
    }
    
    private String stemColor;

    @Override
    public void setValue(String value) {
        this.stemColor = value;

    }

    @Override
    public String getValue() {

        return stemColor;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return super.getName();
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        super.setName(name);
    }
}
