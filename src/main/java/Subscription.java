import java.util.ArrayList;
import java.util.List;

public class Subscription {

    private String emailAddress;
    private List<String> cities;

    public Subscription(String[] row) {
        this.emailAddress = row[0];
        this.cities = new ArrayList<String>();
        for (int i = 1; i < row.length; i++) {
            cities.add(row[i]);
        }
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<String> getCities() {
        return this.cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

}
