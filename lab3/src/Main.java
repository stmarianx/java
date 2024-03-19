import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating attractions
        Statue libertyStatue = new Statue("Liberty Statue", "A symbol of freedom", "All week", "9:00-17:00");
        Church notreDame = new Church("Notre Dame", "Famous historic church", "All week", "8:00-19:00");
        Concert rockConcert = new Concert("Rock Concert", "Annual rock music concert", "Saturday", "18:00-23:00", 50.0);

        // Creating a trip
        Trip tripToParis = new Trip("Paris", "July 2025");

        tripToParis.addAttraction(libertyStatue);
        tripToParis.addAttraction(notreDame);
        tripToParis.addAttraction(rockConcert);

        // Printing the trip details
        System.out.println("Trip to " + tripToParis.getCity() + " in " + tripToParis.getPeriod());
        System.out.println("Attractions:");

        // Displaying attraction details
        List<Object> attractions = tripToParis.getAttractions();
        for (Object attraction : attractions) {
            if (attraction instanceof Statue) {
                Statue statue = (Statue) attraction;
                System.out.println("- Statue: " + statue.getName() + " (" + statue.getOpeningDays() + ", " + statue.getOpeningHours() + ")");
            } else if (attraction instanceof Church) {
                Church church = (Church) attraction;
                System.out.println("- Church: " + church.getName() + " (" + church.getOpeningDays() + ", " + church.getOpeningHours() + ")");
            } else if (attraction instanceof Concert) {
                Concert concert = (Concert) attraction;
                System.out.println("- Concert: " + concert.getName() + " (" + concert.getOpeningDays() + ", " + concert.getOpeningHours() + ", $" + concert.getEntryFee() + ")");
            }
        }

    }
}
