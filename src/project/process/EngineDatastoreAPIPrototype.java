package project.process;

import project.Job;
import project.JobIdentifier;
import project.annotations.ProcessAPIPrototype;

public class EngineDatastoreAPIPrototype {
    @ProcessAPIPrototype
    public void prototypeEngineDatastore(Datastore api) {
        // Writing job
        Job job = new Job();
        WriteJobResponse writeResponse = api.writeJob(job);
        // Reading job
        JobRequest request = new JobRequest(new JobIdentifier());
        ReadJobResponse res = api.readJob(request);
    }
}
