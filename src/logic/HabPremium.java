package logic;

public class HabPremium extends HabAbstract{
    private String nombre = "Habitacion Premium";
    private int personas = 5;
    private double precio = DatosHotel.pPremium;

    public String getNombre(){
        return nombre;
    }

    public int getPersonas(){
        return personas;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPersonas(int personas){
        this.personas = personas;
    }
    
}
