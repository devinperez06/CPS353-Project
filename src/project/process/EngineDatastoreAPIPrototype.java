package project.process;

import project.Job;
import project.annotations.ProcessAPIPrototype;

public class EngineDatastoreAPIPrototype {
    @ProcessAPIPrototype
    public void prototypeEngineDatastore(Datastore api) {
        // Writing job
        Job job = new Job();
        WriteJobResponse writeRes = api.writeJob(job);
        if (writeRes.getResponseCode().success()) {
            System.out.println("Job written successfully!");
        }
        // Reading job
        JobRequest request = new JobRequest();
        ReadJobResponse readRes = api.readJob(request);
        if (readRes.getResponseCode().success()) {
            System.out.println("Job read successfully");
        }
    }
}
