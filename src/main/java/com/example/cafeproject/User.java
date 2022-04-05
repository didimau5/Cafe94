package com.example.cafeproject;

import java.util.ArrayList;
import java.util.Random;

/*
 * Class to make User instances.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

class User extends Profile {

    static String mostActiveUser;
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<String> orderHistory = new ArrayList<>();

    private Random rand =new Random();
    private String address;
    private String customerId;
    private String username;
    private String password;



    /**
     * User class constructor
     * @param firstName
     * @param secondName
     * @param address
     */
    public User(String firstName, String secondName, String address) {
        super(firstName, secondName);
        this.address = address;
        users.add(this);
    }

    /**
     * prints all existing users
     */
    static void printUsers() {
        for(User usr : users){
            System.out.println(usr.getFirstName());
        }
    }

    /**
     * retireves address from the current User object
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * adds Customer Id to current User object
     * @return customerId
     */
    public String getCustomerId() {
        String [] alphabet={"A","B","C","D"};
        customerId=alphabet[rand.nextInt(alphabet.length-1)];
        for(int i=0;i<4;i++){
            customerId+=alphabet[rand.nextInt(alphabet.length-1)];
            customerId+=rand.nextInt(9);
        }
        return customerId;
    }

    /**
     * Prints order history
     */
    public void printOrderHistory() {
        for(String order : orderHistory){
            System.out.println(order);
        }
    }

    /**
     * returns most active customer
     * @return mostActiveUser
     */
    public String mostActiveUser() {
        if(users.size()>0){
            User mostActiveUser = users.get(0);
            User pointer;
            for(int i=1;i<users.size();i++){
                pointer=users.get(i);
                if(mostActiveUser.orderHistory.size()<pointer.orderHistory.size()){
                    mostActiveUser =pointer;
                }
            }

        }else{
            return "you have no users in the system yet !";
        }
        return mostActiveUser;
    }
}

