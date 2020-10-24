package by.training.strings.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Text extends BaseObject {

    final static EnumSet<Punctuation> sentencePunctuation = EnumSet.range(Punctuation.EXCLAMATION,
            Punctuation.DISAMBIGUATION);
    final static EnumSet<Punctuation> nonSentencePunctuation = EnumSet.complementOf(sentencePunctuation);
    final static EnumSet<Punctuation> allPunctuation = EnumSet.allOf(Punctuation.class);

    private String wholeText;

    public ArrayList<ISentenceObject> iSentenceObject;

    public ArrayList<ISentenceObject> getiSentenceObject() {
        return iSentenceObject;
    }

    public String getWholeText() {
        return wholeText;
    }

    public void setWholeText(String wholeText) {
        this.wholeText = wholeText;
    }

    String fileLocation;

    public Text(String fileLocation) {
        iSentenceObject = new ArrayList<>();
        this.fileLocation = fileLocation;
    }

    public int getSize() {
        return iSentenceObject.size();
    }

    public Text(ArrayList<ISentenceObject> iSentenceObject) {
        super();
        this.iSentenceObject = iSentenceObject;
    }

    public void createtext() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
            StringBuilder textBuilder = new StringBuilder();
            while (reader.ready()) {
                String buffer = reader.readLine();
                // replaces one ore more spaces into " "
                buffer = buffer.replaceAll("\\s+", " ");
                textBuilder.append(buffer);
                textBuilder.append('\r');
            }
            wholeText = textBuilder.toString();
            wholeText = wholeText.replaceAll("\\r+", "\r");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void collect() {
        if (wholeText != null && wholeText.length() > 0) {
            int startPosition = 0;
            int index;
            for (index = startPosition; index < wholeText.length(); index++) {
                for (Punctuation punctuation : Text.sentencePunctuation) {
                    if ((wholeText.charAt(index) == punctuation.getSign()) && ((index + 1) < wholeText.length())
                            && ((wholeText.charAt(index + 1) == ' ') || (wholeText.charAt(index + 1) == '\r'))) {
                        if (startPosition < index) {
                            Sentence buffer = new Sentence(getWholeText().substring(startPosition, (index + 1)));
                            iSentenceObject.add(buffer);
                            buffer.collect();
                        }
                        startPosition = index + 1;
                    }
                }
            }
        }
    }

    public HashMap<String, WordInSentence> calculateWordRange(ArrayList<ISentenceObject> iSentenceObject) {
        HashMap<String, WordInSentence> wordRange = new HashMap<String, WordInSentence>();

        for (ISentenceObject sentence : getiSentenceObject()) {

            for (ISentenceObject word : ((Sentence) sentence).getiSentenceObject()) {
                Word currentWord = (Word) word;
                if (wordRange.containsKey(currentWord.getWholeText())) {

                    WordInSentence currentWordRange = wordRange.get(currentWord.getWholeText());
                    currentWordRange.increaseCount();
                    currentWordRange.addSentenceWithWord((Sentence) sentence);
                } else {
                    WordInSentence currentWordRange = new WordInSentence();
                    currentWordRange.increaseCount();
                    currentWordRange.addSentenceWithWord((Sentence) sentence);
                    wordRange.put(currentWord.getWholeText(), currentWordRange);

                }
            }
        }
        return wordRange;
    }

    public String getWordWithMaxRange(HashMap<String, WordInSentence> wordRange) {
        String wordWithMaxRange = null;
        int maxRange = 0;

        for (String word : wordRange.keySet()) {
            WordInSentence wordInSentence = wordRange.get(word);
            if (wordWithMaxRange == null) {
                wordWithMaxRange = word;
                maxRange = wordInSentence.getCount();

            } else {
                if (maxRange < wordInSentence.getCount()) {
                    maxRange = wordInSentence.getCount();
                    wordWithMaxRange = word;
                }
            }
        }
        return wordWithMaxRange;
    }
}
