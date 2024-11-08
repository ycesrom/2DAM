
package palindromo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class EjecutarPalindromo {

	public void lanzarClase() throws IOException {

		Process pb;
		try {
			
			File inputFile = new File("C:\\Users\\yerai\\Desktop\\entrada.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String palabra = reader.readLine(); // Leer la primera línea del archivo
            reader.close();
			pb = new ProcessBuilder("java", "-cp", "C:\\Users\\2DAM\\Documents\\2DAM\\PSP\\PSP WorkSpace 24-25\\palindromo\\bin",
					"palindromo.Palindromo", palabra).start();
					
			

			InputStream is = pb.getInputStream();// stdout del hijo

			// mostramos en pantalla caracter a caracter
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (IOException e) {
			escribirError("Error al ejecutar el proceso "+e.getMessage());
           
           
			// TODO Auto-generated catch block
			e.printStackTrace() ;
		}
	}
	private void escribirError(String mensaje) {
        File errorFile = new File("C:\\Users\\yerai\\Desktop\\errores.txt");
        try (FileWriter errorWriter = new FileWriter(errorFile, true)) { // Modo de añadir
            errorWriter.write(mensaje + "\n");
        } catch (IOException ioException) {
            ioException.printStackTrace(); // Manejar excepción de escritura
        }
    }
	

	public static void main(String[] args) throws IOException {

		

		EjecutarPalindromo l = new EjecutarPalindromo();
		l.lanzarClase();

	}
}
