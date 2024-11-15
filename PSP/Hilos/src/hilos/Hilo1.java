/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

/**
 *
 * @author 2DAM
 */
public class Hilo1 extends Thread {
    
    public void run()
    {
        for(int i=0; i<=5; i++)
        {
            System.out.println("Proceso 1");
        }
    }
    
}
