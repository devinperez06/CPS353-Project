package project;

import java.util.List;

public class OutputSource {
    List<String> outputs;

    public OutputSource(List<String> outputs) {
        this.outputs = outputs;
    }

    public List<String> getOutputs() {
        return outputs;
    }

    public void addOutput(String answer) {
        outputs.add(answer);
    }
}
