package project;

import project.process.Datastore;
import project.process.JobRequest;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

import java.util.List;

public class DatastoreTest implements Datastore {
    InputConfig inputSrc;
    OutputConfig outputSrc;

    public DatastoreTest(InputConfig inputSrc, OutputConfig outputSrc) {
        this.inputSrc = inputSrc;
        this.outputSrc = outputSrc;
    }

    public List<Integer> readInputs() {
        return inputSrc.getInputs();
    }

    public List<String> writeOutput(String output) {
        outputSrc.addOutput(output);
        return outputSrc.getOutputs();
    }

    @Override
    public WriteJobResponse writeJob(Job job) {
        return null;
    }

    @Override
    public ReadJobResponse readJob(JobRequest request) {
        return null;
    }
}
