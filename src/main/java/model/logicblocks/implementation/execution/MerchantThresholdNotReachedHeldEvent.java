package model.logicblocks.implementation.execution;

import model.engine.logicblock.definitions.Executable;
import model.domain.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class MerchantThresholdNotReachedHeldEvent implements Executable<PaymentRequest> {

    @Override
    public void execute(PaymentRequest paymentRequest) {
        System.out.println("MerchantThresholdNotReachedHeldEvent execute: " + paymentRequest.getId());
    }
}
