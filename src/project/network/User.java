package project.network;

import project.Job;
import project.annotations.NetworkAPI;

@NetworkAPI
public interface User {
    ConfigJobResponse configJobRequest(InputSource in, OutputSource out, Delimiters delim);

    Job configJob(InputSource in, OutputSource out, Delimiters delim);

    JobSubmissionResponse submitJob(Job job);

    LoadFormattedOutputResponse loadFormattedOutput(OutputSource src);
}
