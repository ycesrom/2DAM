package com.mycompany.ejercicio5url_yerai_cespedes_romera;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author 2DAM
 */
public class Ejercicio5Url_Yerai_Cespedes_Romera {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Solicitar URL al usuario
        System.out.print("Introduce la URL: ");
        String url = entrada.nextLine();

        // Solicitar el tipo de elemento HTML que desea visualizar
        System.out.print("Introduzca el elemento que quiera visualizar (ej. h1, p, a, etc.): ");
        String elemento = entrada.nextLine();

        // Llamar al método para procesar la URL
        insertarUrl(url, elemento);
    }

    public static void insertarUrl(String url, String elemento) {
        try {
            // Conectar a la URL y obtener el contenido de la página
            Document document = Jsoup.connect(url).get();

            // Seleccionar los elementos especificados por el usuario
            Elements selectedElements = document.select(elemento);

            // Comprobar si se encontraron elementos
            if (selectedElements.isEmpty()) {
                System.out.println("No se encontraron elementos del tipo \"" + elemento + "\" en la página.");
                return;
            }

            // Imprimir los elementos encontrados
            System.out.println("Elementos encontrados (" + elemento + "):");
            int count = 1;
            for (Element element : selectedElements) {
                System.out.println(count + ". " + element.text());
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error al conectar o procesar la página: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("La URL proporcionada no es válida. Por favor, inténtelo de nuevo.");
        }
    }
}
