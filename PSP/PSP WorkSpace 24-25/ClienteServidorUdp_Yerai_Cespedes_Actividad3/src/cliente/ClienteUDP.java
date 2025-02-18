package cliente;

import java.net.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.io.*; 
import java.util.Scanner;


public class ClienteUDP extends Thread { 
// Los argumentos proporcionan el mensaje y el nombre del servidor 
	public static void main(String args[]) throws InterruptedException { 
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
			socketUDP.receive(respuesta); 
			// Enviamos la respuesta del servidor a la salida estandar 
			System.out.println("Respuesta: " + new String(respuesta.getData()).trim());
			String horaRemotaString = new String(respuesta.getData(), 0, respuesta.getLength()).trim();
            System.out.println("Respuesta del servidor (hora remota): " + horaRemotaString);

            // Convertir la hora remota a LocalDateTime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime horaRemota = LocalDateTime.parse(horaRemotaString, formatter);
            ClienteUDP h1=new ClienteUDP();
            Thread.sleep(1000);
            LocalDateTime fecha=LocalDateTime.now();
			
			 System.out.println("Hora local: " + fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            
            // Calcular la diferencia de tiempo entre la hora local y la hora remota
            Duration duracion = Duration.between(horaRemota, fecha);
            System.out.println("Diferencia de tiempo (en segundos): " + duracion.getSeconds() + " segundos.");
			// Cerramos el socket 
			socketUDP.close(); 
 
		} catch (SocketException e) { 
			System.out.println("Socket: " + e.getMessage()); 
		} catch (IOException e) { 
			System.out.println("IO: " + e.getMessage()); 
		} 
  } 
} 
