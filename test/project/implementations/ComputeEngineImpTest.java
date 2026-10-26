package project.implementations;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.InputValue;
import project.Job;
import project.JobHandler;
import project.OutputValue;
import project.ResponseCode;
import project.conceptual.SolveResponse;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobSubmissionResponse;
import project.network.OutputDestination;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ComputeEngineImpTest {
    @Test
    public void testSubmitJob() throws IOException {
        InputSource input = new InputSource();
        OutputDestination output = new OutputDestination();
        Delimiters delim = new Delimiters();
        JobHandler jobHandler = Mockito.mock(JobHandler.class);
        when(jobHandler.readJob(any(Job.class))).thenReturn(new ReadJobResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.SUCCESS;
            }

            @Override
            public InputValue getInput() {
                return new InputValue(List.of(5));
            }
        });
        when(jobHandler.solve(any(InputValue.class))).thenReturn(new SolveResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.SUCCESS;
            }

            @Override
            public OutputValue getOutput() {
                return new OutputValue(List.of(5));
            }
        });
        when(jobHandler.writeJob(any(OutputValue.class), any(Job.class))).thenReturn(new WriteJobResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.SUCCESS;
            }
        });
        ComputeEngineImp imp = new ComputeEngineImp(jobHandler);
        JobSubmissionResponse res = imp.submitJob(input, output, delim);
        ResponseCode responseCode = res.getResponseCode();
        String response = res.response();
        if (!(responseCode.success()) || !(response.equals("Job submitted successfully. For output results, see specified output file!"))) {
            fail();
        }
    }
}
