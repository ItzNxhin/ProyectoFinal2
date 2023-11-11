package logic;

import java.time.LocalDate;

public class Reserva {
	//Variables de instancia necesarias
	private Usuario usaurio;
	private HabAbstract habitacion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	

	//Metodos getter y setter
	public Usuario getUsaurio() {
		return usaurio;
	}
	public void setUsaurio(Usuario usaurio) {
		this.usaurio = usaurio;
	}
	public HabAbstract getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(HabAbstract habitacion) {
		this.habitacion = habitacion;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	//Metodos constructores
	
	public Reserva() {
		
	}
	
	public Reserva(Usuario usuario, HabAbstract habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
		this.usaurio = usuario;
		this.habitacion = habitacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		
	}

	
}
