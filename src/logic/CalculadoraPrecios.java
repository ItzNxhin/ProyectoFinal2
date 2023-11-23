package logic;

public class CalculadoraPrecios {
	//Este metodo ademas de el numero de dias debera recibir el precio por noche
	public static double ValorReserva (long dias, HabAbstract hab) {
		double valorNoche = 0;
		if(hab.getNombre().equals("Habitacion Presidencial")){
            		valorNoche = DatosHotel.pPresidencial;
	        }
	        else if(hab.getNombre().equals("Habitacion Premium")){
	        	valorNoche = DatosHotel.pPremium;
	        }
	        else if(hab.getNombre().equals("Habitacion Vip")){
	        	valorNoche = DatosHotel.pVip;
	        }
	        else if(hab.getNombre().equals("Habitacion Lite")) {
	        	valorNoche = DatosHotel.pLite;
	        }
		double precio = dias*valorNoche;
		return precio;
	}
	public static double ValorServicio1 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.sbarra;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
	public static double ValorServicio2 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.sbuffet;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
	public static double ValorServicio3 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.sjacuzzi;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
	
	public static double ValorServicio4 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.slavanderia;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
	
	public static double ValorServicio5 (boolean selected, long dias) {
		double defaultPrice = 0;
		if (selected) {
			double valorServicio = DatosHotel.stour;
			double precio = dias*valorServicio;
			return precio;
		}else {
			return defaultPrice;
		}
	}
}
