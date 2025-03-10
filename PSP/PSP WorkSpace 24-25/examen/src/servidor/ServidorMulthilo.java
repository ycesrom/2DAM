package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServidorMulthilo 
{

	public static void main(String[] args) throws IOException 
	{
		ServerSocket servidor=new ServerSocket(5000);
		System.out.println("Esperando conexiones");
		
		while(true) 
		{
			Socket cliente=servidor.accept();
			System.out.println("cliente conectado "+cliente.getInetAddress());
			new Thread(new multihilo(cliente)).start();
		}
	}
}
	class multihilo implements Runnable {
		
		private Socket cliente;
	public multihilo(Socket cliente) 
	{
		this.cliente=cliente;
	}
	

	@Override
	public void run() {
		
		try {
			BufferedReader leer=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida=new PrintWriter(cliente.getOutputStream(),true);
			   
			salida.println("Bienvenido introduzca salir para finalizar ");
			String mensaje;
			while((mensaje=leer.readLine()) !=null) 
			{
				System.out.println("Cliente dice "+mensaje);
				if(mensaje.equalsIgnoreCase("salir"))
				break;
				
				salida.println("Servidor"+mensaje.toUpperCase());
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{
			try {
				cliente.close();
			}catch(SocketException e) 
			{
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
}


