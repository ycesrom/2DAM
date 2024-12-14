package infoPersonas;

public class Persona extends Direccion implements Comparable<Persona>
{
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	Direccion direccion;
	
	
	public Persona(String nombre, String apellidos,String dni,int edad,String calle, int numero, int cp, String provincia) 
	{
		super(calle,numero,cp,provincia);
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.dni=dni;
		this.edad=edad;
		
		
	}
	 @Override
	public String toString() {
		return "Persona: "+ "nombre: " + nombre + ", apellidos: " + apellidos + ", Dni: " + dni + ", edad: " + edad
		+", calle: "+calle+", numero: "+numero+", cp: "+cp+", provincia: "+provincia;
	}
	String obtenerNombre() 
	{
		return nombre;
	}
	 void establecerNombre(String nombre) 
	 {
		this.nombre = nombre;
	}
	 String obtenerApellidos() {
		return apellidos;
	}
	 void establecerApellidos(String apellidos) 
	 {
		this.apellidos = apellidos;
	}
	 String obtenerDni() 
	 {
		return dni;
	}
	 void establecerDni(String dni) 
	 {
		this.dni = dni;
	}
	 int obtenerEdad()
	 {
		return edad;
	}
	 void establecerEdad(int edad) 
	 {
		this.edad = edad;
	}
	@Override
	public int compareTo(Persona persona1) {
		// TODO Auto-generated method stub
		return apellidos.compareTo(persona1.obtenerApellidos());
	}
	
	

}
