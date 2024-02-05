package buttons;

public class MacOSButton implements Button {

    public MacOSButton(){
        System.out.println("MacOS button created");
    }
    @Override
    public void onClick() {
        System.out.println("Mac");
    }
}
