package vaco.conditions.numbers;

import vaco.conditions.AbstractPassableCondition;

public abstract class AbstractDoubleCompareCondition extends AbstractPassableCondition<Double> {
    
    protected static final int EQUAL = 0;
    protected static final int AFTER = 1;
    protected static final int BEFORE = -1;
    
    /** A value to be compared with */
    protected Double targetValue;
    
    /**
     * Basic constructor without passing a value
     * 
     * @param value
     * @param targetValue
     */
    public AbstractDoubleCompareCondition(double value , double targetValue) {
        this.value = value;
        this.targetValue = targetValue;
    }
    
    /**
     * Constructor with the double value to be compared with
     * 
     * @param targetValue
     */
    public AbstractDoubleCompareCondition(Double targetValue) {
        this.targetValue = targetValue;
    }
    
    /**
     * Constructor with the integer value to be compared with
     * 
     * @param targetValue
     */
    public AbstractDoubleCompareCondition(int targetValue) {
        this.targetValue = (double) targetValue;
    }
}
