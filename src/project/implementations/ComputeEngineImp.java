package project.implementations;

import project.Job;
import project.network.ComputeEngine;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobCreationResponse;
import project.network.JobSubmissionResponse;
import project.network.LoadOutputResponse;
import project.network.OutputSource;

public class ComputeEngineImp implements ComputeEngine {
    public JobCreationResponse createJob(InputSource input, OutputSource output, Delimiters delim) {
        return new JobCreationResponse() {
            @Override
            public Job getJob() {
                return null;
            }
        };
    }

    public JobSubmissionResponse submitJob(Job job) {
        return new JobSubmissionResponse() {
            @Override
            public String toString() {
                return "";
            }
        };
    }

    public LoadOutputResponse loadOutput(Job job) {
        return new LoadOutputResponse() {
            @Override
            public String toString() {
                return "";
            }
        };
    }
}
