import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ForecastDataFilteringService {

    private final int middayHour = 12;

    public WeatherForecastResponse FilterBytMidday(WeatherForecastResponse weatherForecastResponse) {
        Predicate<ForecastData> byMidday = forecastData -> forecastData.getDateTime().getHour() == middayHour;

        List<ForecastData> filteredList = weatherForecastResponse.getForecastList()
                .stream().filter(byMidday)
                .collect(Collectors.toList());
        weatherForecastResponse.setForecastList(filteredList);
        return weatherForecastResponse;
    }

}
