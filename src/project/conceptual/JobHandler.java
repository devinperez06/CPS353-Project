package project.conceptual;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface JobHandler {
    SendInputResponse sendInput(InputVal val);

    WriteOutputResponse writeOutput(OutputValue output);
}
