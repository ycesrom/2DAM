package productosTienda;

import infoPersonas.Persona;

public class Productos extends Persona
{
	private String nombreProducto;
	private int cantidad;
	private double precio;


	public Productos(String nombreProducto,int cantidad,double precio,String nombre, String apellidos, String dni, int edad, String calle, int numero, int cp,
			String provincia) {
		super(nombre, apellidos, dni, edad, calle, numero, cp, provincia);
		this.nombreProducto=nombreProducto;
		this.cantidad=cantidad;
		this.precio=precio;
		// TODO Auto-generated constructor stub
	}
	
	void establecerNombreProducto(String nombreProducto) 
	{
		this.nombreProducto=nombreProducto;
	}
	
	protected String obtenerNombreProducto() 
	{
		return nombreProducto;
	}
	
	void establecerCantidad(int cantidad) 
	{
		this.cantidad=cantidad;
	}
	
	protected int obtenerCantidad() 
	{
		return cantidad;
	}
	
	void establecerPrecio(double precio) 
	{
		this.precio=precio;
	}
	
	protected double obtenerPrecio() 
	{
		return precio;
	}
	

}
