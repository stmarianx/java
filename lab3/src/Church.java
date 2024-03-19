import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Church implements Visitable {
    private String name;
    private String description;
    private String openingDays; // This will store the opening days
    private String openingHours; // This will store the opening hours
    private Map<LocalDate, TimeInterval> visitingTimetable = new HashMap<>();

    // Constructor now includes opening days and hours
    public Church(String name, String description, String openingDays, String openingHours) {
        this.name = name;
        this.description = description;
        this.openingDays = openingDays;
        this.openingHours = openingHours;
    }

    // Implementing the getOpeningDays method
    @Override
    public String getOpeningDays() {
        return openingDays;
    }

    // Implementing the getOpeningHours method
    @Override
    public String getOpeningHours() {
        return openingHours;
    }

    @Override
    public Map<LocalDate, TimeInterval> getVisitingTimetable() {
        return visitingTimetable;
    }

    @Override
    public void addVisitingTime(LocalDate date, TimeInterval timeInterval) {
        visitingTimetable.put(date, timeInterval);
    }

    // Getters for name and description
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
