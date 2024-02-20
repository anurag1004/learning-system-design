package eventemitter.model.emitter;

import eventemitter.model.enums.EventType;
import eventemitter.model.event.Event;
import eventemitter.model.listener.Listener;

public interface EventEmitter {
    public void subscribe(EventType eventType, Listener listener);
    public void unsubscribe(EventType eventType, Listener listener);
    public void emit(Event event);
    public void startEventLoop();
    public void stopEventLoop();
}
