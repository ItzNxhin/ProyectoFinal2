package logic;

public class HabLite extends HabAbstract{
    private String nombre = "Habitacion Lite";
    private int personas = 2;
    private double precio = DatosHotel.pLite;

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
