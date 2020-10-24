package by.training.strings.book;

public abstract class BaseObject implements ISentenceObject {

    protected String wholeText;

    public String getWholeText() {
        return wholeText;
    }

    public void setWholeText(String wholeText) {
        this.wholeText = wholeText;
    }
}
