package vaco.conditions;

/**
 * @author lokutus
 */
public interface Conditional {
    
    /**
     * This should process the custom condition evaluation routine and return
     * the result.
     *
     * @return TRUE/FALSE based on result of the condition evaluation
     */
    boolean evaluate();
    
}
