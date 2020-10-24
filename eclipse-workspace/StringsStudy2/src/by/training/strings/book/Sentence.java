package by.training.strings.book;

import java.util.ArrayList;

public class Sentence extends BaseObject {
    private ArrayList<ISentenceObject> iSentenceObject;

    protected Sentence(ArrayList<ISentenceObject> iSentenceObject) {
        super();
        this.iSentenceObject = iSentenceObject;
    }

    public ArrayList<ISentenceObject> getiSentenceObject() {
        return iSentenceObject;
    }

    private String wholeText;

    public String getWholeText() {
        return wholeText;
    }

    public void setWholeText(String wholeText) {
        this.wholeText = wholeText;
    }

    public Sentence(String substring) {
        iSentenceObject = new ArrayList<>();
        this.wholeText = substring;
    }

    @Override
    public void collect() {
        if (wholeText != null && wholeText.length() > 0) {
            int startPosition = 0;
            int index;
            for (index = startPosition; index < wholeText.length(); index++) {
                for (Punctuation punctuation : Text.nonSentencePunctuation) {
                    if (((wholeText.charAt(index) == punctuation.getSign()) && ((index + 1) < wholeText.length())
                            && (wholeText.charAt(index + 1) == ' ')) || (wholeText.charAt(index) == ' ')) {
                        if (startPosition < index) {
                            Word buffer = new Word(getWholeText().substring(startPosition, (index)));
                            iSentenceObject.add(buffer);
                            buffer.collect();
                            startPosition = index + 1;
                        }
                    }
                }
            }
        }
    }

}
