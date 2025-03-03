package principal;

import java.util.List;
import java.util.Scanner;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import equipos.Equipo;
import jugadores.Jugadores;

public class Principal {

	public static void main(String[] args) 
	{
		Scanner entrada=new Scanner(System.in);
		menu(entrada);
		
	}
	
	
	private static void menu(Scanner scanner) 
	{
		int opcion=0;
		EmbeddedConfiguration config=Db4oEmbedded.newConfiguration();
			
			config.common().objectClass(Equipo.class).cascadeOnDelete(true);  
			ObjectContainer db=Db4oEmbedded.openFile(config,"liga.db4o");
		
		do {
			try {
			System.out.println("1.Insertar Equipos");
			System.out.println("2.Insertar Jugadores");
			System.out.println("3.Consultar todos los jugadores de un equipo");
			System.out.println("4.Consulta SODA para recuperar jugadores mayores de 25 años");
			System.out.println("5.Borrar un equipo");
			System.out.println("6.Salir");
			
			opcion=scanner.nextInt();
			scanner.nextLine();
			switch(opcion) 
			{
			
			case 1->{insertarEquipo(db,scanner);}
			case 2->{insertarJugadores(db,scanner);}
			case 3->{consultarJugadoresEquipo(db, scanner);}
			case 4->{consultaSODA(db, scanner);}
			case 5->{borrarEquipo(db,scanner);}
			case 6->{System.out.println("Programa Finalizado");}
			default->{System.out.println("Hubo un error");}
			
			}
			}catch(Exception e) 
		{
			db.rollback();
			System.out.println("Hubo un error y se hizo un rollback");
			scanner.nextLine();
		}
		}while(opcion!=6);
		
	}
	
	private static void insertarEquipo(ObjectContainer db, Scanner scanner) {
        System.out.print("Nombre del equipo: ");
        String nombre = scanner.nextLine();
        System.out.print("División: ");
        String division = scanner.nextLine();
        System.out.print("Localidad: ");
        String localidad = scanner.nextLine();
        System.out.print("Provincia: ");
        String provincia = scanner.nextLine();

        Equipo equipo = new Equipo(nombre, division, localidad, provincia);
        db.store(equipo);
        System.out.println("Equipo insertado correctamente.");
    }
	
	
	public static void insertarJugadores(ObjectContainer db,Scanner scanner) 
	{
		System.out.print("Dorsal: "); 
        int dorsal = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Posición: ");
        String posicion = scanner.nextLine();
        System.out.print("Apodo: ");
        String apodo = scanner.nextLine();
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();

        Equipo equipo = buscarEquipo(nombreEquipo,db);
        if (equipo != null) {
            Jugadores jugador = new Jugadores(dorsal, nombre, edad, posicion, apodo, equipo);
            db.store(jugador);
            System.out.println("Jugador insertado correctamente.");
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }
	
	private static void consultaSODA(ObjectContainer db, Scanner scanner) {
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = buscarEquipo(nombreEquipo, db);
        if (equipo != null) {
        Query query = db.query();
        query.constrain(Jugadores.class);
        query.descend("edad").constrain(25).greater();
        query.descend("equipo").descend("nombre").constrain(nombreEquipo);
        List<Jugadores> jugadores = query.execute();
        for (Jugadores j : jugadores) {
            System.out.println(j.nombre + " - " + j.edad + " años"+" - "+j.posicion);
        }
        }else 
        {
        	System.out.println("Equipo no encontrado");
        }
    }
	
	private static void borrarEquipo(ObjectContainer db, Scanner scanner) {
        System.out.print("Nombre del equipo a borrar: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = buscarEquipo(nombreEquipo, db);
        if (equipo != null) {
            Query query = db.query();
            query.constrain(Jugadores.class);
            query.descend("equipo").descend("nombre").constrain(nombreEquipo);
            List<Jugadores> jugadores = query.execute();
            for (Jugadores j : jugadores) {
                db.delete(j);
            }
            db.delete(equipo);
            System.out.println("Equipo y sus jugadores eliminados correctamente.");
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }
	
	private static void consultarJugadoresEquipo(ObjectContainer db, Scanner scanner) {
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = buscarEquipo(nombreEquipo, db);
        if (equipo != null) {
        Query query = db.query();
        query.constrain(Jugadores.class);
        query.descend("equipo").descend("nombre").constrain(nombreEquipo);
        List<Jugadores> jugadores = query.execute();
        for (Jugadores j : jugadores) {
            System.out.println(j.nombre + " - " + j.posicion + " - " + j.edad + " años");
        }
        }else 
        {
        	System.out.println("Equipo no encontrado");
        }
    }
	 private static Equipo buscarEquipo(String nombre,ObjectContainer db) {
	        Query query = db.query();
	        query.constrain(Equipo.class);
	        query.descend("nombre").constrain(nombre);
	        List<Equipo> equipos = query.execute();
	        return equipos.isEmpty() ? null : equipos.get(0);
	    }
	}


