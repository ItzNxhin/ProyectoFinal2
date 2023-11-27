package logic;

/**
 * Esta clase representa el servicio de Tour
 */
public class SerTour extends Services {
	private static final long serialVersionUID = 1L;
	private String nombreSer = "Tour";
    private double precioSer = DatosHotel.stour;

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
