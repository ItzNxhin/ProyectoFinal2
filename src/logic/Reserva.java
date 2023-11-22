package logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Reserva implements Serializable{
	//Variables de instancia necesarias
	private Usuario usuario;
	private HabAbstract habitacion;
	private ArrayList<Services> services = new ArrayList<>();
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	CalculadoraPrecios precios = new CalculadoraPrecios();
	

	//Metodos getter y setter
	public Usuario getUsaurio() {
		return usuario;
	}
	public void setUsaurio(Usuario usaurio) {
		this.usuario = usaurio;
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

	public ArrayList<Services> getServices() {
		return this.services;
	}
	public void setServices(ArrayList<Services> services) {
		this.services = services;
	}
	
	//Metodos constructores
	
	public Reserva() {
	}
	
	public Reserva(Usuario usuario, HabAbstract habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
		this.usuario = usuario;
		this.habitacion = habitacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	


	
}
