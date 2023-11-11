package logic;

import java.time.LocalDate;

public class GestorReservas {
	
	public static void realizarReserva(Usuario usuario, HabAbstract habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
		Reserva reserva = new Reserva(usuario,habitacion,fechaInicio,fechaFin);
		usuario.agregarReserva(reserva);
		
		
	}

}
