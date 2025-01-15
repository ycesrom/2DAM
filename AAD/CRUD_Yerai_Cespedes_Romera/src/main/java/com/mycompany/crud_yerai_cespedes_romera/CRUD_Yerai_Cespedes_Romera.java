/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud_yerai_cespedes_romera;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 2DAM
 */
public class CRUD_Yerai_Cespedes_Romera {

    public static void main(String[] args) 
    {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUD_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
    EntityManager em=emf.createEntityManager();
        
    }
    
    public static void menu()
    {
        int opcion=0;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduzca una opcion");
        opcion=entrada.nextInt();
        switch(opcion)
        {
           
            
        }
    }
    
    public static void añadirProducto()
    {
    }
    
    public static void eliminarProducto()
    {
    }
    
    public static void actualizarLibro()
    {
    }
    
    public static void mostrarProductos()
    {
    }
    
    
}
