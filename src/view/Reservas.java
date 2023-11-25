package view;

//Librerias
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.ImageIcon;

import logic.*;

//Clase reserva
public class Reservas extends JFrame {

	private ArrayList<Reserva> fechas = new ArrayList<>();
	private ReservasExistentes archFExistentes = new ReservasExistentes();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	LocalDate fechaInicio;
	LocalDate fechaFin;

	private int cHabPresidencial = DatosHotel.nPresidencial;
	private int cHabPremium = DatosHotel.nPremium;
	private int cHabVip = DatosHotel.nVip;
	private int cHabLite = DatosHotel.nLite;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private LocalDate obtenerFechaInicio(Date enDate) {
		if (enDate != null) {
			return Instant.ofEpochMilli(enDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		} else {
			// Manejo de la situación cuando enDate es null
			return null;
		}
		// Lógica para obtener la fecha de inicio desde la interfaz
	}

	private LocalDate obtenerFechaFin(Date salDate) {
		if (salDate != null) {
			return Instant.ofEpochMilli(salDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		} else {
			// Manejo de la situación cuando enDate es null
			return null;
		}
		// Lógica para obtener la fecha de fin desde la interfaz
	}

	// Metodo para leer todas las reservaciones del hotel
	public void leer() throws ClassNotFoundException, IOException {
		fechas = new ArrayList<>(archFExistentes.leer());
	}

	/**
	 * En esta clase se hace reservacion, donde se selecciona la habitacion a
	 * reservar Lo que hacemos es leer las reservaciones existentes, y la cantidad
	 * de habitaciones por defecto, restarle las que esten ya reservadas Una vez
	 * seleccionada la Habitacion, se pasa a la Ventana Habitacion
	 * 
	 * @param entrada Este parametro es el check in
	 * @param salida  Este parametro es el check out
	 */
	public Reservas(Date entrada, Date salida, Usuario current) throws FileNotFoundException {

		Reserva reservacion = new Reserva();

		// Convierte las fechas traidas de la ventana Fechas de Date a Local date
		fechaInicio = obtenerFechaInicio(entrada);
		fechaFin = obtenerFechaFin(salida);

		/*
		 * Leer todas reservaciones existentes, entonces si en la fecha que se
		 * selecciono encuentra una habitacion Procede a ver que tipo de habitacion es
		 * esa Luego se la resta a la cantidad de habitaciones que haya disponibles
		 */
		try {
			leer();
			for (Reserva revisor : fechas) {
				if (fechaInicio.isAfter(revisor.getFechaInicio()) && fechaInicio.isBefore(revisor.getFechaFin()) ) {
					if (revisor.getHabitacion().getNombre().equals("Habitacion Presidencial")) {
						cHabPresidencial--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Premium")) {
						cHabPremium--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Vip")) {
						cHabVip--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Lite")) {
						cHabLite--;
					}
				}

				else if (fechaFin.isAfter(revisor.getFechaInicio()) && fechaFin.isBefore(revisor.getFechaFin())) {
					if (revisor.getHabitacion().getNombre().equals("Habitacion Presidencial")) {
						cHabPresidencial--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Premium")) {
						cHabPremium--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Vip")) {
						cHabVip--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Lite")) {
						cHabLite--;
					}
				}

				else if (fechaInicio.isEqual(revisor.getFechaInicio()) || fechaInicio.isEqual(revisor.getFechaFin())) {
					if (revisor.getHabitacion().getNombre().equals("Habitacion Presidencial")) {
						cHabPresidencial--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Premium")) {
						cHabPremium--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Vip")) {
						cHabVip--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Lite")) {
						cHabLite--;
					}
				}

				else if (fechaFin.isEqual(revisor.getFechaInicio()) || fechaFin.isEqual(revisor.getFechaFin())) {
					if (revisor.getHabitacion().getNombre().equals("Habitacion Presidencial")) {
						cHabPresidencial--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Premium")) {
						cHabPremium--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Vip")) {
						cHabVip--;
					} else if (revisor.getHabitacion().getNombre().equals("Habitacion Lite")) {
						cHabLite--;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (cHabPresidencial == 0 && cHabPremium == 0 && cHabVip == 0 && cHabLite == 0) {
			JOptionPane.showMessageDialog(null,
					"Para la fecha seleccionada no tenemos ninguna habitacion disponible, lo sentimos", "Habitacion",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPre = new JLabel("");
		lblPre.setBounds(616, 217, 615, 407);

		JRadioButton rdbtnPresidencial = new JRadioButton("");
		rdbtnPresidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservacion.setHabitacion(new HabPresidential());
				ImageIcon prev = new ImageIcon(Factura.class.getResource("/img/habPresidencial.jpg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal1 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal1);
				contentPane.add(lblPre);	
				getLayeredPane().add(lblPre, Integer.valueOf(1));
			}
		});
		rdbtnPresidencial.setOpaque(false);
		buttonGroup.add(rdbtnPresidencial);
		rdbtnPresidencial.setBounds(118, 314, 23, 23);
		contentPane.add(rdbtnPresidencial);

		JRadioButton rdbtnPremium = new JRadioButton("");
		rdbtnPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservacion.setHabitacion(new HabPremium());
				ImageIcon prev = new ImageIcon(Factura.class.getResource("/img/habPremium.jpg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal2 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal2);
				contentPane.add(lblPre);
				getLayeredPane().add(lblPre, Integer.valueOf(1));	
			}
		});
		buttonGroup.add(rdbtnPremium);
		rdbtnPremium.setOpaque(false);
		rdbtnPremium.setBounds(118, 377, 23, 23);
		contentPane.add(rdbtnPremium);

		JRadioButton rdbtnVip = new JRadioButton("");
		rdbtnVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservacion.setHabitacion(new HabVip());
				ImageIcon prev = new ImageIcon(Factura.class.getResource("/img/habVip.jpg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal3 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal3);
				contentPane.add(lblPre);
				getLayeredPane().add(lblPre, Integer.valueOf(1));	
			}
		});
		buttonGroup.add(rdbtnVip);
		rdbtnVip.setOpaque(false);
		rdbtnVip.setBounds(118, 441, 23, 23);
		contentPane.add(rdbtnVip);

		JRadioButton rdbtnLite = new JRadioButton("");
		rdbtnLite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservacion.setHabitacion(new HabLite());
				ImageIcon prev = new ImageIcon(Factura.class.getResource("/img/habLite.jpeg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal4 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal4);
				contentPane.add(lblPre);
				getLayeredPane().add(lblPre, Integer.valueOf(1));	
			}
		});
		rdbtnLite.setOpaque(false);
		buttonGroup.add(rdbtnLite);
		rdbtnLite.setBounds(118, 503, 23, 23);
		contentPane.add(rdbtnLite);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setFont(new Font("Arvo", Font.BOLD, 18));
		btnCancelar.setBackground(new Color(255, 205, 8));
		btnCancelar.setBounds(118, 570, 160, 54);
		contentPane.add(btnCancelar);

		JButton btnPrueba = new JButton("SIGUIENTE");
		btnPrueba.setForeground(new Color(0, 0, 0));
		btnPrueba.setBackground(new Color(255, 205, 8));
		btnPrueba.setFont(new Font("Arvo", Font.BOLD, 18));
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Obtén la habitación seleccionada y las fechas de inicio/fin
				if (reservacion.getHabitacion() == null) {
					JOptionPane.showMessageDialog(null,
							"Seleeccione el tipo de habitacion que va a reservar antes de continuar", "Habitacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (reservacion.getHabitacion().getNombre().equals("Habitacion Premium") && cHabPremium == 0) {
					JOptionPane.showMessageDialog(null,
							"En este momentos, no tenemos habitaciones PREMIUMS disponibles, lo lamentamos, intenta con otra habitacion",
							"Habitacion", JOptionPane.INFORMATION_MESSAGE);
				} else if (reservacion .getHabitacion().getNombre().equals("Habitacion Presidencial") && cHabPresidencial == 0) {
					JOptionPane.showMessageDialog(null,
							"En este momentos, no tenemos habitaciones PRESIDENCIALES disponibles, lo lamentamos, intenta con otra habitacion",
							"Habitacion", JOptionPane.INFORMATION_MESSAGE);
				} else if ( reservacion.getHabitacion().getNombre().equals("Habitacion Vip") && cHabVip == 0) {
					JOptionPane.showMessageDialog(null,
							"En este momentos, no tenemos habitaciones VIPS disponibles, lo lamentamos, intenta con otra habitacion",
							"Habitacion", JOptionPane.INFORMATION_MESSAGE);
				} else if (reservacion.getHabitacion().getNombre().equals("Habitacion Lite") && cHabLite == 0) {
					JOptionPane.showMessageDialog(null,
							"En este momentos, no tenemos habitaciones LITES disponibles, lo lamentamos, intenta con otra habitacion",
							"Habitacion", JOptionPane.INFORMATION_MESSAGE);
				} else {
					reservacion.setFechaInicio(fechaInicio);
					reservacion.setFechaFin(fechaFin);
					VentanaHabitacion continuar = new VentanaHabitacion(current, reservacion);
					continuar.setVisible(true);
					dispose();
				}
				
			}
		});
		btnPrueba.setBounds(334, 570, 160, 54);
		contentPane.add(btnPrueba);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1264, 681);
		ImageIcon factura = new ImageIcon(Factura.class.getResource("/img/habitacion.png"));
        Image facturaIcon = factura.getImage();
        Image facturaScaled = facturaIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
       	ImageIcon imgFinal = new ImageIcon(facturaScaled);
        lblNewLabel.setIcon(imgFinal);
		contentPane.add(lblNewLabel);	
	}
}