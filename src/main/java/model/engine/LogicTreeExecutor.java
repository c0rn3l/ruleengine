package model.engine;

import model.engine.logicblock.wrappers.LogicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogicTreeExecutor<T> {

    private LogicBlock root;

    @Autowired
    public LogicTreeExecutor(LogicTreeExecutorBuilder logicTreeExecutorBuilder) {
        this.root = logicTreeExecutorBuilder.getRoot();
    }

    public void launch(T t) {
        root.apply(t);
    }
}
