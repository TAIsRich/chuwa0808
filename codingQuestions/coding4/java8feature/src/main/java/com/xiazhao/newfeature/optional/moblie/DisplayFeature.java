package com.xiazhao.newfeature.optional.moblie;

import com.xiazhao.newfeature.optional.mobile7.ScreenResolution;

import java.util.Optional;

public class DisplayFeature {
    private String size;
    private Optional<ScreenResolution> screenResolution;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Optional<ScreenResolution> getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(Optional<ScreenResolution> screenResolution) {
        this.screenResolution = screenResolution;
    }
}
