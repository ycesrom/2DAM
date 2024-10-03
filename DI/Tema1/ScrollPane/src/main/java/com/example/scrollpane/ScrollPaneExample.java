package com.example.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollPaneExample extends Application {

    @javafx.fxml.FXML
    private ScrollPane scrollPane;

    @Override
    public void start(Stage primaryStage) {
        // Crear un VBox con contenido
        VBox content = new VBox();



        String partidos[] = {
                "17/8 Racing Club Ferrol 2-2 Málaga CF",
                "24/8 Málaga 1-1 Mirandés",
                "31/8 Málaga 2-1 Albacete",
                "7/9 Córdoba 0-0 Málaga",
                "14/9 Málaga 1-0 S. D. Huesca",
                "20/9 Granada 2-2 Málaga",
                "28/9 Málaga 0-3 Elche C.F.",
                "6/10 Deportivo vs Málaga",  // No hay resultado, solo el partido programado
                "12/10 Cádiz vs Málaga",
                "19/10 Málaga vs Real Oviedo",
                "24/10 Tenerife vs Málaga",
                "27/10 Málaga vs Eibar",
                "4/11 Levante vs Málaga",
                "10/11 Málaga vs Cartagena",
                "17/11 Real Zaragoza vs Málaga",
                "24/11 Málaga vs Racing de Santander",
                "1/12 Castellón vs Málaga",
                "8/12 Málaga vs Almería",
                "15/12 Burgos vs Málaga",
                "18/12 Málaga vs CD Eldense",
                "22/12 Sporting Gijón vs Málaga",
                "11/1/25 Málaga vs Deportivo",
                "19/1/25 Mirandés vs Málaga",
                "26/1/25 Málaga vs Real Zaragoza",
                "2/2/25 Racing de Santander vs Málaga",
                "9/2/25 Málaga vs Levante",
                "16/2/25 Cartagena vs Málaga",
                "23/2/25 Málaga vs Tenerife",
                "2/3/25 Almería vs Málaga",
                "9/3/25 Málaga vs Cádiz",
                "16/3/25 Albacete vs Málaga",
                "23/3/25 Málaga vs Racing Ferrol",
                "30/3/25 Real Oviedo vs Málaga",
                "6/4/25 Málaga vs Córdoba",
                "13/4/25 S. D. Huesca vs Málaga",
                "20/4/25 Eibar vs Málaga",
                "27/4/25 Málaga vs Castellón",
                "4/5/25 Málaga vs Granada",
                "11/5/25 CD Eldense vs Málaga",
                "18/5/25 Málaga vs Sporting Gijón",
                "25/5/25 Elche C.F. vs Málaga",
                "1/6/25 Málaga vs Burgos"
        };


        for (int i = 0; i <= 41; i++) {
                    // Usar un valor por defecto si no hay un partido disponible en el array
                    String partido = i < partidos.length ? partidos[i] : "Resultado no disponible";
            Text text = new Text("Jornada " +(i+1) + ": " + partido +"\n");




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