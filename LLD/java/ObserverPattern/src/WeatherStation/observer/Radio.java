package WeatherStation.observer;

import WeatherStation.model.Weather;

public class Radio implements WeatherDevice{
     Weather weather;

    @Override
    public void update(Weather weather) {
        this.weather = weather;
        this.showWeather();
    }

    @Override
    public void showWeather() {
        System.out.println("RADIO");
        System.out.println(this.weather.toString());
    }
}
