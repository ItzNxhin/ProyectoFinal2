package logic;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * Esta clase se encarga de poder almacenar los intervalos de fechas, y que
 * habitacion tiene esa fecha
 */
public class FechaReservas implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDate inicio;
	private LocalDate fin;
	private HabAbstract habitacion;

	
	/**
     * Constructor que inicializa una nueva reserva con una habitación y un intervalo de fechas.
     * @param hab La habitación reservada.
     * @param ini La fecha de inicio de la reserva.
     * @param fin La fecha de fin de la reserva.
     */	
	public FechaReservas(HabAbstract hab, LocalDate ini, LocalDate fin) {
		this.inicio = ini;
		this.fin = fin;
		this.habitacion = hab;
	}
	
	//Constructor por defecto
	public FechaReservas() {
	}

	public HabAbstract getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(HabAbstract habitacion) {
		this.habitacion = habitacion;
	}

	public LocalDate getInicio() {
		return this.inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return this.fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

}
