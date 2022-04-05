package com.example.cafeproject;

import java.util.ArrayList;

/*
 * Class to make Staff instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class Staff {

    static ArrayList<Staff> staffArray = new ArrayList<>();
    static ArrayList<Staff> chefsArray = new ArrayList<>();
    static ArrayList<Staff> waitersArray = new ArrayList<>();
    static ArrayList<Staff> driversArray = new ArrayList<>();
    static ArrayList<String> menuArray = new ArrayList<>();
    static ArrayList<String> dailySpecials = new ArrayList<>();
    static ArrayList<Order> outStandingOrder = new ArrayList<>();

    private String name;
    private String lastname;
    private String role;
    private Integer hours;

    /**
     * Staff constructor
     * @param name
     * @param lastname
     * @param role
     * @param hours
     */
    public Staff(String name, String lastname, String role, Integer hours) {
        this.name = name.toLowerCase();
        this.lastname = lastname.toLowerCase();
        this.role = role.toLowerCase();
        this.hours = hours;
    }

    /**
     * retrieves name from staff
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * adds new name to staff instance
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * retireves lastname from staff
     * @return lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * adds new lastname to staff object
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * retrieves role from staff
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * adds new role to staff object
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * retrieves hours from staff object
     * @return hours
     */
    public Integer getHours() {
        return hours;
    }

    /**
     * adds new value to staff object hours
     * @param hours
     */
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    /**
     * creates staff from database
     */
    public void createStaff() {
        Staff staff = new Staff(this.name, this.lastname, this.role, getHours());
        staffArray.add(staff);
        switch (role.toUpperCase()) {
            case "WAITER":
                waitersArray.add(staff);
                break;
            case "DRIVER":
                driversArray.add(staff);
                break;
            case "CHEF":
                chefsArray.add(staff);
                break;
        }
    }

    /**
     * deletes staff from database
     * @param name
     * @param surname
     * @param role
     */
    public void deleteStaff(String name, String surname, String role) {
        for (Staff elem : staffArray) {
            if (elem.getName().equals(name) && elem.getLastname().equals(surname)) {
                staffArray.remove(elem);
                switch (role.toUpperCase()) {
                    case "WAITER":
                        waitersArray.remove(elem);
                        break;
                    case "DRIVER":
                        chefsArray.remove(elem);
                        break;
                    case "CHEF":
                        driversArray.remove(elem);
                        break;
                }

            }
        }
    }
}

