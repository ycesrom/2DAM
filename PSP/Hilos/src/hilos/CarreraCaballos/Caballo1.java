/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos.CarreraCaballos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2DAM
 */
public class Caballo1 extends Thread 
{

    private final String nombre;
    private static String ganador=null;
    public Caballo1(String nombre)
    {
        this.nombre=nombre;
    }
  
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
       
        int meta=100;
       int metros=0;
       while(metros<=meta)
       {
        int avances=(int)((Math.random()*10)+1);
        metros+=avances;
        
         System.out.println(nombre+" avanzo "+metros);
         
        try {
                Thread.sleep((int) (Math.random() * 800) + 200); // Pausa entre 200 y 1000 ms
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpido.");
                return;
            }
        }
       if (ganador == null) { // Solo el primer hilo que llegue entra aquí
            ganador = nombre;
            System.out.println(nombre + " ha ganado la carrera!");
        } else {
            System.out.println(nombre + " cruzó la meta, pero no ganó.");
        }

       

       
        
         
        
     
            
    }
    
}
