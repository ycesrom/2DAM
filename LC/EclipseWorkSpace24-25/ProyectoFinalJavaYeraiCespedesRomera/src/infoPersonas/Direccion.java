package infoPersonas;

public class Direccion 
{
	protected String calle;
	protected int numero;
	protected int cp;
	protected String provincia;
	
	public Direccion() 
	{
		
	}
	public Direccion(String calle, int numero, int cp, String provincia) 
	{
		this.calle=calle;
		this.numero=numero;
		this.cp=cp;
		this.provincia=provincia;
	}
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", cp=" + cp + ", provincia=" + provincia + "]";
	}
	public String obtenerCalle() 
	{
		return calle;
	}
	 void establecerCalle(String calle) 
	 {
		this.calle = calle;
	}
	 protected int obtenerNumero() {
		return numero;
	}
	 void establecerNumero(int numero) 
	 {
		this.numero = numero;
	}
	 protected int obtenerCp() 
	 {
		return cp;
	}
	 void establecerCp(int cp)
	 {
		this.cp = cp;
	}
	 protected String obtenerProvincia() 
	 {
		return provincia;
	}
	 void establecerProvincia(String provincia) 
	 {
		this.provincia = provincia;
	}

}
