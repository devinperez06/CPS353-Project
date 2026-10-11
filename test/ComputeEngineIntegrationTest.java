import implementations.network.ComputeEngineImp;
import org.junit.jupiter.api.Test;
import project.Job;
import project.network.ComputeEngine;
import project.network.Delimiters;
import project.network.JobSubmissionResponse;
import project.network.LoadFormattedOutputResponse;
import project.network.OutputSource;

public class ComputeEngineIntegrationTest {
    @Test
    public void integrationTest() {
        ComputeEngineImp computeEngine = new ComputeEngineImp(new ComputeEngine() {
            @Override
            public JobSubmissionResponse submitJob(Job job) {
                return null;
            }

            @Override
            public LoadFormattedOutputResponse loadFormattedOutput(OutputSource src) {
                return null;
            }
        });
        TestJob job = new TestJob(new InputConfig() {
            @Override
            public void addInput(int input) {
                InputConfig.inputs.add(input);
            }
        }, new OutputConfig() {
            @Override
            public void addOutput(String output) {
                OutputConfig.outputData.add(output);
            }
        }, new Delimiters(":,;"));
    }
}
