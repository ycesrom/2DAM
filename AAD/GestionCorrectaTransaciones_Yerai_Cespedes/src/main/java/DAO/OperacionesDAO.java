/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Usuario;
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.EntityTransaction; 
import javax.persistence.Persistence; 
 
/**
 *
 * @author 2DAM
 */
    //Ejemplo que muestra cómo se crearía un método en un DAO para gestionar una transacción 
//completa con control de errores de manera correcta: 

public class OperacionesDAO { 
 
    private EntityManagerFactory entityManagerFactory; 
 
    public OperacionesDAO() { 
        this.entityManagerFactory = 
Persistence.createEntityManagerFactory("com.mycompany_GestionCorrectaTransaciones_Yerai_Cespedes_jar_1.0-SNAPSHOTPU"); 
    } 
 
    public  void realizarOperaciones() { 
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
        EntityTransaction transaction = entityManager.getTransaction(); 
 
        try { 
            transaction.begin(); 

 
            // 1. Insertar un nuevo Usuario 
            Usuario usuario = new Usuario();
            usuario.setId(1);
            usuario.setNombre("Manolo"); 
            entityManager.persist(usuario); 
 
            // 2. Eliminar un Pedido si existe 
            Pedido pedido = entityManager.find(Pedido.class, 1); 
            if (pedido != null) { 
                entityManager.remove(pedido); 
            } 
 
            // 3. Actualizar un Producto si existe 
            Producto producto = entityManager.find(Producto.class, 1); 
            if (producto != null) { 
                producto.setPrecio((float) 19.99); 
                entityManager.merge(producto); 
            } 
 
            // Confirmar la transacción 
            transaction.commit(); 
        } catch (Exception e) { 
            // Si ocurre un error, hacer rollback 
            if (transaction.isActive()) { 
                transaction.rollback(); 
            } 
            e.printStackTrace(); 
        } finally { 
            entityManager.close(); 
        } 
    } 
 
    public void cerrar() { 
        entityManagerFactory.close(); 
    } 
} 
    
