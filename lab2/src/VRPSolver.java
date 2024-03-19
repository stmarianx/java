import java.util.*;

public class VRPSolver {
    private Problem problem;
    private Map<Vehicle, List<Client>> assignments;
    private Map<String, Integer> travelTimes; // Simulated travel times between locations

    public VRPSolver(Problem problem) {
        this.problem = problem;
        this.assignments = new HashMap<>();
        this.travelTimes = generateRandomTravelTimes();
    }

    /*
    {
    "Depot1->Client1" = 10,
    "Client1->Client2" = 5,
    "Client2->Depot1" = 8,
    // ... and so on for all location pairs
    }
     */

    private Map<String, Integer> generateRandomTravelTimes() {
        Map<String, Integer> generatedTravelTimes = new HashMap<>();
        Random rand = new Random();
        // Existing depot to client and client to depot times
        for (Depot depot : problem.getDepots()) {
            for (Client client : problem.getClients()) {
                String depotToClientKey = depot.getName() + "->" + client.getName();
                generatedTravelTimes.put(depotToClientKey, rand.nextInt(60));
                String clientToDepotKey = client.getName() + "->" + depot.getName();
                generatedTravelTimes.put(clientToDepotKey, rand.nextInt(60));
            }
        }
        // Additional loop for client to client times
        for (Client client1 : problem.getClients()) {
            for (Client client2 : problem.getClients()) {
                if (!client1.equals(client2)) { // Ensure we're not creating a path to the same client
                    String clientToClientKey = client1.getName() + "->" + client2.getName();
                    generatedTravelTimes.put(clientToClientKey, rand.nextInt(60));
                }
            }
        }
        return generatedTravelTimes;
    }


    public void allocateClientsToVehicles() {
        for (Client client : problem.getClients()) {
            Vehicle bestVehicle = null;
            int bestTimeIncrease = Integer.MAX_VALUE;

            for (Vehicle vehicle : problem.getVehicles()) {
                // For simplicity, assume all vehicles can start a new route from their depot to the client.
                int timeIncrease = travelTimes.get(vehicle.getDepot().getName() + "->" + client.getName());
                if (timeIncrease < bestTimeIncrease) {
                    bestTimeIncrease = timeIncrease;
                    bestVehicle = vehicle;
                }
            }

            if (bestVehicle != null) {
                List<Client> vehicleClients = assignments.computeIfAbsent(bestVehicle, k -> new ArrayList<>());
                vehicleClients.add(client);
            }
        }
    }

    public Map<Vehicle, List<Client>> getAssignments() {
        return assignments;
    }
}
