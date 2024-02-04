package WeatherStation.observable;

import WeatherStation.model.Weather;
import WeatherStation.observer.Receiver;

import java.util.ArrayList;
import java.util.List;

public class BroadcastStation implements Broadcast{
    Weather weather;
    List<Receiver> receivers = new ArrayList<>();
    @Override
    public void add(Receiver receiver) {
        receivers.add(receiver);
    }

    @Override
    public void remove(Receiver receiver) {
        receivers.remove(receiver);
    }

    @Override
    public void broadcast() {
        receivers.forEach(receiver -> {
            receiver.update(weather);
        });
    }

    @Override
    public void setWeather(Weather weather) {
        this.weather = weather;
        this.broadcast();
    }

    @Override
    public Weather getWeather() {
        return this.weather;
    }
}
