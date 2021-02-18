import java.util.ArrayList;
import java.util.List;

public class ForecastSendingJob {

    private CsvSubscriptionService csvSubscriptionService;
    private EmailBodyService emailBodyService;
    private EmailService emailService;
    private OpenWeatherMapService openWeatherMapService;
    private ForecastDataFilteringService forecastDataFilteringService;

    public ForecastSendingJob() {
        this.csvSubscriptionService = new CsvSubscriptionService();
        this.emailBodyService = new EmailBodyService();
        this.emailService = new EmailService();
        this.openWeatherMapService = new OpenWeatherMapService();
        this.forecastDataFilteringService = new ForecastDataFilteringService();
    }

    public void Run() {
        List<Subscription> subscriptions = csvSubscriptionService.GetSubscriptions();

        for (Subscription subscription : subscriptions) {

            List<CityWeatherForecast> cityWeatherForecastList = new ArrayList<CityWeatherForecast>();
            for (String cityName : subscription.getCities()) {

                WeatherForecastResponse weatherForecastResponse = openWeatherMapService.Get(cityName);
                if (weatherForecastResponse != null) {
                    weatherForecastResponse = forecastDataFilteringService.FilterBytMidday(weatherForecastResponse);
                    CityWeatherForecast cityWeatherForecast = new CityWeatherForecast(cityName, weatherForecastResponse);
                    cityWeatherForecastList.add(cityWeatherForecast);
                }
            }
            String emailBody = emailBodyService.Build(subscription.getEmailAddress(), cityWeatherForecastList);
            emailService.Send(subscription.getEmailAddress(), emailBody);
        }
        System.out.println("Weather forecast sending job successfully finished");
    }

}
