package project.annotations.conceptual;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class ConceptualAPIPrototype {
    public void PrototypeAPIConceptual(ComputeEngine api) {
        OutputValue val = api.solve(new InputForCompute());
        api.sendOutput(val);
    }
}
