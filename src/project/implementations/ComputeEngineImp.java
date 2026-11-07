package project.implementations;

import project.InputValue;
import project.Job;
import project.JobHandler;
import project.OutputValue;
import project.ResponseCode;
import project.network.ComputeEngine;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobSubmissionResponse;
import project.network.OutputDestination;
import project.process.WriteJobResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ComputeEngineImp implements ComputeEngine {
    JobHandler jobHandler;

    public ComputeEngineImp(JobHandler jobHandler) {
        this.jobHandler = jobHandler;
    }

    @Override
    public JobSubmissionResponse submitJob(InputSource input, OutputDestination output, Delimiters delim) throws IOException {
        JobSubmissionResponse badRes = new JobSubmissionResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.FAILURE;
            }

            @Override
            public String response() {
                return "";
            }
        };
        if (input == null || output == null || delim == null) {
            return badRes;
        }
        Path inpath = Path.of(input.getFilePath());
        if (!Files.exists(inpath)) {
            return badRes;
        }
        Path outpath = Path.of(output.getFilePath());
        Path parent = outpath.getParent();
        if (parent == null || !Files.exists(parent)) {
            return badRes;
        }
        if (!Files.isDirectory(parent)) {
            return badRes;
        }
        Job job = new Job(input, output, delim);
        InputValue inputVal = jobHandler.readJob(job).getInput();
        if (inputVal == null) {
            return badRes;
        }
        OutputValue outputVal = jobHandler.solve(inputVal).getOutput();
        if (outputVal == null) {
            return badRes;
        }
        WriteJobResponse res = jobHandler.writeJob(outputVal, job);
        if (!(res.getResponseCode().success())) {
            return badRes;
        }
        return new JobSubmissionResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.SUCCESS;
            }

            @Override
            public String response() {
                return "Job submitted successfully. For output results, see specified output file!";
            }
        };
    }
}
