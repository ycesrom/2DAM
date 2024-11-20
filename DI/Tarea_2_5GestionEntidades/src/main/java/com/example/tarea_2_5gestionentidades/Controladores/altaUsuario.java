package com.example.tarea_2_5gestionentidades.Controladores;

import com.example.tarea_2_5gestionentidades.Modelos.Users;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class altaUsuario
{
    @FXML
    private TextField fieldActivo,fieldPassword,fieldLogin,fieldActionId,fieldCreateUid;
    private Users user;
    public void guardarUsuario()
    {
        Boolean activo = Boolean.parseBoolean(fieldActivo.getText());
        String password = fieldPassword.getText();
        String login = fieldLogin.getText();
        Integer actionId = Integer.parseInt(fieldActionId.getText());
        Integer createUid = Integer.parseInt(fieldCreateUid.getText());

    }

}
