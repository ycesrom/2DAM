package principal;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import equipos.Equipo;
import jugadores.Jugadores;

public class Principal {

	public static void main(String[] args) 
	{
		  
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"liga.db4o");
		// TODO Auto-generated method stub

		insertarEquipos(db);
	
			
	}
	
	public static void insertarEquipos(ObjectContainer db) 
	{
		Equipo e1=new Equipo("Malaga","2 Division","Malaga","Malaga");
		db.store(e1);	
		insertarJugadores(db,e1);
	}
	
	
	public static void insertarJugadores(ObjectContainer db,Equipo equipo) 
	{
		Equipo e=new Equipo();
		Jugadores j1=new Jugadores(21,"Isco",22,"Medio","Mago",equipo);
	}

}
