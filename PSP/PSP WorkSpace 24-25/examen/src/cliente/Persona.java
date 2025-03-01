/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

/**
 *
 * @author profesor
 */

    
    import java.io.Serializable;
@SuppressWarnings("serial")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
String nombre;
int edad;
public Persona(String nombre, int edad) {
super();
this.nombre = nombre;
this.edad = edad;
}
public Persona() {super();}
public String getNombre() {return nombre;}
public void setNombre(String nombre) {this.nombre = nombre;}
public int getEdad() {return edad;}
public void setEdad(int edad) {this.edad = edad;}
}
    

