package com.example.customer.returnPoints.payload;

import com.example.customer.returnPoints.entity.Purchase;



public class PointDto {

    private long id;

    private double point;

    private Purchase purchase;

    public PointDto() {
    }

    public PointDto(long id, double point, Purchase purchase) {
        this.id = id;
        this.point = point;
        this.purchase = purchase;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "PointDto{" +
                "id=" + id +
                ", point=" + point +
                ", purchase=" + purchase +
                '}';
    }
}
