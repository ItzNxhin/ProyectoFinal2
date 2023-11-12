package logic;

public class HabPremium extends HabAbstract{
    private String nombre = "Habitacion Premium";
    private int personas = 5;
    private int precio = DatosHotel.nPremium;

    public String getNombre(){
        return nombre;
    }

    public int getPersonas(){
        return personas;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
