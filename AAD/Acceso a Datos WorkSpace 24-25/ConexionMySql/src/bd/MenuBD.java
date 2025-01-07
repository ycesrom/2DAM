package bd;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.Scanner; 

	public class MenuBD 
	{ 
		public static void main(String[] args) 
		{ 
			menu();
		} 

	public static void crearTabla() 
	{
		String driver = "com.mysql.cj.jdbc.Driver"; 
		try { 
			Class.forName(driver); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root",""); 
			System.out.println("Conexión establecida"); 
			 

			String sql = "CREATE TABLE IF NOT EXISTS libros (id INT AUTO_INCREMENT PRIMARY KEY,titulo VARCHAR(255) NOT NULL,autor VARCHAR(255) NOT NULL,disponibilidad BOOLEAN DEFAULT TRUE, anioPublicacion INT)";
		    PreparedStatement pstmt = con.prepareStatement(sql); 
		    pstmt.executeUpdate(sql);
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
			Scanner entrada = new Scanner(System.in);
			
				String titulo,autor;
				boolean disponibilidad;
				int anioPublicacion;
				System.out.println("Introduzca el titulo ");
				titulo=entrada.nextLine();
				System.out.println("Introduzca el autor ");
				autor=entrada.nextLine();
				System.out.println("Introduzca la disponibilidad ");
				disponibilidad=entrada.nextBoolean();
				System.out.println("Introduzca el año de publicacion ");
				anioPublicacion=entrada.nextInt();


				String sql = "INSERT INTO libros (titulo, autor, disponibilidad,anioPublicacion) VALUES (?, ?, ?,?)";	

				
				 PreparedStatement pstmt = con.prepareStatement(sql);
				    
				    // Establecer los parámetros del PreparedStatement
				    pstmt.setString(1, titulo);
				    pstmt.setString(2, autor);
				    pstmt.setBoolean(3, disponibilidad);
				    pstmt.setInt(4, anioPublicacion);
				    pstmt.executeUpdate();
				            // Cerrar recursos 
			
			con.close(); 
			 
			        } catch (Exception e) { 
			            System.out.println("Error: " + e); 
			        } 
		}
		
	
		public static void modificarLibro() 
		{
			String driver="com.mysql.cj.jdbc.Driver";
			
			try{
				
				Scanner entrada = new Scanner(System.in);
				Class.forName(driver);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root","");
				System.out.println("Conexion establecida");
				
				  
					boolean disponibilidad;
					int id;
					System.out.println("Introduzca la id del libro: ");
					id=entrada.nextInt();
					System.out.println("Introduzca la disponibilidad del libro: ");
					disponibilidad=entrada.nextBoolean();
					
					String sql="UPDATE libros SET disponibilidad=? WHERE id=?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setBoolean(1, disponibilidad);
					pstmt.setInt(2, id);
					pstmt.executeUpdate();
				
				
			}catch(Exception e) 
			{
				System.out.println("Error: "+e);
				
			}
			
		}
		
		
		public static void eliminarLibro() 
		{
			String driver="com.mysql.cj.jdbc.Driver";
			
			try{
				Class.forName(driver);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root","");
				System.out.println("Conexion establecida");
				Scanner entrada = new Scanner(System.in);
				
					int id;
					System.out.println("Introduzca la id del libro: ");
					id=entrada.nextInt();
					
					String sql="DELETE FROM libros WHERE id=?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,id);
					pstmt.executeUpdate();
				
			}catch(Exception e) 
			{
				System.out.println("Error: "+e);
				
			}
			
		}
		
	   public static void consultarLibros() 
	   {
		   String driver="com.mysql.cj.jdbc.Driver";
			
			Scanner entrada = new Scanner(System.in); 
			try {
				Class.forName(driver);
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos", "root","");
				System.out.println("Conexion establecida");
				boolean disponibilidad=false;
				System.out.println("Introduzca la disponibilidad");
				disponibilidad=entrada.nextBoolean();
				
				String sql="SELECT * FROM libros WHERE disponibilidad=?";
				
				PreparedStatement mistatement = con.prepareStatement(sql);
				mistatement.setBoolean(1, disponibilidad);
	            ResultSet resultadoLibros = mistatement.executeQuery();
	            while (resultadoLibros.next()) {
	                int id = resultadoLibros.getInt("id");
	                String titulo = resultadoLibros.getString("titulo");
	                String autor = resultadoLibros.getString("autor");
	                int anioPublicacion=resultadoLibros.getInt("anioPublicacion");

	                System.out.println("ID: " + id);
	                System.out.println("Título: " + titulo);
	                System.out.println("Autor: " + autor);
	                System.out.println("Disponibilidad: " + disponibilidad);
	                System.out.println("Año Publicacion: "+anioPublicacion);
	              
	            }
	   }catch(Exception e ) 
			{
		   System.out.println("Error: "+e);
		   }
			}
	public static void menu() 
	{
		int opcion=0;
		do {
			Scanner entrada = new Scanner(System.in);
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
				case 3->{modificarLibro();}
				case 4->{consultarLibros();}
				case 5->{eliminarLibro();}
				default->
				{
					System.out.println("Has salido del programa");
				}
			
			}
		
		}while(opcion!=6);
		
		 
	}
} 