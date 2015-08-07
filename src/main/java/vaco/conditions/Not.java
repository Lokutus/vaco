package vaco.conditions;

/**
 * Chainable condition negation. Should be used as the first condition.
 * <p>
 * <code>
 * Conditional condition = new Not(new IsCondition1()).andNot(new IsCondition2());
 * condition.evaluate();
 * </code>
 *
 * @author lokutus
 */
public final class Not extends AbstractChainableCondition {
    
    /** The condition that is being negated by this condition */
    private Chainable condition;
    
    /**
     * @param condition
     */
    public Not(Chainable condition) {
        this.condition = condition;
    }
    
    @Override
    protected boolean eval() {
        return !condition.evaluate();
    }
}
