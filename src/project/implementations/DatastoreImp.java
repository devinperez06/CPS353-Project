package project.implementations;

import project.InputValue;
import project.Job;
import project.OutputValue;
import project.ResponseCode;
import project.network.Delimiters;
import project.process.Datastore;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DatastoreImp implements Datastore {
    @Override
    public WriteJobResponse writeJob(OutputValue val, Job job) {
        try {
            if (val == null || job == null) {
                return () -> ResponseCode.INVALID_ARGUMENT;
            }
            if (val.getOutput() == null || val.getOutput().isEmpty() || job.getOutputDestination() == null) {
                return () -> ResponseCode.INVALID_ARGUMENT;
            }
            Path path = Path.of(job.getOutputDestination().getFilePath());
            Path parent = path.getParent();
            if (parent == null || !Files.exists(parent)) {
                return () -> ResponseCode.DIRECTORY_NOT_FOUND;
            }
            if (!Files.isDirectory(parent)) {
                return () -> ResponseCode.INVALID_DIRECTORY;
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(job.getOutputDestination().getFilePath()))) {
                Delimiters delim = job.getDelim();
                char character = delim.getCharacter();
                List<Integer> solList = val.getOutput();
                for (int i = 0; i < solList.size(); i++) {
                    int sol = val.getOutput().get(i);
                    if (i != solList.size() - 1) {
                        writer.write(String.valueOf(sol));
                        writer.write(character);
                    } else {
                        writer.write(String.valueOf(sol));
                    }
                }
                return () -> ResponseCode.SUCCESS;
            }
        } catch (IOException e) {
            return () -> ResponseCode.IO_ERROR;
        } catch (RuntimeException e) {
            return () -> ResponseCode.INTERNAL_ERROR;
        }
    }

    @Override
    public ReadJobResponse readJob(Job job) {
        try {
            if (job == null || job.getInputSource() == null) {
                return new ReadJobResponse() {
                    @Override
                    public ResponseCode getResponseCode() {
                        return ResponseCode.INVALID_ARGUMENT;
                    }

                    @Override
                    public InputValue getInput() {
                        return null;
                    }
                };
            }
            Path path = Path.of(job.getInputSource().getFilePath());
            if (!Files.exists(path)) {
                return new ReadJobResponse() {
                    @Override
                    public ResponseCode getResponseCode() {
                        return ResponseCode.FILE_DOESNT_EXIST;
                    }

                    @Override
                    public InputValue getInput() {
                        return null;
                    }
                };
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(job.getInputSource().getFilePath()))) {
                List<Integer> nums = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    String trimmed = line.trim();
                    int num = Integer.parseInt(trimmed);
                    nums.add(num);
                }
                return new ReadJobResponse() {
                    @Override
                    public ResponseCode getResponseCode() {
                        return ResponseCode.SUCCESS;
                    }

                    @Override
                    public InputValue getInput() {
                        return new InputValue(nums);
                    }
                };
            }
        } catch (IOException e) {
            return new ReadJobResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.IO_ERROR;
                }

                @Override
                public InputValue getInput() {
                    return null;
                }
            };
        } catch (RuntimeException e) {
            return new ReadJobResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.INTERNAL_ERROR;
                }

                @Override
                public InputValue getInput() {
                    return null;
                }
            };
        }
    }
}
