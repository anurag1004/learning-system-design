package eventdispatcher.EventManager;

import eventdispatcher.Listner.Listener;

public interface EventDispatcher {
    public void subscribe(Listener listener);
    public void unsubscribe(Listener listener);
    public void dispatchTextChangeEvent(String text);
}
