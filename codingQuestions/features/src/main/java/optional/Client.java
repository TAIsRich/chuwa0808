package optional;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        Mobile7 mobile7 = new Mobile7();
        getMobileScreenWidth(mobile7);
    }

    public static int getMobileScreenWidth(Mobile7 mobile7) {
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

    public static int getMobileScreenWidthOptional(Mobile mobile) {
        return Optional.ofNullable(mobile).flatMap(Mobile::getDisplayFeaturesOptional)
                .flatMap(DisplayFeatures::getResolutionOptional)
                .map(ScreenResolution::getWidth)
                .orElse(0);
    }
}
