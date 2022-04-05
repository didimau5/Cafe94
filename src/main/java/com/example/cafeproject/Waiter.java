package com.example.cafeproject;

/*
 * Class to make Waiter staff instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class Waiter extends Staff {
    static int waitersInRestrant;

    /**
     * Waiter class constructor
     * @param firstName
     * @param secondName
     * @param role
     * @param workingHours
     */
    public Waiter(String firstName, String secondName, String role, Integer workingHours) {
        super(firstName, secondName, role, workingHours);
        waitersInRestrant++;

    }
}
