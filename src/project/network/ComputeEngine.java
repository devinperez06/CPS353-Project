package project.network;

import project.Job;
import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputeEngine {
    JobCreationResponse createJob(InputSource input, OutputSource output, Delimiters delim);

    JobSubmissionResponse submitJob(Job job);

    LoadOutputResponse loadOutput(Job job);
}
