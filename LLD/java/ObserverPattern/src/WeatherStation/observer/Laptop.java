package WeatherStation.observer;

import WeatherStation.model.Weather;

public class Laptop implements WeatherDevice{
    Weather weather;
    @Override
    public void update(Weather weather) {
        this.weather = weather;
        this.showWeather();

    }
    public void showWeather(){
        System.out.println("LAPTOP");
        System.out.printf(this.weather.toString());
    }
}
