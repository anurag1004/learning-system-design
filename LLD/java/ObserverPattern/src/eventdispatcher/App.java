package eventdispatcher;

import eventdispatcher.EventManager.EventDispatcher;
import eventdispatcher.EventManager.TextChangeEventDispatcher;
import eventdispatcher.Listner.Listener;
import eventdispatcher.Listner.TextChangeListener;
import eventdispatcher.TextEditor.TextEditor;

public class App {
    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new TextChangeEventDispatcher();
        Listener listener1 = new TextChangeListener();
        Listener listener2 = new TextChangeListener();
        eventDispatcher.subscribe(listener1);
        eventDispatcher.subscribe(listener2);
        TextEditor textEditor = new TextEditor(eventDispatcher);
        textEditor.addText("hello");
    }
}
