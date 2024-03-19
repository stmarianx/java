import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Concert implements Visitable, Payable {
    private String name;
    private String description;
    private double entryFee;
    private String openingDays; // To satisfy Visitable interface
    private String openingHours; // To satisfy Visitable interface
    private Map<LocalDate, TimeInterval> visitingTimetable = new HashMap<>();

    public Concert(String name, String description, String openingDays, String openingHours, double entryFee) {
        this.name = name;
        this.description = description;
        this.openingDays = openingDays; // Initialize openingDays
        this.openingHours = openingHours; // Initialize openingHours
        this.entryFee = entryFee;
    }

    @Override
    public String getOpeningDays() {
        return openingDays;
    }

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

    @Override
    public double getEntryFee() {
        return entryFee;
    }

    // Getters for name and description
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
