package factories;

import buttons.Button;
import buttons.MacOSButton;
import buttons.WindowsButton;
import exceptions.UnSupportedOSException;

public class ButtonFactory {
    public Button createButton() throws UnSupportedOSException {
        String os = System.getProperty("os.name");
        if(os.equalsIgnoreCase("Mac OS X")){
            return new MacOSButton();
        }else if(os.equalsIgnoreCase("Windows")){
            return new WindowsButton();
        }else{
            throw new UnSupportedOSException("Current OS not supported: "+os);
        }
    }
}
