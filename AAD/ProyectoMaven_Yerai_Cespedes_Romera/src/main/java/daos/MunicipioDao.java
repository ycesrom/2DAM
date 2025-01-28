
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Municipio;
import entidades.Provincia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author yerai
 */
public class MunicipioDao 
{
    public static void insertarMunicipio(Scanner entrada)    
    {
       
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        
        Municipio nuevoMunicipio = new Municipio();
        Provincia provincia=new Provincia();
        System.out.println("Introduzca el codigo del municipio");
        int cod=entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduzca el nombre del municipio");
        String nombre=entrada.nextLine();
        System.out.println("Introduzca el codigo de la provincia");
        int codProvincia=entrada.nextInt();
        nuevoMunicipio.setId(cod);
        nuevoMunicipio.setNombre(nombre);
        provincia.setCod(codProvincia);
        nuevoMunicipio.setCodProvincia(provincia);// Asegúrate de tener un setter en la clase Provincia
        em.persist(nuevoMunicipio);
    
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    public static void insertarMunicipiosDesdeExcel() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    String rutaArchivo = "C:\\Users\\yerai\\Downloads\\municipios.xlsx";

    try (FileInputStream fis = new FileInputStream(new File(rutaArchivo))) {
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0); // Leer la primera hoja

        em.getTransaction().begin();

        Set<Integer> codigosProvincias = new HashSet<>(
                em.createQuery("SELECT p.cod FROM Provincia p", Integer.class).getResultList()
        );

        Iterator<Row> rowIterator = sheet.iterator();
        int registrosProcesados = 0, registrosDuplicados = 0, registrosInvalidos = 0;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (row == null || row.getLastCellNum() < 2) {
                registrosInvalidos++;
                continue; // Ignorar filas vacías o incompletas
            }

            Municipio municipio = new Municipio();

            Cell cellCodProvincia = row.getCell(0); // Primera columna (Código Provincia)
            Cell cellNombreMunicipio = row.getCell(1); // Segunda columna (Nombre Municipio)

            if (cellCodProvincia != null && cellCodProvincia.getCellType() == CellType.NUMERIC) {
                int codProvincia = (int) cellCodProvincia.getNumericCellValue();

                // Verificar si la provincia existe
                if (!codigosProvincias.contains(codProvincia)) {
                    System.out.println("Provincia no encontrada para el código: " + codProvincia);
                    registrosInvalidos++;
                    continue;
                }

                Provincia provincia = em.find(Provincia.class, codProvincia);
                municipio.setCodProvincia(provincia); // Asociar municipio con la provincia
            } else {
                registrosInvalidos++;
                continue; // Saltar filas con valores inválidos
            }

            if (cellNombreMunicipio != null && cellNombreMunicipio.getCellType() == CellType.STRING) {
                municipio.setNombre(cellNombreMunicipio.getStringCellValue().trim());
            } else {
                registrosInvalidos++;
                continue; // Saltar filas con valores inválidos
            }

            // Insertar el municipio en la base de datos
            em.persist(municipio);
            registrosProcesados++;
        }

        em.getTransaction().commit();
        System.out.println("Registros insertados correctamente desde el archivo Excel.");
        System.out.println("Registros procesados: " + registrosProcesados);
        System.out.println("Registros inválidos: " + registrosInvalidos);

        workbook.close();
    } catch (FileNotFoundException fnfe) {
        System.out.println("Archivo Excel no encontrado: " + rutaArchivo);
        fnfe.printStackTrace();
    } catch (IOException ioe) {
        System.out.println("Error al leer el archivo Excel: " + ioe.getMessage());
        ioe.printStackTrace();
    } catch (Exception e) {
        System.out.println("Error al insertar registros desde Excel: " + e.getMessage());
        e.printStackTrace();
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        em.close();
        emf.close();
    }
}

     
      public static void consultarMunicipiosPorProvincia() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("Ingrese el nombre de la provincia:");
            String nombreProvincia = entrada.nextLine();

            // Query JPQL para obtener municipios
            String jpql = "SELECT m.nombre FROM Municipio m JOIN m.codProvincia p WHERE p.nombre = :nombreProvincia";
            Query query = em.createQuery(jpql);
            query.setParameter("nombreProvincia", nombreProvincia);

            List<String> municipios = query.getResultList();

            if (municipios.isEmpty()) {
                System.out.println("No se encontraron municipios para la provincia: " + nombreProvincia);
            } else {
                System.out.println("Municipios de la provincia " + nombreProvincia + ":");
                for (String municipio : municipios) {
                    System.out.println("- " + municipio);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar municipios: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    
    public static void eliminarMunicipio(String nombre) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    try {
        em.getTransaction().begin();

        // Buscar la provincia por nombre antes de eliminar
        Query query = em.createNamedQuery("Municipio.findByNombre");
        query.setParameter("nombre", nombre);
        Municipio municipio = (Municipio) query.getSingleResult();

        if (municipio != null) {
            em.remove(municipio); // Eliminar la entidad encontrada
            System.out.println("Municipio Eliminado: " + municipio.getNombre());
        } else {
            System.out.println("No se encontró ningun Municipio con el nombre: " + nombre);
        }

        em.getTransaction().commit();
    } catch (Exception e) {
        System.out.println("Error al eliminar el municipio " + e.getMessage());
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        em.close();
        emf.close();
    }
}
    
      public static void mostrarNumeroRegistros() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    try {
        // Consulta JPQL para contar los registros
        Long count = em.createQuery("SELECT COUNT(m) FROM Municipio m", Long.class).getSingleResult();
        System.out.println("Número total de registros: " + count);
    } catch (Exception e) {
        System.out.println("Error al conectar con la base de datos o ejecutar la consulta: " + e.getMessage());
    } finally {
        // Cerrar los recursos
        em.close();
        emf.close();
    }
}
      
       public static void actualizarMunicipio(String nombre)
    {
        Scanner entrada=new Scanner(System.in);
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.ejemplo.hibernate_ProyectoMaven_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
        
        em.getTransaction().begin();
         Query query = em.createNamedQuery("Municipio.findByNombre");
        query.setParameter("nombre", nombre);
        Municipio municipio = (Municipio) query.getSingleResult();
    
        if (municipio != null) {
         System.out.println("Introduzca el nuevo nombre del municipio ");
        String nuevoNombre=entrada.nextLine();    
        municipio.setNombre(nuevoNombre); // Método setter en la entidad Provincia
        em.merge(municipio);
    }
    
    em.getTransaction().commit();
    em.close();
    emf.close();
    }
    
    
}
