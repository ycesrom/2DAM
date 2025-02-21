
package servidor;

import java.io.*; 
import java.net.*;
import persona.Persona; 

public class Servidor { 
    public static void main(String[] args) throws IOException, ClassNotFoundException { 
        int numeroPuerto = 6000; // Puerto del servidor
        ServerSocket servidor = new ServerSocket(numeroPuerto); 
        System.out.println("Esperando al cliente...");    

        Socket cliente = servidor.accept(); 
        System.out.println("Cliente conectado.");

        // Se prepara un flujo de salida para enviar objetos    
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());   
        
        // Se prepara un objeto y se envía  
        Persona per = new Persona("Juan", 20); 
        outObjeto.writeObject(per); // Enviando objeto 
        System.out.println("Enviado: " + per.getNombre() + " - " + per.getEdad());   
        
        // Se obtiene un stream para leer objetos 
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream()); 
        Persona dato = (Persona) inObjeto.readObject(); 
        System.out.println("Recibido: " + dato.getNombre() + " - " + dato.getEdad()); 

        // CERRAR STREAMS Y SOCKETS 
        outObjeto.close(); 
        inObjeto.close();
        cliente.close(); // Cierra la conexión con el cliente
        servidor.close(); // Cierra el servidor
    }
}

