package project.checkpointtests;

import project.JobHandler;
import project.implementations.CalculatorImp;
import project.implementations.ComputeEngineImp;
import project.implementations.DatastoreImp;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobSubmissionResponse;
import project.network.OutputDestination;

import java.io.IOException;

public class ManualTestingFramework {

    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) throws IOException {
        // TODO 1:
        // Instantiate a real (ie, class definition lives in the src/ folder) implementation 
        // of all 3 APIs
        //
        DatastoreImp datastore = new DatastoreImp();
        CalculatorImp calculator = new CalculatorImp();
        JobHandler jobHandler = new JobHandler(datastore, calculator);
        ComputeEngineImp computeEngine = new ComputeEngineImp(jobHandler);
        // TODO 2:
        // Run a computation with an input file of <root project dir>/manualTestInput.txt
        // and an output of <root project dir>/manualTestOutput.txt, with a delimiter of ',' 
        //
        JobSubmissionResponse res = computeEngine.submitJob(new InputSource(INPUT), new OutputDestination(OUTPUT), new Delimiters(","));
        System.out.println(res.response());
        // Helpful hint: the working directory of this program is <root project dir>,
        // so you can refer to the files just using the INPUT/OUTPUT constants. You do not 
        // need to (and should not) actually create those files in your repo
    }
}
