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
import java.util.ResourceBundle;

/*
 * Controller for OrderPage.fxml.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class OrderController implements Initializable {
    @FXML
    private ListView<String> myOrderListView;
    @FXML
    private ListView<String> newOrderListView;

    private ArrayList<String> orderArray = new ArrayList<>();
    private String currentFood;

    /**
     *  constructor to initialize list views
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        myOrderListView.getItems().addAll(DatabaseController.food);
        myOrderListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentFood = myOrderListView.getSelectionModel().getSelectedItem();
                orderArray.add(currentFood);
            }
        });
    }

    /**
     * Adds items to an order
     * @param event
     */
    public void addOrderButton(ActionEvent event) {
        newOrderListView.getItems().add(orderArray.get(orderArray.size()-1));
    }

    /**
     * removes items from an order
     * @param event
     */
    public void removeOrderButton(ActionEvent event) {
        newOrderListView.getItems().remove(orderArray.get(orderArray.size()-1));
    }

    /**
     * logs the existing order
     * @param event
     * @throws IOException
     */
    public void createOrderButton(ActionEvent event) throws IOException {

        Order order = new Order(orderArray);
        Parent root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
