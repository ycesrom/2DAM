/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.crudcompletoprovincia_yerai_cespedes_romera.Provincia;
import java.util.List;
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
    public static void insertarProvincia(String nombre)    
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
        
    }
    
    public static void mostrarProvincias()
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
        em.getTransaction().begin();
        
        List<Provincia> provincias=em.createNamedQuery("Provincia.findAll")
                .getResultList();
        for(Provincia provincia:provincias)
        {
            System.out.println(provincia);
        }
       
       
    }
    
    public static void eliminarProvincia(String nombre)
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
        em.getTransaction().begin();
        
        List<Provincia> provincias=em.createNamedQuery("Provincia.deleteByNombre")
                .getResultList();
        
        
    }
    
    public static void actualizarProvincia(String nombre)
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
        em.getTransaction().begin();
    }
    
    public static void buscarProvinciaPorNombre(String nombre)
    {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
        em.getTransaction().begin();
    }
    
}
