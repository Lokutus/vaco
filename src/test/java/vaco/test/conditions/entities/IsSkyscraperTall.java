package vaco.test.conditions.entities;

import vaco.conditions.AbstractChainableCondition;

public class IsSkyscraperTall extends AbstractChainableCondition {
    
    @Override
    protected boolean eval() {
        return true;
    }
    
}
