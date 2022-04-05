package com.example.cafeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Main class to load up the FXML.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class Main extends Application {
    /**
     * starts the FXML program
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image
            ("https://cdn3.iconfinder.com/data/icons/coffee-11/500/Coffee_Blood_Vessel-512.png");
        stage.getIcons().add(icon);
        stage.setTitle("Cafe94");
        stage.setWidth(620);
        stage.setHeight(450);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets stage and first scene
     * @param args
     */
    public static void main(String[] args) {
        launch();
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Sushi");
        ArrayList<String> dailySpecial = new ArrayList<String>();
        ArrayList<String> outstandingOrders = new ArrayList<String>();
        ArrayList<String> popularItems = new ArrayList<>();
    }
}