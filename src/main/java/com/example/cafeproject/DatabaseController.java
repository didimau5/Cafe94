package com.example.cafeproject;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Class to write and read from the database, based on different text files.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class DatabaseController {

    static ArrayList<String> food = new ArrayList<>(Arrays.asList("Fish", "Pizza", "Sushi",
            "Ramen", "Chicken", "Bread", "Hamburger"));
    static ArrayList<String> dailySpecials = new ArrayList<>(Arrays.asList("Chicken Ala Cacciatore",
            "Minestrone Soup", "Beef Stroganoff"));
    static ArrayList<String> orderNumber = new ArrayList<>(Arrays.asList("3446", "4665", "4566", "5468", "2135",
            "5454"));
    static ArrayList<String> addresses = new ArrayList<>(Arrays.asList("777 Brockton Avenue, Abington MA 2351",
            "30 Memorial Drive, Avon MA 2322", "250 Hartford Avenue, Bellingham MA 2019",
            "700 Oak Street, Brockton MA 2301", "66-4 Parkhurst Rd, Chelmsford MA 1824",
            "591 Memorial Dr, Chicopee MA 1020"));

    /**
     * searchs in the proposed database the proposed argument
     * @param typeOfData
     * @param item
     * @return found
     * @throws FileNotFoundException
     */
    public static String search(String typeOfData ,  String item) throws FileNotFoundException {
        // choose type of info you want to save, and string you want to save
        String found ="Can't Find "+item;
        File dataBase = new File("userNames.txt");
        Scanner scan = new Scanner(dataBase);

        switch (typeOfData){
            case "userName":
                dataBase = new File("userNames.txt");
                break;
            case "bookingHistory":
                dataBase = new File("bookingHistory.txt");
                break;
            case "menu":
                dataBase = new File("menu.txt");
                break;
        }
        if(dataBase.exists()==false){
            return found;
        }
        while(scan.hasNext()){
            if(scan.next().equals(item)){
                found =  item;
                break;
            }
        }

        return found;

    }

    /**
     * insters new argument in the selected database
     * @param typeOfData
     * @param item
     * @throws IOException
     */
    public static void insert(String typeOfData ,String item ) throws IOException {
        File dataBase = new File("userNames.txt");
        switch (typeOfData){
            case "userName":
                dataBase = new File("userNames.txt");
                break;
            case "bookingHistory":
                dataBase = new File("bookingHistory.txt");
                break;
            case "menu":
                dataBase = new File("Menu.txt");
                break;
        }

        try{
            if(dataBase.exists()==false){
                System.out.println("We had to make a new file dataBase.");
                dataBase.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(dataBase, true));
            out.append(item+"\n");
            out.close();
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }

    }

    /**
     * builds the menu into the menu list
     * @return food
     * @throws IOException
     */
    public static ArrayList menuBuilder() throws IOException {
        for (String item:food){
            insert("menu", item);
        }
        return food;
    }
}
