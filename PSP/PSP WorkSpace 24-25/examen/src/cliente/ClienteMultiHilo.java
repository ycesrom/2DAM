package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteMultiHilo {
	
	public static void main(String[] args) throws IOException 
	
	{
		try(Socket socket=new Socket("localhost",5000);
				BufferedReader leer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				BufferedReader console=new BufferedReader(new InputStreamReader(System.in))){
				
				String msj;
				
				while((msj=console.readLine())!=null) 
				{
					out.println(msj);
					System.out.println(leer.readLine());
					
					if(msj.equalsIgnoreCase("salir")) break;
				}
				
						
			
		
	}
	}
}
