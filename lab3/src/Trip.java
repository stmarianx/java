import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String city;
    private String period;
    private List<Object> attractions; // Using Object to store any type of attraction

    public Trip(String city, String period) {
        this.city = city;
        this.period = period;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Object attraction) {
        this.attractions.add(attraction);
    }

    // Getters and setters for city and period
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    // Getter for attractions
    public List<Object> getAttractions() {
        return attractions;
    }
}
