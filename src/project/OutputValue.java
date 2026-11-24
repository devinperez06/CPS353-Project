package project;

import java.util.ArrayList;
import java.util.List;

public class OutputValue {
    private final List<Integer> output;

    public OutputValue(List<Integer> output) {
        this.output = output == null
            ? new ArrayList<>()
            : new ArrayList<>(output);
    }

    public OutputValue() {
        this.output = new ArrayList<>();
    }

    public List<Integer> getOutput() {
        return List.copyOf(output);
    }
}
