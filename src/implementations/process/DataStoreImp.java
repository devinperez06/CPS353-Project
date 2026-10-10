package implementations.process;

import apidemo.datastore.DataStore;
import implementations.DelimitersImp;
import implementations.InputSourceImp;
import implementations.JobImp;
import implementations.OutputSourceImp;
import project.Job;
import project.process.JobIdentifier;

public class DataStoreImp {
    static DataStore store;

    public int getRecentJobID() {
        return new JobIdentifierImp(0).getInt();
    }

    public String setID(Job job, JobIdentifier jobId) {
        return new SetIDResponseImp().text();
    }

    public String writeJob(Job job) {
        return new WriteJobResponseImp().text();
    }

    public String requestJob(Job job) {
        return "";
    }

    public JobImp getJob(JobIdentifier jobId) {
        return new JobImp(new InputSourceImp("input.txt"), new OutputSourceImp("output.txt"), new DelimitersImp(":,;"));
    }
}
