package notifyMe.observer;

import notifyMe.observable.StockObservable;

public class EmailAlertObserver implements NotificationAlertObserver{
    String email;
    StockObservable stockObservable;
    public EmailAlertObserver(String email, StockObservable stockObservable){
        this.email = email;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        this.sendEmail();
    }
    public void sendEmail(){
        System.out.println(email+": sent email notification");
    }
}
