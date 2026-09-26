package project.annotations.conceptual;

import project.annotations.InputForCompute;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class ConceptualAPIPrototype {
    public void prototypeAPIConceptual(ComputeEngine api) {
        OutputValue val = api.solve(new InputForCompute());
        api.sendOutput(val);
    }
}
