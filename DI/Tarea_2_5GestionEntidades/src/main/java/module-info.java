module com.example.tarea_2_5gestionentidades {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tarea_2_5gestionentidades to javafx.fxml;
    exports com.example.tarea_2_5gestionentidades;
    exports com.example.tarea_2_5gestionentidades.Modelos;
    opens com.example.tarea_2_5gestionentidades.Modelos to javafx.fxml;
    exports com.example.tarea_2_5gestionentidades.Controladores;
    opens com.example.tarea_2_5gestionentidades.Controladores to javafx.fxml;
}