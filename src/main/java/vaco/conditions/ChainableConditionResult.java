package vaco.conditions;

/**
 * Basic object to be returned as a resulting condition when two chainable
 * conditions have been bool-chained and evaluated. Evaluates only to the result
 * that was injected in the constructor.
 *
 * @author lokutus
 */
public final class ChainableConditionResult extends AbstractChainableCondition {
    
    /**
     * @param conditionResult
     */
    public ChainableConditionResult(ConditionResult conditionResult) {
        this.conditionResult = conditionResult;
    }
    
    @Override
    protected boolean eval() {
        switch (conditionResult) {
        case TRUE:
            return true;
        case FALSE:
            return false;
        default:
            return false;
        }
    }
}
