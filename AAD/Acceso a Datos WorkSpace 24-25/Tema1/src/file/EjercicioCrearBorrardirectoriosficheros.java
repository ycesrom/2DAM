package file;

import java.io.File;
import java.util.Scanner;

public class EjercicioCrearBorrardirectoriosficheros 
{

	public static void mostrarMenu() 
	{
		
		//Mostramos los mensajes del menu 
		System.out.println("Ingresa una opcion [1-5]" );
		System.out.println("1.- Crear un fichero nuevo ");
		System.out.println("2.- Borrar un fichero");
		System.out.println("3.- Crear un directorio ");
		System.out.println("4.- Borrar un directorio ");
		System.out.println("5.- Salir ");
		
		
		
	}
	
	public static void crearFichero() 
	{
		try (Scanner entrada = new Scanner(System.in)) 
		{	//Pedimos la ruta del archivo, el nombre del fichero a crear y su extension (C:\Users\yerai\Desktop\prueba.txt)
			System.out.println("Introduzca la ruta del nuevo fichero y su nombre ");
			String ficheros=entrada.nextLine();
			
			//Creamos el fichero
			File fichero=new File(ficheros);
			
			//Comprobamos si el fichero esta creado
			if(fichero.createNewFile()) 
			{
				System.out.println("El fichero se ha creado correctamente ");
			}else
				System.out.println("No se ha podido crear el fichero ");
			
			
		}catch(Exception e) 
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static void borrarFichero() 
	{
		try (//Pedimos la ruta del archivo, el nombre del fichero a borrar y su extension (C:\Users\yerai\Desktop\prueba.txt)
		Scanner entrada = new Scanner(System.in)) {
			System.out.println("Introduzca la ruta del fichero a borrar y su nombre ");
			String ficheros=entrada.nextLine();
			File fichero=new File(ficheros);
			
			//Comprobamos si el fichero existe y si existe lo borramos
			if(fichero.exists())
			{fichero.delete();
			System.out.println("El fichero se ha borrado correctamente ");
			
			}else
				System.out.println("El fichero no existe ");
		}
	}
	
	public static void crearDirectorio() 
	{
		try (//Pedimos la ruta del directorio, el nombre del directorio a crear (C:\Users\yerai\Desktop\prueba)
		Scanner entrada = new Scanner(System.in)) 
		{
			System.out.println("Introduzca la ruta del directorio a crear y su nombre ");
			String carpeta=entrada.nextLine();
			
			//creamos el directorio
			boolean exito=(new File(carpeta)).mkdir();
			
			// si se ha creado saldrá por consola directorio creado
			if(exito)
			{
				System.out.println("Directorio: "+carpeta+" creado");
				
			}else
				System.out.println("Directorio: "+carpeta+" no creado");
		}catch(Exception e) 
		{
			System.out.println("Error: "+e.getMessage());

		}
	}
	
	public static void borrarDirectorio(File directorio) {
        //Obtener los archivos y subdirectorios dentro de el directorio
        File[] archivos = directorio.listFiles();
        
        // Si el directorio tiene archivos o subdirectorios borrarlos
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    // Llamada recursiva para eliminar el subdirectorio
                    borrarDirectorio(archivo);
                } else {
                    // borramos los archivos
                    archivo.delete();
                }
            }
        }
        //Borramos el directorio despues de haber borrado todo el contenido
        directorio.delete();
    }
	
	 public static void borrarDirectorioEntrada() {
	        try (Scanner entrada = new Scanner(System.in)) {
				//Pedimos la ruta del directorio a borrar
				System.out.println("Introduzca la ruta del directorio a borrar:");
				String rutaDirectorio = entrada.nextLine();
				
				//Crearmos el objeto File con la ruta del directorio
				File directorio = new File(rutaDirectorio);
				
				//Comprobamos si el directorio existe
				if (directorio.exists() && directorio.isDirectory()) {
				    // Llamada al método borrarDirectorio para borrar el directorio y su contenido
				    borrarDirectorio(directorio);
				    System.out.println("Directorio eliminado exitosamente: " + rutaDirectorio);
				} else {
				    System.out.println("El directorio no existe o no es válido.");
				}
			}
	        
	    }
		
	

	public static void main(String[] args)
	{
		int opcion=0;
		Scanner entrada=new Scanner(System.in);
		do {
		
		
		mostrarMenu();
		opcion=entrada.nextInt();
		switch(opcion) {
		
		case 1-> {crearFichero();}
		case 2-> {borrarFichero();}
		case 3->{crearDirectorio();}
		case 4->{borrarDirectorioEntrada();}
			
		case 5->System.out.println("Saliendo ... ");
		default -> System.out.println("Opción no válida, elija otra.");
		}
		}while(opcion!=5);
		
		entrada.close();
		
		// TODO Auto-generated method stub

	}

}
