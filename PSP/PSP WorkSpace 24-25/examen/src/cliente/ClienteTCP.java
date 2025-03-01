package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		String host="localhost";
		int puerto=6000;
		
		Socket cliente=new Socket(host,puerto);
		
		ObjectOutputStream salir=new ObjectOutputStream(cliente.getOutputStream());
		ObjectInputStream in=new ObjectInputStream(cliente.getInputStream());
		
		Persona dato=(Persona) in.readObject();
		System.out.println("Recibo "+dato.getNombre()+" "+dato.getEdad());
		
		dato.setNombre("Manoloi");
		dato.setEdad(11);
		
		salir.writeObject(dato);
		
		System.out.println("Envio "+dato.getNombre()+" "+dato.getEdad());
		
		salir.close();
		in.close();
		cliente.close();
		// TODO Auto-generated method stub

	}

}
