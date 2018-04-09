package com.jk.entity;

import java.io.Serializable;

public class Car implements Serializable{

    private static final long serialVersionUID = 5402585245169284611L;

    private  String carid;

    private  String carname;

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carid='" + carid + '\'' +
                ", carname='" + carname + '\'' +
                '}';
    }
}
