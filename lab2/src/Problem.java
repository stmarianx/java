import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Depot> depots = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addDepot(Depot depot) {
        if (!depots.contains(depot)) {
            depots.add(depot);
        } else {
            System.out.println("Depot already exists: " + depot.getName());
        }
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        } else {
            System.out.println("Client already exists: " + client.getName());
        }
    }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        } else {
            System.out.println("Vehicle already exists: " + vehicle.getRegistrationNumber());
        }
    }

    public Vehicle[] getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for (Depot depot : depots) {
            allVehicles.addAll(depot.getVehicles());
        }
        return allVehicles.toArray(new Vehicle[0]);
    }
    public List<Depot> getDepots() {
        return new ArrayList<>(depots);
    }

    public List<Client> getClients() {
        return new ArrayList<>(clients);
    }
}

