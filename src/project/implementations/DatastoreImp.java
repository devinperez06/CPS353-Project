package project.implementations;

import project.Job;
import project.process.Datastore;
import project.process.JobRequest;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

public class DatastoreImp implements Datastore {

    @Override
    public WriteJobResponse writeJob(Job job) {
        return new WriteJobResponse() {
        };
    }

    @Override
    public ReadJobResponse readJob(JobRequest request) {
        return new ReadJobResponse() {
        };
    }
}
