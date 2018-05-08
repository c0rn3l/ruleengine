package model.engine;

import model.Properties;
import model.engine.logicblock.wrappers.Instruction;
import model.engine.logicblock.wrappers.LogicBlock;
import model.engine.logicblock.wrappers.Rule;
import model.engine.logicblock.definitions.Conditional;
import model.engine.logicblock.definitions.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class LogicTreeExecutorBuilder {

    private Properties properties;
    private Map<String, Conditional> conditionsMap;
    private Map<String, Executable> executionsMap;

    private LogicBlock root;

    @Autowired
    public LogicTreeExecutorBuilder(Properties properties, List<Conditional> conditionals, List<Executable> executables) {
        this.properties = properties;
        conditionsMap = conditionals.stream().collect(Collectors.toMap((conditional) -> conditional.getClass().getSimpleName(), Function.identity()));
        executionsMap = executables.stream().collect(Collectors.toMap((execution) -> execution.getClass().getSimpleName(), Function.identity()));
        root = buildBlock(properties.getStartRule());
    }

    private LogicBlock buildBlock(String logicBlockClass) {
        Conditional conditional = conditionsMap.get(logicBlockClass);
        if (null != conditional){
            return buildConditional(conditional);
        } else {
            Executable executable = executionsMap.get(logicBlockClass);
            if(null != executable) {
                return buildExecutable(executable);
            } else {
                throw new RuntimeException("label not found for class: "+logicBlockClass);
            }
        }
    }

    private Rule buildConditional(Conditional conditional) {
        String positiveInstructionLabel = properties.getPositiveLabel(conditional.getClass().getSimpleName());
        String negativeInstructionLabel = properties.getNegativeLabel(conditional.getClass().getSimpleName());
        return new Rule(conditional,
                positiveInstructionLabel != null ? buildBlock(positiveInstructionLabel) : null,
                negativeInstructionLabel != null ? buildBlock(negativeInstructionLabel) : null);
    }

    private Instruction buildExecutable(Executable executable) {
        String nextInstructionLabel = properties.getNextInstructionLabel(executable.getClass().getSimpleName());
        return new Instruction(executable,
                nextInstructionLabel != null ? buildBlock(nextInstructionLabel) : null);
    }

    public LogicBlock getRoot() {
        return root;
    }
}
