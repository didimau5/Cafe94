package com.example.cafeproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;
    private String name;
    private String lastname;
    private String username;
    private String password;
    @FXML
    private TextField myRegisterName;
    @FXML
    private TextField myRegisterLastname;
    @FXML
    private TextField myRegisterUsername;
    @FXML
    private TextField myRegisterPassword;
    @FXML
    private Button myRegisterButton;
    @FXML
    private TextField myTextField;
    @FXML
    private Label loginLabel;
    private ArrayList<String> userRegistry = new ArrayList<>();

    /**
     * goes to UserPage.fxml scene
     * @param actionEvent
     * @throws IOException
     */
    public void goToUser(ActionEvent actionEvent) throws IOException {
        if ((DatabaseController.search("userName", myTextField.getText())).equalsIgnoreCase(myTextField.getText())){
            root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
            stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            loginLabel.setText("Invalid credentials, try again");
        }
    }

    /**
     * goes to staff triage scene
     * @param actionEvent
     * @throws IOException
     */
    public void goToTriage(ActionEvent actionEvent) throws IOException {

        if (myTextField.getText().equalsIgnoreCase("admin")) {
            root = FXMLLoader.load(getClass().getResource("StaffTriage.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            loginLabel.setText("Are you sure you work here?");
        }
    }

    /**
     * goes to register scene
     * @param actionEvent
     * @throws IOException
     */
    public void goToRegister(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RegisterForm.fxml"));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * goes back to login and logs user data
     * @param actionEvent
     * @throws IOException
     */
    public void goToLogin(ActionEvent actionEvent) throws IOException {

        name = myRegisterName.getText();
        lastname = myRegisterLastname.getText();
        username = myRegisterUsername.getText();
        password = myRegisterPassword.getText();
        System.out.println(name+","+lastname+","+username+","+password);
        //writeUser(name, lastname, username, password);
        DatabaseController.insert("userName", username);


        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}