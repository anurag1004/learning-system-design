import interfaces.PortableWeatherDevice;
import model.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // create observable
        WeatherStation weatherStation = new WeatherStation();

        // create observers
        PortableWeatherDevice radio = new Radio();
        PortableWeatherDevice phone = new Phone();
        PortableWeatherDevice tv = new Television();

        // add observers
        weatherStation.add(radio);
        weatherStation.add(phone);
        weatherStation.add(tv);

        // create some dummy weather
        Weather weather = new Weather();
        weather.setTemp(35.2f); // Celsius
        weather.setHumidity(59f); // out of 100
        weather.setWindSpeed(11.2f); // kmph

        // set weather
        weatherStation.setWeather(weather);

        Float currTemp = weather.getTemp();
        int counter = 0;
        while(counter<5){
            Thread.sleep(5000); // 5sec or 5000ms
            weatherStation.setTemperature(currTemp+0.5f);
            counter++;
            currTemp+=0.5f;
        }

    }
}