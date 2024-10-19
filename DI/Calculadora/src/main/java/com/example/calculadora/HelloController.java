package com.example.calculadora;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private GridPane gpCalculadora;
    @FXML
    private TextField tfVisor;


    @FXML
    public void onGPPrincipalClicked(Event event) {


    }

    public void initialize() {
        System.out.println("Inicializando");
        tfVisor.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        gpCalculadora.addEventFilter(MouseEvent.MOUSE_CLICKED,
                event -> {
                    System.out.println(event.toString());
                    // Si es un click en un botón o en el texto que tiene el botón (OJO que tiene otro target)
                    // el source no se puede usar pues toma el grid
                    // if ( event.getTarget() instanceof Button || event.getTarget() instanceof Text) {
                    if (event.getTarget() instanceof Button ||
                            ((event.getTarget() instanceof Text) && ((Text) event.getTarget()).getParent() instanceof Button)) {

                        String texto = (event.getTarget() instanceof Button) ? ((Button) event.getTarget()).getText() : ((Text) event.getTarget()).getText();

                        if (!(texto.equals("+") || texto.equals("-")
                                || texto.equals("*") || texto.equals("/")
                                || texto.equals("%") || texto.equals(".")
                                || texto.equals("="))) {
                            tfVisor.setText(tfVisor.getText().equals("0") ? "" : tfVisor.getText() + texto);
                        }
                        event.consume();
                    }
                });
    }


}