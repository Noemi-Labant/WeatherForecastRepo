import com.fasterxml.jackson.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "main",
        "weather",
        "dt_txt"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastData {
    @JsonProperty("main")
    private ForecastMainData forecastMainData;
    @JsonProperty("weather")
    private List<Weather> weather = null;
    @JsonProperty("dt_txt")
    private LocalDateTime dateTime;

    @JsonProperty("main")
    public ForecastMainData getForecastMainData() {
        return forecastMainData;
    }

    @JsonProperty("main")
    public void setForecastMainData(ForecastMainData forecastMainData) {
        this.forecastMainData = forecastMainData;
    }

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("dt_txt")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @JsonProperty("dt_txt")
    public void setDateTime(String dtTxt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateTime = LocalDateTime.parse(dtTxt, formatter);
    }

}