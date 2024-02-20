package eventemitter.model.listener;

import eventemitter.model.event.Event;

public class SimpleListener implements Listener{
    private final String name;
    public SimpleListener(String name){
        this.name = name;
    }

    @Override
    public void onEvent(Event event) {
        System.out.printf("Listener: %s\n", name);
        System.out.println(event);
    }
}
