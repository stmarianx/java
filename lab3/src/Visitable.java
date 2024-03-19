import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.SortedSet;

public interface Visitable {
    String getOpeningDays();
    String getOpeningHours();

    Map<LocalDate, TimeInterval> getVisitingTimetable();
    void addVisitingTime(LocalDate date, TimeInterval timeInterval);

    // Default method to get opening hour for a given date
    default LocalTime getOpeningHour(LocalDate date) {
        TimeInterval interval = getVisitingTimetable().get(date);
        return (interval != null) ? interval.getStart() : null;
    }

}
