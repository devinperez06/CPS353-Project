package threadharness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.JobHandler;
import project.implementations.CalculatorImp;
import project.implementations.ComputeEngineImp;
import project.implementations.DatastoreImp;
import project.implementations.MultiThreadedComputeEngineImp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMultiUser {

    private ComputeEngineImp singleThreadedEngine;
    private MultiThreadedComputeEngineImp multiThreadedEngine;

    @BeforeEach
    public void initializeComputeEngines() {
        singleThreadedEngine = new ComputeEngineImp(new JobHandler(new DatastoreImp(), new CalculatorImp()));
        multiThreadedEngine = new MultiThreadedComputeEngineImp(new JobHandler(new DatastoreImp(), new CalculatorImp()));
    }

    @Test
    public void compareMultiAndSingleThreaded() throws Exception {
        int num_threads = 4;
        List<TestUser> singleUsers = new ArrayList<>();
        for (int i = 0; i < num_threads; i++) {
            singleUsers.add(new TestUser(singleThreadedEngine));
        }

        // Run single threaded
        String singleThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";
        for (int i = 0; i < num_threads; i++) {
            File singleThreadedOut =
                new File(singleThreadFilePrefix + i);
            singleThreadedOut.deleteOnExit();
            singleUsers.get(i).run(singleThreadedOut.getCanonicalPath());
        }

        // Run multi threaded
        List<TestUser> multiUsers = new ArrayList<>();
        for (int i = 0; i < num_threads; i++) {
            multiUsers.add(new TestUser(multiThreadedEngine));
        }
        String multiThreadFilePrefix =
            "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";
        ExecutorService testPool = Executors.newFixedThreadPool(num_threads);
        try {
            List<Future<?>> results = new ArrayList<>();

            for (int i = 0; i < num_threads; i++) {
                File output = new File(multiThreadFilePrefix + i);
                output.deleteOnExit();

                String outputPath = output.getCanonicalPath();
                TestUser testUser = multiUsers.get(i);

                results.add(testPool.submit(
                    () -> testUser.run(outputPath)));
            }
            for (Future<?> future : results) {
                future.get();
            }
        } finally {
            testPool.shutdown();
            multiThreadedEngine.close();
        }

        // Check that the output is the same for multi-threaded and single-threaded
        List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, num_threads);
        List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, num_threads);
        System.out.println(singleThreaded);
        System.out.println(multiThreaded);
        Assertions.assertEquals(singleThreaded, multiThreaded);
    }

    private List<String> loadAllOutput(String prefix, int num_threads) throws IOException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < num_threads; i++) {
            File multiThreadedOut =
                new File(prefix + i);
            result.addAll(Files.readAllLines(multiThreadedOut.toPath()));
        }
        return result;
    }

}
