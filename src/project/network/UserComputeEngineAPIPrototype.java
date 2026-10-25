package project.network;

import project.annotations.NetworkAPIPrototype;

import java.io.IOException;

public class UserComputeEngineAPIPrototype {
    @NetworkAPIPrototype
    public void prototypeUserComputeEngine(ComputeEngine api) throws IOException {
        // Submit a job
        JobSubmissionResponse jobCreationRes = api.submitJob(new InputSource(), new OutputDestination(), new Delimiters());
        if (jobCreationRes.getResponseCode().success()) {
            System.out.println(jobCreationRes.response());
        }
    }
}
