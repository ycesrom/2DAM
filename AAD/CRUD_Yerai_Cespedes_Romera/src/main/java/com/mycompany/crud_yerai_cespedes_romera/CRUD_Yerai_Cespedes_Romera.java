/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud_yerai_cespedes_romera;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
         
/**
 *
 * @author 2DAM
 */
public class CRUD_Yerai_Cespedes_Romera {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        mostrarMenu(entrada);
    }

    public static void mostrarMenu(Scanner entrada) {
       
        int opcion=0;
        do {
            
            System.out.println("1. Insertar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto por ID");
            System.out.println("5. Salir del programa");

            System.out.println("Introduce una opcion");
             opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> {
                    insertarProducto(entrada);
                }
                case 2 -> {
                    mostrarProductos();
                }
                case 3 -> {
                    actualizarProducto(entrada);
                }
                case 4 -> {
                    eliminarProducto(entrada);
                }
                default -> {
                    System.out.println("Se ha cerrado correctamente");
                }
            }
        } while (opcion<5);
    }

    public static void insertarProducto(Scanner entrada) {
       EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUD_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();

        try {
           entrada.nextLine();
            
            System.out.print("Introduce el nombre del producto: ");
            String nombre = entrada.nextLine();

            System.out.print("Introduce la cantidad del producto:  ");
            int cantidad = entrada.nextInt();

            System.out.print("Introduce el precio del producto: ");
            double precio=entrada.nextDouble();

            
            em.getTransaction().begin();
            Productos producto = new Productos(nombre,precio,cantidad);

            em.persist(producto); 
            em.getTransaction().commit();
            System.out.println("Producto guardado con éxito");
        } catch (Exception e) {
            
            em.getTransaction().rollback();
            System.out.println("Error al guardar en la BBDD: " + e.getMessage());
        } finally {
            
            em.close();
            emf.close();
        }
    }

  public static void mostrarProductos() {
        // Configuración del EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CRUD_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // Iniciar la transacción

            // Consulta JPQL para mostrar todos los productos
            String jpql = "SELECT l FROM Productos l";
            List<Productos> productos = em.createQuery(jpql, Productos.class).getResultList();

            // Verificar y mostrar los resultados
            if (productos.isEmpty()) {
                System.out.println("No hay productos en la base de datos.");
            } else {
                System.out.println("Lista de productos:");
                for (Productos producto : productos) {
                    System.out.println("Id: " + producto.getId() +
                            ", Nombre: " + producto.getNombre() +
                            ", Cantidad: " + producto.getCantidad() +
                            ", Precio: " + producto.getPrecio());
                }
            }

            em.getTransaction().commit(); // Confirmar la transacción
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            System.out.println("Error al mostrar los productos: " + e.getMessage());
        } finally {
            em.close(); // Cerrar EntityManager
            emf.close(); // Cerrar EntityManagerFactory
        }
    }


    public static void actualizarProducto(Scanner entrada) {
       EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUD_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();

        try {
            System.out.print("Introduce el ID del producto que deseas actualizar: ");
            int id = entrada.nextInt();
            entrada.nextLine(); 

            em.getTransaction().begin();

            Productos producto = em.find(Productos.class, id);

            if (producto != null) {
                System.out.println("Producto: ");
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Cantidad: " + producto.getCantidad());
                System.out.println("Precio: " + producto.getPrecio());

                System.out.print("Introduce el nuevo nombre: ");
                String nombre = entrada.nextLine();
                if (!nombre.isEmpty()) {
                    producto.setNombre(nombre);
                }

                System.out.print("Introduce la nueva cantidad: ");
                int cantidad=entrada.nextInt();
                if (cantidad!=0) {
                    producto.setCantidad(cantidad);
                }

                System.out.print("Introduce el nuevo precio: ");
                double precio=entrada.nextDouble();
               entrada.nextLine();
                if (precio != 0) {
                   producto.setPrecio(precio);
                }

                em.getTransaction().commit();
                System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se encontró ningún producto con el ID especificado.");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void eliminarProducto(Scanner entrada) {
         EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUD_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();

        try {
            System.out.print("Introduce el ID del producto que deseas eliminar: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            em.getTransaction().begin();

            Productos producto = em.find(Productos.class, id);

            if (producto != null) {
                em.remove(producto);
                System.out.println("Producto eliminado con éxito.");
            } else {
                System.out.println("Producto no encontrado.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
