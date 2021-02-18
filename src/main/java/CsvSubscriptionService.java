import java.util.ArrayList;
import java.util.List;

public class CsvSubscriptionService {

    public List<Subscription> GetSubscriptions() {
        String csvFilePath = "Subscriptions.csv";
        CSVReader csvReader = new CSVReader();
        List<String[]> rows = csvReader.read(csvFilePath);

        List<Subscription> subscriptions = new ArrayList<Subscription>();
        for (String[] row : rows) {
            Subscription subscription = new Subscription(row);
            subscriptions.add(subscription);
        }
        return subscriptions;
    }
}
