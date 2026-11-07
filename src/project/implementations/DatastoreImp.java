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
    public WriteJobResponse writeJob(OutputValue val, Job job) throws IOException {
        WriteJobResponse badRes = () -> ResponseCode.FAILURE;
        if (val == null || job == null) {
            return badRes;
        }
        if (val.getOutput().isEmpty() || job.getOutputDestination() == null) {
            return badRes;
        }
        Path path = Path.of(job.getOutputDestination().getFilePath());
        Path parent = path.getParent();
        if (parent == null || !Files.exists(parent)) {
            return badRes;
        }
        if (!Files.isDirectory(parent)) {
            return badRes;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(job.getOutputDestination().getFilePath()));
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
        writer.close();
        return () -> ResponseCode.SUCCESS;
    }

    @Override
    public ReadJobResponse readJob(Job job) throws IOException {
        ReadJobResponse badRes = new ReadJobResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.FAILURE;
            }

            @Override
            public InputValue getInput() {
                return null;
            }
        };
        if (job == null || job.getInputSource() == null) {
            return badRes;
        }
        Path path = Path.of(job.getInputSource().getFilePath());
        if (!Files.exists(path)) {
            return badRes;
        }
        List<Integer> nums = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(job.getInputSource().getFilePath()));
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
}
