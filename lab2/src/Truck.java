public class Truck extends Vehicle {
    private int capacity; // Load capacity of the truck

    // Updated constructor to include Depot parameter
    public Truck(String registrationNumber, Depot depot, int capacity) {
        super(registrationNumber, depot); // Pass both registrationNumber and depot to the Vehicle constructor
        this.capacity = capacity;
    }

    // Getter for the capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter for the capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "registrationNumber='" + getRegistrationNumber() + '\'' +
                ", capacity=" + capacity +
                ", depot=" + getDepot().getName() +
                '}';
    }
}
