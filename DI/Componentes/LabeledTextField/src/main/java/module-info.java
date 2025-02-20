module com.example.labeledtextfield {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.labeledtextfield to javafx.fxml;
    exports com.example.labeledtextfield;
}