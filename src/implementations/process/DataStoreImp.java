package implementations.process;

import implementations.DelimitersImp;
import implementations.InputSourceImp;
import implementations.JobImp;
import implementations.OutputSourceImp;
import project.process.JobIdentifier;

public class DataStoreImp {

    public int getRecentJobID() {
        return 0;
    }

    public String setID(JobImp job, JobIdentifier jobId) {
        return "";
    }

    public String writeJob(JobImp job) {
        return "";
    }

    public String requestJob(JobImp job) {
        return "";
    }

    public JobImp getJob(JobIdentifier jobId) {
        return new JobImp(new InputSourceImp("input.txt"), new OutputSourceImp("output.txt"), new DelimitersImp(":,;"));
    }
}
