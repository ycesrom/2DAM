/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudcompletoprovincia_yerai_cespedes_romera;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 2DAM
 */
public class CRUDCompletoProvincia_Yerai_Cespedes_Romera {
   EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
    public static void menu(Scanner entrada)
    {
        int opcion=0;
        
        do
        {

            System.out.println("1.- Insertar registros desde Excel");
            System.out.println("2.- Insertar registro manualmente");
            System.out.println("3.- Consultar registros por nombre");
            System.out.println("4.- Mostrar todos los registros de la tabla");
            System.out.println("5.- Modificar el nombre de un registro");
            System.out.println("6.- Eliminar un registro ");
            System.out.println("7.- Mostrar el número de registros actual de la tabla");
            System.out.println("8.- Salir ");
            opcion=entrada.nextInt();
            
            switch(opcion)
            {
                case 1->{insertarRegistrosExcel();}
                case 2->{insertarRegistrosManual();}
                case 3->{consultarRegistroNombre();}
                case 4->{mostrarRegistro();}
                case 5->{modificarNombreRegistro();}
                case 6->{eliminarRegistro();}
                case 7->{mostrarNumeroRegistros();}
                default->{}
            }
            
        }while(opcion<8);
    }
    
    public static void insertarRegistrosExcel()
    {EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    }
    
    public static void insertarRegistrosManual()
    {EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    }
    
    public static void consultarRegistroNombre()
    {EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    }
    
    public static void mostrarRegistro()
    {EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    }
    
    public static void modificarNombreRegistro()
    {EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    }
    
    public static void eliminarRegistro()
    {EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    }
    
    public static void mostrarNumeroRegistros()
    {EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    }
}
    
    
