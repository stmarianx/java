public class Truck extends Vehicle {
    private int capacity; // Load capacity of the truck

    public Truck(String registrationNumber, int capacity) {
        super(registrationNumber);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "registrationNumber='" + getRegistrationNumber() + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
