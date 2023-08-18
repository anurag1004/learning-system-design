package model;

import interfaces.PortableWeatherDevice;

public class Phone implements PortableWeatherDevice {
    @Override
    public boolean updateWeather(Weather weather) {
        System.out.println("==============================================");
        System.out.println("PHONE Weather Report Updating...");
        try{
            System.out.printf("Temperature:%.1f,Humidity:%.1f,WindSpeed:%.1f\n",weather.getTemp(), weather.getHumidity(), weather.getWindSpeed());
            System.out.println("==============================================");
            return true;
        }catch (Exception e){
            e.getStackTrace();
        }
        System.out.println("==============================================");
        return false;
    }
}
