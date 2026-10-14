package project.conceptual;

import project.InputForCompute;
import project.Job;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface JobHandler {
    InputForCompute extractInput(Job job);

    OutputValue solve(InputForCompute input);

    SendOutputResponse sendOutput(OutputValue val);
}
