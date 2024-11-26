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
    private String nombre;
    private int metros=0;
    public Caballo1(String nombre)
    {
        this.nombre=nombre;
    }
    public void run(String nombre)
    {
        int meta=100;
       
        System.out.println();
       while(metros<=meta)
       {
        int avances=(int)((Math.random()*10)+1);
        metros+=avances;
        
         System.out.print(nombre+" avanzo "+metros);

        
       
        }
            
    }
    
}
