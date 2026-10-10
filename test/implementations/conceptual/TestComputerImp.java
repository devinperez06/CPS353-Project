package implementations.conceptual;

import implementations.JobImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

public class TestComputerImp {
    @Test
    public void extractJobTest() {
        ComputerImp mockComputer = Mockito.mock(ComputerImp.class);
        JobImp mockJob = Mockito.mock(JobImp.class);
        when(mockComputer.extractInput(mockJob)).thenReturn(5);
        ComputerImp actualComputer = new ComputerImp();
        if (mockComputer.extractInput(mockJob) != actualComputer.extractInput(mockJob)) {
            fail("Extract Job Test Failed");
        }
    }

    @Test
    public void solveTest() {
        ComputerImp mockComputer = Mockito.mock(ComputerImp.class);
        InputForComputeImp input = Mockito.mock(InputForComputeImp.class);
        when(mockComputer.solve(input)).thenReturn(5);
        ComputerImp actualComputer = new ComputerImp();
        if (mockComputer.solve(input) != actualComputer.solve(input)) {
            fail("Solve test failed");
        }
    }

    @Test
    public void sendOutputTest() {
        ComputerImp mockComputer = Mockito.mock(ComputerImp.class);
        OutputValueImp output = Mockito.mock(OutputValueImp.class);
        when(mockComputer.sendOutput(output)).thenReturn("Output sent successfully!");
        ComputerImp actualComputer = new ComputerImp();
        if (!(mockComputer.sendOutput(output).equals(actualComputer.sendOutput(output)))) {
            fail("Send output test failed");
        }
    }
}
