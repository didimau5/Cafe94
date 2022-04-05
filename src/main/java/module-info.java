module com.example.cafeproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cafeproject to javafx.fxml;
    exports com.example.cafeproject;
}