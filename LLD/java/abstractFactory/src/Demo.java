import Config.AppConfig;
import exceptions.UnsupportedOSException;
import factory.MacOSXGUIFactory;
import Application.App;
import factory.WindowsGUIFactory;

public class Demo {
    public static App configureApp() throws UnsupportedOSException {
        String os = AppConfig.getOS();
        if(os.equalsIgnoreCase("Mac OS X")){
            return new App(new MacOSXGUIFactory());
        }else if(os.equalsIgnoreCase("Windows")) {
            return new App(new WindowsGUIFactory());
        }else{
            throw new UnsupportedOSException("Unsupported OS:"+os);
        }
    }

    public static void main(String[] args) throws UnsupportedOSException {
        App app = configureApp();
        app.paint();
    }
}
