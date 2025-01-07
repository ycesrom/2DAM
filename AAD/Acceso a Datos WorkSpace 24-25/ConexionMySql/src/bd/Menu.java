package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Menu 
{
	public static void main(String[]args) 
	{
		menu();
	}
	public static void insertarTabla() 
	{
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try { 
			Class.forName(driver); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root",""); 
			System.out.println("Conexión establecida"); 

			String sql="CREATE TABLE IF NOT EXISTS productos (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(20) NOT NULL, precio DOUBLE, cantidad INT)";
			
			PreparedStatement t=con.prepareStatement(sql);
			t.execute();
			
			con.close();
		}catch(Exception e) 
		{
			System.out.println("Error "+e);
		}
	
	}
	
	public static void busqueda() 
	{
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try { 
			Class.forName(driver); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root",""); 
			System.out.println("Conexión establecida"); 
			Scanner entrada=new Scanner(System.in);
			System.out.print("Nombre");
			String nombre=entrada.nextLine();

			String sql="SELECT * FROM productos WHERE nombre=?";
			
			PreparedStatement t=con.prepareStatement(sql);
			t.setString(1, nombre); 
			ResultSet resultadoLibros = t.executeQuery();
            while (resultadoLibros.next()) {
                int id = resultadoLibros.getInt("id");
                String titulo = resultadoLibros.getString("nombre");
                int autor = resultadoLibros.getInt("cantidad");
                double anioPublicacion=resultadoLibros.getDouble("precio");

                System.out.println("ID: " + id);
                System.out.println("Título: " + nombre);
                System.out.println("Autor: " + autor);
                
                System.out.println("Año Publicacion: "+anioPublicacion);
              
			
            }
		}catch(Exception e) 
		{
			System.out.println("Error "+e);
		}
		
	}
	
	public static void insercion() 
	{
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try { 
			Class.forName(driver); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root",""); 
			System.out.println("Conexión establecida"); 
			Scanner entrada=new Scanner(System.in);
			
			String sql="INSERT INTO productos(nombre,precio,cantidad) VALUES(?,?,?)";
			System.out.println("nOmbre");
			String nombre=entrada.nextLine();
			System.out.println("precio");

			double precio=entrada.nextDouble();
			System.out.println("cantidad");

			int cantidad=entrada.nextInt();
			

			PreparedStatement t=con.prepareStatement(sql);
			t.setString(1, nombre);
			t.setDouble(2, precio);
			t.setInt(3, cantidad);
			t.execute();
			
			con.close();
		}catch(Exception e) 
		{
			System.out.println("Error "+e);
		}
		
	}
	
	public static void eliminar() 
	{
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try { 
			Class.forName(driver); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root",""); 
			System.out.println("Conexión establecida"); 
			Scanner entrada=new Scanner(System.in);
			System.out.println("id");
			int cantidad=entrada.nextInt();
			String sql="DELETE FROM productos WHERE id=?";
			
			

			
			

			PreparedStatement t=con.prepareStatement(sql);
			t.setInt(1, cantidad);
			t.execute();
			
			con.close();
		}catch(Exception e) 
		{
			System.out.println("Error "+e);
		}
		
	}
	
	public static void menu() 
	{
		int opcion=0;
		Scanner entrada=new Scanner(System.in);
		do 
		{
			System.out.println("1.");
			System.out.println("2.");
			System.out.println("3.");
			System.out.println("1.");
			System.out.println("Opcion");
			opcion=entrada.nextInt();
			switch(opcion) 
			{
			case 1->insertarTabla();
			case 2->busqueda();
			case 3->insercion();
			case 4->eliminar();
			
			}
		}while(opcion<5);
	}

	}


