package implementations.process;

import project.Job;
import project.process.Datastore;
import project.process.JobIdentifier;

public class DatastoreImp {
    private final Datastore api;

    public DatastoreImp(Datastore api) {
        this.api = api;
    }

    public int getRecentJobID() {
        api.getRecentJobID();
        return 1;
    }

    public String setID(Job job, JobIdentifier jobId) {
        api.setID(job, jobId);
        return "";
    }

    public String writeJob(Job job) {
        api.writeJob(job);
        return "";
    }

    public String requestJob(JobIdentifier jobId) {
        api.requestJob(jobId);
        return "";
    }

    public String getJob(JobIdentifier jobId) {
        api.getJob(jobId);
        return "";
    }
}
