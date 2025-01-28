
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Municipio;
import entidades.Provincia;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author yerai
 */
public class MunicipioDao 
{
    public static void insertarMunicipio(Scanner entrada)    
    {
       
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        
        Municipio nuevoMunicipio = new Municipio();
        Provincia provincia=new Provincia();
        System.out.println("Introduzca el codigo del municipio");
        int cod=entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduzca el nombre del municipio");
        String nombre=entrada.nextLine();
        System.out.println("Introduzca el codigo de la provincia");
        int codProvincia=entrada.nextInt();
        nuevoMunicipio.setId(cod);
        nuevoMunicipio.setNombre(nombre);
        provincia.setCod(codProvincia);
        nuevoMunicipio.setCodProvincia(provincia);// Asegúrate de tener un setter en la clase Provincia
        em.persist(nuevoMunicipio);
    
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    public static void eliminarMunicipio(String nombre) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    try {
        em.getTransaction().begin();

        // Buscar la provincia por nombre antes de eliminar
        Query query = em.createNamedQuery("Municipio.findByNombre");
        query.setParameter("nombre", nombre);
        Municipio municipio = (Municipio) query.getSingleResult();

        if (municipio != null) {
            em.remove(municipio); // Eliminar la entidad encontrada
            System.out.println("Municipio Eliminado: " + municipio.getNombre());
        } else {
            System.out.println("No se encontró ningun Municipio con el nombre: " + nombre);
        }

        em.getTransaction().commit();
    } catch (Exception e) {
        System.out.println("Error al eliminar el municipio " + e.getMessage());
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        em.close();
        emf.close();
    }
}
    
      public static void mostrarNumeroRegistros() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    try {
        // Consulta JPQL para contar los registros
        Long count = em.createQuery("SELECT COUNT(m) FROM Municipio m", Long.class).getSingleResult();
        System.out.println("Número total de registros: " + count);
    } catch (Exception e) {
        System.out.println("Error al conectar con la base de datos o ejecutar la consulta: " + e.getMessage());
    } finally {
        // Cerrar los recursos
        em.close();
        emf.close();
    }
}
    
    
}
