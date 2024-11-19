package mySql;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.Scanner; 
public class MenuBD { 
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

	menu();
    }

	public static void crearTabla() 
	{
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try { 
			Class.forName(driver); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root",""); 
			System.out.println("Conexión establecida"); 
			 
			Statement mistatement = con.createStatement(); 

			String sql = "CREATE TABLE IF NOT EXISTS libros (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "titulo VARCHAR(255) NOT NULL," +
                    "autor VARCHAR(255) NOT NULL," +
                    "disponibilidad BOOLEAN DEFAULT TRUE)";
			mistatement.executeUpdate(sql);
			            // Cerrar recursos 
			          
			            con.close(); 
			 
			        } catch (Exception e) { 
			            System.out.println("Error: " + e); 
			        } 
		}
	
	public static void insertarLibro() 
	{
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try { 
			Class.forName(driver); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root",""); 
			System.out.println("Conexión establecida"); 
			 
			Statement mistatement = con.createStatement(); 
			Scanner entrada=new Scanner(System.in);
			String titulo,autor;
			boolean disponibilidad;
			System.out.println("Introduzca el titulo ");
			titulo=entrada.nextLine();
			System.out.println("Introduzca el autor ");
			autor=entrada.nextLine();
			System.out.println("Introduzca la disponibilidad ");
			disponibilidad=entrada.nextBoolean();


			String sql = "INSERT INTO libros (titulo, autor, disponibilidad) VALUES (?, ?, ?)";	
			mistatement.executeUpdate(sql);

			
			 PreparedStatement pstmt = con.prepareStatement(sql);
	            
	            // Establecer los parámetros del PreparedStatement
	            pstmt.setString(1, titulo);
	            pstmt.setString(2, autor);
	            pstmt.setBoolean(3, disponibilidad);
	            pstmt.executeUpdate();
			            // Cerrar recursos 
			          
			            con.close(); 
			 
			        } catch (Exception e) { 
			            System.out.println("Error: " + e); 
			        } 
		}
		
	
		
	


	public static void menu() 
	{
		int opcion=0;
		do {
			Scanner entrada=new Scanner(System.in);
		System.out.println("1.Crear la tabla libros si no existe");
		System.out.println("2.Insertar un nuevo libro");
		System.out.println("3.Modificar la disponiblidad de un libro");
		System.out.println("4.Consultar todos los linros, por bien disponibles o bien prestados");
		System.out.println("5.Eliminar un libro por su ID");
		System.out.println("6.Salir del programa");
		opcion=entrada.nextInt();
		switch(opcion) 
		{	
			case 1->{crearTabla();}
			case 2->{insertarLibro();}
			case 3->{}
			case 4->{}
			case 5->{}
			default->
			{
				System.out.println("Has salido del programa");
			}
		
		}
		}while(opcion!=6);
		 
	}
} 