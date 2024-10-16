package file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FileFilter implements FilenameFilter {  // Class name starts with uppercase

    private String extension;

    // Constructor to initialize the extension
    public FileFilter(String extension) {
        this.extension = extension.toLowerCase();  // Convert to lowercase for case-insensitive comparison
    }

    @Override
    public boolean accept(File dir, String name) {
        // Filtrar solo archivos que terminen con la extensión especificada (ignorando mayúsculas/minúsculas)
        return name.toLowerCase().endsWith(extension);
    }

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Introduzca la ruta de los archivos:");
            String ruta = entrada.nextLine();

            // Directorio que quieres filtrar
            File directorio = new File(ruta);

            if (!directorio.isDirectory()) {
                System.out.println("La ruta especificada no es un directorio válido.");
                return;
            }

            System.out.println("Introduzca la extensión de los archivos (ejemplo: .exe):");
            String extension = entrada.nextLine();

            // Crear instancia del filtro con la extensión especificada
            FilenameFilter filtro = new FileFilter(extension);  // Use the correct class name

            // Obtener lista de archivos filtrados
            String[] archivos = directorio.list(filtro);

            // Mostrar los archivos filtrados
            if (archivos != null && archivos.length > 0) {
                System.out.println("Archivos encontrados con la extensión " + extension + ":");
                for (String archivo : archivos) {
                    System.out.println(archivo);
                }
            } else {
                System.out.println("No se encontraron archivos con la extensión " + extension);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
