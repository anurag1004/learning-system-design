package factory;

import Button.Button;
import Checkbox.Checkbox;

public interface GUIFactory {
    public Button createButton();
    public Checkbox createCheckbox();
}
