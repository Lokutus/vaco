package vaco.conditions;

/**
 * Basic object to be returned as a resulting condition when two passable
 * conditions have been bool-chained and evaluated. Evaluates only to the result
 * that was injected in the constructor.
 *
 * @author lokutus
 */
public final class PassableConditionResult<E> extends AbstractPassableCondition<E> {
    
    /**
     * @param conditionResult
     */
    public PassableConditionResult(ConditionResult conditionResult) {
        this.conditionResult = conditionResult;
    }
    
    @Override
    public boolean eval() {
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
