package by.training.strings.book;

import java.util.HashSet;
import java.util.Set;

public class WordInSentence {
    private int count;
    private Set<Sentence> sentences;

    public WordInSentence() {
        super();
        this.count = 0;
        this.sentences = new HashSet<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        count++;
    }

    public void addSentenceWithWord(Sentence sentence) {
        sentences.add(sentence);
    }

    public Set<Sentence> getSentences() {
        return sentences;
    }

    public Integer getSize() {
        return sentences.size();
    }

    public void setSentences(Set<Sentence> sentences) {
        this.sentences = sentences;
    }

}
