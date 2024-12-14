package agendaTélefonica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;




public class agenda {
	
    public static void main(String[] args) {
        
        ArrayList<contacto> Agenda = new ArrayList<contacto>();
        Scanner sc = new Scanner(System.in);
        cargarContacto(Agenda);
        int eleccion;
        do {
        	 System.out.println("==Opciones Disponibles=="
                     + "\n\t1-.NUEVO CONTACTO"
                     + "\n\t2-.BUSCAR POR NOMBRE"
                     + "\n\t3-.MOSTRAR CONTACTOS"
                     + "\n\t4-.Ordenar Agenda ascedente por el telefono"
                     + "\n\t5-.Ordenar Agenda descedente por el telefono"
                     + "\n\t6-Borrar Contacto.(Por el nombre)"
                     +"\n\t7-.SALIR");
        
       
        switch(eleccion=introducirEntero("Introduzca una de las siguientes opciones ",1,7,sc)) 
        {
        case 1-> añadirContacto(sc, Agenda);
        case 2-> buscarNombre(sc, Agenda);
        case 3-> mostrarContactos(Agenda);
        case 4-> ordenarAgendaAscedente(Agenda);
        case 5->ordenarAgendaDescedente(Agenda);
        case 6->borrarPorNombre(Agenda,sc);
        }
       
        	
        } while (eleccion!=7);
        añadirAgenda(Agenda);
        System.out.println("Fin del programa...");
sc.close(); 
    }
    
    static void cargarContacto(ArrayList<contacto> agenda) {
    	try {
    		FileReader leer = new FileReader("C:\\Users\\Admin1Dam\\Desktop\\control3v\\contactos.txt");
    		BufferedReader leido = new BufferedReader(leer);
    		String linea;
    		 while ((linea = leido.readLine()) != null) {
    			 String [] nombreYTelefono=linea.split(" ");
    			 contacto c = new contacto(nombreYTelefono[0],nombreYTelefono[1]);
    			 agenda.add(c);
    		 }
    		 leido.close();
    		 leer.close();
    	} catch (IOException ioe) {
    		System.err.println(ioe);
    	}

    }

    static void añadirContacto(Scanner sc, ArrayList<contacto> agenda) {
        System.out.println("Introduce el nombre que quieres añadir: ");
        String nombre = sc.next();
        sc.nextLine(); 
        System.out.println("Introduce el numero de telefono de tu contacto: ");
        String telefono = sc.nextLine();
        contacto c1 = new contacto(nombre, telefono);
        agenda.add(c1);
		
		
	}
    
    static void imprimirFichero (String fichero) throws IOException {
    	try {
    	BufferedReader reader = new BufferedReader(new FileReader(fichero));
    	String linea = reader.readLine();
    	while (linea!=null) {
    		System.out.println(linea);
    		linea=reader.readLine(); }
    		reader.close();
    		} catch (IOException ioe) {
    			System.out.println("Error");
    	}
    	

    
    }
    
	static void buscarNombre(Scanner sc, ArrayList<contacto> agenda) {
		
		
		System.out.println("Introduce el nombre que quieres buscar: ");
		String buscado = sc.nextLine();
		buscado=buscado.toLowerCase();
		
		int encontrado = 0;

		for (contacto c1 : agenda) {
			if (c1.obtenerNombre().trim().toLowerCase().startsWith(buscado)) {
				encontrado = 1;
				System.out.println("Contacto coincidente encontrado: " + c1.toString());
			}
		}

		if (encontrado == 0) {
			System.out.println("Contacto no encontrado");
		}
	}
    
    static void mostrarContactos (ArrayList<contacto>agenda) {
    	System.out.println(agenda.toString());
    }

    static void añadirAgenda(ArrayList<contacto> agenda) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Admin1Dam\\Desktop\\control3v\\contactos.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (contacto c1 : agenda) {
                bw.write(c1.obtenerNombre() + " " + c1.obtenerTelefono());
                bw.newLine();
                System.out.println("Contacto añadido al archivo: " + c1.obtenerNombre() + " " + c1.obtenerTelefono());
            }
            bw.close();
            fw.close();
            System.out.println("Datos guardados en el archivo correctamente.");
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
    
    static void ordenarAgendaAscedente(ArrayList<contacto> agenda) 
    {
    	Collections.sort(agenda);
    }
    
    static void ordenarAgendaDescedente(ArrayList<contacto> agenda) 
    {
    	
    	Collections.reverse(agenda);
    }
    
    static void borrarPorNombre(ArrayList<contacto> agenda, Scanner sc) 
    {
    	
    	
    	String nombre="";
    	System.out.println("Introduzca el nombre del contacto que desea eliminar ");
    	nombre=sc.nextLine();
    	nombre=nombre.toLowerCase();
    	boolean borrado=false;
    	Iterator<contacto> it=agenda.iterator();
    	while(it.hasNext()) 
    	{
    		contacto aux=it.next();
    		
    		if(aux.obtenerNombre().equalsIgnoreCase(nombre)) 
    		{
    			borrado=true;
    			it.remove();
    		}else
    			borrado=false;
    			
    	}
    	if(borrado==false) 
    	{
    		System.out.println("Contacto no encontrado ");
    	}
    	
    }
    
    static int introducirEntero(String mensaje,int inicio, int nFinal,Scanner sc) 
    {
		int numero = -1;
		boolean acabado = true;
		do {
			try {
				System.out.println(mensaje + " [" + inicio + "-" + nFinal + "]");
				numero = sc.nextInt();
				if(numero > nFinal || numero < inicio) 
					throw new InputMismatchException();
				 sc.nextLine();
				acabado = true;
			} catch (InputMismatchException e) {
				 sc.nextLine();
				acabado = false;
			} 
		} while (!acabado);
		return numero;
	}
    
    
   
}
    
   