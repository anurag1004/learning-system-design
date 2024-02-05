package methods;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public void pay(float amount) {
        System.out.println("credit card:"+amount);
    }
}
