import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
public class Statue implements Visitable {
    private String name;
    private String description;
    private String openingDays;
    private String openingHours;

    private Map<LocalDate, TimeInterval> visitingTimetable = new HashMap<>();

    public Statue(String name, String description, String openingDays, String openingHours) {
        this.name = name;
        this.description = description;
        this.openingDays = openingDays;
        this.openingHours = openingHours;
    }

    @Override
    public String getOpeningDays() {
        return openingDays;
    }

    @Override
    public String getOpeningHours() {
        return openingHours;
    }

    // Getters for name and description
    public String getName() {
        return name;
    }

    @Override
    public Map<LocalDate, TimeInterval> getVisitingTimetable() {
        return visitingTimetable;
    }

    @Override
    public void addVisitingTime(LocalDate date, TimeInterval timeInterval) {
        visitingTimetable.put(date, timeInterval);
    }

    public String getDescription() {
        return description;
    }
}
