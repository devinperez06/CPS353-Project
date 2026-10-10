package implementations.conceptual;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.InputForCompute;
import project.Job;
import project.conceptual.Computer;
import project.conceptual.OutputValue;
import project.conceptual.SendOutputResponse;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TestComputerImp {
    @Test
    public void extractInputTest() {
        Computer api = Mockito.mock(Computer.class);
        ComputerImp computer = new ComputerImp(api);
        Job mockJob = Mockito.mock(Job.class);
        when(api.extractInput(any(Job.class))).thenReturn(new InputForCompute(1));
        if (computer.extractInput(mockJob) != api.extractInput(mockJob).getNum()) {
            fail("Extract Job Test Failed.");
        }
    }

    @Test
    public void solveTest() {
        Computer api = Mockito.mock(Computer.class);
        ComputerImp computer = new ComputerImp(api);
        InputForCompute input = Mockito.mock(InputForCompute.class);
        when(api.solve(any(InputForCompute.class))).thenReturn(new OutputValue(1));
        if (computer.solve(input) != api.solve(input).getNum()) {
            fail("Solve test failed.");
        }
    }

    @Test
    public void sendOutputTest() {
        Computer api = Mockito.mock(Computer.class);
        ComputerImp computer = new ComputerImp(api);
        OutputValue output = new OutputValue(1);
        SendOutputResponse res = () -> "";
        when(api.sendOutput(any(OutputValue.class))).thenReturn(res);
        if (!(computer.sendOutput(output).equals(api.sendOutput(output).text()))) {
            fail("Send output test failed.");
        }
    }
}
