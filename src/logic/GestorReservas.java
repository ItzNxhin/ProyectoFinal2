package logic;

import java.time.LocalDate;


/**
 * Esta clase gestiona las reservas.
 */
public class GestorReservas {
	
	
    /**
     * Este método realiza una reserva.
     * @param usuario El usuario que realiza la reserva.
     * @param habitacion La habitación reservada.
     * @param fechaInicio La fecha de inicio de la reserva.
     * @param fechaFin La fecha de fin de la reserva.
     */
	public static void realizarReserva(Usuario usuario, HabAbstract habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
		Reserva reserva = new Reserva(usuario,habitacion,fechaInicio,fechaFin);
		usuario.agregarReserva(reserva);
		
		
	}

}
