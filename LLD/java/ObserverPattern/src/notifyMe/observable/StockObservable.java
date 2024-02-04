package notifyMe.observable;

import notifyMe.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver alertObserver);
    public void remove(NotificationAlertObserver alertObserver);
    public void notifySubscribers();
    public void setStocksCount(int stocksCount);
    public int getStocksCount();
}
