package project.network;

public class Delimiters {
    private String characters;

    public Delimiters(String characters) {
        this.characters = characters;
    }

    public Delimiters() {
        this.characters = ":,;";
    }
}
