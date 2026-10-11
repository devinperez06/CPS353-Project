import project.network.Delimiters;

public class TestJob {
    // Test-specific job implementation that takes in InputConfig and OutputConfig
    private InputConfig inputConfig;
    private OutputConfig outputConfig;
    private Delimiters delimiters;

    public TestJob(InputConfig inputConfig, OutputConfig outputConfig, Delimiters delimiters) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
        this.delimiters = delimiters;
    }
}
