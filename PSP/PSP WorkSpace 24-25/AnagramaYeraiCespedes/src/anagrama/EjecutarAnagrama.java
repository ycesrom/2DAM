package anagrama;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class EjecutarAnagrama {

    // Método para lanzar el proceso y ejecutar la verificación
    public void lanzarClase() throws IOException {
        Process pb;
        try {
            // Leer las cadenas desde el archivo de entrada
            File inputFile = new File("C:\\Users\\2DAM\\Desktop\\entradas.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String cadena1 = reader.readLine(); // Leer la primera cadena
            String cadena2 = reader.readLine(); // Leer la segunda cadena
            reader.close();

            // Ejecutar el proceso que verifica los anagramas
            pb = new ProcessBuilder("java", "-cp", "C:\\Users\\2DAM\\Documents\\2DAM\\PSP\\PSP WorkSpace 24-25\\AnagramaYeraiCespedes\\bin",
                    "anagrama.Anagrama", cadena1, cadena2).start();

            // Capturar la salida del proceso
            InputStream is = pb.getInputStream(); // stdout del hijo

            // Mostrar la salida en consola
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        } catch (IOException e) {
            // Si ocurre un error, escribirlo en el archivo de errores
            escribirError("Error al ejecutar el proceso: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para escribir los errores en un archivo de log
    private void escribirError(String mensaje) {
        File errorFile = new File("C:\\Users\\2DAM\\Desktop\\errores.txt");
        try (FileWriter errorWriter = new FileWriter(errorFile, true)) { // Modo añadir
            errorWriter.write(mensaje + "\n");
        } catch (IOException ioException) {
            ioException.printStackTrace(); // Manejar excepción de escritura
        }
    }

    // Método principal para ejecutar la clase
    public static void main(String[] args) throws IOException {
        EjecutarAnagrama ejecutar = new EjecutarAnagrama();
        ejecutar.lanzarClase();
    }
}

