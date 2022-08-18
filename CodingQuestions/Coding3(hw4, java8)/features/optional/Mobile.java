import java.util.Optional;

public class Mobile {
    private long id;
    private String brand;
    private String name;
    private Optional<DisplayFeatures> displayFeaturesOptional;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<DisplayFeatures> getDisplayFeaturesOptional() {
        return displayFeaturesOptional;
    }

    public void setDisplayFeaturesOptional(Optional<DisplayFeatures> displayFeaturesOptional) {
        this.displayFeaturesOptional = displayFeaturesOptional;
    }
}
