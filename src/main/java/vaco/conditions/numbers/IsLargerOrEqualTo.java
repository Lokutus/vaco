package vaco.conditions.numbers;

/**
 * Compare base value with injected target value.<br>
 * Return {@code TRUE} if the base value is larger or equal then target value.
 * Otherwise return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsLargerOrEqualTo extends AbstractDoubleCompareCondition {
    
    /**
     * @param value
     * @param targetValue
     */
    public IsLargerOrEqualTo(double value , double targetValue) {
        super(value, targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsLargerOrEqualTo(Double targetValue) {
        super(targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsLargerOrEqualTo(int targetValue) {
        super(targetValue);
    }
    
    @Override
    protected boolean eval() {
        int result = value.compareTo(targetValue);
        return result == AFTER || result == EQUAL;
    }
}
