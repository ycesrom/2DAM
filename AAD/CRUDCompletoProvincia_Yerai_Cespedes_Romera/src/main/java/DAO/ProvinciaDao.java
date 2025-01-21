/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.crudcompletoprovincia_yerai_cespedes_romera.Provincia;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 2DAM
 */
public class ProvinciaDao 
{
    public static void insertarProvincia(Scanner entrada)    
    {
       
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        
        Provincia nuevaProvincia = new Provincia();
        System.out.println("Introduzca el codigo de la provincia");
        int cod=entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduzca el nombre de la provincia");
        String nombre=entrada.nextLine();
        nuevaProvincia.setCod(cod);
        nuevaProvincia.setNombre(nombre); // Asegúrate de tener un setter en la clase Provincia
        em.persist(nuevaProvincia);
    
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    public static void mostrarProvincias()
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
       
        
        List<Provincia> provincias=em.createNamedQuery("Provincia.findAll")
                .getResultList();
        for(Provincia provincia:provincias)
        {
            System.out.println(provincia);
        }
       
        em.close();
        emf.close();
    }
    
   public static void eliminarProvincia(String nombre) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    try {
        em.getTransaction().begin();

        // Buscar la provincia por nombre antes de eliminar
        Query query = em.createNamedQuery("Provincia.findByNombre");
        query.setParameter("nombre", nombre);
        Provincia provincia = (Provincia) query.getSingleResult();

        if (provincia != null) {
            em.remove(provincia); // Eliminar la entidad encontrada
            System.out.println("Provincia eliminada: " + provincia.getNombre());
        } else {
            System.out.println("No se encontró ninguna provincia con el nombre: " + nombre);
        }

        em.getTransaction().commit();
    } catch (Exception e) {
        System.out.println("Error al eliminar la provincia: " + e.getMessage());
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        em.close();
        emf.close();
    }
}

    
    public static void actualizarProvincia(String nombre)
    {
        Scanner entrada=new Scanner(System.in);
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
        em.getTransaction().begin();
         Query query = em.createNamedQuery("Provincia.findByNombre");
        query.setParameter("nombre", nombre);
        Provincia provincia = (Provincia) query.getSingleResult();
    
        if (provincia != null) {
        String nuevoNombre=entrada.nextLine();    
        provincia.setNombre(nuevoNombre); // Método setter en la entidad Provincia
        em.merge(provincia);
    }
    
    em.getTransaction().commit();
    em.close();
    emf.close();
    }
    
    public static void buscarProvinciaPorNombre(String nombre)
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
       Query query = em.createNamedQuery("Provincia.findByNombre");
        query.setParameter("nombre", nombre);
        List<Provincia> provincias = query.getResultList();
    
    for (Provincia provincia : provincias) {
        System.out.println(provincia);
    }
    
    em.close();
    emf.close();
    }
    
}
