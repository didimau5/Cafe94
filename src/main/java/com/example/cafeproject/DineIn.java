package com.example.cafeproject;

/*
 * Class to make DineIn booking instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class DineIn extends Booking {
    Table table;

    /**
     * Constructor for Table
     * @param table
     * @param name
     * @param seatings
     * @param username
     * @param date
     */
    DineIn(Table table, String name, int seatings, String username, String date) {
        super(name, seatings, username, date);
        this.table = table;
        table.assignTable();
    }
    //void newDine(){
    //    table.assignTable();
    //}
}
