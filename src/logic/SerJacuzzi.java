package logic;

public class SerJacuzzi extends Services{

    private String nombreSer = "Jacuzzi";
    private double precioSer = DatosHotel.sjacuzzi;

    public String getNombreSer() {
        return this.nombreSer;
    }

    public void setNombreSer(String nombreSer) {
        this.nombreSer = nombreSer;
    }

    public double getPrecioSer() {
        return this.precioSer;
    }

    public void setPrecioSer(double precioSer) {
        this.precioSer = precioSer;
    }
    
}
