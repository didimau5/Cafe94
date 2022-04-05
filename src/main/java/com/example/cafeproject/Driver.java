package com.example.cafeproject;

/*
 * Class to make Driver staff instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class Driver extends Staff {
    /**
     * Constructor for Driver
     * @param firstName
     * @param secondName
     * @param role
     * @param workingHours
     */
    Driver(String firstName, String secondName, String role, Integer workingHours) {
        super(firstName, secondName, role, workingHours);
    }
}
