package project;

import project.network.OutputDestination;

import java.util.List;

public class OutputConfig extends OutputDestination {
    List<String> outputs;

    public OutputConfig(List<String> outputs) {
        this.outputs = outputs;
    }

    public List<String> getOutputs() {
        return outputs;
    }

    public void addOutput(String answer) {
        outputs.add(answer);
    }
}
