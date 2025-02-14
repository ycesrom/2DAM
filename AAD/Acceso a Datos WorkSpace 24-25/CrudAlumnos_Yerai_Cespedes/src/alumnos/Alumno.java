package alumnos;

/**
 *
 * @author 2DAM
 */
public class Alumno 
{
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
}
