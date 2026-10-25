package project.network;

public class OutputDestination {
    private final String filePath;

    public OutputDestination(String filePath) {
        this.filePath = filePath;
    }

    public OutputDestination() {
        this.filePath = "src/project/sources/output.txt";
    }

    public String getFilePath() {
        return filePath;
    }
}
