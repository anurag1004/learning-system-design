package eventemitter.model.listener;

import eventemitter.model.event.Event;

public interface Listener {
    public void onEvent(Event event);
}
