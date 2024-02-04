package eventdispatcher.Listner;

public class TextChangeListener implements Listener{
    @Override
    public void onTextChange(String text) {
        System.out.println("Text appended: "+text);
    }
}
