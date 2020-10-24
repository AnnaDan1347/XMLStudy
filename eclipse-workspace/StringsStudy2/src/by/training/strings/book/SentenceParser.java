package by.training.strings.book;

import java.io.IOException;
import java.util.*;

public class SentenceParser {

    private ArrayList<ISentenceObject> iSentenceObject;

    public ArrayList<ISentenceObject> getiSentenceObject() {
        return iSentenceObject;
    }

    public void setiSentenceObject(ArrayList<ISentenceObject> iSentenceObject) {
        this.iSentenceObject = iSentenceObject;
    }

    public SentenceParser() {
        iSentenceObject = new ArrayList<>();
    }

    final static EnumSet<Punctuation> sentencePunctuation = EnumSet.range(Punctuation.EXCLAMATION,
            Punctuation.DISAMBIGUATION);
    final static EnumSet<Punctuation> nonSentencePunctuation = EnumSet.complementOf(sentencePunctuation);
    final static EnumSet<Punctuation> allPunctuation = EnumSet.allOf(Punctuation.class);

    private static final String FILE_LOCATION = "ThinkingInJava2.txt";

    public void run() {
        Text currentText = new Text(FILE_LOCATION);
        try {
            currentText.createtext();
        } catch (IOException e) {
            System.out.println(e);
        }

        currentText.collect();
        System.out.println(String.format("Number of sentences in a text: %d", currentText.getSize()));

        HashMap<String, WordInSentence> wordRange = currentText.calculateWordRange(iSentenceObject);

        String wordWithMaxRange = currentText.getWordWithMaxRange(wordRange);
        System.out.println(String.format("Word with maximum range: %s", wordWithMaxRange));
        WordInSentence wordInSentence = wordRange.get(wordWithMaxRange);
        System.out.println(
                String.format("Number of sentences with at least one similar word: %d", wordInSentence.getCount()));

    }
}
