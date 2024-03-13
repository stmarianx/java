public class Drone extends Vehicle {
    private int maximumFlightDuration; // Maximum flight duration in minutes

    public Drone(String registrationNumber, int maximumFlightDuration) {
        super(registrationNumber);
        this.maximumFlightDuration = maximumFlightDuration;
    }

    public int getMaximumFlightDuration() {
        return maximumFlightDuration;
    }

    public void setMaximumFlightDuration(int maximumFlightDuration) {
        this.maximumFlightDuration = maximumFlightDuration;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "registrationNumber='" + getRegistrationNumber() + '\'' +
                ", maximumFlightDuration=" + maximumFlightDuration +
                '}';
    }
}
