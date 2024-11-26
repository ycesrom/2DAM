
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
import generated.Universidad.Facultades.Facultad.Departamentos;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class RelacionEjerciciosJAXBYeraiCespedes {

   
    public static void main(String[] args) {
        
        // Ejercicio 1
        try{
            // Crear el contexto JAXB basado en la clase raíz generada Tienda
            JAXBContext context=JAXBContext.newInstance(Tienda.class);
            // Crear el unmarshaller
            Unmarshaller unmarshaller=context.createUnmarshaller();
            // Leer el archivo XML
            File file = new File("C:\\Users\\2DAM\\Documents\\2DAM\\AAD\\RelacionEjerciciosJAXBYeraiCespedes\\src\\relacionejerciciosjaxbyeraicespedes\\tienda.xml");
            // Hacer el unmarshalling del archivo XML a un objeto Tienda
             Tienda tienda = (Tienda) unmarshaller.unmarshal(file);
            
             // Imprimir los datos de la tienda
            System.out.println("Nombre Tienda: "+tienda.getNombre());
            System.out.println("Codigo Tienda: "+tienda.getCodigoTienda());
                Productos productos = tienda.getProductos();
            List<Producto> listaProductos = productos.getProducto();
          
            // Imprimir los datos de los productos
            for (Producto producto :   listaProductos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Modelo: " + producto.getModelo());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("-------------------------");
}

        // Nos imprimira un error
        }catch(JAXBException e)
        {e.printStackTrace();
        }
        
        // Ejercicio 2
       
        try{
            // Crear el contexto JAXB basado en la clase raíz generada Biblioteca
            JAXBContext context=JAXBContext.newInstance(Biblioteca.class);
            // Crear el unmarshaller
            Unmarshaller unmarshaller=context.createUnmarshaller();
            // Leer el archivo XML
            File file = new File("C:\\Users\\2DAM\\Documents\\2DAM\\AAD\\RelacionEjerciciosJAXBYeraiCespedes\\src\\relacionejerciciosjaxbyeraicespedes\\biblioteca.xml");
            // Hacer el unmarshalling del archivo XML a un objeto Biblioteca
            Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(file);
                    
            // Imprimir los datos de la Biblioteca
            System.out.println("Nombre Biblioteca: "+biblioteca.getNombre());
            System.out.println("Codigo Biblioteca: "+biblioteca.getCodigoBiblioteca());
            Libros libro = biblioteca.getLibros();

            List<Libro> listaLibros = libro.getLibro();
          
            // Imprimir los datos de los libros
            for (Libro libros :   listaLibros) {
            System.out.println("Autor: " + libros.getAutor());
            System.out.println("ISBN: " + libros.getISBN());
            System.out.println("Nombre: " + libros.getNombre());
            System.out.println("Titulo: " + libros.getTitulo());
           System.out.println("Cantidad Disponible: "+libros.getCantidadDisponible());
           System.out.println("Precio: "+ libros.getPrecio());
           System.out.println("-------------------------");

}
          
       

        // Nos imprimira un error
        }catch(JAXBException e)
        {e.printStackTrace();
        }
        
         // Ejercicio 3
        try{
            // Crear el contexto JAXB basado en la clase raíz generada Universidad
            JAXBContext context=JAXBContext.newInstance(Universidad.class);
             // Crear el unmarshaller
            Unmarshaller unmarshaller=context.createUnmarshaller();
             // Leer el archivo XML
            File file = new File("C:\\Users\\2DAM\\Documents\\2DAM\\AAD\\RelacionEjerciciosJAXBYeraiCespedes\\src\\relacionejerciciosjaxbyeraicespedes\\universidad.xml");
             // Hacer el unmarshalling del archivo XML a un objeto Universidad
            Universidad universidad = (Universidad) unmarshaller.unmarshal(file);
            
            // Imprimir los datos de la Universidad
            System.out.println("Nombre Universidad: "+universidad.getNombre());
            System.out.println("Codigo Universidad: "+universidad.getCodigoUniversidad());
             Facultades facultades = universidad.getFacultades();

            List<Facultad> listaFacultades = facultades.getFacultad();
          
            // Imprimir los datos de la facultad
            for (Facultad facultad :   listaFacultades) 
            {
                System.out.println("Codigo Facultad: "+facultad.getCodigoFacultad());
                System.out.println("Nombre Facultad: "+facultad.getNombre());
                Universidad.Facultades.Facultad.Departamentos departamentos = facultad.getDepartamentos();
                List<Universidad.Facultades.Facultad.Departamentos.Departamento> listaDepartamentos = departamentos.getDepartamento();
    
             // Imprimir los datos de los departamentos
             for (Universidad.Facultades.Facultad.Departamentos.Departamento departamento : listaDepartamentos) 
             {
                 System.out.println("Codigo Departameto: "+departamento.getCodigoDepartamento());
                 System.out.println("Nombre Departamento: "+departamento.getNombre());
        
        
                System.out.println("-------------------------");
                 Universidad.Facultades.Facultad.Departamentos.Departamento.Cursos cursos= departamento.getCursos();
                 List<Departamentos.Departamento.Cursos.Curso> listaCurso = cursos.getCurso();
                 
             // Imprimir los datos de los cursos
             for(Departamentos.Departamento.Cursos.Curso curso:listaCurso)
             {
                System.out.println("Codigo Curso: "+curso.getCodigoCurso());
                System.out.println("Creditos del Curso: "+curso.getCreditos());
                System.out.println("Nombre del Curso: "+curso.getNombre());
                 
               }  
                         System.out.println("-------------------------");

             Universidad.Facultades.Facultad.Departamentos.Departamento.Estudiantes estudiantes = departamento.getEstudiantes(); 
            List<Departamentos.Departamento.Estudiantes.Estudiante> listaEstudiante = estudiantes.getEstudiante();
          
            // Imprimir los datos de los estudiantes    
            for (Departamentos.Departamento.Estudiantes.Estudiante estudiante : listaEstudiante) 
            {
            System.out.println("Cursos Inscritos "+estudiante.getCursosInscritos().getCodigoCurso());
            System.out.println("Identificacion Estudiante: "+estudiante.getIdentificacion());
            System.out.println("Nombre Estudiante "+estudiante.getNombre());
            }
                         System.out.println("-------------------------");

                
           
            Universidad.Facultades.Facultad.Departamentos.Departamento.Profesores profesores=departamento.getProfesores();
               
            List<Departamentos.Departamento.Profesores.Profesor> listaProfesor=profesores.getProfesor();
           
            
            // Imprimir los datos de los profesores
            for(Departamentos.Departamento.Profesores.Profesor profesor:listaProfesor)
            {
                System.out.println("Cursos Profesor: "+profesor.getCursos().getCodigoCurso());
                System.out.println("Identificacion del profesor: "+profesor.getIdentificacion());
                System.out.println("Nombre Profesor: "+profesor.getNombre());
           
                
            }
            } 
            
            }
        // Nos imprimira un error
        }catch(JAXBException e)
        {e.printStackTrace();
        }
        
        
    
}   
}
 