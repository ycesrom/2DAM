/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos;

/**
 *
 * @author 2DAM
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo1 h1=new Hilo1();
        Thread h2=new Thread(new Hilo2());
        h1.start();
        h2.start();
        // TODO code application logic here
    }
    
}
