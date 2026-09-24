package project.annotations.network;

public class JobSubmissionRequest {
    private Job job;

    public JobSubmissionRequest(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
