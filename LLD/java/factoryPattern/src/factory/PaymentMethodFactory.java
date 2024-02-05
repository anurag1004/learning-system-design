package factory;

import enums.PaymentType;
import exceptions.InvalidPaymentTypeException;
import methods.CreditCardPayment;
import methods.DebitCardPayment;
import methods.PayPalMethod;
import methods.PaymentMethod;
public class PaymentMethodFactory {
    public PaymentMethod createPaymentMethod(PaymentType paymentType) throws InvalidPaymentTypeException{
        switch (paymentType){
            case CREDIT :
                return new CreditCardPayment();
            case DEBIT:
                return new DebitCardPayment();
            case PAYPAL:
                return new PayPalMethod();
            default:
                throw new InvalidPaymentTypeException("Invalid payment type: "+paymentType);
        }
    }
}
