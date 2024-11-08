
package relacionejerciciosjaxbyeraicespedes;

import generated.Biblioteca;
import generated.Biblioteca.Libros;
import generated.Biblioteca.Libros.Libro;
import generated.Tienda;
import generated.Tienda.Productos;
import generated.Tienda.Productos.Producto;
import generated.Universidad;
import generated.Universidad.Facultades;
import generated.Universidad.Facultades.Facultad;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class RelacionEjerciciosJAXBYeraiCespedes {

   
    public static void main(String[] args) {
        
        // Ejercicio 1
        try{
            JAXBContext context=JAXBContext.newInstance(Tienda.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            File file = new File("C:\\Users\\yerai\\Documents\\2DAM\\AAD\\RelacionEjerciciosJAXBYeraiCespedes\\src\\relacionejerciciosjaxbyeraicespedes\\tienda.xml");
            Tienda tienda = (Tienda) unmarshaller.unmarshal(file);
            
            System.out.println(tienda.getNombre());
            System.out.println(tienda.getCodigoTienda());
                Productos productos = tienda.getProductos();
            List<Producto> listaProductos = productos.getProducto();
          
            for (Producto producto :   listaProductos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Modelo: " + producto.getModelo());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("-------------------------");
}

        }catch(JAXBException e)
        {e.printStackTrace();
        }
        
        // Ejercicio 2
       
        try{
            JAXBContext context=JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            File file = new File("C:\\Users\\yerai\\Documents\\2DAM\\AAD\\RelacionEjerciciosJAXBYeraiCespedes\\src\\relacionejerciciosjaxbyeraicespedes\\biblioteca.xml");
            Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(file);
            
            System.out.println(biblioteca.getNombre());
            System.out.println(biblioteca.getCodigoBiblioteca());
            Libros libro = biblioteca.getLibros();

            List<Libro> listaLibros = libro.getLibro();
          
            for (Libro libros :   listaLibros) {
            System.out.println("Autor: " + libros.getAutor());
            System.out.println("ISBN: " + libros.getISBN());
            System.out.println("Nombre: " + libros.getNombre());
            System.out.println("Titulo: " + libros.getTitulo());
           System.out.println("Cantidad Disponible: "+libros.getCantidadDisponible());
           System.out.println("Precio: "+ libros.getPrecio());
}
          
       

        }catch(JAXBException e)
        {e.printStackTrace();
        }
        
         // Ejercicio 3
        try{
            JAXBContext context=JAXBContext.newInstance(Universidad.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            File file = new File("C:\\Users\\yerai\\Documents\\2DAM\\AAD\\RelacionEjerciciosJAXBYeraiCespedes\\src\\relacionejerciciosjaxbyeraicespedes\\universidad.xml");
            Universidad universidad = (Universidad) unmarshaller.unmarshal(file);
            
            System.out.println(universidad.getNombre());
            System.out.println(universidad.getCodigoUniversidad());
             Facultades facultades = universidad.getFacultades();

            List<Facultad> listaFacultades = facultades.getFacultad();
          
            for (Facultad facultad :   listaFacultades) 
            {
                System.out.println(facultad.getCodigoFacultad());
                System.out.println(facultad.getNombre());
               

            }
            


        }catch(JAXBException e)
        {e.printStackTrace();
        }
        
        
    
    }
}
