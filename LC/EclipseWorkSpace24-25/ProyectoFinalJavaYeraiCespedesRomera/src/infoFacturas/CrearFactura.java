package infoFacturas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import infoPersonas.Persona;

public class CrearFactura {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		menu();

	}
	
	static void insertarFactura(ArrayList<Factura> facturas) 
	{
		try(BufferedReader archivo =new BufferedReader(new FileReader("C:\\Users\\Admin1Dam\\Desktop\\control3v\\contactoscontrol.txt")))
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
			
			facturas.add(new Factura(cp, nombre,apellidos,dni,edad,cp, calle,provincia, provincia, numero,provincia, cp,cp, provincia));
		}
	}catch(IOException e) 
	{
		System.out.println("Error "+e.getMessage());
	}
		
	}
	
	static void eliminarFactura(ArrayList<Factura> facturas, Scanner sc) 
	{
		int id;
		System.out.println("Introduzca el id de la factura a eliminar");
		id=sc.nextInt();
		Iterator<Factura> it=facturas.iterator();
		while(it.hasNext()) 
		{
			Factura aux=it.next();
			
			if(aux.obtenerIdFactura()==id) 
			{
				it.remove();
			}else 
			{
				System.out.println("Id de factura no encontrado");
			}
		}
		
	}
	
	static void modificarFactura(ArrayList<Factura> facturas,Scanner sc) 
	{
		int id;
		System.out.println("Introduzca el id de la factura a modificar");
		id=sc.nextInt();
		
		Iterator<Factura> it=facturas.iterator();
		while(it.hasNext()) 
		{
			Factura aux=it.next();
			
			if(aux.obtenerIdFactura()==id) 
			{
				
			}else 
			{
				System.out.println("Id de factura no encontrado");
			}
		}
		
	}
	
	static void menu() 
	{
		Scanner entrada=new Scanner(System.in);
		int opcion=0;
		ArrayList<Factura> facturas=new ArrayList<Factura>();
		do{
			System.out.println("1.Crear Factura");
			System.out.println("2.Eliminar Factura");
			System.out.println("3.Modificar Factura");
			System.out.println("4.Salir");
			opcion=entrada.nextInt();
		
			switch(opcion) 
			{
			case 1->{insertarFactura(facturas);}
			case 2->{eliminarFactura(facturas,entrada);}
			case 3->{modificarFactura(facturas,entrada);}
			default->{System.out.println("Programa Finalizado");}
			
			}
			
		}while(opcion<4);
	}
	
	
}
