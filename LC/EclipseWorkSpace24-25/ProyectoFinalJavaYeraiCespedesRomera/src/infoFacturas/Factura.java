package infoFacturas;

import java.util.ArrayList;

import infoPersonas.Persona;
import productosTienda.Productos;

public class Factura 
{
    private static int contador = 1;
    private int idFactura;
    private String nombreEmpresa;
    private String cif;
    private Persona cliente;
    private ArrayList<Productos> productos;// Almacena un solo cliente
    
    public Factura() 
    {
    	
    }
    
    // Constructor que recibe un cliente específico
    public Factura(String nombreEmpresa, String cif, Persona cliente,ArrayList<Productos> productos) 
    {
        this.idFactura = contador++;
        this.nombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.cliente = cliente;
        this.productos=new ArrayList<>(productos);
       
      
    }

    public int obtenerIdFactura() 
    {
        return idFactura;
    }

    public String obtenerNombreEmpresa() 
    {
        return nombreEmpresa;
    }

    public String obtenerCif() 
    {
        return cif;
    }

    public Persona obtenerCliente() 
    {
        return cliente;
    }
    
    public ArrayList<Productos> obtenerProductos() 
    {
    	return productos;
    }
    
  
    

    public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}

	@Override
    public String toString() 
    {
    	double total = 0;
    for (Productos producto : productos) {
        total += producto.obtenerPrecio();} 
        return "Factura ID: " + idFactura + "\n" +
               "Empresa: " + nombreEmpresa + "\n" +
               "CIF: " + cif + "\n" +
               "Cliente: " + (cliente != null ? cliente.obtenerNombre() : "Sin Cliente") + "\n"+
               "Productos: "+obtenerProductos()+
               "\n"+"Total: "+total +" Euros";
    }

}

