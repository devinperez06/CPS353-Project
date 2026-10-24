package project.network;

import project.annotations.NetworkAPIPrototype;

public class UserComputeEngineAPIPrototype {
    @NetworkAPIPrototype
    public void prototypeUserComputeEngine(ComputeEngine api) {
        // Create a job
        JobCreationResponse jobCreationRes = api.createJob(new InputSource(), new OutputDestination(), new Delimiters());
        // Load a response
        if (jobCreationRes.getResponseCode().success()) {
            LoadOutputResponse loadOutputRes = api.loadOutput(jobCreationRes.getJob());
            if (loadOutputRes.getResponseCode().success()) {
                System.out.println(loadOutputRes.response());
            }
        }
    }
}
