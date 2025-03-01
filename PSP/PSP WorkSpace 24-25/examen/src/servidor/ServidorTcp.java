package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cliente.Persona;

public class ServidorTcp {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		int puerto=6000;
		
		ServerSocket servidor=new ServerSocket(puerto);
		
		Socket socket=servidor.accept();
		
		ObjectOutputStream salir=new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
		
		Persona persona=new Persona("Juanuino Banana",22);
		
		salir.writeObject(persona);
		
		System.out.println("Envio "+persona.getNombre()+" "+persona.getEdad());
		
		Persona dato=(Persona) in.readObject();
		
		System.out.println("Recibo "+dato.getNombre()+" "+dato.getEdad());
		
		salir.close();
		in.close();
		socket.close();
		servidor.close();

		// TODO Auto-generated method stub

	}

}
