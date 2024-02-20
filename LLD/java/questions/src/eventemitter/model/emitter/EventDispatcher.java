package eventemitter.model.emitter;

import eventemitter.model.enums.EventType;
import eventemitter.model.event.Event;
import eventemitter.model.listener.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class EventDispatcher implements EventEmitter{
    private final Map<EventType,List<Listener>> eventSubscribersMap;
    private final EventQueueManager eventQueueManager;
    public EventDispatcher(){
        this.eventSubscribersMap = new ConcurrentHashMap<>();
        for(EventType eventType: EventType.values()) this.eventSubscribersMap.put(eventType, new ArrayList<>());
        this.eventQueueManager = new EventQueueManager(eventSubscribersMap);
        // start the event loop thread
        this.startEventLoop();
    }
    @Override
    public void subscribe(EventType eventType, Listener listener) {
        eventSubscribersMap.get(eventType).add(listener);
    }

    @Override
    public void unsubscribe(EventType eventType, Listener listener) {
        eventSubscribersMap.get(eventType).remove(listener);
    }

    @Override
    public void emit(Event event) {
        // add event to eventQueue
        this.eventQueueManager.addEvent(event);
    }
    public void stopEventLoop(){
        eventQueueManager.stopEventLoop();
    }
    public void startEventLoop(){
        eventQueueManager.startEventLoop();
    }
}
