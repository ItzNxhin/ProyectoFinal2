package logic;


/**
 * Esta clase representa el servicio de lavanderia
 */
public class SerLavanderia extends Services {

    private static final long serialVersionUID = 1L;
	private String nombreSer = "Lavanderia";
    private double precioSer = DatosHotel.slavanderia;

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
