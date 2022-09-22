package com.chuwa.customerRewards.payload;

public class PointDto {
    private Long id;
    private int point;
    private String firstName;
    private String lastName;

    public PointDto() {
    }

    public PointDto(Long id, int point, String firstName, String lastName) {
        this.id = id;
        this.point = point;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
