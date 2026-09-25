package project.annotations.process;

import project.annotations.Job;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class ProcessAPIPrototype {
    public void prototypeAPIProcess(Datastore api) {
        // Writing job
        JobIdentifier jobId = api.getRecentJobID();
        Job job = new Job();
        SetIDResponse res = api.setID(job, jobId);
        CompleteStatus isComplete = api.isComplete(job);
        WriteJobResponse writeResponse = api.writeJob(job, isComplete);

        // Reading job
        JobIdentifier requestJobId = new JobIdentifier();
        JobRequestResponse requestResponse = api.requestJob(requestJobId);
        Job requestJob = api.getJob(requestJobId);
        InputForCompute input = api.extractInputFromJob(requestJob);
    }
}
