package cliente;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteUDP {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 6789;

    public static void main(String[] args) {
        try {
            DatagramSocket socketUDP = new DatagramSocket();
            
            // Hilo para recibir mensajes del servidor continuamente
            Thread receiverThread = new Thread(new Receiver(socketUDP));
            receiverThread.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Escribe un mensaje (o 'salir' para terminar): ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("salir")) {
                    System.out.println("Cerrando cliente...");
                    socketUDP.close();
                    break;
                }

                // Enviar mensaje al servidor
                byte[] mensaje = message.getBytes();
                InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
                DatagramPacket request = new DatagramPacket(mensaje, mensaje.length, serverAddress, SERVER_PORT);
                socketUDP.send(request);
            }

            scanner.close();
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    // Hilo para recibir mensajes de manera continua sin bloquear el envío
    static class Receiver implements Runnable {
        private DatagramSocket socketUDP;

        public Receiver(DatagramSocket socketUDP) {
            this.socketUDP = socketUDP;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            while (!socketUDP.isClosed()) {
                try {
                    DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                    socketUDP.receive(response);
                    String receivedMessage = new String(response.getData(), 0, response.getLength());
                    System.out.println("\n[Servidor]: " + receivedMessage);
                } catch (IOException e) {
                    if (socketUDP.isClosed()) {
                        System.out.println("Socket cerrado, terminando recepción.");
                        break;
                    }
                    System.out.println("Error recibiendo mensaje: " + e.getMessage());
                }
            }
        }
    }
}
