package ManejoExc;


/**
 * Esta clase maneja la excepcion para cuando un campo se encuentre vacio
 */
public class CampoVacioException extends Exception{
	private static final long serialVersionUID = 1L;

	public CampoVacioException () {
		super("Por favor, digite un usuario o contraseña");
	}
}
