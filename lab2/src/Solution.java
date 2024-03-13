import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Solution {
    private Map<Vehicle, List<Client>> vehicleAssignments;

    public Solution() {
        this.vehicleAssignments = new HashMap<>();
    }

    public void assignClientToVehicle(Vehicle vehicle, Client client) {
        // Get the current list of clients assigned to the vehicle, or create a new list if none exists
        List<Client> assignedClients = this.vehicleAssignments.computeIfAbsent(vehicle, k -> new ArrayList<>());
        // Add the client to the list
        assignedClients.add(client);
    }

    public Map<Vehicle, List<Client>> getVehicleAssignments() {
        return vehicleAssignments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Solution:\n");
        for (Map.Entry<Vehicle, List<Client>> entry : vehicleAssignments.entrySet()) {
            sb.append(entry.getKey().getRegistrationNumber())
                    .append(": ")
                    .append(entry.getValue().size())
                    .append(" clients\n");
        }
        return sb.toString();
    }

}
