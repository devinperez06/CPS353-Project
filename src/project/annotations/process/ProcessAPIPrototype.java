package project.annotations.process;

import project.annotations.InputForCompute;
import project.annotations.Job;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class ProcessAPIPrototype {
    public void PrototypeAPIProcess(Datastore api) {
        // Writing job
        JobIdentifier jID = api.getRecentJobID();
        Job job = new Job();
        SetIDResponse res = api.setID(job, jID);
        CompleteStatus isComplete = api.isComplete(job);
        WriteJobResponse wRes = api.writeJob(job, isComplete);

        // Reading job
        JobIdentifier rJID = new JobIdentifier();
        JobRequestResponse rRes = api.requestJob(rJID);
        Job rJob = api.getJob(rJID);
        InputForCompute input = api.extractInputFromJob(rJob);
    }
}
