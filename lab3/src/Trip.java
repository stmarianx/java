import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Trip {
    private String city;
    private String period;
    private List<Visitable> attractions; // Corrected to store Visitable objects

    public Trip(String city, String period) {
        this.city = city;
        this.period = period;
        this.attractions = new ArrayList<>();
    }

    // Changed parameter type to Visitable
    public void addAttraction(Visitable attraction) {
        this.attractions.add(attraction);
    }

    public void displayVisitableNotPayable() {
        List<Visitable> visitableNotPayable = attractions.stream()
                .filter(attraction -> !(attraction instanceof Payable))
                .collect(Collectors.toList());

        for (Visitable attraction : visitableNotPayable) {
            System.out.println(attraction + " - Opens at: " + attraction.getOpeningHour(LocalDate.now()));
        }
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

    // Corrected getter for attractions to return List<Visitable>
    public List<Visitable> getAttractions() {
        return attractions;
    }
}
