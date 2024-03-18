public class Church implements Visitable {
    private String name;
    private String description;
    private String openingDays;
    private String openingHours;

    public Church(String name, String description, String openingDays, String openingHours) {
        this.name = name;
        this.description = description;
        this.openingDays = openingDays;
        this.openingHours = openingHours;
    }

    @Override
    public String getOpeningDays() {
        return openingDays;
    }

    @Override
    public String getOpeningHours() {
        return openingHours;
    }

    // Getters for name and description
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
