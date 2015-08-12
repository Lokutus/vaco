package vaco.test.conditions.entities;

import vaco.conditions.AbstractChainableCondition;

public class IsWheelRound extends AbstractChainableCondition {
    
    @Override
    protected boolean eval() {
        return true;
    }
    
}
