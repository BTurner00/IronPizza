package com.theironyard;

import java.util.ArrayList;

/**
 * Created by Ben on 6/16/16.
 */
public class Pizza {
    int id;
    String size;
    String crust;
    String sauce;
    String orderName;
    ArrayList<Toppings> topping = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Pizza(int id, String size, String crust, String sauce, String orderName, ArrayList<Toppings> topping) {
        this.id  = id;
        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.orderName = orderName;
        this.topping = (ArrayList) topping;
    }

    public Pizza(String orderName) {
        this.orderName = orderName;
    }

    public Pizza() {
    }

    public Pizza(String orderName, String size, String crust, String sauce) {

        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.orderName = orderName;

    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public ArrayList<Toppings> getTopping() {
        return topping;
    }

    public void setTopping(ArrayList<Toppings> topping) {
        this.topping = topping;
    }
}
