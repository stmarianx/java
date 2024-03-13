import java.util.ArrayList;
import java.util.List;

public class Depot {
    private String name;
    private List<Vehicle> vehicles;

    public Depot(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String identifier) {
        this.name = identifier;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }


    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    @Override
    public String toString() {
        return "Depot{" +
                "identifier='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }

    // … equals
}
