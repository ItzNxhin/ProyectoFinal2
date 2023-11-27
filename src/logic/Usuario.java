package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase representa a un usuario.
 */
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	// Variables de instancia necesarias
	private ArrayList<Reserva> reservas;
	private String nombreUsuario;
	private String email;
	private String contrasena;
	
	
	//Constructor por defecto
	public Usuario() {
		
	}

    /**
     * Constructor que inicializa un nuevo usuario con nombre, correo electrónico y contraseña.
     * @param nombreUsuario El nombre del usuario.
     * @param email El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     */
	public Usuario(String nombreUsuario, String email, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasena = contrasena;
		this.reservas = new ArrayList<>();
	}

	// Metodos getter
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	//Metodo para las reservas
	public ArrayList<Reserva> getReservas(){
		return reservas;
	}
	
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	//Setters
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}

