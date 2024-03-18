public abstract class Vehicle {
    private String registrationNumber;
    private Depot depot; // Add reference to Depot

    public Vehicle(String registrationNumber, Depot depot) {
        this.registrationNumber = registrationNumber;
        this.depot = depot;
    }

    public Depot getDepot() {
        return depot;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
