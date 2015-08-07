package vaco.conditions;

/**
 * Passable and chainable condition that implements routines to enable passing
 * the value and bool-chaining via AND, OR, negative AND and negative OR
 * functions.
 * <p>
 * Chaining and passing value through the chain EXAMPLE:
 * <p>
 * <code>
 * Conditional condition = new IsNumber("5").and(new IsSmallerThem(7)).andNot(new IsEqualTo(6));<br>
 * boolean result = condition.evaluate();
 * </code>
 *
 * @author lokutus
 */
public abstract class AbstractPassableCondition<E> extends AbstractCondition implements Passable<E> {
    
    /** The value to be passed through all involved conditions chain */
    protected E value;
    
    @Override
    public E getValue() {
        return value;
    }
    
    @Override
    public void setValue(E value) {
        this.value = value;
    }
    
    @Override
    public boolean hasValue() {
        return value != null;
    }
    
    @Override
    public Passable<E> and(Passable<E> condition) {
        
        /* Value could be passed using the constructor */
        if (!condition.hasValue())
            condition.setValue(getValue());
        
        PassableConditionResult<E> result = new PassableConditionResult<E>(
                evaluate() && condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
        
        result.setValue(getValue());
        
        return result;
    }
    
    @Override
    public Passable<E> or(Passable<E> condition) {
        
        /* Value could be passed using the constructor */
        if (!condition.hasValue())
            condition.setValue(getValue());
        
        PassableConditionResult<E> result = new PassableConditionResult<E>(
                evaluate() || condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
        
        result.setValue(getValue());
        
        return result;
    }
    
    @Override
    public Passable<E> andNot(Passable<E> condition) {
        
        /** Value could be passed using the constructor */
        if (!condition.hasValue())
            condition.setValue(getValue());
        
        PassableConditionResult<E> result = new PassableConditionResult<E>(
                evaluate() && condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
        
        result.setValue(getValue());
        
        return result;
    }
    
    @Override
    public Passable<E> orNot(Passable<E> condition) {
        
        /** Value could be passed using the constructor */
        if (!condition.hasValue())
            condition.setValue(getValue());
        
        PassableConditionResult<E> result = new PassableConditionResult<E>(
                evaluate() || condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
        
        result.setValue(getValue());
        
        return result;
    }
}
