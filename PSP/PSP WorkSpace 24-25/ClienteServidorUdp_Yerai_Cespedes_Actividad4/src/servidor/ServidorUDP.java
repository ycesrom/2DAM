package servidor;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class ServidorUDP {
    private static final int PUERTO = 6789;

    public static void main(String[] args) {
        try {
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
            System.out.println("Servidor UDP escuchando en el puerto " + PUERTO + "...");

            while (true) {
                byte[] buffer = new byte[1024]; // Tamaño del buffer
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                
                // Espera y recibe mensajes de clientes
                socketUDP.receive(peticion);

                // Maneja cada cliente en un hilo separado
                new Thread(new ClienteHandler(socketUDP, peticion)).start();
            }
        } catch (SocketException e) {
            System.out.println("Error de socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    // Hilo para procesar cada cliente
    static class ClienteHandler implements Runnable {
        private DatagramSocket socketUDP;
        private DatagramPacket peticion;

        public ClienteHandler(DatagramSocket socketUDP, DatagramPacket peticion) {
            this.socketUDP = socketUDP;
            this.peticion = peticion;
        }

        @Override
        public void run() {
            try {
                String mensajeRecibido = new String(peticion.getData(), 0, peticion.getLength());
                System.out.println("Mensaje recibido de " + peticion.getAddress() + ":" + peticion.getPort() + " → " + mensajeRecibido);

                // Responder con la fecha y hora actual
                String dateTime = getCurrentDateTime();
                byte[] respuestaBytes = dateTime.getBytes();
                
                DatagramPacket respuesta = new DatagramPacket(
                    respuestaBytes, respuestaBytes.length,
                    peticion.getAddress(), peticion.getPort()
                );

                socketUDP.send(respuesta);
                System.out.println("Respuesta enviada: " + dateTime);
            } catch (IOException e) {
                System.out.println("Error al procesar cliente: " + e.getMessage());
            }
        }
    }

    // Método para obtener la fecha y hora actual
    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
