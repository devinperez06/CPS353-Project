package project.process;

import project.Job;
import project.annotations.ProcessAPIPrototype;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class EngineStoreAPIPrototype {
    @ProcessAPIPrototype
    public void prototypeEngineStore(Datastore api) {
        // Writing job
        JobIdentifier jobId = api.getRecentJobID();
        Job job = new Job();
        SetIDResponse res = api.setID(job, jobId);
        System.out.println(res);
        WriteJobResponse writeResponse = api.writeJob(job);
        System.out.println(writeResponse);

        // Reading job
        JobIdentifier requestJobId = new JobIdentifier(0);
        JobRequestResponse requestResponse = api.requestJob(requestJobId);
        if (requestResponse.getResponseCode().success()) {
            Job requestedJob = api.getJob(requestJobId);
            System.out.println(requestedJob);
        }
    }
}
