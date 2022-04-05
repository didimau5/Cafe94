package com.example.cafeproject;

/*
 * Class to make Manager staff instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class Manager extends Staff {
    /**
     * Manager constructor
     * @param firstName
     * @param secondName
     * @param role
     * @param workingHours
     */
    Manager(String firstName, String secondName, String role, Integer workingHours) {
        super(firstName, secondName, role, workingHours);
    }

    /**
     * edits staff selected
     * @param name
     * @param surname
     * @param newName
     * @param newSurname
     * @param role
     */
    public void editStaff(String name, String surname, String newName, String newSurname, String role) {
        for(Staff elem : staffArray){
            if(elem.getName().equals(name)&&elem.getLastname().equals(surname)){
                staffArray.get(staffArray.indexOf(elem)).setName(newName);
                staffArray.get(staffArray.indexOf(elem)).setLastname(newSurname);
                switch (role.toUpperCase()) {
                    case "WAITER":
                        waitersArray.get(waitersArray.indexOf(elem)).setName(newName);
                        waitersArray.get(waitersArray.indexOf(elem)).setLastname(newSurname);
                        break;
                    case "DRIVER":
                        driversArray.get(driversArray.indexOf(elem)).setName(newName);
                        driversArray.get(driversArray.indexOf(elem)).setLastname(newSurname);
                        break;
                    case "CHEF":
                        chefsArray.get(chefsArray.indexOf(elem)).setName(newName);
                        chefsArray.get(chefsArray.indexOf(elem)).setLastname(newSurname);
                        break;
                }
            }
        }
    }

    /**
     * prints all staff
     */
    void printStaff() {
        for (Staff worker : staffArray){
            System.out.println(worker.getName());
            System.out.println(worker.getLastname());

        }
    }
}
