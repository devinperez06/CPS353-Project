package project;

import project.network.InputSource;

import java.util.List;

public class InputConfig extends InputSource {
    List<Integer> inputs;

    public InputConfig(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public List<Integer> getInputs() {
        return inputs;
    }
}
