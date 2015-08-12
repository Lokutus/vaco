package vaco.test.conditions.entities;

import vaco.conditions.AbstractChainableCondition;

public class IsSalmonFish extends AbstractChainableCondition {
    
    @Override
    protected boolean eval() {
        return true;
    }
    
}
