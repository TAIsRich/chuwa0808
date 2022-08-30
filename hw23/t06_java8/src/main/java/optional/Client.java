package optional;

import java.util.Optional;
public class Client {

    public int getMobileScreenWidth(Mobile7 mobile7) {
        if (mobile7 != null) {
            DisplayFeatures7 df = mobile7.getDisplayFeatures();
            if (df != null) {
                ScreenResolution sr = df.getResolution();
                if (sr != null) {
                    return sr.getWidth();
                }
            }
        }

        return 0;
    }

    public int getMobileScreenWidthOptional(Mobile mobile) {
        return Optional.ofNullable(mobile).flatMap(Mobile::getDisplayFeaturesOptional)
                .flatMap(DisplayFeatures::getResolutionOptional)
                .map(ScreenResolution::getWidth)
                .orElse(0);
    }
}