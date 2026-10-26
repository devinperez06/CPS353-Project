package project.network;

public class InputSource {
    private final String filePath;

    public InputSource(String filePath) {
        this.filePath = filePath;
    }

    public InputSource() {
        this.filePath = "src/project/sources/input.txt";
    }

    public String getFilePath() {
        return filePath;
    }
}
