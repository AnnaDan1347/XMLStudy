package by.training.strings.book;

import java.util.ArrayList;

public class Word extends BaseObject {
    public ArrayList<ISentenceObject> iSentenceObject;

    public Word(String substring) {
        iSentenceObject = new ArrayList<>();
        this.wholeText = substring;
    }

    @Override
    public void collect() {
        if (wholeText != null && wholeText.length() > 0) {
            int index;
            for (index = 0; index < wholeText.length(); index++) {
                Symbol buffer = new Symbol(wholeText.charAt(index));
                iSentenceObject.add(buffer);
            }
        }
    }
}
