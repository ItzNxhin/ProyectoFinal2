package logic;


/**
 * Esta clase representa una habitacion Vip
 */
public class HabVip extends HabAbstract{
    private static final long serialVersionUID = 1L;
	private String nombre = "Habitacion Vip";
    private int personas = 3;
    private double precio = DatosHotel.pVip;

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPersonas(){
        return personas;
    }

    public void setPersonas(int personas){
        this.personas = personas;
    }
    
}
