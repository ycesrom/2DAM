package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BorrarPalabraFicTexPlano {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca la ruta del archivo ");
		String archivo = entrada.nextLine(); // Ruta del archivo
		System.out.println("Introduzca la cadena de texto a eliminar");
		String palabraAEliminar = entrada.nextLine(); // Palabra a eliminar
		//Quitar espacios al principio y al final
		palabraAEliminar=palabraAEliminar.trim();
		eliminar(archivo, palabraAEliminar);
		entrada.close();
}
	//	//Creamos el metodo buscar para la ruta del archivo y la cadena a borrar  

	public static void eliminar(String archivo,String palabraAEliminar){
		try {
			// Leer todo el contenido del archivo
			String contenido = new String(Files.readAllBytes(Paths.get(archivo)));


			// Reemplazar la palabra deseada con una cadena vacía
			contenido = contenido.replaceAll("\\b" + palabraAEliminar + "\\b", "");
			//Quitar espacios al principio y al final
			contenido=contenido.trim();
			// Escribir el contenido modificado de nuevo al archivo
			Files.write(Paths.get(archivo), contenido.getBytes());

			System.out.println("La palabra '" + palabraAEliminar + "' ha sido eliminada.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}