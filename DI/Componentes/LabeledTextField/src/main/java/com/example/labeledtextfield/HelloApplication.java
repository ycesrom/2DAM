package com.example.labeledtextfield; // ¡Ajusta el paquete!

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10); // VBox con espacio vertical
        root.setPadding(new Insets(20)); // Margen

        // Crear instancias de LabeledTextField
        LabeledTextField nameField = new LabeledTextField();
        nameField.setLabelText("Nombre:");

        LabeledTextField emailField = new LabeledTextField();
        emailField.setLabelText("Correo Electrónico:");

        // Añadir los componentes al layout
        root.getChildren().addAll(nameField, emailField);

        // Configurar la escena y mostrar la ventana
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ejemplo de Componente Personalizado");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}