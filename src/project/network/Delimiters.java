package project.network;

public class Delimiters {
    private char character;

    public Delimiters(char character) {
        this.character = character;
    }

    public Delimiters() {
        this.character = ',';
    }

    public char getCharacter() {
        return character;
    }
}
