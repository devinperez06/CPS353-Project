package threadharness;

import project.network.ComputeEngine;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.OutputDestination;

import java.io.File;


public class TestUser {
    private final ComputeEngine coordinator;

    public TestUser(ComputeEngine coordinator) {
        this.coordinator = coordinator;
    }

    public void run(String outputPath) {
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar + "testInputFile.test";
        coordinator.submitJob(new InputSource(inputPath), new OutputDestination(outputPath), new Delimiters(delimiter));
    }

}
