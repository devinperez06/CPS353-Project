package project.network;

import java.util.ArrayList;
import java.util.List;

public class Inputs {
    private List<Integer> list;

    public Inputs(List<Integer> list) {
        this.list = list;
    }

    public Inputs() {
        this.list = new ArrayList<>(List.of(1, 10, 25));
    }
}
