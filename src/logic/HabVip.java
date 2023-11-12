package logic;

public class HabVip extends HabAbstract{
    private String nombre = "Habitacion Lite";
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
    
}
