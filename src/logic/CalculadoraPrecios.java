package logic;

/**
 * Esta clase calcula los precios de las reservas y servicios.
 */
public class CalculadoraPrecios {
	
	
    /**
     * Este método calcula el valor de la reserva en función del número de días y el tipo de habitación.
     * @param dias El número de días de la reserva.
     * @param hab La habitación reservada.
     * @return El precio de la reserva.
     */
	public static double ValorReserva(long dias, HabAbstract hab) {
		double valorNoche = 0;
		if (hab.getNombre().equals("Habitacion Presidencial")) {
			valorNoche = DatosHotel.pPresidencial;
		} else if (hab.getNombre().equals("Habitacion Premium")) {
			valorNoche = DatosHotel.pPremium;
		} else if (hab.getNombre().equals("Habitacion Vip")) {
			valorNoche = DatosHotel.pVip;
		} else if (hab.getNombre().equals("Habitacion Lite")) {
			valorNoche = DatosHotel.pLite;
		}
		double precio = dias * valorNoche;
		return precio;
	}
	
    /**
     * Los siguientes métodos calculan el valor del servicio de cada uno de los servicios en función de si está seleccionado y el número de días.
     * @param selected Si el servicio está seleccionado.
     * @param dias El número de días del servicio.
     * @return El precio del servicio.
     */

	public static double ValorServicio1(boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.sbarra;
			double precio = dias * valorServicio;
			return precio;
		} else {
			return defaultPrice;
		}
	}

	public static double ValorServicio2(boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.sbuffet;
			double precio = dias * valorServicio;
			return precio;
		} else {
			return defaultPrice;
		}
	}

	public static double ValorServicio3(boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.sjacuzzi;
			double precio = dias * valorServicio;
			return precio;
		} else {
			return defaultPrice;
		}
	}

	public static double ValorServicio4(boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.slavanderia;
			double precio = dias * valorServicio;
			return precio;
		} else {
			return defaultPrice;
		}
	}

	public static double ValorServicio5(boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.stour;
			double precio = dias * valorServicio;
			return precio;
		} else {
			return defaultPrice;
		}
	}
}
