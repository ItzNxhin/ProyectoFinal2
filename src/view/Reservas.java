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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import logic.*;
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
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	public Reservas(Date entrada, Date salida, Usuario current) throws FileNotFoundException {	

		FechaReservas reservacion = new FechaReservas();

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

		if(cHabPresidencial == 0 || cHabPremium == 0 || cHabVip == 0 || cHabLite == 0){
			JOptionPane.showMessageDialog(null,"Para la fecha seleccionada no tenemos ninguna habitacion disponible, lo sentimos", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		fechaInicio = obtenerFechaInicio(entrada);
		fechaFin = obtenerFechaFin(salida);

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
					if(reservacion.getHabitacion() == null){
						JOptionPane.showMessageDialog(null,"Seleeccione el tipo de habitacion que va a reservar antes de continuar", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(cHabPremium == 0){
						JOptionPane.showMessageDialog(null,"En este momentos, no tenemos habitaciones PREMIUMS disponibles, lo lamentamos, intenta con otra habitacion", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(cHabPresidencial == 0){
						JOptionPane.showMessageDialog(null,"En este momentos, no tenemos habitaciones PRESIDENCIALES disponibles, lo lamentamos, intenta con otra habitacion", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(cHabVip == 0){
						JOptionPane.showMessageDialog(null,"En este momentos, no tenemos habitaciones VIPS disponibles, lo lamentamos, intenta con otra habitacion", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(cHabLite == 0){
						JOptionPane.showMessageDialog(null,"En este momentos, no tenemos habitaciones LITES disponibles, lo lamentamos, intenta con otra habitacion", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						reservacion.setInicio(fechaInicio);
						reservacion.setFin(fechaFin);
						VentanaHabitacion continuar = new VentanaHabitacion(current, reservacion);
						continuar.setVisible(true);
						dispose();
					}
					
				}
			});
			contentPane.setLayout(null);
			btnReservar.setBounds(144, 196, 111, 23);
			contentPane.add(btnReservar);
			
			JRadioButton rdbtnPresidencial = new JRadioButton("Presidencial");
			rdbtnPresidencial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reservacion.setHabitacion(new HabPresidential());
				}
			});
			buttonGroup.add(rdbtnPresidencial);
			rdbtnPresidencial.setBounds(272, 25, 109, 23);
			contentPane.add(rdbtnPresidencial);
			
			JRadioButton rdbtnPremium = new JRadioButton("Premium");
			rdbtnPremium.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reservacion.setHabitacion(new HabPremium());
				}
			});
			buttonGroup.add(rdbtnPremium);
			rdbtnPremium.setBounds(272, 51, 109, 23);
			contentPane.add(rdbtnPremium);
			
			JRadioButton rdbtnVip = new JRadioButton("Vip");
			rdbtnVip.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reservacion.setHabitacion(new HabVip());
				}
			});
			buttonGroup.add(rdbtnVip);
			rdbtnVip.setBounds(272, 77, 109, 23);
			contentPane.add(rdbtnVip);
			
			JRadioButton rdbtnLite = new JRadioButton("Lite");
			rdbtnPresidencial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reservacion.setHabitacion(new HabLite());
				}
			});
			buttonGroup.add(rdbtnLite);
			rdbtnLite.setBounds(272, 103, 109, 23);
			contentPane.add(rdbtnLite);
		
	}
}