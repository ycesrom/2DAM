package jugadores;

import equipos.Equipo;

public class Jugadores 
{
	private int dorsal;
	private String nombre;
	private int edad;
	private String posicion;
	private String apodo;
	private Equipo equipo;

	public Jugadores() 
	{
		this.dorsal=0;
		this.nombre=null;
		this.edad=edad;
		this.posicion=posicion;
		this.apodo=null;
		this.equipo=null;
	}
	
	public Jugadores(int dorsal, String nombre, int edad, String posicion, String apodo, Equipo equipo ) 
	{
		this.dorsal=dorsal;
		this.nombre=nombre;
		this.edad=edad;
		this.posicion=posicion;
		this.apodo=apodo;
		this.equipo=equipo;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}
