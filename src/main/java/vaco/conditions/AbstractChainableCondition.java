package vaco.conditions;

/**
 * Chainable condition that implements routines to enable bool-chaining via AND,
 * OR, negative AND and negative OR functions.
 * <p>
 * Chaining EXAMPLE:
 * <p>
 * <code>
 * Conditional condition = new IsCondition1().and(new IsCondition2()).andNot(new IsCondition3());<br>
 * boolean result = condition.evaluate();
 * </code>
 *
 * @author lokutus
 */
public abstract class AbstractChainableCondition extends AbstractCondition implements Chainable {
    
    @Override
    public Chainable and(Conditional condition) {
        return new ChainableConditionResult(
                evaluate() && condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
    }
    
    @Override
    public Chainable or(Conditional condition) {
        return new ChainableConditionResult(
                evaluate() || condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
    }
    
    @Override
    public Chainable andNot(Conditional condition) {
        return new ChainableConditionResult(
                evaluate() && !condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
    }
    
    @Override
    public Chainable orNot(Conditional condition) {
        return new ChainableConditionResult(
                evaluate() || !condition.evaluate()
                        ? ConditionResult.TRUE : ConditionResult.FALSE);
    }
}
