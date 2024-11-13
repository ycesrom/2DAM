package com.example.tarea_2_5gestionentidades.Modelos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// https://github.com/AmirUCR/jdbc_mechanic_shop/blob/master/src/Connection/ConnectionClass.java
public class ConexionDB
{
    public static Connection connection = null;
    public static Connection getConnection() {

        //Parámetros de conexión
        String dbName = "odoo";
        String dbPort = "5432";
        String username = "odoo";
        String password = "odoo";


        try
        {
            // Establecemos la conexion con nuestra base de datos
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:" + dbPort + "/" + dbName + "?user=" + username + "&password=" + password;
            // obtain a physical connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace(); // Si no se establece la conexion imprimos el error
            System.exit(-1);
        }

        return connection;
    }


}

