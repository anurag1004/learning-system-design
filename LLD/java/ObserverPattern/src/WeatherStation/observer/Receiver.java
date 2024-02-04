package WeatherStation.observer;

import WeatherStation.model.Weather;

public interface Receiver {
    public void update(Weather weather);
}
