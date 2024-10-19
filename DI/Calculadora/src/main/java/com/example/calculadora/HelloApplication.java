package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); // Ajusta el tamaño aquí
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        stage.setTitle("Calculadora"); // Cambia el título para reflejar la aplicación
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
