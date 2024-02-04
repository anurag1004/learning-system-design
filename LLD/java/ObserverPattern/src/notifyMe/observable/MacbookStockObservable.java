package notifyMe.observable;

import notifyMe.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class MacbookStockObservable implements StockObservable{
    int stocksCount = 0;
    List<NotificationAlertObserver> observers = new ArrayList<>();
    @Override
    public void add(NotificationAlertObserver alertObserver) {
        this.observers.add(alertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver alertObserver) {
        this.observers.remove(alertObserver);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver notificationAlertObserver: observers){
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStocksCount(int stocksCount) {
        if(this.stocksCount==0){
            this.notifySubscribers();
        }
        this.stocksCount+=stocksCount;
    }

    @Override
    public int getStocksCount() {
        return this.stocksCount;
    }
}
