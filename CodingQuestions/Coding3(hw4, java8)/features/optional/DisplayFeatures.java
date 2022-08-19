import java.util.Optional;

public class DisplayFeatures {
    private String size;
    private Optional<ScreenResolution> resolutionOptional;

    public DisplayFeatures(String size, Optional<ScreenResolution> resolutionOptional) {
        this.size = size;
        this.resolutionOptional = resolutionOptional;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Optional<ScreenResolution> getResolutionOptional() {
        return resolutionOptional;
    }

    public void setResolutionOptional(Optional<ScreenResolution> resolutionOptional) {
        this.resolutionOptional = resolutionOptional;
    }
}
