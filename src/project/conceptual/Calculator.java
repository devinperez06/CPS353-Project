package project.conceptual;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface Calculator {
    GetInputResponse getInput(InputVal val);

    WriteOutputResponse writeOutput(OutputValue output);
}
