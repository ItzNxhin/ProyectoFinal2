package logic;

public class HabPresidential extends HabAbstract{
    private String nombre = "Habitacion Presidencial";
    private int personas = 7;
    private double precio = DatosHotel.pPresidencial;

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
