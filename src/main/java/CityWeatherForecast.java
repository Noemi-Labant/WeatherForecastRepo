public class CityWeatherForecast {

    private WeatherForecastResponse weatherForecastResponse;
    private String cityName;

    public CityWeatherForecast(String cityName, WeatherForecastResponse weatherForecastResponse) {
        this.cityName = cityName;
        this.weatherForecastResponse = weatherForecastResponse;
    }

    public WeatherForecastResponse getWeatherForecastResponse() {
        return this.weatherForecastResponse;
    }

    public void setWeatherForecastResponse(WeatherForecastResponse weatherForecastResponse) {
        this.weatherForecastResponse = weatherForecastResponse;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
