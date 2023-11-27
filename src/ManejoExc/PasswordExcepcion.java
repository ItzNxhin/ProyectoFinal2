package ManejoExc;


/**
 * Esta clase maneja la exepcion para cuando la contraseña
 * que se ha ingresado no corresponda con el correo
 */
public class PasswordExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	public PasswordExcepcion() {
        super("Contraseña incorrecta");
    }
}
