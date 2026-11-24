package project.network;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputeEngine {
    JobSubmissionResponse submitJob(InputSource input, OutputDestination output, Delimiters delim);
}
