package logic;

import java.io.Serializable;

public abstract class HabAbstract implements Serializable {
    public abstract String getNombre();
    public abstract int    getPersonas();
    public abstract void   setPersonas(int x);
    public abstract double getPrecio();

    
    
}

