package eventemitter.model.emitter;

import eventemitter.model.enums.EventType;
import eventemitter.model.event.Event;
import eventemitter.model.listener.Listener;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class EventQueueManager {
    private volatile boolean isEventLoopRunning = false;
    private final BlockingQueue<Event> eventQueue;
    private final Map<EventType, List<Listener>> eventSubscribersMap;
    private Thread eventLoop;
    public EventQueueManager(Map<EventType, List<Listener>> eventSubscribersMap){
        this.eventQueue = new LinkedBlockingQueue<>();
        this.eventSubscribersMap = eventSubscribersMap;
    }
    public void addEvent(Event event){
        eventQueue.add(event);
    }
    public void startEventLoop(){
        if(isEventLoopRunning){
            // already running
            return;
        }
        isEventLoopRunning = true;
        eventLoop = new Thread(()->{
            while(isEventLoopRunning) {
                try {
                    Thread.sleep(1000);
                    Event event = eventQueue.take();
                    for (Listener listener : eventSubscribersMap.get(event.getEventType())) {
                        listener.onEvent(event);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        },"eventLoop");
        eventLoop.start();
    }
    public void stopEventLoop(){
        isEventLoopRunning = false;
        eventLoop.interrupt();
    }
}
