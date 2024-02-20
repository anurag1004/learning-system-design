package eventemitter.model.event;

import eventemitter.model.enums.EventType;

public class Event {
    private final EventType eventType;
    private final String data;

    public Event(EventType eventType, String data) {
        this.eventType = eventType;
        this.data = data;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getData() {
        return data;
    }
    public String toString(){
        return String.format("EventType: %s, Data:%s",eventType.toString(), data);
    }
}
