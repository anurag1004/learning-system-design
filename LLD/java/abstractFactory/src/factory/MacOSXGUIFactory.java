package factory;

import Button.*;
import Checkbox.*;

public class MacOSXGUIFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSXButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSXCheckbox();
    }
}
