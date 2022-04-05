package com.example.cafeproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

/*
 * Controller for WaiterHome.fxml.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class WaiterController implements Initializable {

    @FXML
    private ListView<String> myWaiterListView;
    @FXML
    private ListView<String> newWaiterListView;
    @FXML
    private ListView<String> nameList;
    @FXML
    private ListView<String> dateList;
    @FXML
    private ListView<String> orderIdList;
    @FXML
    private ListView<String> FoodOrderList;
    @FXML
    private ListView<String> timeList;

    private ArrayList<String> nameArray = new ArrayList<>(Arrays.asList
            ("Jhon", "Andrew", "Ramon", "Carl", "Brad", "Hilario"));
    private ArrayList<String> dateArray = new ArrayList<>(Arrays.asList
            ("03-04-2022", "03-04-2022", "03-04-2022", "03-04-2022", "03-04-2022", "02-04-2022"));
    private ArrayList<String> orderIdArray = new ArrayList<>(Arrays.asList
            ("34456", "34455", "34454", "34453", "34452", "34451"));
    private ArrayList<String> foodOrderArray = new ArrayList<>(Arrays.asList
            ("Pizza, Sushi, Pizza", "Sushi, Sushi, Sushi", "Ramen, Chicken, Pizza",
                    "Chicken, Sushi, Ramen", "Pizza, Pizza", "Hamburger, Pizza"));
    private ArrayList<String> timeArray = new ArrayList<>(Arrays.asList
            ("16:04", "13:57", "13:22", "13:10", "22:12", "21:13"));
    private ArrayList<String> orderArray = new ArrayList<>();
    private String currentFood;

    /**
     * Initializes tables and list views in FXML
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        nameList.getItems().addAll(nameArray);
        dateList.getItems().addAll(dateArray);
        orderIdList.getItems().addAll(orderIdArray);
        FoodOrderList.getItems().addAll(foodOrderArray);
        timeList.getItems().addAll(timeArray);
        myWaiterListView.getItems().addAll(DatabaseController.food);
        myWaiterListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentFood = myWaiterListView.getSelectionModel().getSelectedItem();
                orderArray.add(currentFood);
            }
        });}

    /**
     * Adds menu items to order
     * @param event
     */
    public void addOrderButton(ActionEvent event) {
        newWaiterListView.getItems().add(orderArray.get(orderArray.size()-1));
    }

    /**
     * removes menu items from order
     * @param event
     */
    public void removeOrderButton(ActionEvent event) {
        newWaiterListView.getItems().remove(orderArray.get(orderArray.size()-1));
    }

    /**
     * Creates an order from the list
     * @param event
     * @throws IOException
     */
    public void createOrderButton(ActionEvent event) throws IOException {

        Order order = new Order(orderArray);
        Parent root = FXMLLoader.load(getClass().getResource("WaiterHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Approves delivery
     * @param event
     */
    public void approveDelivery(ActionEvent event) {
        int selectedID = nameList.getSelectionModel().getSelectedIndex();
        nameList.getItems().remove(selectedID);
        dateList.getItems().remove(selectedID);
        orderIdList.getItems().remove(selectedID);
        FoodOrderList.getItems().remove(selectedID);
        timeList.getItems().remove(selectedID);
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
}