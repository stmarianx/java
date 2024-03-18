public class Drone extends Vehicle {
    private int maximumFlightDuration; // Maximum flight duration in minutes

    // Updated constructor to include Depot parameter
    public Drone(String registrationNumber, Depot depot, int maximumFlightDuration) {
        super(registrationNumber, depot); // Pass both registrationNumber and depot to the Vehicle constructor
        this.maximumFlightDuration = maximumFlightDuration;
    }

    // Getter for the maximumFlightDuration
    public int getMaximumFlightDuration() {
        return maximumFlightDuration;
    }

    // Setter for the maximumFlightDuration
    public void setMaximumFlightDuration(int maximumFlightDuration) {
        this.maximumFlightDuration = maximumFlightDuration;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "registrationNumber='" + getRegistrationNumber() + '\'' +
                ", maximumFlightDuration=" + maximumFlightDuration +
                ", depot=" + getDepot().getName() +
                '}';
    }
}
