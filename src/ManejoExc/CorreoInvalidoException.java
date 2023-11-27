package ManejoExc;

/**
 * Esta clase maneja la exepcion para cuando el correo que se digite
 * no cumpla con los parametros establecidos
 */
public class CorreoInvalidoException extends Exception{
	 private static final long serialVersionUID = 1L;

	public CorreoInvalidoException() {
	        super("El correo que ha digitado no es valido");
	    }
}
