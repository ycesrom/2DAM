package cliente;

import java.net.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.io.*; 
import java.util.Scanner;


public class ClienteUDP extends Thread { 
	
	static class Hilo implements Runnable {
        private DatagramSocket socketUDP;

        public Hilo(DatagramSocket socketUDP) {
            this.socketUDP = socketUDP;
        }
        
        @Override
        public void run() {
        	byte[] bufer = new byte[1000]; 
			DatagramPacket respuesta = 
					new DatagramPacket(bufer, bufer.length); 
			try {
				socketUDP.receive(respuesta);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.println("Respuesta: " + new String(respuesta.getData()).trim());
			
			// Cerramos el socket 
			socketUDP.close(); 
        	// TODO Auto-generated method stub
        	
        } }

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
			
			socketUDP.close(); 
 
		} catch (SocketException e) { 
			System.out.println("Socket: " + e.getMessage()); 
		} catch (IOException e) { 
			System.out.println("IO: " + e.getMessage()); 
		} 
  }
	}


