package interfaces;

import model.Weather;

public interface WeatherStationObservable {
    void add(PortableWeatherDevice portableWeatherDevice);
    void remove(PortableWeatherDevice portableWeatherDevice);

    // will notify to all entertainment systems about the temp and humidity change
    void broadcast();

    void setTemperature(Float temperature);

    void setHumidity(Float humidity);

    void setWindSpeed(Float windSpeed);

    public void setWeather(Weather weather);
}
