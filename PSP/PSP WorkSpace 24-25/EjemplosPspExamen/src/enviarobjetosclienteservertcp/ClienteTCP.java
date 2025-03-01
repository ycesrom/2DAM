package enviarobjetosclienteservertcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class ClienteTCP {
	
	public static void main(String[] arg) throws IOException,
	ClassNotFoundException {
	String Host = "localhost";
	int Puerto = 6000;//puerto remoto
	System.out.println("PROGRAMA CLIENTE INICIADO....");
	Socket cliente = new Socket(Host, Puerto);
	//FLUJO DE salida para objetos
	ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
	//Flujo de entrada para objetos
	ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
	
	//Se recibe un objeto
	Persona dato = (Persona) perEnt.readObject();//recibo objeto
	System.out.println("Recibo: "+dato.getNombre()+"*"+dato.getEdad());  
	//Modifico el objeto
	dato.setNombre("Juan Ramos");
	dato.setEdad(22);
	
	// Se envía el objeto
	perSal.writeObject(dato);
	System.out.println("Envio: "+dato.getNombre()+"*"+dato.getEdad());
	// CERRAR STREAMS Y SOCKETS
	perSal.close();
	perEnt.close();
	
	//cliente.close();
	}

}
