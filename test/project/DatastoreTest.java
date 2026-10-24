package project;

import project.process.Datastore;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

public class DatastoreTest implements Datastore {
    InputConfig inputSrc;
    OutputConfig outputSrc;

    public DatastoreTest(InputConfig inputSrc, OutputConfig outputSrc) {
        this.inputSrc = inputSrc;
        this.outputSrc = outputSrc;
    }

    @Override
    public WriteJobResponse writeJob(OutputValue val, Job job) {
        outputSrc.addOutput(val.getOutput());
        return new WriteJobResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.SUCCESS;
            }
        };
    }

    @Override
    public ReadJobResponse readJob(Job job) {
        return new ReadJobResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.SUCCESS;
            }

            @Override
            public InputValue getInput() {
                return (InputValue) inputSrc.getInputs();
            }
        };
    }
}
