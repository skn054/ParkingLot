package com.example.factory;

import com.example.models.PaymentType;
import com.example.strategies.PaymentProcessor;
import com.example.strategies.UPIPaymentProcessor;

public class PaymentFactory {

    public static PaymentProcessor  getPaymentMethodByType(PaymentType type) throws Exception{

            switch (type) {
                case UPI:
                    return new UPIPaymentProcessor();
                    
            
                default:
                    throw new Exception("Illegal Payment Type");
            }
    }

}
