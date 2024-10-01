package jni;

public class Jni {
    // Declaramos el método nativo
    public native int sumar(int a, int b);

    // Cargar la librería nativa (libsumador)
    static {
        System.loadLibrary("sumador");
    }

    public static void main(String[] args) {
        Jni sumador = new Jni();
        int resultado = sumador.sumar(5, 3);
        System.out.println("Resultado de la suma: " + resultado);
    }
}
