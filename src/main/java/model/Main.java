package model;

import model.engine.LogicTreeExecutor;
import model.domain.PaymentRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BusinessLogicConfiguration.class);

        LogicTreeExecutor<PaymentRequest> logicTreeExecutor = context.getBean(LogicTreeExecutor.class);
        logicTreeExecutor.launch(new PaymentRequest(77));
    }
}
