package vaco.conditions;

/**
 * Conditional interface to enable method chaining based on boolean logic
 * implementation.
 * 
 * @author lokutus
 */
public interface Chainable extends Conditional {
    
    /**
     * This allows to chain two conditions with boolean AND and return the new
     * condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Chainable object
     */
    Chainable and(Conditional condition);
    
    /**
     * This allows to chain two conditions with boolean OR and return the new
     * condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Chainable object
     */
    Chainable or(Conditional condition);
    
    /**
     * This allows to chain two conditions with boolean AND NOT and return the
     * new condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Chainable object
     */
    Chainable andNot(Conditional condition);
    
    /**
     * This allows to chain two conditions with boolean OR NOT and return the
     * new condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Chainable object
     */
    Chainable orNot(Conditional condition);
    
}
