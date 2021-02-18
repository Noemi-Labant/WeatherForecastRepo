import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmailBodyService {

    private final String whiteSpace = " ";

    public String Build(String toAddress, List<CityWeatherForecast> cityWeatherForecastList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dear ");
        stringBuilder.append(toAddress);
        stringBuilder.append(",");
        for (CityWeatherForecast cityWeatherForecast : cityWeatherForecastList) {
            stringBuilder.append("\n\nThe weather for the upcoming days in ");
            stringBuilder.append(cityWeatherForecast.getCityName());
            stringBuilder.append(" is:");
            stringBuilder.append("\n");
            for (ForecastData forecastData : cityWeatherForecast.getWeatherForecastResponse().getForecastList())
            {
                stringBuilder.append("\n");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd");
                stringBuilder.append(forecastData.getDateTime().format(formatter));
                stringBuilder.append(whiteSpace);
                stringBuilder.append(":");
                stringBuilder.append(whiteSpace);
                stringBuilder.append(forecastData.getWeather().get(0).getDescription());
                stringBuilder.append("\n");
                stringBuilder.append("Temperature: ");
                stringBuilder.append(forecastData.getForecastMainData().getTemperature());
                stringBuilder.append("°C");
                stringBuilder.append(whiteSpace);
                stringBuilder.append("Feels like: ");
                stringBuilder.append(forecastData.getForecastMainData().getFeelsLike());
                stringBuilder.append("°C");
                stringBuilder.append(whiteSpace);
                stringBuilder.append("Humidity: ");
                stringBuilder.append(forecastData.getForecastMainData().getHumidity());
                stringBuilder.append("%");

            }
        }
        stringBuilder.append("\n\nEnjoy!");
        return stringBuilder.toString();
    }

}
