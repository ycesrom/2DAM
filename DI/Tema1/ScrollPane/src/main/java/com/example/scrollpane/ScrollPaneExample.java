package com.example.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un VBox con contenido
        VBox content = new VBox();
        for (int i = 1; i <= 50; i++) {
            Text text = new Text("Línea de texto " + i);

            // Evento de clic en cada línea de texto
            text.setOnMouseClicked(e -> handleClick(e, text));

            content.getChildren().add(text);
        }

        // Crear el ScrollPane y agregar el VBox
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(content);

        // Configurar propiedades del ScrollPane
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPannable(true);

        // Evento para detectar desplazamiento con la rueda del ratón
        scrollPane.setOnScroll(e -> handleScroll(e));

        // Evento para detectar arrastre del contenido
        scrollPane.setOnMouseDragged(e -> handleMouseDrag(e));

        // Crear la escena y mostrarla
        Scene scene = new Scene(scrollPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ejemplo de ScrollPane con Eventos");
        primaryStage.show();
    }

    // Manejar evento de clic en una línea de texto
    private void handleClick(MouseEvent e, Text text) {
        System.out.println("Se ha hecho clic en: " + text.getText());
    }

    // Manejar evento de desplazamiento
    private void handleScroll(javafx.scene.input.ScrollEvent e) {
        System.out.println("Desplazamiento detectado: " + e.getDeltaY());
    }

    // Manejar evento de arrastre del ratón
    private void handleMouseDrag(MouseEvent e) {
        System.out.println("Arrastrando contenido en: " + e.getSceneX() + ", " + e.getSceneY());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
