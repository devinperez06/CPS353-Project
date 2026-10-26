package project;

import java.util.ArrayList;
import java.util.List;

public class OutputValue {
    List<Integer> output;

    public OutputValue(List<Integer> output) {
        this.output = output;
    }

    public OutputValue() {
        this.output = new ArrayList<>();
    }

    public List<Integer> getOutput() {
        return output;
    }
}
