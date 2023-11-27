package logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Esta clase representa una reserva.
 */
@SuppressWarnings("serial")
public class Reserva implements Serializable{
	//Variables de instancia necesarias
	private Usuario usuario;
	private HabAbstract habitacion;
	private ArrayList<Services> services = new ArrayList<>();
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double precioReserva;
	private double precioServicesAdd;
	private double total;
	private String TarjetaCre;
	private String cvv;
	private String nombreReal;
	

	//Metodos getter y setter
	//Usuario
	public Usuario getUsaurio() {
		return usuario;
	}
	public void setUsaurio(Usuario usaurio) {
		this.usuario = usaurio;
	}
	
	//Habitacion
	public HabAbstract getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(HabAbstract habitacion) {
		this.habitacion = habitacion;
	}
	
	//Fecha de inicio de la reservación
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	//Fecha final de la reservación
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	//Servicios que se incluyen con la reserva
	public ArrayList<Services> getServices() {
		return this.services;
	}
	public void setServices(ArrayList<Services> services) {
		this.services = services;
	}
	
	
	//Precio de la reserva 
	public double getPrecioReserva() {
		return this.precioReserva;
	}

	public void setPrecioReserva(double precioReserva) {
		this.precioReserva = precioReserva;
	}
	
	//Precio de los servicios que se han añadido
	public double getPrecioServicesAdd() {
		return this.precioServicesAdd;
	}

	public void setPrecioServicesAdd(double precioServicesAdd) {
		this.precioServicesAdd = precioServicesAdd;
	}
	
	
	//Precio total de la reservación
	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	//Numero de tarjeta de credito con la cual se realiza la reservación
	public String getTarjetaCre() {
		return TarjetaCre;
	}
	public void setTarjetaCre(String tarjetaCre) {
		TarjetaCre = tarjetaCre;
	}
	
	//Codigo de seguridad de la tarjeta de crédito
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	//Nombre completo de la persona a cargo de la reservación
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
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
