package view;

//Librerias
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;

import data.ReservasExistentes;
import logic.DatosHotel;
import logic.FechaReservas;
import logic.HabPresidential;

//Clase reserva
public class Reservas extends JFrame {

	private ArrayList<FechaReservas> fechas = new ArrayList<>();
	private ReservasExistentes archFExistentes = new ReservasExistentes();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public Reservas(Date entrada, Date salida) throws FileNotFoundException {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		fechaInicio = obtenerFechaInicio(entrada);
		fechaFin = obtenerFechaFin(salida);

		/*
		 * Leer todas reservaciones existentes, entonces si en la fecha que se selecciono encuentra una habitacion
		 * Procede a ver que tipo de habitacion es esa
		 * Luego se la resta a la cantidad de habitaciones que haya disponibles
		 */

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
					
				

					//Esto es inutil pero es para pasar a la ventana de la habitacion, donde se genera la reservacion y su respectiva factura
					if (fechita != null && fechaInicio != null && fechaFin != null) {
						
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, complete la información de reserva", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			contentPane.setLayout(null);
			btnReservar.setBounds(160, 207, 111, 23);
			contentPane.add(btnReservar);
		
	}
	 
}
