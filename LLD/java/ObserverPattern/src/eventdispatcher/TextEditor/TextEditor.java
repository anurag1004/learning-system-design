package eventdispatcher.TextEditor;

import eventdispatcher.EventManager.EventDispatcher;

public class TextEditor {
    StringBuilder sb = new StringBuilder();
    EventDispatcher eventManager;
    public TextEditor(EventDispatcher eventManager){
        this.eventManager = eventManager;
    }
    public void addText(String text){
        sb.append(text);
        this.eventManager.dispatchTextChangeEvent(text);
    }
}
