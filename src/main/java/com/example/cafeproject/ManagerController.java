package com.example.cafeproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/*
 * Controller class for ManagerHome.fxml.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class ManagerController implements Initializable {

    @FXML
    private TextField staffNameTextField;
    @FXML
    private TextField staffLastnameTextField;
    @FXML
    private TextField staffRoleTextField;
    @FXML
    private TextField staffHoursTextField;
    @FXML
    private TableView<Staff> staffList;
    @FXML
    private TableColumn<Staff, String> staffNameColumn;
    @FXML
    private TableColumn<Staff, String> staffLastnameColumn;
    @FXML
    private TableColumn<Staff, String> staffRoleColumn;
    @FXML
    private TableColumn<Staff, Integer> staffHoursColumn;

    /**
     * initializes table view
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        staffLastnameColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("lastname"));
        staffRoleColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
        staffHoursColumn.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("hours"));
    }

    /**
     * Submit button to add a Staff
     * @param event
     */
    public void createStaffButton(ActionEvent event) {
        Staff staff = new Staff(
                staffNameTextField.getText(),
                staffLastnameTextField.getText(),
                staffRoleTextField.getText(),
                Integer.parseInt(staffHoursTextField.getText()));
        ObservableList<Staff> staffs = staffList.getItems();
        staffs.add(staff);
        staffList.setItems(staffs);
        staff.createStaff();
    }

    /**
     * Delete button to delete selected Staff
     * @param event
     */
    public void removeStaff(ActionEvent event) {
        int selectedID = staffList.getSelectionModel().getSelectedIndex();
        staffList.getItems().remove(selectedID);
        /**Staff.deleteStaff(staffNameTextField.getText().toLowerCase(),
               staffLastnameTextField.getText().toLowerCase(),
                staffRoleTextField.getText().toLowerCase());**/
    }

    /**
     * Edit button method for staff
     * @param event
     */
    public void editStaff(ActionEvent event) {
        Staff staff = new Staff(
                staffNameTextField.getText(),
                staffLastnameTextField.getText(),
                staffRoleTextField.getText(),
                Integer.parseInt(staffHoursTextField.getText()));
        ObservableList<Staff> staffs = staffList.getItems();
        int selectedID = staffList.getSelectionModel().getSelectedIndex();
        staffList.getItems().remove(selectedID);
        staffs.add(staff);
        staffList.setItems(staffs);
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
