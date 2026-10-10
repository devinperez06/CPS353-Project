package implementations.network;

import project.Job;
import project.network.ComputeEngine;
import project.network.OutputSource;

public class ComputeEngineImp {
    private final ComputeEngine api;

    public ComputeEngineImp(ComputeEngine api) {
        this.api = api;
    }

    public String submitJob(Job job) {
        api.submitJob(job);
        return "";
    }

    public String loadFormattedOutput(OutputSource src) {
        api.loadFormattedOutput(src);
        return "";
    }
}
