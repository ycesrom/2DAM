package cliente;

import java.net.*; 
import java.io.*; 
import java.util.Scanner;


public class ClienteUDP { 
// Los argumentos proporcionan el mensaje y el nombre del servidor 
	public static void main(String args[]) { 
		try { 
                    Scanner entrada=new Scanner(System.in);
                    
                    String serverAddress="localhost";
                    DatagramSocket socketUDP = new DatagramSocket(); 
                        System.out.println("Introduzca un mensaje");
                        String nombre=entrada.nextLine(); 
                        byte[] mensaje = nombre.getBytes(); 
			InetAddress hostServidor = InetAddress.getByName(serverAddress); 
			int puertoServidor = 6789; 
			// Construimos un datagrama para enviar el mensaje al servidor 
			DatagramPacket peticion = 
					new DatagramPacket(mensaje, mensaje.length, hostServidor, 
							puertoServidor); 
			// Enviamos el datagrama 
			socketUDP.send(peticion); 
			// Construimos el DatagramPacket que contendrá la respuesta 
			byte[] bufer = new byte[1000]; 
			DatagramPacket respuesta = 
					new DatagramPacket(bufer, bufer.length);
			socketUDP.setSoTimeout(5000);
			socketUDP.receive(respuesta); 
			// Enviamos la respuesta del servidor a la salida estandar 
			System.out.println("Respuesta: " + new String(respuesta.getData())); 
			// Cerramos el socket 
			socketUDP.close(); 
 
		} catch (SocketException e) { 
			System.out.println("Socket: " + e.getMessage()); 
		} catch (IOException e) { 
			System.out.println("IO: " + e.getMessage()); 
		} 
  } 
} 
