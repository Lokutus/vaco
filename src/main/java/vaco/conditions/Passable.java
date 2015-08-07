package vaco.conditions;

/**
 * Conditional interface to enable method chaining based on boolean logic
 * implementation like the {@link Chainable} interface with passing a value
 * through the whole chain.
 * 
 * @author lokutus
 *
 * @param <E>
 */
public interface Passable<E> extends Conditional {
    
    /**
     * Get the value that should be passed from the chaining condition.
     *
     * @param value
     */
    E getValue();
    
    /**
     * Set the value that should be passed to the chained condition.
     *
     * @param value
     */
    void setValue(E value);
    
    /**
     * Checks if there has value already been passed.
     *
     * @return TRUE/FALSE based on the value check
     */
    boolean hasValue();
    
    /**
     * This allows to chain two conditions with boolean AND and return the new
     * condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Passable object
     */
    Passable<E> and(Passable<E> condition);
    
    /**
     * This allows to chain two conditions with boolean OR and return the new
     * condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Passable object
     */
    Passable<E> or(Passable<E> condition);
    
    /**
     * This allows to chain two conditions with boolean AND NOT and return the
     * new condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Passable object
     */
    Passable<E> andNot(Passable<E> condition);
    
    /**
     * This allows to chain two conditions with boolean OR NOT and return the
     * new condition which evaluates to the proper result to allow additional
     * chaining.
     *
     * @param condition
     * @return Passable object
     */
    Passable<E> orNot(Passable<E> condition);
    
}
