package infoPersonas;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListaPersonas 
{

	public static void main(String[] args) 
	{
		ArrayList<Persona> personas=new ArrayList<Persona>();
		
		// TODO Auto-generated method stub
		
		cargarContactos1(personas);
		OrdenarListaporApellidoAsc(personas);
		mostrarContactos(personas);
		borrarMenoresEdad(personas);
		System.out.println("==Lista sin menores de edad ==");
		mostrarContactos(personas);
		volcarInfoFichero(personas);

	}
	
	static void cargarContactos1(ArrayList<Persona> persona ) 
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
				
				persona.add(new Persona(nombre,apellidos,dni,edad,calle,numero,cp,provincia));
			}
		}catch(IOException e) 
		{
			System.out.println("Error "+e.getMessage());
		}
	}
	
	static void mostrarContactos(ArrayList<Persona> persona ) 
	{
		for(Persona personas:persona) 
		{
			System.out.println(personas.toString());
			
		}
	}
	
	static void borrarMenoresEdad(ArrayList<Persona> persona) 
	{
		Iterator<Persona> it=persona.iterator();
		while(it.hasNext()) 
		{
			Persona aux=it.next();
			
			if(aux.obtenerEdad()<18) 
			{
				it.remove();
			}
		}
	}
	
	static void OrdenarListaporApellidoAsc(ArrayList<Persona> persona) 
	{
		Collections.sort(persona);
	}
	
	static void volcarInfoFichero(ArrayList<Persona> persona) 
	{
		try(BufferedWriter archivo=new BufferedWriter(new FileWriter("C:\\Users\\Admin1Dam\\Desktop\\control3v\\personascaceres.txt")))
		{
			for(Persona personas:persona) 
			{
				archivo.write(personas.toString());
				archivo.newLine();
			}
			archivo.close();
			
		}catch(IOException e) 
		{
			
		}
	}

}
