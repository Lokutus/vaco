package vaco.test.conditions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vaco.conditions.Not;
import vaco.test.conditions.entities.IsSalmonBird;
import vaco.test.conditions.entities.IsSalmonFish;
import vaco.test.conditions.entities.IsSkyscraperSmall;
import vaco.test.conditions.entities.IsSkyscraperTall;
import vaco.test.conditions.entities.IsTileRound;
import vaco.test.conditions.entities.IsWheelRound;

public class ChainableConditionTest {
    
    @Test
    public void TwoPositiveConditionsJoinedWithConjunctionEvalsToTrue() {
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        
        assertTrue(isWheelRound.and(isSkyScraperTall).evaluate());
    }
    
    @Test
    public void TwoPositiveConditionsJoinedWithDisjunctionEvalsToTrue() {
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        
        assertTrue(isWheelRound.or(isSkyScraperTall).evaluate());
    }
    
    @Test
    public void PositiveAndNegativeConditionJoinedWithConjunctionEvalsToFalse() {
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertFalse(isWheelRound.and(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void PositiveAndNegativeConditionJoinedWithDisjunctionEvalsToTrue() {
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertTrue(isSkyScraperTall.or(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void TwoNegativeConditionsJoinedWithConjunctionEvalsToFalse() {
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertFalse(isTileRound.and(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void TwoNegativeConditionsJoinedWithDisjunctionEvalsToFalse() {
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertFalse(isTileRound.or(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void TwoPositiveConditionsJoinedWithNegativeConjunctionEvalsToFalse() {
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        
        assertFalse(isWheelRound.andNot(isSkyScraperTall).evaluate());
    }
    
    @Test
    public void TwoPositiveConditionsJoinedWithNegativeDisjunctionEvalsToTrue() {
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        
        assertTrue(isWheelRound.orNot(isSkyScraperTall).evaluate());
    }
    
    @Test
    public void PositiveAndNegativeConditionsJoinedWithNegativeConjunctionEvalsToTrue() {
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertTrue(isWheelRound.andNot(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void PositiveAndNegativeConditionsJoinedWithNegativeDisjunctionEvalsToTrue() {
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertTrue(isSkyScraperTall.orNot(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void TwoNegativeConditionsJoinedWithNegativeConjunctionUsingNotEvalsToTrue() {
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertTrue(new Not(isTileRound).andNot(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void TwoNegativeConditionsJoinedWithNegativeConjunctionEvalsToFalse() {
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertFalse(isTileRound.andNot(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void TwoNegativeConditionsJoinedWithNegativeDisjunctionEvalsToTrue() {
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyScraperSmall = new IsSkyscraperSmall();
        
        assertTrue(isTileRound.orNot(isSkyScraperSmall).evaluate());
    }
    
    @Test
    public void ThreePositiveConditionsJoinedWithConjunctionEvalsToTrue() {
        IsSalmonFish isSalmonFish = new IsSalmonFish();
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        
        assertTrue(isSalmonFish.and(isWheelRound).and(isSkyScraperTall).evaluate());
    }
    
    @Test
    public void ThreePositiveConditionsJoinedWithDisjunctionEvalsToTrue() {
        IsSalmonFish isSalmonFish = new IsSalmonFish();
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperTall isSkyScraperTall = new IsSkyscraperTall();
        
        assertTrue(isSalmonFish.or(isWheelRound).or(isSkyScraperTall).evaluate());
    }
    
    @Test
    public void PositiveAndPositiveAndNegativeConditionJoinedWithConjunctionEvalsToFalse() {
        IsSalmonFish isSalmonFish = new IsSalmonFish();
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperSmall isSkyscraperSmall = new IsSkyscraperSmall();
        
        assertFalse(isSalmonFish.and(isWheelRound).and(isSkyscraperSmall).evaluate());
    }
    
    @Test
    public void PositiveAndPositiveAndNegativeConditionJoinedWithDisjunctionEvalsToTrue() {
        IsSalmonFish isSalmonFish = new IsSalmonFish();
        IsWheelRound isWheelRound = new IsWheelRound();
        IsSkyscraperSmall isSkyscraperSmall = new IsSkyscraperSmall();
        
        assertTrue(isSalmonFish.or(isWheelRound).or(isSkyscraperSmall).evaluate());
    }
    
    @Test
    public void NegativeAndNegativeAndNegativeConditionJoinedWithNegativeConjunctionEvalsToFalse() {
        IsSalmonBird isSalmonBird = new IsSalmonBird();
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyscraperSmall = new IsSkyscraperSmall();
        
        assertFalse(isSalmonBird.andNot(isTileRound).andNot(isSkyscraperSmall).evaluate());
    }
    
    @Test
    public void NegativeNegativeAndNegativeAndNegativeConditionJoinedWithNegativeConjunctionEvalsToTrue() {
        IsSalmonBird isSalmonBird = new IsSalmonBird();
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyscraperSmall = new IsSkyscraperSmall();
        
        assertTrue(new Not(isSalmonBird).andNot(isTileRound).andNot(isSkyscraperSmall).evaluate());
    }
    
    @Test
    public void NegativeNegativeAndNegativeAndNegativeConditionJoinedWithNegativeDisjunctionEvalsToTrue() {
        IsSalmonBird isSalmonBird = new IsSalmonBird();
        IsTileRound isTileRound = new IsTileRound();
        IsSkyscraperSmall isSkyscraperSmall = new IsSkyscraperSmall();
        
        assertTrue(new Not(isSalmonBird).orNot(isTileRound).orNot(isSkyscraperSmall).evaluate());
    }
}
