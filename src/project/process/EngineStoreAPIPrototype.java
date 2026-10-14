package project.process;

import project.Job;
import project.JobIdentifier;
import project.annotations.ProcessAPIPrototype;

public class EngineStoreAPIPrototype {
    @ProcessAPIPrototype
    public void prototypeEngineStore(Datastore api) {
        // Writing job
        Job job = new Job();
        WriteJobResponse writeResponse = api.writeJob(job);
        // Reading job
        JobRequest request = new JobRequest(new JobIdentifier());
        ReadJobResponse res = api.readJob(request);
    }
}
