module com.example.tarea_2_5gestionentidades {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea_2_5gestionentidades to javafx.fxml;
    exports com.example.tarea_2_5gestionentidades;
}