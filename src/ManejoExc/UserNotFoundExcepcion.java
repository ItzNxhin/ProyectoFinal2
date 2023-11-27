package ManejoExc;


/**
 * Esta clase se encarga de manejar la exepcion para cuando 
 * no se encuentre el usuario que se ha ingresado
 */
public class UserNotFoundExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	public UserNotFoundExcepcion() {
        super("Usuario no encontrado");
    }
}
