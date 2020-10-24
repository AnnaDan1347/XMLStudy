package by.training.strings.book;

public class Symbol extends BaseObject {
    private char symbol;

    public Symbol(char charAt) {
        this.symbol = charAt;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public void collect() {
    }

}
