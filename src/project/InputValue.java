package project;

import java.util.ArrayList;
import java.util.List;

public class InputValue {
    private List<Integer> inputs;

    public InputValue(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public InputValue() {
        this.inputs = new ArrayList<>();
    }

    public List<Integer> getInputs() {
        return inputs;
    }
}
