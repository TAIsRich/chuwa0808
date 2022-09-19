package com.chuwa.project.payload;

public class RewardDto {

    private Long customerId;
    private int totalPoints;
    private int currMonthPoints;

    public RewardDto() {
    }

    public RewardDto(Long customerId, int totalPoints, int currMonthPoints) {
        this.customerId = customerId;
        this.totalPoints = totalPoints;
        this.currMonthPoints = currMonthPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getCurrMonthPoints() {
        return currMonthPoints;
    }

    public void setCurrMonthPoints(int currMonthPoints) {
        this.currMonthPoints = currMonthPoints;
    }

    @Override
    public String toString() {
        return "RewardDto{" +
                "customerId=" + customerId +
                ", totalPoints=" + totalPoints +
                ", currMonthPoints=" + currMonthPoints +
                '}';
    }
}
