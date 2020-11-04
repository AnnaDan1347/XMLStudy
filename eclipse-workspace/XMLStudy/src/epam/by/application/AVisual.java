package epam.by.application;

public abstract class AVisual {
private String name;
private String characteristic;

private String element;

public String getElement() {
    return element;
}

public void setElement(String element) {
    this.element = element;
}

public AVisual(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
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
@Override
public int hashCode() {
    return getClass().hashCode();
}

@Override
public boolean equals(Object obj) {
    return obj != null && getClass() == obj.getClass();
}
}
