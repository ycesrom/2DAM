/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud_yerai_cespedes_romera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 2DAM
 */
public class CRUD_Yerai_Cespedes_Romera {

    public static void main(String[] args) {
EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUD_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
EntityManager em=emf.createEntityManager();
        System.out.println("Hello World!");
    }
    
    
}
