import WeatherStation.model.Weather;
import WeatherStation.observable.BroadcastStation;
import WeatherStation.observer.Laptop;
import WeatherStation.observer.Mobile;
import WeatherStation.observer.Radio;

public class Main {
    public static void main(String[] args) {
        BroadcastStation broadcastStation = new BroadcastStation();
        broadcastStation.add(new Laptop());
        broadcastStation.add(new Radio());
        broadcastStation.add(new Mobile());

        broadcastStation.setWeather(new Weather(24,0.54f,10,76));
    }
}