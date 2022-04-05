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
     * @return
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
     * @return
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
     * @return
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
     * @return
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









/**
public class Staff extends Profile{

    static ArrayList<Staff> staff = new ArrayList<>();
    static ArrayList<String> menuArray = new ArrayList<>();
    static ArrayList<String> dailySpecials = new ArrayList<>();
    static ArrayList<Order> outStandingOrder = new ArrayList<>();
    private String firstName;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    Random rand =new Random();
    public Integer workingHours;
    private String role;

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    double totalWorkingHrs;
    public Staff(String firstName, String secondName, String role, Integer hours) {
        super(firstName,secondName);
        this.firstName = firstName;
        this.lastName = secondName;
        this.role = role;
        this.workingHours = workingHours;

    }




    public Integer getWorkingHours() {
        workingHours = 8;
        return workingHours;
    }

    public double getTotalWorkingHrs() {
        return workingHours*rand.nextInt(3);
    }
    static void seeMenu(){
        for (String item:menuArray) {
            System.out.println(item);
        }
    }
    static void seeDailySpecials(){
        for (String item:dailySpecials) {
            System.out.println(item);
        }
    }

}



class Driver extends Staff {
    Driver(String firstName, String secondName, String role, Integer workingHours){
        super(firstName, secondName, role, workingHours);
    }
}

class Manager extends Staff {
    Manager(String firstName, String secondName, String role, Integer workingHours){
        super(firstName, secondName, role, workingHours);
    }

    void createStaff(String name, String surname, String role){
        role =  role.toUpperCase();
        switch (role){
            case "WAITER":
                Waiter waiter = new Waiter(name,surname, role, workingHours);
                staff.add(waiter);
                break;
            case "DRIVER":
                Driver driver = new Driver(name,surname, role, workingHours);
                staff.add(driver);
                break;
            case "CHEF" :
                Chef chef = new Chef(name,surname, role, workingHours);
                staff.add(chef);
                break;
        }

    }

    void editStaff(String name, String surname, String newName, String newSurname){
        for(Staff elem : staff){
            if(elem.getFirstName().equals(name)&&elem.getLastName().equals(surname)){
                staff.get(staff.indexOf(elem)).setFirstName(newName);
                staff.get(staff.indexOf(elem)).setLastName(newSurname);
            }
        }
    }

    void deleteStaff(String name, String surname){
        for(Staff elem : staff){
            if(elem.getFirstName().equals(name)&&elem.getLastName().equals(surname)){
                staff.remove(elem);
            }
        }
    }

    void printStaff(){
        for (Staff worker : staff){
            System.out.println(worker.getFirstName());
            System.out.println(worker.getLastName());
        }
    }
}


class Chef extends Staff{
    private static int chefsInRestrant;

    public Chef(String firstName, String secondName, String role, Integer workingHours) {
        super(firstName, secondName, role, workingHours);
    }
    void createDailySpecials(String dishName){
        dailySpecials.add(dishName);
    }
    void createMenuItem(String dishName){
        menuArray.add(dishName);
    }
}
class Waiter extends Staff {
    private static int waitersInRestrant;

    public Waiter(String firstName, String secondName, String role, Integer workingHours) {
        super(firstName,  secondName, role, workingHours);
        waitersInRestrant++;

    }

    public void order() {

    }
}**/
