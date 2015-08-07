package vaco.conditions;

/**
 * Base condition implementation that implements simple
 * {@linkplain ConditionResult} handling for additional features. The eval()
 * method should implements evaluation logic in descendants.
 *
 * @author lokutus
 */
public abstract class AbstractCondition implements Conditional {
    
    /** The result of the condition evaluation */
    protected ConditionResult conditionResult;
    
    /**
     * @return {@code TRUE} if condition evaluates, otherwise {@code FALSE}
     */
    @Override
    public boolean evaluate() {
        if (eval()) {
            conditionResult = ConditionResult.TRUE;
            return true;
        } else {
            conditionResult = ConditionResult.FALSE;
            return false;
        }
    }
    
    /**
     * This should process the custom condition evaluation routine and return
     * the result. Expected to be overriden.
     *
     * @return TRUE/FALSE based on result of the condition evaluation
     */
    protected abstract boolean eval();
    
}
