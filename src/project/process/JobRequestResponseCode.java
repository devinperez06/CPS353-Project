package project.process;

public enum JobRequestResponseCode {
    SUCCESS(true),
    FAILURE(false);
    private boolean success;

    private JobRequestResponseCode(boolean success) {
        this.success = success;
    }

    public boolean success() {
        return success;
    }
}

