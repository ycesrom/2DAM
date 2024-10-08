package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GeneradorNotas {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\2DAM\\Downloads\\alumnos.txt";
        String outputFilePath = "C:\\Users\\2DAM\\Downloads\\calificaciones.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath)))
        {
        	 
            String line;
            // Comprobar si la línea no está vacía
            while ((line = br.readLine()) != null) {
                
            	// Saltar líneas en blanco
                if (line.trim().isEmpty()) {
                    continue; 
                }
                // Dividir la línea en partes
                String[] parts = line.split(";");
                // El primer elemento es el nombre
                String nombre = parts[0]; 
                double suma = 0;
                int contador = 0;

                // Sumar las notas
                for (int i = 1; i < parts.length; i++) {
                    // Dividir las notas usando ',' como delimitador
                    String[] notas = parts[i].split(",");
                    for (String nota : notas) {
                        // Parsear cada nota y sumarla, Usar trim para eliminar espacios
                        suma += Double.parseDouble(nota.trim()); 
                        contador++;
                    }
                }

                // Calcular la media
                double media = suma / contador;
                // condicion si la media es igual o mayor que 4,5 y menor que 5 sera la media 5
                int mediaRedondeada = (int) Math.round(media);
                	
                // Escribir el resultado en el archivo de salida
                bw.write(nombre + ": " + mediaRedondeada); // Formatear la media
                bw.newLine();
            }

            System.out.println("Calificaciones calculadas y guardadas en " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error al parsear las notas. Asegúrate de que son números.");
            e.printStackTrace();
        }
    }
}
