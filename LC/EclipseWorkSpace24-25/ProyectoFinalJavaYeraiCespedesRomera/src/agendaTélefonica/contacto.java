package agendaTélefonica;

public class contacto implements Comparable<contacto> {
	
	private String nombre;
	private String tfno;
	
	public contacto (String nombre, String tfno) {
		this.nombre=nombre;
		this.tfno=tfno;
	} 
	
	public String obtenerNombre() {
		return nombre;
	}
	public void establecerNombre(String nombre) {
		this.nombre = nombre;
	}
	public String obtenerTelefono() {
		return tfno;
	}
	public void establecerTelefono(String tfno) {
		this.tfno = tfno;
	}
	@Override
	public String toString() {
		return "\n"+nombre+" "+tfno ;
	}
    public int comparadorNombre(contacto contacto1) {
    	return this.nombre.compareToIgnoreCase(contacto1.obtenerNombre());
    }

	public int compareTo(contacto contacto1) {
		// TODO Auto-generated method stub
		return this.tfno.compareTo(contacto1.obtenerTelefono());
	}
	
	

	
}
