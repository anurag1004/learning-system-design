package buttons;

public class WindowsButton implements Button {
    public WindowsButton(){
        System.out.println("Windows button created");
    }
    @Override
    public void onClick() {
        System.out.println("Windows Button clicked");
    }
}
