package Application;
import Checkbox.Checkbox;
import Button.Button;
import factory.GUIFactory;

public class App {
    private Button button;
    private Checkbox checkbox;

    public App(GUIFactory factory){
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }
    public void paint(){
        this.button.paint();
        this.checkbox.paint();
    }

}
