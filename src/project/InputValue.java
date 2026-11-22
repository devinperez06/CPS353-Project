package project;

import java.util.ArrayList;
import java.util.List;

public class InputValue {
    private final List<Integer> inputs;

    public InputValue(List<Integer> inputs) {
        this.inputs = inputs == null
            ? new ArrayList<>()
            : new ArrayList<>(inputs);
    }

    public InputValue() {
        this.inputs = new ArrayList<>();
    }

    public List<Integer> getInputs() {
        return List.copyOf(inputs);
    }
}
