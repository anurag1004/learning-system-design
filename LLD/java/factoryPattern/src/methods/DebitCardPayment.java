package methods;

public class DebitCardPayment implements PaymentMethod{

    @Override
    public void pay(float amount) {
        System.out.println("Debit card:"+amount);
    }
}
