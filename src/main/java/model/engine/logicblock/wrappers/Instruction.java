package model.engine.logicblock.wrappers;

import model.engine.logicblock.definitions.Executable;

import java.util.Optional;

public class Instruction<T> implements LogicBlock<T> {

    private Executable executable;
    private Optional<LogicBlock> nextLogicBlock;

    public Instruction(Executable executable, LogicBlock nextLogicBlock) {
        this.executable = executable;
        this.nextLogicBlock = Optional.ofNullable(nextLogicBlock);
    }

    @Override
    public void apply(T t) {
        executable.execute(t);
        nextLogicBlock.ifPresent(logicBlock -> logicBlock.apply(t));
    }
}
