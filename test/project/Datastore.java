package project;

import java.util.List;

public class Datastore {
    InputSource inputSrc;
    OutputSource outputSrc;

    public Datastore(InputSource inputSrc, OutputSource outputSrc) {
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
