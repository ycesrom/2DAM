package file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoDirectoFichero {

    public static void main(String[] args) throws IOException {
        // Ruta del archivo donde vamos a almacenar los registros
        File archivo = new File("C:\\Users\\yerai\\Desktop\\personas.txt");

        
        

        // Leer y mostrar el registro número 5
        leerRegistro5(archivo);

        // Agregar un nuevo registro
        agregarNuevoRegistro(archivo, "Maria", "Lopez", "Gonzalez", 28);

        // Contar los registros en el archivo
        contarRegistros(archivo);
    }

    

    // Método para leer el registro 5 (índice 4)
    private static void leerRegistro5(File archivo) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "r")) {
        	// El registro 5 está en la posición 4 * 30 (120 bytes)
            raf.seek(4 * 30); 
            // Leer los 30 bytes
            byte[] buffer = new byte[30]; 
            raf.read(buffer); 
            // Convertir los bytes a cadena
            String registro = new String(buffer);  
            System.out.println("Registro 5: " + registro);  
        }
    }

    // Método para agregar un nuevo registro al final del archivo
    private static void agregarNuevoRegistro(File archivo, String nombre, String apellido1, String apellido2, int edad) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            // Ir al final del archivo
            raf.seek(raf.length());

            // Crear el nuevo registro con exactamente 30 bytes
            String nuevoRegistro = String.format("%-10s|%-10s|%-10s|%-5d", nombre, apellido1, apellido2, edad);
            raf.writeBytes(nuevoRegistro);
            System.out.println("Nuevo registro agregado: " + nuevoRegistro);
        }
    }

    // Método para contar la cantidad de registros en el archivo
    private static void contarRegistros(File archivo) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "r")) {
            long tamañoArchivo = raf.length();
            // Cada registro tiene 30 bytes
            int totalRegistros = (int) (tamañoArchivo / 30);  
            System.out.println("Total de registros en el archivo: " + totalRegistros);
        }
    }
}
