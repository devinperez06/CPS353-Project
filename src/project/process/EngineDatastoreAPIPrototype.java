package project.process;

import project.Job;
import project.OutputValue;
import project.annotations.ProcessAPIPrototype;

import java.io.IOException;

public class EngineDatastoreAPIPrototype {
    @ProcessAPIPrototype
    public void prototypeEngineDatastore(Datastore api) throws IOException {
        // Reading from job
        Job job = new Job();
        ReadJobResponse readRes = api.readJob(job);
        if (readRes.getResponseCode().success()) {
            System.out.println(readRes.getInput());
        }
        // Writing to job
        WriteJobResponse writeRes = api.writeJob(new OutputValue(), job);
        if (writeRes.getResponseCode().success()) {
            System.out.println("Solution written successfully!");
        }
    }
}
