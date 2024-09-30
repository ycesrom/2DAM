package file;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CreaciónInformaciónArchivoBinario {

	public static void main(String[] args) throws IOException 
	{
		//Objecto que se declara
		DataOutputStream file;
		
		try 
		{
			//Ruta donde ira el archivo
			String fileName="C:\\Users\\yerai\\Desktop\\datos.dat" ;
			
			//crearemos donde guardaremos los datos filename(es la ruta del archivo), true(para que siga escribiendo y no borre lo anterior)
			file = new DataOutputStream (new FileOutputStream(fileName,true));
			try (// Escribir cadena de texto
			Scanner entrada = new Scanner(System.in)) {
				System.out.println("Introduce el texto: ");
				String archivo=entrada.nextLine();
				//Escribir los bytes en el archivo y un separador para cada vez que se inserte texto
				file.writeBytes(archivo+System.lineSeparator());
			}
			//Cerramos el archivo
			file.close();
		}catch(FileNotFoundException e)  
		{
			System.out.println("Error "+e.getMessage());
		}
		// TODO Auto-generated method stub

	}

}
