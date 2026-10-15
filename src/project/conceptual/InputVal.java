package project.conceptual;

import java.util.ArrayList;
import java.util.List;

public class InputVal {
    List<Integer> inputs;

    public InputVal(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public InputVal() {
        this.inputs = new ArrayList<Integer>(List.of(1, 10, 25));
    }
}
