package epam.by.application;

public abstract class AVisual {
private String name;
private String characteristic;

public AVisual(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public String getCharacteristic() {
    return characteristic;
}
public void setCharacteristic(String characteristic) {
    this.characteristic = characteristic;
}
public abstract void setValue(String value);

public abstract String getValue();

@Override
public String toString() {
    return getValue();
}

}
