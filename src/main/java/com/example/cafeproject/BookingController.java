package com.example.cafeproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/*
 * Controller class for UserPage.fxml.
 * @author Diego Feliz Gonzalez
 * @version 2.0
 */

public class BookingController implements Initializable {

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Label bookingLabel;
    @FXML
    private TextField bookingName;
    @FXML
    private TextField bookingSeatings;
    @FXML
    private TextField bookingUsername;
    @FXML
    private TableView<Booking> tableView;
    @FXML
    private TableColumn<Booking, String> nameColumn;
    @FXML
    private TableColumn<Booking, Integer> seatingsColumn;
    @FXML
    private TableColumn<Booking, String> dateColumn;
    @FXML
    private TableColumn<Booking, String> usernameColumn;
    private String [] modes = {"Dine In", "Delivery", "Take Away"};

    /**
     * initializes both the table and the choice box
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("name"));
        seatingsColumn.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("seatings"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("date"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("username"));

        myChoiceBox.getItems().addAll(modes);
        myChoiceBox.setValue("Dine In");

    }

    /**
     * records new bookings
     * @param event
     */
    public void submit(ActionEvent event) {
        Booking booking = new Booking(
                bookingName.getText(),
                Integer.parseInt(bookingSeatings.getText()),
                bookingUsername.getText(),
                getDate());
        ObservableList<Booking> bookings = tableView.getItems();
        bookings.add(booking);
        tableView.setItems(bookings);
    }

    /**
     * removes booking
     * @param event
     */
    public void removeCustomer(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    /**
     * changes scene to order page
     * @param event
     * @throws IOException
     */
    public void goToOrder(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * logs out the user and goes to login page
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
     * gets date of from the date picker
     * @return myFormattedDate
     */
    public String getDate() {
        LocalDate myDate = myDatePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return myFormattedDate;
    }

    /**
     * retrieves choice box selection
     * @param myChoiceBox
     * @return choice
     */
    public String getChoiceBoxChoice(ChoiceBox<String>myChoiceBox) {
    String choice = myChoiceBox.getValue();
    return choice;
}
}
