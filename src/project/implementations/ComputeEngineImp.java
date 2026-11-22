package project.implementations;

import project.JobHandler;
import project.network.ComputeEngine;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobSubmissionResponse;
import project.network.OutputDestination;

public class ComputeEngineImp implements ComputeEngine {
    JobHandler jobHandler;

    public ComputeEngineImp(JobHandler jobHandler) {
        this.jobHandler = jobHandler;
    }

    @Override
    public JobSubmissionResponse submitJob(InputSource input, OutputDestination output, Delimiters delim) {
        return ComputeEngineHelper.processJob(jobHandler, input, output, delim);
    }
}
