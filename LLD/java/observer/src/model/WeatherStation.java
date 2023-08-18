package model;

import interfaces.PortableWeatherDevice;
import interfaces.WeatherStationObservable;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherStationObservable {
    private List<PortableWeatherDevice> portableWeatherDeviceList = new ArrayList<>();
    private Weather weather;
    @Override
    public void add(PortableWeatherDevice portableWeatherDevice) {
        portableWeatherDeviceList.add(portableWeatherDevice);
    }

    @Override
    public void remove(PortableWeatherDevice portableWeatherDevice) {
        portableWeatherDeviceList.remove(portableWeatherDevice);
    }

    @Override
    public void broadcast() {
        portableWeatherDeviceList.forEach(portableWeatherDevice -> {
            portableWeatherDevice.updateWeather(this.weather);
        });
    }

    @Override
    public void setTemperature(Float temperature) {
        this.weather.setTemp(temperature);
        this.broadcast();
    }

    @Override
    public void setHumidity(Float humidity) {
        this.weather.setHumidity(humidity);
        this.broadcast();
    }

    @Override
    public void setWindSpeed(Float windSpeed) {
        this.weather.setWindSpeed(windSpeed);
        this.broadcast();
    }
    @Override
    public void setWeather(Weather weather) {
        this.weather = weather;
        this.broadcast();
    }
}
