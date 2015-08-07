package vaco.conditions.numbers;

/**
 * Compare base value with injected target value.<br>
 * Return {@code TRUE} if the base value is equal to target value. Otherwise
 * return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsEqualTo extends AbstractDoubleCompareCondition {
    
    /**
     * @param value
     * @param targetValue
     */
    public IsEqualTo(double value , double targetValue) {
        super(value, targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsEqualTo(Double targetValue) {
        super(targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsEqualTo(int targetValue) {
        super(targetValue);
    }
    
    @Override
    protected boolean eval() {
        return value.compareTo(targetValue) == EQUAL;
    }
}
