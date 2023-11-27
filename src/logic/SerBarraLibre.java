package logic;


/**
 * Esta clase representa el servicio de barra libre.
 */
public class SerBarraLibre extends Services {

    private static final long serialVersionUID = 1L;
	private String nombreSer = "Barra";
    private double precioSer = DatosHotel.sbarra;

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
