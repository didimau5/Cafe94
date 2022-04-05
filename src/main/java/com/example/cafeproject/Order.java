package com.example.cafeproject;

import java.util.ArrayList;

/*
 * Class to make Order instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class Order {
    private Booking booking;
    private ArrayList<String> order;

    /**
     * Order constructor
     * @param order
     */
    public Order(ArrayList order){
        this.order = order;
    }
}

