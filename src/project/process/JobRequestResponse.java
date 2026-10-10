package project.process;

public interface JobRequestResponse {
    JobRequestResponseCode getResponseCode();

    String text();
}
