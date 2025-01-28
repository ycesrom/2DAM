/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

import static daos.MunicipioDao.actualizarMunicipio;
import static daos.MunicipioDao.consultarMunicipiosPorProvincia;
import static daos.MunicipioDao.eliminarMunicipio;
import static daos.MunicipioDao.insertarMunicipio;
import static daos.MunicipioDao.insertarMunicipiosDesdeExcel;
import static daos.MunicipioDao.mostrarNumeroRegistros;
import java.util.Scanner;


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
        System.out.println("7. - Salir ");
        opcion=entrada.nextInt();
        
        switch(opcion)
        {
            case 1->insertarMunicipiosDesdeExcel();
            case 2-> insertarMunicipio(entrada);
            case 3->consultarMunicipiosPorProvincia();
            case 4-> modificarNombreRegistro();
            case 5->eliminarRegistro();
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
     
     public static void modificarNombreRegistro()
    {
   Scanner entrada=new Scanner(System.in);
   System.out.println("Introduzca el nombre del municipio a actualizar");
   String nombre=entrada.nextLine();
  
   actualizarMunicipio(nombre);

    }
     
    
}
