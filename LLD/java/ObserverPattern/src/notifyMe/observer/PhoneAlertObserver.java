package notifyMe.observer;

import notifyMe.observable.StockObservable;

public class PhoneAlertObserver implements NotificationAlertObserver{
    String phnNum;
    StockObservable stockObservable;
    public PhoneAlertObserver(String phnNum, StockObservable stockObservable){
        this.phnNum = phnNum;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        this.sendTextMsg();
    }
    public void sendTextMsg(){
        System.out.println(phnNum+": sent phone notification");
    }
}
