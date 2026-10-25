package project.implementations;

import project.InputValue;
import project.Job;
import project.OutputValue;
import project.ResponseCode;
import project.process.Datastore;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatastoreImp implements Datastore {
    // Currently, formatting is being handled by Calculator, Calculator uses default :, delimiters
    // TODO: Move formatting logic to write job method
    @Override
    public WriteJobResponse writeJob(OutputValue val, Job job) throws IOException {
        WriteJobResponse badRes = () -> ResponseCode.FAILURE;
        if (val == null || job == null) {
            return badRes;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(job.getOutputDestination().getFilePath()));
        writer.write(val.getOutput());
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
        if (job == null) {
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
