package com.example.tarea_2_5gestionentidades.Controladores;

import com.example.tarea_2_5gestionentidades.Modelos.Action;
import com.example.tarea_2_5gestionentidades.Modelos.ActionDAO;
import com.example.tarea_2_5gestionentidades.Modelos.ConexionDB;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.*;
import java.time.LocalDateTime;

public class altaCliente
{
    @FXML
    private TextField fieldNombre,fieldEstado,fieldSecuencia,fielAccion,fieldId,fieldAccion;

    private Action action; // Guardará la acción a editar


    // Metodo para crear una nueva entidad en la base de datos
    public void guardarNuevaEntidad() {

        String nombre = fieldNombre.getText();
        String estado = fieldEstado.getText();
        Integer secuencia = Integer.parseInt(fieldSecuencia.getText());
        Integer accion = Integer.parseInt(fieldAccion.getText());

        try (Connection conn = ConexionDB.getConnection()) {
            // Consulta SQL para insertar datos, sin incluir el id ya que se autoincrementa
            String sql = "INSERT INTO ir_actions_todo (action_id, sequence, state, name, create_date) VALUES (?, ?, ?, ?, ?)";

            // Asignamos los valores y establecemos conexion con la base de datos
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, accion);      // action_id
                pstmt.setInt(2, secuencia);   // sequence
                pstmt.setString(3, estado);   // state
                pstmt.setString(4, nombre);    // name
                pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // create_date

                int filasInsertadas = pstmt.executeUpdate(); // Ejecutamos la accion

                if (filasInsertadas > 0)
                {
                   mostrarMensajeExito("La entidad se ha guardado con exito");

                    // Obtener el ID generado
                    try (ResultSet generatedKeys = pstmt.getGeneratedKeys())
                    {
                        if (generatedKeys.next())
                        {
                            int generatedId = generatedKeys.getInt(1); // El ID generado

                        } else
                        {
                            System.out.println("No se pudo obtener el ID generado.");
                        }
                    }
                } else
                {
                    mostrarMensajeError("La entidad no se ha guardado.");
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace(); // Inmprimimos el error
        }

        // Cerrar la ventana
        ((Stage) fieldNombre.getScene().getWindow()).close();
    }




    public void setAction(Action action) {
        this.action = action;

            // Cargar los datos en los campos de texto
        // Vincular las propiedades con los campos de texto
        fieldId.textProperty().bind(action.getIdProperty().asString());
        fieldAccion.textProperty().bindBidirectional(action.getAction_idProperty(), new javafx.util.converter.NumberStringConverter());
        fieldSecuencia.textProperty().bindBidirectional(action.getSequenceProperty(), new javafx.util.converter.NumberStringConverter());
        fieldEstado.textProperty().bindBidirectional(action.getStateProperty());
        fieldNombre.textProperty().bindBidirectional(action.getNameProperty());




    }
    @FXML
    private void actualizar() {
        // Actualiza el objeto con los nuevos valores
        action.createDateProperty().set(Timestamp.valueOf(LocalDateTime.now()));
        // Llama a la clase ActionDAO para actualizar la base de datos
        try
        {
            ActionDAO.updateAction(action, null); // No necesitas pasar la tabla aquí
        } catch (SQLException e) {
            mostrarMensajeError("Error al actualizar la accion");
            e.printStackTrace();
        }

        // Cierra la ventana de edición
        ((Stage) fieldId.getScene().getWindow()).close();
        mostrarMensajeExito("La entidad se ha actualizado con exito");
    }

    // Metodo para cancelar las operaciones
    @FXML
    private void cancelar()
    {
        ((Stage) fieldNombre.getScene().getWindow()).close();
        mostrarMensajeCancelar("La operacion se ha cancelado");
    }

    // Mostrar mensaje de éxito
    private void mostrarMensajeExito(String mensaje)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Mostrar mensaje de error
    private void mostrarMensajeError(String mensaje)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Mostrar mensaje de cancelación
    private void mostrarMensajeCancelar(String mensaje)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Operación Cancelada");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    }

