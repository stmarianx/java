import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some depots
        Depot depot1 = new Depot("Depot 1");
        Depot depot2 = new Depot("Depot 2");

        // Create some vehicles
        Vehicle myVehicle = new Truck("IS06BWN", 450); // 450 kg capacity
        Vehicle truck1 = new Truck("Truck A", 5000); // 5000 kg capacity
        Vehicle truck2 = new Truck("Truck B", 4500); // 4500 kg capacity
        Vehicle drone1 = new Drone("Drone X", 30); // 30 minutes flight duration
        Vehicle drone2 = new Drone("Drone Y", 45); // 45 minutes flight duration

        // Assign vehicles to depots
        depot1.addVehicle(myVehicle);
        depot1.addVehicle(truck1);
        depot1.addVehicle(drone1);
        depot2.addVehicle(truck2);
        depot2.addVehicle(drone2);

        // Create some clients
        Client client1 = new Client("Client 1", Client.ClientType.REGULAR, LocalTime.of(9, 0), LocalTime.of(17, 0));
        Client client2 = new Client("Client 2", Client.ClientType.PREMIUM); // No specific time window

        // Initialize the problem
        Problem problem = new Problem();
        problem.addDepot(depot1);
        problem.addDepot(depot2);
        problem.addClient(client1);
        problem.addClient(client2);


        // Example of using the list-based getVehicles method
        System.out.println("\nList of Vehicles in all Depots:");
        List<Vehicle> vehiclesList = problem.getVehicles();
        for (Vehicle vehicle : vehiclesList) {
            System.out.println(vehicle);
        }
    }
}
