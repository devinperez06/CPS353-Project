package project.conceptual;

import project.Job;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface Calculator {
    GetInputResponse getInput(Job job); // Given a job, extract an input (list of integers)

    SendOutputResponse sendOutput(Job job, OutputValue output); // Solve for an output and send answer to job handler for rewrite
}
