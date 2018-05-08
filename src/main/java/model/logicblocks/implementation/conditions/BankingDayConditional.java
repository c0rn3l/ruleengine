package model.logicblocks.implementation.conditions;


import model.domain.PaymentRequest;
import model.engine.logicblock.definitions.Conditional;
import org.springframework.stereotype.Component;

@Component
public class BankingDayConditional implements Conditional<PaymentRequest> {

    @Override
    public boolean verify(PaymentRequest paymentRequest) {
        System.out.println("BankingDayConditional verify: " + paymentRequest.getId());
        return false;
    }

    @Override
    public void doPositive(PaymentRequest paymentRequest) {
        System.out.println("BankingDayConditional doPositive: " + paymentRequest.getId());
    }

    @Override
    public void doNegative(PaymentRequest paymentRequest) {
        System.out.println("BankingDayConditional doNegative: " + paymentRequest.getId());
    }
}
