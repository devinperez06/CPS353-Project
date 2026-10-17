package project;

import project.network.OutputSource;

import java.util.List;

public class OutputConfig extends OutputSource {
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
