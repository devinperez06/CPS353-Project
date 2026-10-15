package project;

import java.util.List;

public class DatastoreTest {
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
}
