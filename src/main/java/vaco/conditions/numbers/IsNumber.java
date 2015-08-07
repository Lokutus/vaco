package vaco.conditions.numbers;

import vaco.conditions.AbstractPassableCondition;
import vaco.conditions.ConditionResult;

/**
 * Try to parse injected value as if it was a {@link Double} number and return
 * {@code TRUE} if the parsing was a success. Otherwise return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsNumber extends AbstractPassableCondition<Double> {
    
    /** The potential number value that is being evaluated */
    private String possibleNumber;
    
    /**
     * @param possibleNumber
     */
    public IsNumber(String possibleNumber) {
        this.possibleNumber = possibleNumber;
    }
    
    public IsNumber() {
    }
    
    @Override
    public Double getValue() {
        if (value == null)
            value = getNumber();
        
        return value;
    }
    
    @Override
    protected boolean eval() {
        conditionResult = ConditionResult.FALSE;
        
        if (value == null) {
            value = getNumber();
            if (value == null)
                return false;
        }
        
        conditionResult = ConditionResult.TRUE;
        return true;
    }
    
    /**
     * @return a number parsed out from possible number value
     */
    private Double getNumber() {
        double number;
        
        try {
            number = Double.parseDouble(possibleNumber);
        } catch (Exception e) {
            if (possibleNumber.contains(","))
                possibleNumber = possibleNumber.replace(",", ".");
            else
                possibleNumber = possibleNumber.replace(".", ",");
            try {
                number = Double.parseDouble(possibleNumber);
            } catch (Exception e2) {
                return null;
            }
        }
        
        return number;
    }
}
