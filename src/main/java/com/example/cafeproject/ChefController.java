package com.example.cafeproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

/*
 * Controller class for Chef home.fxml.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class ChefController implements Initializable {



    private ArrayList<String> pending = new ArrayList<>(Arrays.asList("Pizza",
            "Sushi", "Ramen", "Chicken", "Bread", "Hamburger"));
    @FXML
    private ListView<String> myPendingOrderList;
    @FXML
    private ListView<String> myList;
    @FXML
    private ListView<String> myDailyList;
    @FXML
    private TextField myDailyTextField;
    @FXML
    private TextField myText;
    @FXML
    void add(ActionEvent event) {
        myList.getItems().addAll(myText.getText());
    }
    @FXML
    void remove(ActionEvent event) {
        int selectedID = myList.getSelectionModel().getSelectedIndex();
        myList.getItems().remove(selectedID);
    }

    /**
     * initializes before loading the page the daily specials list, menu list and pending orders
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myList.getItems().addAll(DatabaseController.food);
        myPendingOrderList.getItems().addAll(pending);
        myDailyList.getItems().addAll(DatabaseController.dailySpecials);

    }

    /**
     * logs out and goes to login page
     * @param event
     * @throws IOException
     */
    public void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Completes orders
     * @param event
     */
    public void completeOrder(ActionEvent event) {
        int selectedID = myPendingOrderList.getSelectionModel().getSelectedIndex();
        myPendingOrderList.getItems().remove(selectedID);
    }

    /**
     * adds a daily special to the list
     */
    public void addDaily(){
        myDailyList.getItems().addAll(myDailyTextField.getText());
        DatabaseController.dailySpecials.add(myDailyTextField.getText());
    }

    /**
     * deletes selected daily special
     */
    public void deleteDaily() {
        int selectedID = myDailyList.getSelectionModel().getSelectedIndex();
        myDailyList.getItems().remove(selectedID);
        DatabaseController.dailySpecials.remove(myDailyTextField.getText());
    }
}
