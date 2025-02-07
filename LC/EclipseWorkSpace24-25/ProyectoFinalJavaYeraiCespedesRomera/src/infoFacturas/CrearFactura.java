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
	
	static void insertarProductos(ArrayList<Productos>productos,Scanner entrada) 
	{
		try {
		
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
	    insertarProductos(productosFactura,entrada);	   
		
			facturas.add(new Factura(nombreEmpresa,cif, persona,productosFactura));
		}
		
	}
	
	
	static void eliminarFactura(ArrayList<Factura> facturas,Scanner entrada) 
	{
		int id;
		
		System.out.println("Introduzca el id de la factura a eliminar");
		id=entrada.nextInt();
		boolean eliminar=false;
		Iterator<Factura> it=facturas.iterator();
		while(it.hasNext()) 
		{
			Factura aux=it.next();
			
			if(aux.obtenerIdFactura()==id) 
			{
				it.remove();
				eliminar=true;
				System.out.println("Factura con el id "+id+" Borrada correctamente");
			}
			
			
				
			
		}
		if(eliminar==false) 
			{
					System.out.println("Id de factura no encontrado");
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
	

	static ArrayList<Factura> recuperarFacturas(String filePath, ArrayList<Persona> personas) {
	    ArrayList<Factura> facturasRecuperadas = new ArrayList<>();

	    try (BufferedReader archivo = new BufferedReader(new FileReader(filePath))) {
	        String linea;
	        Factura facturaActual = null;
	        ArrayList<Productos> productosFactura = new ArrayList<>();

	        while ((linea = archivo.readLine()) != null) {
	            linea = linea.trim(); // Eliminamos espacios en blanco

	            if (linea.isEmpty()) {
	                continue; // Saltamos líneas vacías
	            }

	            if (linea.startsWith("Factura ID:")) {
	                // Guardamos la factura anterior si existe
	                if (facturaActual != null) {
	                    facturaActual.setProductos(productosFactura);
	                    facturasRecuperadas.add(facturaActual);
	                    productosFactura = new ArrayList<>(); // Reiniciar lista de productos
	                }

	                // Validación para evitar error de índice
	                String[] partes = linea.split(":");
	                if (partes.length < 2) {
	                    System.err.println("Error en el formato de la factura: " + linea);
	                    continue;
	                }

	                int idFactura = Integer.parseInt(partes[1].trim());

	                // Leemos Empresa
	                linea = archivo.readLine();
	                if (linea == null || !linea.contains(":")) continue;
	                String nombreEmpresa = linea.split(":")[1].trim();

	                // Leemos CIF
	                linea = archivo.readLine();
	                if (linea == null || !linea.contains(":")) continue;
	                String cif = linea.split(":")[1].trim();

	                // Leemos Cliente
	                linea = archivo.readLine();
	                if (linea == null || !linea.contains(":")) continue;
	                String nombreCliente = linea.split(":")[1].trim();

	                // Buscar persona
	                Persona cliente = null;
	                for (Persona persona : personas) {
	                    if (persona.obtenerNombre().equalsIgnoreCase(nombreCliente)) {
	                        cliente = persona;
	                        
	                    }
	                }

	                if (cliente != null) {
	                    facturaActual = new Factura(nombreEmpresa, cif, cliente, new ArrayList<>());
	                } else {
	                    System.err.println("Cliente no encontrado: " + nombreCliente);
	                    facturaActual = null; // Evita agregar una factura sin cliente
	                }
	            } else if (linea.startsWith("Productos:")) {
	                if (facturaActual == null) continue;

	                String productosLinea = linea.split(":", 2)[1].trim();
	                productosLinea = productosLinea.replace("[", "").replace("]", ""); // Quitamos corchetes

	                // Parseamos productos
	                String[] productosArray = productosLinea.split(", ");
	                for (String productoStr : productosArray) {
	                    String[] datosProducto = productoStr.split(" - ");
	                    if (datosProducto.length < 3) {
	                        System.err.println("Formato incorrecto en productos: " + productoStr);
	                        continue;
	                    }

	                    String nombreProducto = datosProducto[0].trim();
	                    int cantidad = Integer.parseInt(datosProducto[1].split(":")[1].trim());
	                    double precio = Double.parseDouble(datosProducto[2].split(":")[1].trim());

	                    productosFactura.add(new Productos(nombreProducto, cantidad, precio, cantidad * precio));
	                }
	            }
	        }

	        // Guardamos la última factura
	        if (facturaActual != null) {
	            facturaActual.setProductos(productosFactura);
	            facturasRecuperadas.add(facturaActual);
	        }
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Error inesperado: " + e.getMessage());
	    }

	    return facturasRecuperadas;
	}

	
	static void modificarFactura(ArrayList<Factura>facturas,ArrayList<Persona> personas,ArrayList<Productos>productos) 
	{
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el id de la factura para modificar la factura:");
	    int id = entrada.nextInt();
	  
	    int opcion=0;
	     
	    try {
	    	Factura facturaSeleccionada = null;
	    for (Factura factura : facturas) {
	        if (factura.obtenerIdFactura() == id) {
	            facturaSeleccionada = factura;
	            
	        }
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
	    case 1-> insertarProductos(productosFactura,entrada);
	    case 2->{eliminarProductos(productosFactura,entrada);}
	    case 3->{modificarProductos(productosFactura,entrada);}
	    default-> System.out.println("Modificacion finalizada");
	   
	    
	    }
		 }while(opcion<4);
	    }catch(java.lang.NullPointerException e)
		   {
			   	System.out.println("Id de la factura no Encontrado ");
			   
		   }
	}
	
	static void verFactura(ArrayList<Factura> facturas,Scanner entrada) 
	{
       
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
	
	static void facturaTxt(ArrayList<Factura> facturas, ArrayList<Productos> productos) {
	    String filePath = "C:\\Users\\yerai\\Downloads\\facturas.txt";
	    HashSet<Integer> idsExistentes = new HashSet<>();

	    try {
	        // Leer IDs existentes del archivo
	        Files.lines(Paths.get(filePath)).forEach(line -> {
	            if (line.startsWith("Factura ID:")) {
	                String id = line.split(":")[1].trim();
	                idsExistentes.add(Integer.parseInt(id));
	            }
	        });

	        try (BufferedWriter archivo = new BufferedWriter(new FileWriter(filePath,false))) { // Usamos false para sobrescribir las facturas con el mismo id
	            for (Factura factura : facturas) {
	                // Solo escribimos las facturas que no están ya en el archivo
	                if (!idsExistentes.contains(factura.obtenerIdFactura())||idsExistentes.contains(factura.obtenerIdFactura())) {
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

	                    // Calcular el total de la factura
	                    double totalFactura = 0.0;
	                    for (Productos producto : factura.obtenerProductos()) {
	                        totalFactura += producto.obtenerTotal();
	                    }

	                    // Escribir el total de la factura
	                    archivo.write("Total: " + totalFactura + " Euros");
	                    archivo.newLine();
	                    archivo.newLine(); // Separador entre facturas

	                    // Añadir el ID de la factura al conjunto de IDs existentes
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
			System.out.println("6.Recuperar Facturas");
			System.out.println("7.Salir");

			opcion=entrada.nextInt();
		
			switch(opcion) 
			{

			case 1->{insertarFactura(facturas,personas,productos);}
			case 2->{eliminarFactura(facturas,entrada);}
			case 3->{modificarFactura(facturas,personas,productos);}
			case 4->{verFactura(facturas,entrada);}
			case 5->{facturaTxt(facturas,productos);
			System.out.println("Factura creada");}
			case 6->{ System.out.println("Recuperando facturas...");
		    ArrayList<Factura> facturasRecuperadas = recuperarFacturas("C:\\Users\\yerai\\Downloads\\facturas.txt", personas);
		    facturas.addAll(facturasRecuperadas);
		    System.out.println("Facturas recuperadas: " + facturasRecuperadas.size());}
			
			default->{System.out.println("Programa Finalizado");}
			
			}
			}catch(InputMismatchException e) 
			{
				 System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
				entrada.nextLine();
			}
			
		}while(opcion<7);
		
		entrada.close();
		
		
	}
	
	
}
