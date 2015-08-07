package vaco.conditions.numbers;

/**
 * Compare base value with injected target value.<br>
 * Return {@code TRUE} if the base value is smaller or equal then target value.
 * Otherwise return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsSmallerOrEqualTo extends AbstractDoubleCompareCondition {
    
    /**
     * @param value
     * @param targetValue
     */
    public IsSmallerOrEqualTo(double value , double targetValue) {
        super(value, targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsSmallerOrEqualTo(Double targetValue) {
        super(targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsSmallerOrEqualTo(int targetValue) {
        super(targetValue);
    }
    
    @Override
    protected boolean eval() {
        int result = value.compareTo(targetValue);
        return result == BEFORE || result == EQUAL;
    }
}
