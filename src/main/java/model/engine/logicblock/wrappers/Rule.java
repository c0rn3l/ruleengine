package model.engine.logicblock.wrappers;

import model.engine.logicblock.definitions.Conditional;

import java.util.Optional;

public class Rule<T> implements LogicBlock<T> {

    private Conditional conditional;
    private Optional<LogicBlock> logicBlockAfterConditionPass;
    private Optional<LogicBlock> logicBlockAfterConditionFail;

    public Rule(Conditional conditional, LogicBlock logicBlockAfterConditionPass, LogicBlock logicBlockAfterConditionFail) {
        this.conditional = conditional;
        this.logicBlockAfterConditionPass = Optional.ofNullable(logicBlockAfterConditionPass);
        this.logicBlockAfterConditionFail = Optional.ofNullable(logicBlockAfterConditionFail);
    }

    public void apply(T t) {
        if(conditional.verify(t)) {
            conditional.doPositive(t);
            logicBlockAfterConditionPass.ifPresent(logicBlock -> logicBlock.apply(t));
        } else {
            conditional.doNegative(t);
            logicBlockAfterConditionFail.ifPresent(logicBlock -> logicBlock.apply(t));
        }
    }
}
