package model.logicblocks.implementation.conditions;

import model.engine.logicblock.definitions.Conditional;
import model.domain.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class MerchantThresholdReachedConditional implements Conditional<PaymentRequest> {

    @Override
    public boolean verify(PaymentRequest paymentRequest) {
        System.out.println("MerchantThresholdReachedConditional verify: " + paymentRequest.getId());
        return true;
    }

    @Override
    public void doPositive(PaymentRequest paymentRequest) {
        System.out.println("MerchantThresholdReachedConditional doPositive: " + paymentRequest.getId());
    }

    @Override
    public void doNegative(PaymentRequest paymentRequest) {
        System.out.println("MerchantThresholdReachedConditional doNegative: " + paymentRequest.getId());
    }


}
