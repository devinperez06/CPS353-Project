package project.network;

import project.Job;
import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputeEngine {
    JobSubmissionResponse submitJob(Job job);

    LoadFormattedOutputResponse loadFormattedOutput(OutputSource src);
}
