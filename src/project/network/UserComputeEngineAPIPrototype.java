package project.network;

import project.Job;
import project.annotations.NetworkAPIPrototype;

public class UserComputeEngineAPIPrototype {
    @NetworkAPIPrototype
    public void prototypeUserComputeEngine(ComputeEngine api) {
        // Create a job
        JobCreationResponse jobCreationRes = api.createJob(new InputSource(), new OutputSource(), new Delimiters());
        // Load a response
        LoadOutputResponse loadOutputRes = api.loadOutput(new Job());
    }
}
