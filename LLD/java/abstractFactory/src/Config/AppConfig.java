package Config;

public class AppConfig {
    private static String os = "";
    public static String getOS(){
        if(os==null || os.isEmpty()) {
            os = System.getProperty("os.name");
        }
        return os;
    }
}
