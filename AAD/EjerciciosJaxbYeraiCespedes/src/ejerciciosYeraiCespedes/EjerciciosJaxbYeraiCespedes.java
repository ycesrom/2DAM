package ejerciciosYeraiCespedes;

import generated.EmpleadoType;
import generated.Empresa;
import generated.Persona;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class EjerciciosJaxbYeraiCespedes {
    public static void main(String[] args) {
        // Ejercicio 1
        try {
            // Crear el contexto JAXB basado en la clase raíz generada Persona
            JAXBContext context = JAXBContext.newInstance(Persona.class);
            // Crear el unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Leer el archivo XML
            File file = new File("C:\\Users\\Yerai\\Documents\\2DAM\\AAD\\EjerciciosJaxbYeraiCespedes\\src\\ejerciciosYeraiCespedes\\ejercicio1.xml");
            
            // Hacer el unmarshalling del archivo XML a un objeto Persona
            Persona persona = (Persona) unmarshaller.unmarshal(file);
            
            // Imprimir los datos leídos del XML
            System.out.println("Nombre : "+persona.getNombre());
            System.out.println("Edad : "+persona.getEdad());
            if (persona.getDireccion() != null) {
                System.out.println("Direccion:");
                System.out.println("  Calle: " + persona.getDireccion().getCalle());
                System.out.println("  Numero: " + persona.getDireccion().getNumero());
                System.out.println("  Codigo Postal: " + persona.getDireccion().getCodigoPostal());
            }

            // Mostrar los detalles del contacto
            if (persona.getContacto() != null) {
                System.out.println("Contacto:");
                System.out.println("  Telefono: " + persona.getContacto().getTelefono());
                System.out.println("  Email: " + persona.getContacto().getEmail());
            }
            
            // Puedes imprimir más información si lo deseas
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    
    
        // Ejercicio 2
     try {
            // Crear el contexto JAXB basado en la clase raíz generada Empresa
            JAXBContext context = JAXBContext.newInstance(Empresa.class);
            // Crear el unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Leer el archivo XML
            File file = new File("C:\\Users\\Yerai\\Documents\\2DAM\\AAD\\EjerciciosJaxbYeraiCespedes\\src\\ejerciciosYeraiCespedes\\ejercicio2.xml");
            
            // Hacer el unmarshalling del archivo XML a un objeto Empresa
            Empresa empresa = (Empresa) unmarshaller.unmarshal(file);
            
            // Imprimir los datos leídos del XML
            System.out.println("\nNombre Empresa: "+empresa.getNombreEmpresa());
            for (EmpleadoType empleado : empresa.getEmpleado()) {
                System.out.println("\nEmpleado:");
                System.out.println("  ID: " + empleado.getID());
                System.out.println("  Nombre: " + empleado.getNombre());
                System.out.println("  Edad: " + empleado.getEdad());
                System.out.println("  Genero: " + empleado.getGenero());
                System.out.println("  Activo: " + empleado.isActivo());

                // Imprimir información del departamento del empleado
                if (empleado.getDepartamento() != null) {
                    System.out.println("  Departamento:");
                    System.out.println("    Nombre: " + empleado.getDepartamento().getNombre());
                    System.out.println("    Extension: " + empleado.getDepartamento().getExtension());
                }
            }
            
            // Puedes imprimir más información si lo deseas
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
