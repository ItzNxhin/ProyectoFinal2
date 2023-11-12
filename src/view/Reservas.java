package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.ReservasExistentes;
import logic.DatosHotel;
import logic.FechaReservas;
import logic.GestorReservas;
import logic.HabAbstract;
import logic.HabPresidential;
import logic.Usuario;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

//Clase reserva
public class Reservas extends JFrame {

	private ArrayList<FechaReservas> fechas = new ArrayList<>();
	private ReservasExistentes archFExistentes = new ReservasExistentes();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Date entrada;
	private Date salida;
	LocalDate fechaInicio;
	LocalDate fechaFin;

	private int cHabPresidencial= DatosHotel.nPresidencial;
	private int cHabPremium 	= DatosHotel.nPremium;
	private int cHabVip 	= DatosHotel.nVip;
	private int cHabLite 		= DatosHotel.nLite;

    private LocalDate obtenerFechaInicio(Date enDate) {
		if (enDate != null) {
			return Instant.ofEpochMilli(enDate.getTime())
						  .atZone(ZoneId.systemDefault())
						  .toLocalDate();
		} else {
			// Manejo de la situación cuando enDate es null
			return null; 
		}
        // Lógica para obtener la fecha de inicio desde la interfaz
    }

    private LocalDate obtenerFechaFin(Date salDate) {
		if (salDate != null) {
			return Instant.ofEpochMilli(salDate.getTime())
						  .atZone(ZoneId.systemDefault())
						  .toLocalDate();
		} else {
			// Manejo de la situación cuando enDate es null
			return null; 	
		}
        // Lógica para obtener la fecha de fin desde la interfaz
    }

	//Metodo para leer todas las reservaciones del hotel
	public void leer() throws ClassNotFoundException, IOException{
		fechas = new ArrayList<>(archFExistentes.leer());
	}

	/**
	 * En esta clase se hace reservacion, donde se selecciona la habitacion a reservar
	 * Lo que hacemos es leer las reservaciones existentes, y la cantidad de habitaciones por defecto, restarle las que esten ya reservadas
	 * Una vez seleccionada la Habitacion, se pasa a la Ventana Habitacion
	 * @param entrada Este parametro es el check in
	 * @param salida  Este parametro es el check out
	 */
	public Reservas(Date entrada, Date salida) {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		fechaInicio = obtenerFechaInicio(entrada);
		fechaFin = obtenerFechaFin(salida);

		try {
			leer();
			for(FechaReservas revisor : fechas){
			if(fechaInicio.isAfter(revisor.getInicio()) && fechaInicio.isBefore(revisor.getFin())){
				if(revisor.getHabitacion().getNombre().equals("Habitacion Presidencial")){
					cHabPresidencial--;
				}
				else if (revisor.getHabitacion().getNombre().equals("Habitacion Premium")){
					cHabPremium -- ;
				}
				else if (revisor.getHabitacion().getNombre().equals("Habitacion Vip")){
					cHabVip -- ;
				}
				else if (revisor.getHabitacion().getNombre().equals("Habitacion Lite")){
					cHabLite -- ;
				}}
			
			else if(fechaFin.isAfter(revisor.getInicio()) && fechaFin.isBefore(revisor.getFin())){
				if(revisor.getHabitacion().getNombre().equals("Habitacion Presidencial")){
					cHabPresidencial--;
				}
				else if (revisor.getHabitacion().getNombre().equals("Habitacion Premium")){
					cHabPremium -- ;
				}
				else if (revisor.getHabitacion().getNombre().equals("Habitacion Vip")){
					cHabVip -- ;
				}
				else if (revisor.getHabitacion().getNombre().equals("Habitacion Lite")){
					cHabLite -- ;
				}}
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Pruebas en consolas, ignorar y borrar al terminar esto
		System.out.println(cHabPresidencial);
		System.out.println(cHabPremium);
		System.out.println(cHabVip);
		System.out.println(cHabLite);

		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		System.out.println(entrada);
		System.out.println(salida);

		JButton btnReservar = new JButton("Realizar reserva");
			btnReservar.addActionListener(new ActionListener() {
				private Usuario usuarioActual;

				public void actionPerformed(ActionEvent e) {
					// Obtén la habitación seleccionada y las fechas de inicio/fin

					FechaReservas fechita = new FechaReservas(new HabPresidential() , fechaInicio , fechaFin );
					fechas.add(fechita);
					try {
						archFExistentes.guardar(fechas);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					/*  Realiza la reserva
					*if (habitacionSeleccionada != null && fechaInicio != null && fechaFin != null) {
					*	GestorReservas.realizarReserva(usuarioActual, habitacionSeleccionada, fechaInicio, fechaFin);
					*	JOptionPane.showMessageDialog(null, "Reserva realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					*} else {
					*	JOptionPane.showMessageDialog(null, "Por favor, complete la información de reserva", "Error", JOptionPane.ERROR_MESSAGE);
					*}
					*/
				}
			});
			contentPane.setLayout(null);
			btnReservar.setBounds(160, 207, 111, 23);
			contentPane.add(btnReservar);
		
	}
	 
}
