package infoFacturas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import infoPersonas.Persona;
import productosTienda.Productos;


public class CrearFactura 
{

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
		try {
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
		double total=cantidad*precio;
		productos.add(new Productos(nombreProducto,cantidad,precio,total));
		 entrada.nextLine();

		}
		}catch(InputMismatchException e) 
		{
			System.out.println("Error "+e);
		}
		
	}
	

	static void insertarFactura(ArrayList<Factura> facturas,ArrayList<Persona> personas,ArrayList<Productos>productos) 
	{
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el DNI del cliente para crear la factura:");
	    String dni = entrada.nextLine();
		// Buscar la persona con el DNI
	    Persona persona = buscarPersonaPorDni(personas, dni);
	    if(persona==null) 
	    {
	    	System.out.println("Cliente no Encontrado");
	    }else 
	    {
	    String nombreEmpresa="Ejido Store";
	    String cif="B040567990";
	    ArrayList<Productos> productosFactura=new ArrayList<>();
	    insertarProductos(productosFactura);	   
		
			facturas.add(new Factura(nombreEmpresa,cif, persona,productosFactura));
		}
		
	}
	
	
	static void eliminarFactura(ArrayList<Factura> facturas) 
	{
		int id;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el id de la factura a eliminar");
		id=sc.nextInt();
		boolean eliminar=true;
		Iterator<Factura> it=facturas.iterator();
		while(it.hasNext()) 
		{
			Factura aux=it.next();
			
			if(aux.obtenerIdFactura()==id) 
			{
				it.remove();
				eliminar=false;
			}
			if(eliminar=true) 
			{
					System.out.println("Id de factura no encontrado");
			}
			
				
			
		}
		
		
	}
	
	
	static void eliminarProductos(ArrayList<Productos>productos,Scanner sc) 
	{
		String producto="";
		System.out.println("Introduzca el nombre del producto a eliminar");
		producto=sc.nextLine();
		boolean encontrado=false;
		Iterator<Productos> it=productos.iterator();
		
		while(it.hasNext()) 
		{
			Productos aux=it.next();
			if(aux.obtenerNombreProducto().equalsIgnoreCase(producto)) 
			{
				it.remove();
				encontrado=true;
			}
		
			
		}
		
		if(encontrado==true) 
		{
			System.out.println("Producto eliminado");
		}else 
		{
			System.out.println("Producto no encontrado");
		}

	}
	
	static void modificarProductos(ArrayList<Productos>productos,Scanner sc) 
	{
		String producto="";
		System.out.println("Introduzca el nombre del producto a modificar");
		producto=sc.nextLine();
		boolean encontrado=false;
		Iterator<Productos> it=productos.iterator();
		int opcion=0;
		while(it.hasNext()&&opcion<5) 
		{
			
			
			Productos aux=it.next();
			if(aux.obtenerNombreProducto().equalsIgnoreCase(producto)) 
			{
				System.out.println("1.Cambiar nombre");
				System.out.println("2.Cambiar cantidad");
				System.out.println("3.Cambiar precio");
				System.out.println("4.Cambiar todo");
				System.out.println("5.Salir");
				opcion=sc.nextInt();
				
				sc.nextLine();
				encontrado=true;
				
				switch(opcion) 
				{
				case 1-> {System.out.println("Introduzca el nuevo nombre");
				String nombre=sc.nextLine();
				aux.establecerNombreProducto(nombre);}
				case 2->{System.out.println("Introduzca la nueva cantidad");
						int cantidad=sc.nextInt();
						aux.establecerCantidad(cantidad);}
				case 3->{System.out.println("Introduzca el nuevo precio");
						double precio=sc.nextDouble();
						aux.establecerPrecio(precio);}
				case 4->{System.out.println("Introduzca el nuevo nombre");
				String nombre=sc.nextLine();
				aux.establecerNombreProducto(nombre);
				System.out.println("Introduzca la nueva cantidad");
						int cantidad=sc.nextInt();
						aux.establecerCantidad(cantidad);
				System.out.println("Introduzca el nuevo precio");
						double precio=sc.nextDouble();
						aux.establecerPrecio(precio);}
				
				}
			}
			
		}
		
		if(encontrado==true) 
		{
			System.out.println("Producto modificado");
		}else 
		{
			System.out.println("Producto no encontrado");
		}

	}
	
	
	static void modificarFactura(ArrayList<Factura>facturas,ArrayList<Persona> personas,ArrayList<Productos>productos) 
	{
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el id de la factura para modificar la factura:");
	    int id = entrada.nextInt();
	   
	    int opcion=0;
	    Factura facturaSeleccionada = null;
	    for (Factura factura : facturas) {
	        if (factura.obtenerIdFactura() == id) {
	            facturaSeleccionada = factura;
	            
	        }
	    }

	    if (facturaSeleccionada == null) {
	        System.out.println("Factura no encontrada.");
	        return;
	    }

	    ArrayList<Productos> productosFactura = facturaSeleccionada.obtenerProductos();
	    do 
	    {
	    	System.out.println("1.Añadir mas productos a la factura");
	    	System.out.println("2.Eliminar productos de la factura");
	    	System.out.println("3.Modificar productos de la factura");
	    	System.out.println("4.Salir");
	    	opcion=entrada.nextInt();
	    	entrada.nextLine();
	  
	    switch(opcion) 
	    {
	    case 1-> insertarProductos(productosFactura);
	    case 2->{eliminarProductos(productosFactura,entrada);}
	    case 3->{modificarProductos(productosFactura,entrada);}
	    default-> System.out.println("Modificacion finalizada");
	   
	    
	    }
		 }while(opcion<4);
	}
	
	static void verFactura(ArrayList<Factura> facturas) 
	{
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el ID de la factura que desea ver:");
        int id = entrada.nextInt();
        
        for (Factura factura : facturas) 
        {
            if (factura.obtenerIdFactura() == id) 
            {
                System.out.println(factura);  // Muestra la factura usando el método toString de Factura
                return;
            }
        }
        System.out.println("Factura no encontrada.");
    }
	
	static void facturaTxt(ArrayList<Factura> facturas,ArrayList<Productos>producto) {
	    String filePath = "C:\\Users\\yerai\\Downloads\\factura.txt";
	    HashSet<Integer> idsExistentes = new HashSet<>();
	    try {
	        // Leer IDs existentes del archivo
	        Files.lines(Paths.get(filePath)).forEach(line -> {
	            if (line.startsWith("Factura ID:")) {
	                String id = line.split(":")[1].trim();
	                idsExistentes.add(Integer.parseInt(id));
	            }
	        });

	        try (BufferedWriter archivo = new BufferedWriter(new FileWriter(filePath, false))) {
	            for (Factura factura : facturas) {
	                // Solo escribimos las facturas que no están ya en el archivo
	                if (idsExistentes.contains(factura.obtenerIdFactura())|| !idsExistentes.contains(factura.obtenerIdFactura())) {
	                    archivo.write("Factura ID: " + factura.obtenerIdFactura());
	                    archivo.newLine();
	                    archivo.write("Empresa: " + factura.obtenerNombreEmpresa());
	                    archivo.newLine();
	                    archivo.write("CIF: " + factura.obtenerCif());
	                    archivo.newLine();
	                    archivo.write("Cliente: " + factura.obtenerCliente().obtenerNombre());
	                    archivo.newLine();

	                    // Guardamos los productos de la factura
	                    archivo.write("Productos: ");
	                    archivo.write(factura.obtenerProductos().toString());
	                    archivo.newLine();
	                   for(Productos productos : producto) 
	                   {archivo.write("Total: " + productos.obtenerTotal() + " Euros");
	                    archivo.newLine();}
	                    
	                    idsExistentes.add(factura.obtenerIdFactura());
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("Error al escribir en el archivo: " + e.getMessage());
	    }
	}


	
	static void menu() 
	{
		Scanner entrada=new Scanner(System.in);

		int opcion=0;

		ArrayList<Factura> facturas=new ArrayList<Factura>();
		ArrayList<Persona> personas=new ArrayList<Persona>();
		ArrayList<Productos>productos=new ArrayList<Productos>();
		cargarContactos1(personas);
	
		do{		
			
	try {
			System.out.println("1.Crear Factura");
			System.out.println("2.Eliminar Factura");
			System.out.println("3.Modificar Factura");
			System.out.println("4.Ver Factura");
			System.out.println("5.Factura terminada");
			System.out.print("6.Salir");

			opcion=entrada.nextInt();
		
			switch(opcion) 
			{

			case 1->{insertarFactura(facturas,personas,productos);}
			case 2->{eliminarFactura(facturas);}
			case 3->{modificarFactura(facturas,personas,productos);}
			case 4->{verFactura(facturas);}
			case 5->{facturaTxt(facturas,productos);
			System.out.println("Factura creada");}
			
			default->{System.out.println("Programa Finalizado");}
			
			}
			}catch(InputMismatchException e) 
			{
				 System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
				entrada.nextLine();
			}
			
		}while(opcion<6);
		
		entrada.close();
		
		
	}
	
	
}
