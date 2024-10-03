module com.example.scrollpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scrollpane to javafx.fxml;
    exports com.example.scrollpane;
}