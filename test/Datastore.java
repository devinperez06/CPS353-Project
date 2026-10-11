import java.util.List;

public interface Datastore {
    String readInputs(List<Integer> inputs);

    void writeOutput(List<String> outputs);
}
