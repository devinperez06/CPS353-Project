package project.implementations;

import org.junit.jupiter.api.Test;

public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeEngine() {
        ComputeEngineImp engine = new ComputeEngineImp();
        engine.createJob();
    }
}
