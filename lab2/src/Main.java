public class Main {
    public static void main(String[] args) {
        // Create a vehicle
        Vehicle vehicle = new Truck("IS06BWN", 50);
        System.out.println(vehicle);

        // Create a regular client
        Client regularClient = new Client("John Doe", Client.ClientType.REGULAR);
        System.out.println(regularClient);

        // Create a premium client
        Client premiumClient = new Client("Jane Doe", Client.ClientType.PREMIUM);
        System.out.println(premiumClient);

        // Create a depot and add the vehicle and clients
        Depot depot = new Depot("Depot1");
        depot.addVehicle(vehicle);
        System.out.println(depot);
    }
}