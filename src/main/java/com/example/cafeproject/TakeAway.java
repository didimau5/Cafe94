package com.example.cafeproject;

/*
 * Class to Create TakeAway booking instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class TakeAway extends Booking {
    /**
     * Take away class constructor
     * @param name
     * @param seatings
     * @param username
     * @param date
     */
    TakeAway(String name, int seatings, String username, String date){
        super(name, seatings, username, date);
    }

    /**
     * Calculates pick up time for customer
     * @return
     */
    public String calculatePickUpTime() {
        String pickUpTime = String.valueOf(getTimeBookedHour()+1)+":"+String.valueOf(getTimeBookedMinute());
        System.out.println("Your food will be ready at" + (pickUpTime));
        return pickUpTime;
    }
}