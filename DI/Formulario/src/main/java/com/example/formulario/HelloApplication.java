package com.example.formulario;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //        grid.setAlignment(Pos.CENTER);
        //      grid.setHgap(10);
        //    grid.setVgap(10);
        //  grid.setPadding(new Insets(25, 25, 25, 25));

        //Text scenetitle = new Text("Welcome");
        //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        //grid.add(scenetitle, 0, 0, 2, 1);

        //Label userName = new Label("User Name:");
        //grid.add(userName, 0, 1);
        //TextField userTextField = new TextField();
        //grid.add(userTextField, 1, 1);

        //Label pw = new Label("Password:");
        //grid.add(pw, 0, 2);
        //PasswordField pwBox = new PasswordField();
        //grid.add(pwBox, 1, 2);

        //Button btn = new Button("Submit");
        //grid.add(btn, 1, 3);

        //Button statusBtn = new Button(); // Botón para mostrar el estado
        //statusBtn.setVisible(false); // Oculto inicialmente
        //grid.add(statusBtn, 1, 4); // Agregar debajo de Submit

        //btn.setOnAction(e -> {
        //  String username = userTextField.getText();
        //String password = pwBox.getText();
        // Lógica para manejar el inicio de sesión
        //System.out.println("Username: " + username + ", Password: " + password);

        // Cambiar el texto y el color del botón de estado
        //statusBtn.setText("Sign in button pressed");
        //statusBtn.setTextFill(Color.FIREBRICK);
        //statusBtn.setVisible(true); // Hacer visible el botón de estado
        //});

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();

        Pane circlePane = (Pane) root.lookup("#circlePane");

        // Crear un círculo de radio 20 y color azul
        Circle circle = new Circle(20, Color.BLUE); // Radio de 20, color azul

        // Posicionar el círculo en la parte superior izquierda
        circle.setTranslateX(0); // Margen desde el borde izquierdo
        circle.setTranslateY(0); // Margen desde el borde superior

        // Agregar el círculo al pane
        circlePane.getChildren().add(circle);
        Scene scene = new Scene(root, 300, 275);
        scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
