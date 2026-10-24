package project.network;

import project.Job;
import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputeEngine {
    JobCreationResponse createJob(InputSource input, OutputDestination output, Delimiters delim);

    LoadOutputResponse loadOutput(Job job);
}
