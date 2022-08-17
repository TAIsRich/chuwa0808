package com.xiazhao.newfeature.optional;

import com.xiazhao.newfeature.optional.mobile7.DisplayFeature7;
import com.xiazhao.newfeature.optional.mobile7.Mobile7;
import com.xiazhao.newfeature.optional.mobile7.ScreenResolution;
import com.xiazhao.newfeature.optional.moblie.DisplayFeature;
import com.xiazhao.newfeature.optional.moblie.Mobile;

import java.util.Optional;

public class Client {
    public int getMobileScreenWidth(Mobile7 mobile7) {
        if (mobile7 != null) {
            DisplayFeature7 df = mobile7.getDisplayFeature7();
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
        return Optional.ofNullable(mobile).flatMap(Mobile::getDisplayFeature)
                .flatMap(DisplayFeature::getScreenResolution)
                .map(ScreenResolution::getWidth)
                .orElse(0);
    }
}
