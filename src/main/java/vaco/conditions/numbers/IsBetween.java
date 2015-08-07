package vaco.conditions.numbers;

import vaco.conditions.AbstractPassableCondition;

/**
 * Compare base value with injected target value.<br>
 * Return {@code TRUE} if the base value is equal to target value. Otherwise
 * return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsBetween extends AbstractPassableCondition<Double> {
    
    private Double min;
    private Double max;
    
    /**
     * @param value
     * @param min
     * @param max
     */
    public IsBetween(double value , double min , double max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }
    
    /**
     * @param min
     * @param max
     */
    public IsBetween(double min , double max) {
        this.min = min;
        this.max = max;
    }
    
    /**
     * @param min
     * @param max
     */
    public IsBetween(int min , int max) {
        this((double) min, (double) max);
    }
    
    @Override
    protected boolean eval() {
        return value > min && value < max;
    }
}
