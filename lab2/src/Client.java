import java.time.LocalTime;

public class Client {

    public enum ClientType {
        REGULAR,
        PREMIUM
    }

    private String name;
    private ClientType clientType;
    private LocalTime minTime;
    private LocalTime maxTime;

    // Constructor, getters, setters, and other methods
    public Client(String name, ClientType clientType, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.clientType = clientType;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
    public Client(String name, ClientType clientType){
        this.name = name;
        this.clientType = clientType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", clientType=" + clientType +
                '}';
    }
}
