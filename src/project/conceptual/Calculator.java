package project.conceptual;

import project.InputValue;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface Calculator {
    SolveResponse solve(InputValue input); // Given an input, solve for the output
}
