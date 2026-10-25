package project.network;

import project.annotations.NetworkAPI;

import java.io.IOException;

@NetworkAPI
public interface ComputeEngine {
    JobSubmissionResponse submitJob(InputSource input, OutputDestination output, Delimiters delim) throws IOException;
}
