package com.example.tarea_2_5gestionentidades.Modelos;

import javafx.scene.control.TableView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionDAO
{
    // Metodo para obtener las acciones de la base de datos, ordenadas por nombre
    public static List<Action> actions() throws SQLException
    {
        List<Action> acciones = new ArrayList<>();

        // Establecemos la conexion con la base de datos
        try (Connection conexion = ConexionDB.getConnection();
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ir_actions_todo ORDER BY name ")) {

            while (resultSet.next()) {
                // Itera sobre los resultados y crea instancias de Action con los datos obtenidos
               Action accion= new Action();
                accion.getIdProperty().set(resultSet.getInt("id"));
                accion.getAction_idProperty().set(resultSet.getInt("action_id"));
                accion.getSequenceProperty().set(resultSet.getInt("sequence"));
                accion.getStateProperty().set(resultSet.getString("state"));
                accion.getNameProperty().set(resultSet.getString("name"));
                accion.createDateProperty().set(resultSet.getTimestamp("create_date"));

                acciones.add(accion); // Añadimos los datos a la tabla
                System.out.println(resultSet.getString("name"));
            }
        }

        return acciones;// Devuelve las acciones que hemos buscado
    }

    // Actualiza una accion de la base de datos
    public static void updateAction(Action persona,TableView<Action> actionTableView) throws SQLException
    {
        String sql = "UPDATE ir_actions_todo SET action_id = ?,sequence=?,create_uid=?,state=?,name=?,create_date=? WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //Configura los parametros de la sentencia sql
          pstmt.setInt(1, persona.getAction_id());
          pstmt.setInt(2, persona.getSequence());
          pstmt.setInt(3, persona.getCreate_uid());
          pstmt.setString(4, persona.getState());
          pstmt.setString(5, persona.getName());
          pstmt.setTimestamp(6, persona.getCreate_date());
          pstmt.setInt(7, persona.getId());
            pstmt.executeUpdate(); // Ejecuta la actualizacion de los datos
        }
    }


}

