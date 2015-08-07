package vaco.conditions.numbers;

/**
 * Compare base value with injected target value.<br>
 * Return {@code TRUE} if the base value is larger then target value. Otherwise
 * return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsLargerThen extends AbstractDoubleCompareCondition {
    
    /**
     * @param value
     * @param targetValue
     */
    public IsLargerThen(double value , double targetValue) {
        super(value, targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsLargerThen(Double targetValue) {
        super(targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsLargerThen(int targetValue) {
        super(targetValue);
    }
    
    @Override
    protected boolean eval() {
        return value.compareTo(targetValue) == AFTER;
    }
}
