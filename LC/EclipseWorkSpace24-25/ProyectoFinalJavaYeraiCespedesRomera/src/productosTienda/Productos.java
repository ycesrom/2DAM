package productosTienda;


public class Productos 
{
	private String nombreProducto;
	private int cantidad;
	private double precio;
	private double total;
	

	public Productos() 
	{
		
	}

	public Productos(String nombreProducto,int cantidad,double precio,double total)
	{
		
		this.nombreProducto=nombreProducto;
		this.cantidad=cantidad;
		this.precio=precio;
		this.total=total;
		// TODO Auto-generated constructor stub
	}
	
	public void establecerNombreProducto(String nombreProducto) 
	{
		this.nombreProducto=nombreProducto;
	}
	
	public String obtenerNombreProducto() 
	{
		return nombreProducto;
	}
	
	public void establecerCantidad(int cantidad) 
	{
		this.cantidad=cantidad;
	}
	
	public int obtenerCantidad() 
	{
		return cantidad;
	}
	
	public void establecerPrecio(double precio) 
	{
		this.precio=precio;
	}
	
	public double obtenerPrecio() 
	{
		return precio*cantidad;
	}
	
	public void establecerTotal(double total)
	{
		
	}
	
	public double obtenerTotal() 
	{
		return total;
	}
	
	@Override
	public String toString() 
	{
        return nombreProducto + " - Cantidad: " + cantidad + " - Precio: " + precio;

		
	}
	

}
