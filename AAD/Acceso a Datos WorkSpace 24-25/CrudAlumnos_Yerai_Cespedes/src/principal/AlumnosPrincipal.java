package principal;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class AlumnosPrincipal 
{
	
	 public static void main(String[] args) {
		    ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
		            "congreso.db4o");
		    //La base de datos física es el fichero "congreso.db4o" almacenado en la
		    //carpeta raíz del proyecto creado
		    try {
		     
		    } finally {
		      db.close(); //cerrar la conexión a la base de datos
		    }
		  }
}
