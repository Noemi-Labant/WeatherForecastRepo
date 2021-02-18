import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cod",
        "list"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastResponse {

    @JsonProperty("cod")
    private int code;
    @JsonProperty("list")
    private List<ForecastData> forecastList = null;

    @JsonProperty("cod")
    public int getCode() {
        return this.code;
    }

    @JsonProperty("cod")
    public void setCode(int code) {
        this.code = code;
    }

    @JsonProperty("list")
    public List<ForecastData> getForecastList() {
        return forecastList;
    }

    @JsonProperty("list")
    public void setForecastList(List<ForecastData> forecastList) {
        this.forecastList = forecastList;
    }
}


