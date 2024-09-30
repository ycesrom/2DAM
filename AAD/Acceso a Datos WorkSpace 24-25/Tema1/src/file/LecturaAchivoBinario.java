package file;

import java.io.FileInputStream;
import java.io.IOException;

public class LecturaAchivoBinario 
{

	public static void main(String[] args) 
	{
		try
		{
			//Declaramos un objecto
		FileInputStream fis;
		//Ruta donde esta el archivo binario
		fis = new FileInputStream("C:\\Users\\yerai\\Desktop\\datos.dat");
		int i;
		//leemos byte a byte
		while((i=fis.read())!= -1)
		{
		//Sacamos por consola lo que contiene el archivo binario
		System.out.print((char)i);

		}
		fis.close();
		}
		catch (IOException e) 
		{
			System.out.println("Error "+e.getMessage());
		// TODO Auto-generated catch block
		
		}
	

	}

}
