package infoFacturas;

import java.util.ArrayList;

import infoPersonas.Persona;
import productosTienda.Productos;

public class Factura {
    private static int contador = 1;
    private int idFactura;
    private String nombreEmpresa;
    private String cif;
    private Persona cliente;
    private ArrayList<Productos> productos;// Almacena un solo cliente

    // Constructor que recibe un cliente específico
    public Factura(String nombreEmpresa, String cif, Persona cliente,ArrayList<Productos> productos) {
        this.idFactura = contador++;
        this.nombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.cliente = cliente;
        this.productos=productos;
    }

    public int obtenerIdFactura() {
        return idFactura;
    }

    public String obtenerNombreEmpresa() {
        return nombreEmpresa;
    }

    public String obtenerCif() {
        return cif;
    }

    public Persona obtenerCliente() {
        return cliente;
    }
    
    public ArrayList<Productos> obtenerProductos() 
    {
    	return productos;
    }

    @Override
    public String toString() {
        return "Factura ID: " + idFactura + "\n" +
               "Empresa: " + nombreEmpresa + "\n" +
               "CIF: " + cif + "\n" +
               "Cliente: " + (cliente != null ? cliente.obtenerNombre() : "Sin Cliente") + "\n"+
               "Productos: "+obtenerProductos();
    }
}

