package com.example.cafeproject;

/*
 * Class to create Chef instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class Chef extends Staff {
    public static int chefsInRestrant;

    /**
     * Constructor for Chef class
     * @param firstName
     * @param secondName
     * @param role
     * @param workingHours
     */
    public Chef(String firstName, String secondName, String role, Integer workingHours) {
        super(firstName, secondName, role, workingHours);
    }

    /**
     * adds new to the daily specials database
     * @param dishName
     */
    void createDailySpecials(String dishName){
        dailySpecials.add(dishName);
    }

    /**
     * creates a new item menu to menu database
     * @param dishName
     */
    void createMenuItem(String dishName){
        menuArray.add(dishName);
    }
}
