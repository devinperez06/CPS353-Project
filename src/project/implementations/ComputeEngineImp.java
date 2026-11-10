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

import java.nio.file.Files;
import java.nio.file.Path;

public class ComputeEngineImp implements ComputeEngine {
    JobHandler jobHandler;

    public ComputeEngineImp(JobHandler jobHandler) {
        this.jobHandler = jobHandler;
    }

    @Override
    public JobSubmissionResponse submitJob(InputSource input, OutputDestination output, Delimiters delim) {
        if (input == null || output == null || delim == null) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.INVALID_ARGUMENT;
                }

                @Override
                public String response() {
                    return "";
                }
            };
        }
        Path inpath = Path.of(input.getFilePath());
        if (!Files.exists(inpath)) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.FILE_DOESNT_EXIST;
                }

                @Override
                public String response() {
                    return "";
                }
            };
        }

        Path outpath = Path.of(output.getFilePath());
        Path parent = outpath.getParent();
        if (parent == null || !Files.exists(parent)) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.DIRECTORY_NOT_FOUND;
                }

                @Override
                public String response() {
                    return "";
                }
            };
        }
        if (!Files.isDirectory(parent)) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.INVALID_DIRECTORY;
                }

                @Override
                public String response() {
                    return "";
                }
            };
        }
        Job job = new Job(input, output, delim);
        InputValue inputVal = jobHandler.readJob(job).getInput();
        if (inputVal == null) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.FAILURE;
                }

                @Override
                public String response() {
                    return "Null input value returned by read operation";
                }
            };
        }
        OutputValue outputVal = jobHandler.solve(inputVal).getOutput();
        if (outputVal == null) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.FAILURE;
                }

                @Override
                public String response() {
                    return "Null output value returned by solve operation.";
                }
            };
        }
        WriteJobResponse res = jobHandler.writeJob(outputVal, job);
        if (!(res.getResponseCode().success())) {
            return new JobSubmissionResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.FAILURE;
                }

                @Override
                public String response() {
                    return "Write operation failed.";
                }
            };
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
