import buttons.Button;
import exceptions.UnSupportedOSException;
import factories.ButtonFactory;

public class App {
    public static void main(String[] args) throws UnSupportedOSException {
        ButtonFactory buttonFactory = new ButtonFactory();
        Button button = buttonFactory.createButton();
        button.onClick();
    }
}
