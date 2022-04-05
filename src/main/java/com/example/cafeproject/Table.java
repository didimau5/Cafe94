package com.example.cafeproject;

/*
 * Class to create Table instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class Table {

    static int[]table2 = new int[] {0,0,0,0};
    static int[]table4 = new int[] {0,0,0,0};
    static int[]table8 = new int[] {0,0};
    static int[]table10 = new int[] {0};

    private int tableNumber;
    private int seatings;
    private Booking booking;

    /**
     * Table constructor
     * @param booking
     */
    Table(Booking booking){

        this.booking = booking;
    }

    /**
     * retrieves seatings in the current object
     * @return
     */
    public int getSeated() {
        return seatings;
    }

    /**
     * adds new value to seatings
     * @param seatings
     */
    public void setSeated(int seatings) {
        this.seatings = seatings;
    }

    /**
     * retrieves table number for current Table object
     * @return
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * adds new value to table number
     * @param tableNumber
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Assigns a table according to number os seatings in current object
     *
     */
    public void assignTable() {
        this.seatings = booking.getSeatings();
        if (this.seatings == 2) {
            for (int i = 0; i < table2.length; i++) {
                if (table2[i]>0) {
                    table2[i] = seatings;
                    this.tableNumber = i+1;
                    System.out.println("Cafe94.Table " + i+1 +" assigned for " +seatings + " people.");
                }
                else{
                    System.out.println("Cafe94.Table " + i+1 +" is occupied!");
                }
            }
        }
        if (this.seatings == 4) {
            for (int i = 0; i < table2.length; i++) {
                if (table4[i]>0) {
                    table4[i] = seatings;
                    this.tableNumber = i+5;
                    System.out.println("Cafe94.Table " + i+5 +" assigned for " +seatings + " people.");
                }
                else{
                    System.out.println("Cafe94.Table " + i+5 +" is occupied!");
                }
            }
        }
        if (this.seatings == 8) {
            for (int i = 0; i < table2.length; i++) {
                if (table8[i]>0) {
                    table8[i] = seatings;
                    this.tableNumber = i+9;
                    System.out.println("Cafe94.Table " + i+9 +" assigned for " +seatings + " people.");
                }
                else{
                    System.out.println("Cafe94.Table " + i+9 +" is occupied!");
                }
            }
        }
        if (this.seatings == 10) {
            for (int i = 0; i < table2.length; i++) {
                if (table10[i]>0) {
                    table10[i] = this.seatings;
                    this.tableNumber = i+11;
                    System.out.println("Cafe94.Table " + i+11 +" assigned for " +seatings + " people.");
                }
                else{
                    System.out.println("Cafe94.Table " + i+11 +" is occupied!");
                }
            }
        }
    }
}
