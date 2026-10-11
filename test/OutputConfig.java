import java.util.ArrayList;
import java.util.List;

public interface OutputConfig {
    public static final List<String> outputData = new ArrayList<>();

    void addOutput(String output);
}
