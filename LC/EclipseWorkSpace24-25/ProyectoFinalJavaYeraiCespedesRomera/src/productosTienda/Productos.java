package productosTienda;


public class Productos 
{
	private String nombreProducto;
	private int cantidad;
	private double precio;


	public Productos(String nombreProducto,int cantidad,double precio)
	{
		
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
	
	@Override
	public String toString() 
	{
        return nombreProducto + " - Cantidad: " + cantidad + " - Precio: " + precio;

		
	}
	

}
