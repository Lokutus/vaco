package vaco.conditions.numbers;

/**
 * Compare base value with injected target value.<br>
 * Return {@code TRUE} if the base value is smaller then target value. Otherwise
 * return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsSmallerThen extends AbstractDoubleCompareCondition {
    
    /**
     * @param value
     * @param targetValue
     */
    public IsSmallerThen(double value , double targetValue) {
        super(value, targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsSmallerThen(Double targetValue) {
        super(targetValue);
    }
    
    /**
     * @param targetValue
     */
    public IsSmallerThen(int targetValue) {
        super(targetValue);
    }
    
    @Override
    protected boolean eval() {
        return value.compareTo(targetValue) == BEFORE;
    }
}
