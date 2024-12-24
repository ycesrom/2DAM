package infoFacturas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import infoPersonas.Persona;
import productosTienda.Productos;


public class CrearFactura {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		menu();

	}
	
	static void cargarContactos1(ArrayList<Persona> personas ) 
	{
		try(BufferedReader archivo =new BufferedReader(new FileReader("C:\\Users\\yerai\\Desktop\\personas.txt")))
		{
			String linea;
			while((linea=archivo.readLine())!=null)
			{
				String datos[]=linea.split("-");
				String nombre=datos[0].trim();
				String apellidos=datos[1];
				String dni=datos[2];
				int edad=Integer.parseInt(datos[3]);
				String calle=datos[4];
				int numero=Integer.parseInt(datos[5]);
				int cp=Integer.parseInt(datos[6]);
				String provincia=datos[7];
				
				personas.add(new Persona(nombre,apellidos,dni,edad,calle,numero,cp,provincia));
			}
		}catch(IOException e) 
		{
			System.out.println("Error "+e.getMessage());
		}
	}
	
	 
	
	static Persona buscarPersonaPorDni(ArrayList<Persona> personas, String dni) 
	{
	    for (Persona persona : personas) 
	    {
	        if (persona.obtenerDni().equalsIgnoreCase(dni)) 
	        {
	            return persona;  // Devuelve la persona si el DNI coincide
	        }
	    }
	    return null;  // Devuelve null si no se encuentra ninguna persona con el DNI
	}
	
	static void insertarProductos(ArrayList<Productos>productos) 
	{
		Scanner entrada=new Scanner(System.in);
		System.out.println("Cuantos productos desea añadir");
		int cantidadP=entrada.nextInt();
		 entrada.nextLine();

		for(int i=0; i<cantidadP;i++) 
		{
		System.out.println("Introduzca el nombre del producto");
		String nombreProducto=entrada.nextLine();
		System.out.println("Introduzca la cantidad");
		int cantidad=entrada.nextInt();
		System.out.println("Introduzca el precio");
		double precio=entrada.nextDouble();
		productos.add(new Productos(nombreProducto,cantidad,precio));
		 entrada.nextLine();

		}
		
		
	}
	
	
	static void insertarFactura(ArrayList<Factura> facturas,ArrayList<Persona> personas,ArrayList<Productos>productos) 
	{
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el DNI del cliente para crear la factura:");
	    String dni = entrada.nextLine();
		// Buscar la persona con el DNI
	    Persona persona = buscarPersonaPorDni(personas, dni);
	    
	    String nombreEmpresa="Ejido Store";
	    String cif="B040567990";
	    insertarProductos(productos);	   
		
			facturas.add(new Factura(nombreEmpresa,cif, persona,productos));
		
	}
	
	
	
	static void eliminarFactura(ArrayList<Factura>facturas) 
	{
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el id de la factura a eliminar");
		int id=entrada.nextInt();
		Iterator<Factura> it=facturas.iterator();
		while(it.hasNext()) 
		{
			Factura aux=it.next();
			if(aux.obtenerIdFactura()==id) 
			{
				it.remove();
				System.out.println("Factura eliminada correctamente");
			}
		}
		
	}
	
	static void modificarFactura(ArrayList<Factura>facturas,ArrayList<Persona> personas) 
	{
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el DNI del cliente para modificar la factura:");
	    String dni = entrada.nextLine();
		// Buscar la persona con el DNI
	    Persona persona = buscarPersonaPorDni(personas, dni);
		
	}
	
	static void verFactura(ArrayList<Factura> facturas) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el ID de la factura que desea ver:");
        int id = entrada.nextInt();
        
        for (Factura factura : facturas) {
            if (factura.obtenerIdFactura() == id) {
                System.out.println(factura);  // Muestra la factura usando el método toString de Factura
                return;
            }
        }
        System.out.println("Factura no encontrada.");
    }

	
	static void menu() 
	{
		Scanner entrada=new Scanner(System.in);
		
		ArrayList<Factura> facturas=new ArrayList<Factura>();
		ArrayList<Persona> personas=new ArrayList<Persona>();
		ArrayList<Productos>productos=new ArrayList<Productos>();
		cargarContactos1(personas);
		int opcion;
		do{		
			

			System.out.println("1.Crear Factura");
			System.out.println("2.Eliminar Factura");
			System.out.println("3.Modificar Factura");
			System.out.println("4.Ver Factura");
			System.out.println("5.Salir");
			opcion=entrada.nextInt();
		
			switch(opcion) 
			{
			case 1->{insertarFactura(facturas,personas,productos);}
			case 2->{eliminarFactura(facturas);}
			case 3->{modificarFactura(facturas,personas);}
			case 4->{verFactura(facturas);}
			default->{System.out.println("Programa Finalizado");}
			
			}
			
		}while(opcion<5);
	}
	
	
}
