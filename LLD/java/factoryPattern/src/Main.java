import enums.PaymentType;
import exceptions.InvalidPaymentTypeException;
import factory.PaymentMethodFactory;
import methods.PaymentMethod;
public class Main {
    public static void main(String[] args) throws InvalidPaymentTypeException {
        PaymentMethodFactory paymentMethodFactory = new PaymentMethodFactory();
        PaymentMethod paymentType = paymentMethodFactory.createPaymentMethod(PaymentType.CREDIT);
        paymentType.pay(12.45f);
        paymentType = paymentMethodFactory.createPaymentMethod(PaymentType.DEBIT);
        paymentType.pay(192.12f);
        paymentType = paymentMethodFactory.createPaymentMethod(PaymentType.XYZ_PAY);
        paymentType.pay(192.12f);

    }
}