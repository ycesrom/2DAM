package anagrama;

import java.util.Arrays;

public class Anagrama {

    public static void main(String args[]) {

        // Verificamos si se han pasado los dos argumentos
        if (args.length < 2) {
            System.out.println("Se deben ingresar dos cadenas.");
        } else {
            String cadena1 = args[0]; // Primer argumento
            String cadena2 = args[1]; // Segundo argumento

            // Verificamos si alguna de las cadenas está vacía
            if (cadena1.isEmpty() || cadena2.isEmpty()) {
                System.out.println("Una de las cadenas está vacía");
            } else {
                // Comprobamos si las cadenas son anagramas
                if (sonAnagramas(cadena1, cadena2)) {
                    System.out.println("Las cadenas son anagramas");
                } else {
                    System.out.println("Las cadenas no son anagramas");
                }
            }
        }
    }

    // Método para verificar si dos cadenas son anagramas
    public static boolean sonAnagramas(String cadena1, String cadena2) {
        // Si las cadenas tienen diferente longitud, no pueden ser anagramas
        if (cadena1.length() != cadena2.length()) {
            return false;
        }

        // Convertir las cadenas a arreglos de caracteres, ordenarlos y compararlos
        char[] arreglo1 = cadena1.toCharArray();
        char[] arreglo2 = cadena2.toCharArray();

        Arrays.sort(arreglo1);
        Arrays.sort(arreglo2);

        return Arrays.equals(arreglo1, arreglo2);
    }
}
