package project.conceptual;

import project.Job;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface JobHandler {
    SendInputResponse sendInput(Job job);

    WriteOutputResponse writeOutput(OutputValue output);
}
