package com.example.cafeproject;

/*
 * Class to make Delivery booking instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class Delivery extends Booking {

    private boolean waiterApproval = false;
    private int pickUpTime;

    /**
     * constructor for Delivery
     * @param name
     * @param seatings
     * @param username
     * @param date
     */
    public Delivery(String name, int seatings, String username, String date){
        super(name, seatings, username, date);
    }

    /**
     * Calculates ETA for delivery
     * @return
     */
    public String calculateDeliveryTime() {
        String minDeliveryTime = String.valueOf(getTimeBookedHour()+1)+":"+String.valueOf(getTimeBookedMinute());
        System.out.println("The estimated delivery time is" + minDeliveryTime);
        return minDeliveryTime;
    }
}
