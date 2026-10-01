package project.process;

public enum CompleteStatus {
    COMPLETE(true),
    INCOMPLETE(false);
    private boolean complete;

    private CompleteStatus(boolean complete) {
        this.complete = complete;
    }

    public boolean complete() {
        return complete;
    }
}
