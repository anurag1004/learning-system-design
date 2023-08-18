package interfaces;

import model.Weather;

// Observer
public interface PortableWeatherDevice {
    boolean updateWeather(Weather weather);
}
