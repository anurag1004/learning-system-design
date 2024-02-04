package WeatherStation.observable;

import WeatherStation.model.Weather;
import WeatherStation.observer.Receiver;

import java.util.ArrayList;
import java.util.List;

public interface Broadcast {
    public void add(Receiver receiver);
    public void remove(Receiver receiver);
    public void broadcast(); // notify all the receivers
    public void setWeather(Weather weather);
    public Weather getWeather();
}
