package equipos;

public class Equipo 
{
	private String nombre;
	private String division;
	private String localidad;
	private String provincia;
	
	public Equipo() 
	{
		this.nombre=null;
		this.division=null;
		this.localidad=null;
		this.provincia=null;
		
	}
	
	public Equipo(String nombre, String division, String localidad, String provincia) 
	{
		this.nombre=nombre;
		this.division=division;
		this.localidad=localidad;
		this.provincia=provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
