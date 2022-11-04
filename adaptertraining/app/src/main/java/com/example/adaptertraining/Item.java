package com.example.adaptertraining;

import java.io.Serializable;

public class Item implements Serializable {
  private   String flightname;
    private int flightimage ;
    private double flightprice;

    public String getFlightname() {
        return flightname;
    }

    public void setFlightname(String flightname) {
        this.flightname = flightname;
    }

    public int getFlightimage() {
        return flightimage;
    }

    public void setFlightimage(int flightimage) {
        this.flightimage = flightimage;
    }

    public double getFlightprice() {
        return flightprice;
    }

    public void setFlightprice(double flightprice) {
        this.flightprice = flightprice;
    }

    public Item(String flightname, int flightimage, double flightprice) {
        this.flightname = flightname;
        this.flightimage = flightimage;
        this.flightprice = flightprice;

    }
}
