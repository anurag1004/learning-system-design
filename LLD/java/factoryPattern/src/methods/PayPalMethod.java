package methods;

public class PayPalMethod implements PaymentMethod{
    @Override
    public void pay(float amount) {
        System.out.println("PayPal:"+amount);
    }
}
