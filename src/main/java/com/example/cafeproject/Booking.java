package com.example.cafeproject;

import java.time.LocalDateTime;

/*
* Class to make booking instances.
* @author Diego Feliz Gonzalez
* @version 2.0
 */

public class Booking {
    private Order order;
    private String name;
    private Integer seatings;
    private String username;
    private String date;
    private int timeBookedHour;
    private int timeBookedMinute;

    /**
     * Constructs Booking
     * @param name
     * @param seatings
     * @param username
     * @param date
     */
    public Booking(String name, Integer seatings, String username, String date) {
        this.name = name;
        this.seatings = seatings;
        this.username = username;
        this.date = date;
        this.timeBookedHour = LocalDateTime.now().getHour();
        this.timeBookedMinute = LocalDateTime.now().getMinute();
    }

    /**
     * retrieves name variable
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name variable
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets seatings for the booking
     * @return
     */
    public Integer getSeatings() {
        return seatings;
    }

    /**
     * sets seatings for the booking
     * @param seatings
     */
    public void setSeatings(Integer seatings) {
        this.seatings = seatings;
    }

    /**
     * retrieves username from the booking
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * assigns username new value to the booking
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * retrieves date variable
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * assigns date new value
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * retrieves the hour the booking was made
     * @return
     */
    public int getTimeBookedHour() {
        return timeBookedHour;
    }

    /**
     * retrieves the minute the booking was made
     * @return
     */
    public int getTimeBookedMinute() {
        return timeBookedMinute;
    }
}



