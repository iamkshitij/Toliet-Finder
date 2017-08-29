package com.zappby.tolietfinder;

/**
 * Created by iamkshitij on 28/08/17.
 */

public class ToiletModel {
    String id;
    String name;
    String address;
    String rating;

    public ToiletModel() {
    }

    public ToiletModel(String id, String name, String address, String rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRating() {
        return rating;
    }
}
