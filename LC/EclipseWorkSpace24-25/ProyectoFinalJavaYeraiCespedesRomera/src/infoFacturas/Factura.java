package infoFacturas;

import productosTienda.Productos;

public class Factura extends Productos 
{
	private int idFactura;
	private String nombreEmpresa;
	private String cif;
	

	public Factura(int idFactura, String nombreEmpresa,String cif,String nombreProducto, int cantidad, double precio, String nombre, String apellidos, String dni,
			int edad, String calle, int numero, int cp, String provincia) {
		super(nombreProducto, cantidad, precio, nombre, apellidos, dni, edad, calle, numero, cp, provincia);
		this.idFactura=idFactura;
		this.nombreEmpresa=nombreEmpresa;
		this.cif=cif;
		// TODO Auto-generated constructor stub
	}
	
	 void establecerIdFactura(int idFactura) 
	{
		this.idFactura=idFactura;
	}
	
	 int obtenerIdFactura() 
	{
		return idFactura;
	}
	
	void establecerNombreEmpresa(String nombreEmpresa) 
	{
		this.nombreEmpresa=nombreEmpresa;
	}
	
	String obtenerNombreEmpresa() 
	{
		return nombreEmpresa;
	}
	
	void establecerCif(String cif) 
	{
		this.cif=cif;
		
	}
	
	String obtenerCif() 
	{
		return cif;
	}

	@Override
	public String toString() {
		return super.toString() ;
	}  
	
	

}
