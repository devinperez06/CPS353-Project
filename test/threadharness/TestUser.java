package threadharness;

import project.implementations.ComputeEngineImp;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.OutputDestination;

import java.io.File;


public class TestUser {
    private final ComputeEngineImp coordinator;

    public TestUser(ComputeEngineImp coordinator) {
        this.coordinator = coordinator;
    }

    public void run(String outputPath) {
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar + "testInputFile.test";
        coordinator.submitJob(new InputSource(inputPath), new OutputDestination(outputPath), new Delimiters(delimiter));
    }

}
