package logic;

import java.io.Serializable;


/**
 * Esta es una clase abstracta que representa una habitación.
 */
public abstract class HabAbstract implements Serializable {
    private static final long serialVersionUID = 1L;
	public abstract String getNombre();
    public abstract int    getPersonas();
    public abstract void   setPersonas(int x);
    public abstract double getPrecio();

    
    
}

