package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("rules.properties")
public class Properties {

    @Autowired
    private Environment env;

    @Value("${rule.executor.startrule}")
    private String startRule;

    public String getStartRule() {
        return startRule;
    }

    public String getPositiveLabel(String conditionalName) {
        return env.getProperty(conditionalName + ".positive");
    }

    public String getNegativeLabel(String conditionalName) {
        return env.getProperty(conditionalName + ".negative");
    }

    public String getNextInstructionLabel(String executableName) {
        return env.getProperty(executableName + ".next");
    }
}
