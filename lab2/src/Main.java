import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create some depots
        Depot depot1 = new Depot("Depot 1");
        Depot depot2 = new Depot("Depot 2");

        // Create some vehicles with associated depots
        Vehicle myVehicle = new Truck("IS06BWN", depot1, 450); // 450 kg capacity
        Vehicle truck1 = new Truck("Truck A", depot1, 5000); // 5000 kg capacity
        Vehicle truck2 = new Truck("Truck B", depot2, 4500); // 4500 kg capacity
        Vehicle drone1 = new Drone("Drone X", depot1, 30); // 30 minutes flight duration
        Vehicle drone2 = new Drone("Drone Y", depot2, 45); // 45 minutes flight duration

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

        // Initialize the VRPSolver with the problem
        VRPSolver vrpSolver = new VRPSolver(problem);

        // Allocate clients to vehicles using the solver
        vrpSolver.allocateClientsToVehicles();

        // Retrieve and print out the assignments
        Map<Vehicle, List<Client>> assignments = vrpSolver.getAssignments();
        System.out.println("\nVehicle Assignments:");
        for (Map.Entry<Vehicle, List<Client>> entry : assignments.entrySet()) {
            System.out.println("Vehicle: " + entry.getKey().getRegistrationNumber() + " has clients:");
            for (Client client : entry.getValue()) {
                System.out.println("\t- " + client.getName() + " (" + client.getClientType() + ")");
            }
        }
    }
}
