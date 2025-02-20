package com.example.labeledtextfield; // ¡Asegúrate de que este sea tu paquete!

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class LabeledTextField extends HBox {

    @FXML
    private Label label;

    @FXML
    private TextField textField;

    public LabeledTextField() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LabeledTextField.fxml"));
        fxmlLoader.setRoot(this); // *CRUCIAL*
        fxmlLoader.setController(this); // *CRUCIAL*

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String value) {
        textField.setText(value);
    }

    public String getLabelText() {
        return label.getText();
    }

    public void setLabelText(String value) {
        label.setText(value);
    }

    // Puedes agregar más métodos getter/setter para otras propiedades...
}