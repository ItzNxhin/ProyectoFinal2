package logic;

import java.io.Serializable;

/**
 * Esta es una clase abstracta que representa un servicio.
 */
public abstract class Services implements Serializable{
    private static final long serialVersionUID = 1L;
	public abstract String getNombreSer();
    public abstract double getPrecioSer();
     
}
