/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudcompletoprovincia_yerai_cespedes_romera;

import static DAO.ProvinciaDao.actualizarProvincia;
import static DAO.ProvinciaDao.buscarProvinciaPorNombre;
import static DAO.ProvinciaDao.eliminarProvincia;
import static DAO.ProvinciaDao.insertarProvincia;
import static DAO.ProvinciaDao.mostrarProvincias;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 *
 * @author 2DAM
 */
public class CRUDCompletoProvincia_Yerai_Cespedes_Romera {
   EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
   EntityManager em=emf.createEntityManager();
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        menu(entrada);
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
    
   public static void insertarRegistrosExcel() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    try (FileInputStream fis = new FileInputStream(new File("C:\\Users\\2DAM\\Downloads\\cod-prov.xlsx"))) {
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0); // Leer la primera hoja del archivo Excel

        em.getTransaction().begin();

        // Lista para almacenar las provincias
        List<Provincia> provincias = new ArrayList<>();

        // Iterar sobre las filas del archivo Excel (saltamos la cabecera si existe)
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Validar si la fila no es nula
            if (row != null) {
                Provincia provincia = new Provincia();

                // Iterar sobre las celdas de la fila
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);

                    // Validar si la celda no es nula
                    if (cell != null) {
                        switch (i) {
                            case 0: // Primera columna: código de provincia
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    provincia.setCod((int) cell.getNumericCellValue());
                                }
                                break;
                            case 1: // Segunda columna: nombre de la provincia
                                if (cell.getCellType() == CellType.STRING) {
                                    provincia.setNombre(cell.getStringCellValue().trim());
                                }
                                break;
                        }
                    }
                }

                // Agregar la provincia a la lista
                provincias.add(provincia);
            }
        }

        // Ordenar la lista de provincias por el código (cod)
        provincias.sort(Comparator.comparingInt(Provincia::getCod));

        // Insertar las provincias ordenadas en la base de datos
        for (Provincia provincia : provincias) {
            em.persist(provincia);
        }

        em.getTransaction().commit();
        System.out.println("Registros insertados desde el archivo Excel.");
        workbook.close();
    } catch (Exception e) {
        System.out.println("Error al insertar registros desde Excel: " + e.getMessage());
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        em.close();
        emf.close();
    }
}


    
    public static void insertarRegistrosManual()
    {
    Scanner entrada=new Scanner(System.in);
    insertarProvincia(entrada);
   
    }
    
    public static void consultarRegistroNombre()
    {
   System.out.println("Introduzca el nombre de la provincia a buscar");
   Scanner entrada=new Scanner(System.in);
   String nombre=entrada.nextLine();
   buscarProvinciaPorNombre(nombre);
    }
    
    public static void mostrarRegistro()
    {
    mostrarProvincias();
    
    }
    
    public static void modificarNombreRegistro()
    {
   Scanner entrada=new Scanner(System.in);
   System.out.println("Introduzca el nombre de la provincia a actualizar");
   String nombre=entrada.nextLine();
   actualizarProvincia(nombre);

    }
    
    public static void eliminarRegistro()
    {
   Scanner entrada=new Scanner(System.in);
   System.out.println("Introduzca el nombre de la provincia a eliminar");
   String nombre=entrada.nextLine();
   eliminarProvincia(nombre);
    }
    
   public static void mostrarNumeroRegistros() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CRUDCompletoProvincia_Yerai_Cespedes_Romera_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    try {
        // Consulta JPQL para contar los registros
        Long count = em.createQuery("SELECT COUNT(p) FROM Provincia p", Long.class).getSingleResult();
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
    
    
