package servidor;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import cliente.ClienteUDP;

import java.io.*; 
 
public class ServidorUDP extends Thread { 
 
  public static void main (String args[]) { 
 
	
    try { 
 
      DatagramSocket socketUDP = new DatagramSocket(6789); 
      byte[] bufer = new byte[1000]; 
 
      while (true) { 
        // Construimos el DatagramPacket para recibir peticiones 
        DatagramPacket peticion = 
          new DatagramPacket(bufer, bufer.length); 
 
        // Leemos una petición del DatagramSocket 
        socketUDP.receive(peticion); 
 
        System.out.print("Datagrama recibido del host: " + 
                           peticion.getAddress()); 
        System.out.println(" desde el puerto remoto: " + 
                           peticion.getPort()); 
 
        String dateTime = getCurrentDateTime();
        byte[] respuestaBytes = dateTime.getBytes();
        // Construimos el DatagramPacket para enviar la respuesta 
        DatagramPacket respuesta = 
          new DatagramPacket(respuestaBytes, respuestaBytes.length, 
                             peticion.getAddress(), peticion.getPort()); 
 
        // Enviamos la respuesta, que es un eco 
        socketUDP.send(respuesta);
        
        
       
      } 
    	} catch (SocketException e) { 
    		System.out.println("Socket: " + e.getMessage()); 
    	} catch (IOException e) { 
    		System.out.println("IO: " + e.getMessage()); 
    	} 
  } 
  
  // Método que obtiene la fecha y hora actual
  public static String getCurrentDateTime() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return sdf.format(new Date());
  }
}