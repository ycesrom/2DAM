package tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class RedireccionarSalidaProcesoLaEntradaOtro {
	
	public static void main(String[] args) {
		String line="";
		Process p1, p2;
		int retorno=-1;
		try {
			p1 = new ProcessBuilder("CMD", "/C", "date", "/t").start();
			InputStream is = p1.getInputStream();//stdout del hijo
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
			line = br.readLine();
			try {
				retorno = p1.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Fecha actual: "+line);
			System.out.println("Retorno p1: "+retorno);
			is.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			p2 = new ProcessBuilder("CMD", "/C", "date").start();
			OutputStream os = p2.getOutputStream();//stdin del hijo
			Scanner entrada=new Scanner(System.in);
			line=entrada.nextLine();
			//escribimos en proceso 2 la salida del proceso1
			//guardada en String line, se convierte en bytes
			// para ser grabada
			os.write(line.getBytes());
			//no se escribe si no liberamos el buffer usado
			os.flush();
			os.close();	
			
			
			//recuperamos el stdout del segundo proceso
			// es decir su salida
			InputStream is2 = p2.getInputStream();			
			
			// mostramos la salida del proceso 2
			int c;
			while ((c = is2.read()) != -1)
			System.out.print((char) c);
			is2.close();
			
			try {				
				retorno = p2.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Retorno p2: "+retorno);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
} 