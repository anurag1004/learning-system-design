package eventdispatcher.EventManager;

import eventdispatcher.Listner.Listener;

import java.util.ArrayList;
import java.util.List;

public class TextChangeEventDispatcher implements EventDispatcher{
    List<Listener> listeners = new ArrayList<>();
    @Override
    public void subscribe(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void dispatchTextChangeEvent(String text) {
        for(Listener listener: listeners){
            listener.onTextChange(text);
        }
    }

}
