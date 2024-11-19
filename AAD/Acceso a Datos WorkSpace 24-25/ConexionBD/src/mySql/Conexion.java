package mySql;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
public class Conexion { 
public static void main(String[] args) { 
String driver = "com.mysql.cj.jdbc.Driver"; 
try { 
Class.forName(driver); 
            Connection con = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root",""); 
            System.out.println("Conexión establecida"); 
 
            Statement mistatement = con.createStatement(); 

 
            ResultSet miResulset = mistatement.executeQuery("SELECT * FROM clientes");
 
            // Cerrar recursos 
          
            con.close(); 
 
        } catch (Exception e) { 
            System.out.println("Error: " + e); 
        } 
    } 
} 