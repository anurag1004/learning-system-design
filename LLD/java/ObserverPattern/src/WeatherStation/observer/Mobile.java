package WeatherStation.observer;

import WeatherStation.model.Weather;

public class Mobile implements WeatherDevice{
    Weather weather;
    @Override
    public void update(Weather weather) {
        this.weather = weather;
        this.showWeather();
    }
    public void showWeather(){
        System.out.println("MOBILE");

        System.out.println(this.weather.toString());
    }
}
