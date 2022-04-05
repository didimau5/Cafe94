package com.example.cafeproject;

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
import java.util.ResourceBundle;

/*
 * Controller for DriverHome.fxml.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class DriverController implements Initializable {

    @FXML
    private ListView<String> orderNumberList;
    @FXML
    private ListView<String> orderAddressList;

    /**
     *Constructor method to fill the list view
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderNumberList.getItems().addAll(DatabaseController.orderNumber);
        orderAddressList.getItems().addAll(DatabaseController.addresses);

    }

    /**
     * Method that complete deliveries
     * @param event
     */
    public void completeOrder(ActionEvent event) {
        int selectedID = orderNumberList.getSelectionModel().getSelectedIndex();
        orderNumberList.getItems().remove(selectedID);
        orderAddressList.getItems().remove(selectedID);
    }

    /**
     * Logs out and sends to login screen
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
