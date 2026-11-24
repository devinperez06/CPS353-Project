package project.implementations;

import project.JobHandler;
import project.ResponseCode;
import project.network.ComputeEngine;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobSubmissionResponse;
import project.network.OutputDestination;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedComputeEngineImp implements ComputeEngine {
    private static final int MAX_THREADS = 4;
    private final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
    private JobHandler jobHandler;

    public MultiThreadedComputeEngineImp(JobHandler jobHandler) {
        this.jobHandler = jobHandler;
    }

    @Override
    public JobSubmissionResponse submitJob(InputSource input, OutputDestination output, Delimiters delim) {
        Future<JobSubmissionResponse> future = executor.submit(
            () -> ComputeEngineHelper.processJob(
                jobHandler, input, output, delim));
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.FAILURE;
                }

                @Override
                public String response() {
                    return "Thread interrupted.";
                }
            };
        } catch (ExecutionException e) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.FAILURE;
                }

                @Override
                public String response() {
                    return "Execution failure.";
                }
            };
        }
    }

    public void close() {
        executor.shutdown();
    }
}
