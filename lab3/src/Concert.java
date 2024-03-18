public class Concert implements Visitable, Payable {
    private String name;
    private String description;
    private String openingDays;
    private String openingHours;
    private double entryFee;

    public Concert(String name, String description, String openingDays, String openingHours, double entryFee) {
        this.name = name;
        this.description = description;
        this.openingDays = openingDays;
        this.openingHours = openingHours;
        this.entryFee = entryFee;
    }

    @Override
    public String getOpeningDays() {
        return openingDays;
    }

    @Override
    public String getOpeningHours() {
        return openingHours;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }

    // Getters for name and description
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
