package file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalFichTexPl {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca la ruta del archivo ");
		String archivo=entrada.nextLine();
		System.out.println("Introduzca la cadena de texto a buscar ");
		String palabra=entrada.nextLine();
		buscar(archivo,palabra);
		entrada.close();
	}
	//Creamos el metodo buscar para la ruta del archivo y la cadena a encontrar
	
	public static void buscar(String nombre, String nombreABuscar) {
		try {
			//Creamos un archivo nuevo
			File archivo = new File(nombre);
			
			//Leemos el archivo
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			// acceso secuencial al fichero
			String linea;
			boolean encontrado=false;
			
				//Buscamos la cadena de texto
				while((linea=br.readLine())!=null && !encontrado){
					if(linea.toLowerCase().contains(nombreABuscar.toLowerCase())) {						
						encontrado=true;
					}
				}
				if(encontrado)
					System.out.println("Hemos encontrado en el archivo el nombre: "+nombreABuscar);
				else
					System.out.println("No hemos encontrado en el archivo el nombre: "+nombreABuscar);
				br.close();
				fr.close();
					
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
