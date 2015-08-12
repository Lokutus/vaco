package vaco.test.conditions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vaco.conditions.numbers.IsEqualTo;
import vaco.conditions.numbers.IsNumber;

public class PassableConditionTest {
    
    @Test
    public void TwoPositiveConditionsJoinedWithConjunctionEvalsToTrue() {
        IsNumber isNumber = new IsNumber("5");
        IsEqualTo isEqualTo = new IsEqualTo(5);
        
        assertTrue(isNumber.and(isEqualTo).evaluate());
    }
    
    @Test
    public void TwoPositiveConditionsJoinedWithDisjunctionEvalsToTrue() {
        IsNumber isNumber = new IsNumber("5");
        IsEqualTo isEqualTo = new IsEqualTo(5);
        
        assertTrue(isNumber.or(isEqualTo).evaluate());
    }
}
