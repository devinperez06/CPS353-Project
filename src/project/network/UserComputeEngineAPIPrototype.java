package project.network;

import project.Job;
import project.annotations.NetworkAPIPrototype;

public class UserComputeEngineAPIPrototype {
    @NetworkAPIPrototype
    public void prototypeUserComputeEngine(ComputeEngine api) {
        // Create a job
        JobCreationResponse jobCreationRes = api.createJob(new InputSource(new Inputs()), new OutputSource(), new Delimiters());
        // Send a job
        JobSubmissionResponse jobSubmissionRes = api.submitJob(jobCreationRes.getJob());
        // Load a response
        LoadOutputResponse loadOutputRes = api.loadOutput(new Job());
        // Get result
        Result res = loadOutputRes.getResult();
    }
}
