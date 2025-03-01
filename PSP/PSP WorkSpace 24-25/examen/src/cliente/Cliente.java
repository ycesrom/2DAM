package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws IOException {
		
		try(Socket cliente=new Socket("localhost",5000);
		
		BufferedReader leer=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		PrintWriter out=new PrintWriter(cliente.getOutputStream(),true);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in))){
			
			String msj;
			
			while((msj=in.readLine())!=null) 
			{
				out.println(msj);
				System.out.println(leer.readLine());
				
				if(msj.equalsIgnoreCase("salir")) break;
			}
	}
		// TODO Auto-generated method stub

	}

}
