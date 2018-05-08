package model.logicblocks.implementation.execution;

import model.domain.PaymentRequest;
import model.engine.logicblock.definitions.Executable;
import org.springframework.stereotype.Component;

@Component
public class PopulatePaymentInstructionExecutable implements Executable<PaymentRequest> {

    @Override
    public void execute(PaymentRequest paymentRequest) {
        System.out.println("PopulatePaymentInstructionExecutable execute: " + paymentRequest.getId());
    }
}
