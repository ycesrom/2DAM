package principal;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import alumnos.Alumno;

public class AlumnosPrincipal 
{
	
	 public static void main(String[] args) {
		    
		//La base de datos física es el fichero "alumnos.db4o" almacenado en la
		    //carpeta raíz del proyecto creado
	  ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
		            "alumnos.db4o");
	  try { menu(db);
	  }catch(com.db4o.ext.DatabaseClosedException e) 
	    {
	    	System.out.println("Hubo un error inesperado");
	    	db.rollback();
	    	
	    
	    	
	    } finally {
	      db.close(); //cerrar la conexión a la base de datos
	    }
		
		 
	 }
	 
	 public static void menu(ObjectContainer db) 
	 {
		 Scanner entrada=new Scanner(System.in);
		
		 
		 int opcion=0;
		 
		 
		 do {
		    
		   
		    try {
		    	System.out.println("1.Insertar alumnos");
		    	System.out.println("2.Consultar todos los alumnos");
		    	System.out.println("3.Consultar los alumnos que son mayores de edad");
		    	System.out.println("4.Consultar los alumnos con notaMedia superior a 5");
		    	System.out.println("5.Modificar la notaMedia de uno de los alumnos");
		    	System.out.println("6.Borrar el alumno con la notaMedia más baja");
		    	System.out.println("7.Salir");
		    	
		    	opcion=entrada.nextInt();
		    	
		   
		    
		    switch(opcion) 
		    {
		    case 1->{insertarAlumno(db);}
		    case 2->{consultarAlumnos(db);}
		    case 3->{consultarAlumnosMayoresEdad(db);}
		    case 4->{ consultarNotaMediaMayor5( db);}
		    case 5->{
		    	entrada.nextLine();
		    	System.out.println("Introduzca el dni del alumno");
		    	String dni=entrada.nextLine();
		    	System.out.println("Introduzca la nueva nota del alumno");
		    	double nota=entrada.nextDouble();
		    	modificarNotaMedia(db,dni,nota);}
		    case 6->{borrarAlumnoNotaBaja(db);}
		    default ->{System.out.println("Por favor inserte una opcion entre 1-6");}
		    
		    }
		    }catch(Exception e) 
		    {
		    	System.out.println("Hubo un error inesperado");
		    	entrada.nextLine();
		    }
		    

		  
		  }while(opcion!=7);
	}
		 
	 
	 
	 public static void insertarAlumno(ObjectContainer db) 
	 {
		 Alumno a1=new Alumno ("12345678A",16,"1SMR",2);
		 Alumno a2=new Alumno("22334455B",20,"2DAM",6);
		 Alumno a3=new Alumno("33445566C",19,"2SMR",4.67);
		 Alumno a4=new Alumno("44556677D",21,"2DAW",7.78);
		 db.store(a1);
		 db.store(a2);
		 db.store(a3);
		 db.store(a4);
		 
	 }
	 
	 public static void modificarNotaMedia(ObjectContainer db, String dni, double notaMedia) 
	 {
		 ObjectSet resul=db.queryByExample(new Alumno(dni,0,null,0));
		 Alumno a=(Alumno) resul.next();
		 a.setNotaMedia(notaMedia);
		 db.store(a);
		 
	 }
	 
	 public static void borrarAlumnoNotaBaja(ObjectContainer db) 
	 {
		 ObjectSet<Alumno> res = db.query(Alumno.class); // Consulta todos los alumnos

		    // Inicializar variables para encontrar al alumno con la nota más baja
		    Alumno alumnoConNotaBaja = null;
		    double notaBaja = Double.MAX_VALUE; // Usamos un valor muy alto al principio

		    // Iterar sobre todos los alumnos y encontrar el de la nota más baja
		    while (res.hasNext()) {
		        Alumno alumno = res.next(); // Obtener siguiente alumno
		        if (alumno.getNotaMedia() < notaBaja) {
		            alumnoConNotaBaja = alumno; // Actualizamos el alumno con la nota más baja
		            notaBaja = alumno.getNotaMedia(); // Actualizamos la nota más baja
		        }
		    }

		    // Si encontramos un alumno con la nota más baja, lo eliminamos
		    if (alumnoConNotaBaja != null) {
		        db.delete(alumnoConNotaBaja); // Eliminar el alumno de la base de datos
		        System.out.println("Alumno eliminado: " + alumnoConNotaBaja);
		    } else {
		        System.out.println("No se encontraron alumnos para eliminar.");
		    }
		 
	 }
	 
	
	 public static void consultarAlumnosMayoresEdad(ObjectContainer db) 
	 {
		 System.out.println("\nConsulta de todos los alumnos Mayores de Edad");
		
		   Query query = db.query();//declara un objeto Query
		    //indica la clase a la que se aplicarán restricciones
		    query.constrain(Alumno.class);
		    query.descend("edad").constrain(17).greater();
		    ObjectSet result = query.execute(); //Ejecuta la consulta
		    mostrarConsulta(result);//muestra los resultados de la consulta
		
	 }
	 
	 public static void consultarAlumnos(ObjectContainer db) 
	 {
		 System.out.println("Consulta de todos los alumnos");
			
		   Query query = db.query();//declara un objeto Query
		   query.constrain(Alumno.class);
		   ObjectSet result=query.execute();
		   mostrarConsulta(result);
		 
	 }
	 
	 public static void consultarNotaMediaMayor5(ObjectContainer db) 
	 {
		 System.out.println("\nAlumnos con nota media mayor de 5");
		 Query query=db.query();
		 query.constrain(Alumno.class);
		 query.descend("notaMedia").constrain(5).greater();
		 ObjectSet result=query.execute();
		 mostrarConsulta(result);
	 }
	 
	 public static void mostrarConsulta(ObjectSet resul) {
		    System.out.println("\nRecuperados " + resul.size() + " Objetos\n");
		    while (resul.hasNext()) {
		      System.out.println(resul.next());
		    }
		  }

		 

}
