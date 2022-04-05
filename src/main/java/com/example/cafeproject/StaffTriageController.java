package com.example.cafeproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/*
 * Controller for StaffTriage.fxml.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class StaffTriageController {

    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;

    /**
     * goes to manager home scene
     * @param actionEvent
     * @throws IOException
     */
    public void goToManager(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ManagerHome.fxml"));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * goes to waiter home scene
     * @param actionEvent
     * @throws IOException
     */
    public void goToWaiter(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("WaiterHome.fxml"));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * goes to chef home scene
     * @param actionEvent
     * @throws IOException
     */
    public void goToChef(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Chef home.fxml"));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * goes to driver home scene
     * @param actionEvent
     * @throws IOException
     */
    public void goToDriver(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DriverHome.fxml")));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
