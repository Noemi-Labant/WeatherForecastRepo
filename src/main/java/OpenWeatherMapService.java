import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherMapService {

    public WeatherForecastResponse Get(String cityName) {
        WeatherForecastResponse response = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?units=metric&appid=5ed6ff76bc91f37496b814f3155c5e24&q=" + cityName);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                ObjectMapper mapper = new ObjectMapper();

                response = mapper.readValue(content.toString(), WeatherForecastResponse.class);
            }
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
