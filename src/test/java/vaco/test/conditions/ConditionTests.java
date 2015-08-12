package vaco.test.conditions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vaco.test.conditions.entities.IsSkyBlue;
import vaco.test.conditions.entities.IsSunBlue;

/**
 * @author lokutus
 */
public class ConditionTests {
    
    @Test
    public void ConditionEvalsToTrue() {
        IsSkyBlue condition = new IsSkyBlue();
        assertTrue(condition.evaluate());
    }
    
    @Test
    public void ConditionEvalsToFalse() {
        IsSunBlue condition = new IsSunBlue();
        assertFalse(condition.evaluate());
    }
    
}
