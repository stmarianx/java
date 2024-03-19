import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TravelPlan {
    private Map<LocalDate, List<Visitable>> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    public void addPlan(LocalDate date, List<Visitable> attractions) {
        plan.put(date, attractions);
    }

    public void displayPlan() {
        plan.forEach((date, attractions) -> {
            System.out.println("On " + date + " visit:");
            for (Visitable attraction : attractions) {
                // Attempt to cast and print details for each type
                if (attraction instanceof Statue) {
                    Statue statue = (Statue) attraction;
                    System.out.println(" - Statue: " + statue.getName() + " - Opens at: " +
                            (statue.getOpeningHour(date) != null ? statue.getOpeningHour(date) : "Opening time not available"));
                } else if (attraction instanceof Church) {
                    Church church = (Church) attraction;
                    System.out.println(" - Church: " + church.getName() + " - Opens at: " +
                            (church.getOpeningHour(date) != null ? church.getOpeningHour(date) : "Opening time not available"));
                } else if (attraction instanceof Concert) {
                    Concert concert = (Concert) attraction;
                    System.out.println(" - Concert: " + concert.getName() + " - Ticket price: $" + concert.getEntryFee() +
                            ", Opens at: " + (concert.getOpeningHour(date) != null ? concert.getOpeningHour(date) : "Opening time not available"));
                }
            }
        });
    }
}
