package clienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	 public static void main(String[] args) throws IOException {
	        try (ServerSocket serverSocket = new ServerSocket(12345)) {
	        	// esperando conexiones en el puerto 12345
	        	System.out.println("Esperando conexiones...");
	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                new ClientHandler(clientSocket).start();
	            }
	        }
	    }
	}

	class ClientHandler extends Thread {
	    private final Socket socket;

	    public ClientHandler(Socket socket) {
	        this.socket = socket;
	    }

	    @Override
	    public void run() {
	        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
	            String msg;
	            	
	            while ((msg = in.readLine()) != null) {
	            
	            	int numero=Integer.parseInt(msg);
	            	if(numero==0) 
	            	{
	            		out.println("Servidor cerrado");
	            		
	            		socket.close();
	            	}else 
	            	{
	            		int cuadrado=numero*numero;
	            		out.println(cuadrado);
	            	}
	              
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
