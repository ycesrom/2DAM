package jni;

public class Jni {
	
	static {
        System.loadLibrary("jni_Jni"); // Cargar la biblioteca nativa sin la extensión
    }
	

	    public native int sum(int a, int b);

	    public native int multiply(int a, int b);
	    
	    public static void main(String [] args) 
	    {
	    	new Jni().sum(10, 20);
	    }
	       
}
