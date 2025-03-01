package alumnos;

/**
 *
 * @author 2DAM
 */
public class Alumno 
{
    public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	private String dni;
    private int edad;
    private String curso;
    private double notaMedia;
    
    public Alumno()
    {
        this.dni=null;
        this.edad=0;
        this.curso=null;
        this.notaMedia=0;
    }
    
    public Alumno(String dni, int edad, String curso, double notaMedia)
    {
        this.dni=dni;
        this.edad=edad;
        this.curso=curso;
        this.notaMedia=notaMedia;
    }
    
    @Override
    public String toString() 
    {
    	return "dni: "+dni+" edad "+edad+" curso "+curso+" notaMedia "+notaMedia;
    			
    }
}
