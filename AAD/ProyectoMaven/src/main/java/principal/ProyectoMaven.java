/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

import static daos.MunicipioDao.eliminarMunicipio;
import static daos.MunicipioDao.insertarMunicipio;
import static daos.MunicipioDao.mostrarNumeroRegistros;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author profesor
 */
public class ProyectoMaven {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
       menu(entrada);
    }
    
    public static void menu(Scanner entrada)
    {
        int opcion=0;
    
        do{
        System.out.println("1.- Insertar municipios desde Excel"); 
        System.out.println("2.- Insertar municipio manualmente");
        System.out.println("3.- Consultar el nombre de los municipios de una provincia dada por teclado su nombre");
        System.out.println("4.- Modificar el nombre de un municipio");
        System.out.println("5.- Eliminar un municipio");
        System.out.println("6.- Mostrar la cantidad total de municipios existentes.");
        opcion=entrada.nextInt();
        
        switch(opcion)
        {
            case 2-> insertarMunicipio(entrada);
            case 5->{eliminarRegistro();}
            case 6-> mostrarNumeroRegistros();
        }
    }while(opcion<7);
    }
     public static void eliminarRegistro()
    {
   Scanner entrada=new Scanner(System.in);
   System.out.println("Introduzca el nombre del municipio a eliminar");
   String nombre=entrada.nextLine();
   eliminarMunicipio(nombre);
    }
     
    
}
