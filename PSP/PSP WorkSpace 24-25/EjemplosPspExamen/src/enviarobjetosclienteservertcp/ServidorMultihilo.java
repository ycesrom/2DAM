/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enviarobjetosclienteservertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author profesor
 */
public class ServidorMultihilo {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor en espera de conexiones...");

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress());
            new Thread(new ManejadorCliente(cliente)).start(); // Hilo por cliente
        }
    }
}

class ManejadorCliente implements Runnable {
    private Socket cliente;

    public ManejadorCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true)) {

            salida.println("¡Bienvenido! Escribe 'fin' para desconectarte.");
            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Cliente dice: " + mensaje);
                if (mensaje.equalsIgnoreCase("salir")) break;
                salida.println("Servidor: " + mensaje.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { 
                cliente.close(); 
                System.out.println("cerrando hilo");
                    } 
            catch(SocketException s){
                System.out.println("El cliente ha cerrado la conexión");
            }
            catch (IOException e) 
            { e.printStackTrace(); }
        }
    }
    
}
