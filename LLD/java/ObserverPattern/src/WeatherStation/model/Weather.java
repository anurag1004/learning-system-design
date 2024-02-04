package WeatherStation.model;

public class Weather {
    int temp;
    float humidity;
    int windSpeed;
    int aqi;
    public Weather(){

    }

    public Weather(int temp, float humidity, int windSpeed, int aqi) {
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.aqi = aqi;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }
    public String toString(){
        return String.format("====== Today's Weather ======\n" +
                        "Temp: %d C\n" +
                        "Humidity: %.2f \n" +
                        "Wind Speed: %d kmph\n"+
                        "AQI: %d\n",
                temp, humidity * 100f, windSpeed, aqi);
    }
}
