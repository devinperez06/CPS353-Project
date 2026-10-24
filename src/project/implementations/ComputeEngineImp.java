package project.implementations;

import project.Job;
import project.JobHandler;
import project.ResponseCode;
import project.network.ComputeEngine;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobCreationResponse;
import project.network.LoadOutputResponse;
import project.network.OutputDestination;

public class ComputeEngineImp implements ComputeEngine {
    JobHandler jobHandler;

    public ComputeEngineImp(JobHandler jobHandler) {
        this.jobHandler = jobHandler;
    }

    @Override
    public JobCreationResponse createJob(InputSource input, OutputDestination output, Delimiters delim) {
        return new JobCreationResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return null;
            }

            @Override
            public Job getJob() {
                return null;
            }
        };
    }

    @Override
    public LoadOutputResponse loadOutput(Job job) {
        return new LoadOutputResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return null;
            }

            @Override
            public String response() {
                return "";
            }
        };
    }
}
