package palindromo;

public class Palindromo {

	public static void main(String args[]) {
		
	
		if (args.length < 0) {
			System.out.println("El argumento no ha sido informado");
		} else {
			String palabra = args[0];
			String palabraAlReves =args[1];
			
			if(palabra.isEmpty()) 
			{
				System.out.println("La cadena esta vacia");
			}
			// recorremos al revés palabra
			

			if (palabra.length()>0 && palabra.equals(palabraAlReves))
				System.out.println("La palabra introducida es palíndromo");
			else if(palabra.length()>0)
				System.out.println("La palabra introducida no es palíndromo");

		}
	}
}