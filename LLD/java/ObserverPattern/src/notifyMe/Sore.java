package notifyMe;

import notifyMe.observable.MacbookStockObservable;
import notifyMe.observable.StockObservable;
import notifyMe.observer.EmailAlertObserver;
import notifyMe.observer.NotificationAlertObserver;
import notifyMe.observer.PhoneAlertObserver;

public class Sore {
    public static void main(String[] args) {
        NotificationAlertObserver observer1 = new EmailAlertObserver("abc@gmail.com", new MacbookStockObservable());
        NotificationAlertObserver observer2 = new EmailAlertObserver("abc@gmail.com", new MacbookStockObservable());
        NotificationAlertObserver observer3 = new PhoneAlertObserver("9898201231", new MacbookStockObservable());

        StockObservable stockObservable = new MacbookStockObservable();
        stockObservable.add(observer1);
        stockObservable.add(observer2);
        stockObservable.add(observer3);

        stockObservable.setStocksCount(10);
        stockObservable.setStocksCount(100);
    }
}
