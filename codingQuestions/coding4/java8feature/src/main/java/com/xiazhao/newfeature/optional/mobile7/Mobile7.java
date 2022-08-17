package com.xiazhao.newfeature.optional.mobile7;

public class Mobile7 {
    private long id;
    private String brand;
    private String name;
    private DisplayFeature7 displayFeature7;

    public Mobile7(Long id, String brand, String name, DisplayFeature7 displayFeature7) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.displayFeature7 = displayFeature7;
    }

    public Mobile7() {
        this(null, null, null, null);
    }

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

    public DisplayFeature7 getDisplayFeature7() {
        return displayFeature7;
    }

    public void setDisplayFeature7(DisplayFeature7 displayFeature7) {
        this.displayFeature7 = displayFeature7;
    }
}
