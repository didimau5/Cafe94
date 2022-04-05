package com.example.cafeproject;

/*
 * Class to make Profile instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class Profile {
    private  String firstName;
    private String lastName;

    /**
     *
     * @param firstName
     * @param lastName
     */
    public Profile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * get firstname from profile
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * adds new firstname to the profile
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * adds lastname to profile
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * retrieves lastname from profile
     * @return
     */
    public String getLastName() {
        return lastName;
    }
}
