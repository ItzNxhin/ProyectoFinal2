package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;

import logic.*;

/**
 * Esta clase se encarga de terminar la reservación Donde se eligen los
 * servicios que se quieran añadir o quitar Una vez el usuario termine detalles,
 * se le confirma y se genera factura Y por último, se guarda en el archivo de
 * reservaciones
 */
public class VentanaHabitacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean servicio1Seleccionado = false;
	private boolean servicio2Seleccionado = false;
	private boolean servicio3Seleccionado = false;
	private boolean servicio4Seleccionado = false;
	private boolean servicio5Seleccionado = false;
	private double valorServicio1 = 0;
	private double valorServicio2 = 0;
	private double valorServicio3 = 0;
	private double valorServicio4 = 0;
	private double valorServicio5 = 0;
	private double totalServicios = 0;
	private long dias;
	private JLabel lblMostrarTotal;

	private ArrayList<Services> servicios = new ArrayList<>();

	LocalDate fechaInicio;
	LocalDate fechaFin;
	private double valorReserva;

	// Falta añadir el ID o el tipo de la habitacón para obtener la imagen y el
	// precio por noche
	public VentanaHabitacion(Usuario current, Reserva preReserva) {
		// Operaciones de inicio de ventana
		fechaInicio = preReserva.getFechaInicio();
		fechaFin = preReserva.getFechaFin();

		// Obtener los servicios por defecto de cada de habitacion
		ServicesReturn serviciosDefecto = new ServicesReturn();
		preReserva.setServices(serviciosDefecto.SerPorDefecto(preReserva.getHabitacion()));
		servicios = new ArrayList<>(serviciosDefecto.SerPorDefecto(preReserva.getHabitacion()));

		// Calcular la diferencia entre las fechas
		@SuppressWarnings("unused")
		Period periodo = Period.between(fechaInicio, fechaFin);
		// Obtener la cantidad de días del periodo
		dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		//Obtener el valor de la habitación
		valorReserva = CalculadoraPrecios.ValorReserva(dias, preReserva.getHabitacion());
		totalServicios = valorReserva;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hola usuario: " + current.getNombreUsuario());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 238, 33);
		contentPane.add(lblNewLabel);

		// Colocar condicional para el tipo de habitacion!!!!
		JLabel Imagen = new JLabel();
		Imagen.setBounds(10, 55, 191, 138);
		ImageIcon img1 = new ImageIcon("src/img/room1.jpg");
		Image imgIns = img1.getImage();
		Image newImg = imgIns.getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon finalImage = new ImageIcon(newImg);
		Imagen.setIcon(finalImage);
		contentPane.add(Imagen);

		JLabel lblNewLabel_1 = new JLabel("FechaCheck-In: " + fechaInicio);
		lblNewLabel_1.setBounds(229, 35, 179, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("FechaCheck-Out: " + fechaFin);
		lblNewLabel_2.setBounds(229, 55, 179, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblMostrarValorR = new JLabel("$: " + valorReserva);
		lblMostrarValorR.setBounds(359, 75, 128, 14);
		contentPane.add(lblMostrarValorR);

		lblMostrarTotal = new JLabel("");
		lblMostrarTotal.setBounds(359, 279, 46, 14);
		contentPane.add(lblMostrarTotal);

		/*
		 * CalculadoraPrecios.ValorReserva(dias, precioXnoche) Cambiar el valor del
		 * total y del valor de la reserva
		 */
		JLabel lblMostrarValorS1 = new JLabel("$: " + valorServicio1);
		lblMostrarValorS1.setBounds(359, 100, 128, 14);
		contentPane.add(lblMostrarValorS1);

		JLabel lblMostrarValorS2 = new JLabel("$: " + valorServicio2);
		lblMostrarValorS2.setBounds(359, 126, 128, 14);
		contentPane.add(lblMostrarValorS2);

		JLabel lblMostrarValorS3 = new JLabel("$: " + valorServicio3);
		lblMostrarValorS3.setBounds(362, 152, 125, 14);
		contentPane.add(lblMostrarValorS3);

		JLabel lblMostrarValorS4 = new JLabel("$: " + valorServicio4);
		lblMostrarValorS4.setBounds(362, 177, 125, 14);
		contentPane.add(lblMostrarValorS4);

		JLabel lblMostrarValorS5 = new JLabel("$: " + valorServicio5);
		lblMostrarValorS5.setBounds(362, 203, 125, 14);
		contentPane.add(lblMostrarValorS5);

		JCheckBox servicio1 = new JCheckBox("Barra Libre");
		servicio1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicios.add(new SerBarraLibre());
				servicio1Seleccionado = servicio1.isSelected();
				valorServicio1 = CalculadoraPrecios.ValorServicio1(servicio1Seleccionado, dias);
				lblMostrarValorS1.setText("$: " + valorServicio1);
				recalcularTotalServicios();
			}
		});
		servicio1.setBounds(229, 96, 97, 23);

		JCheckBox servicio2 = new JCheckBox("Buffet");
		servicio2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicios.add(new SerBuffet());
				servicio2Seleccionado = servicio2.isSelected();
				valorServicio2 = CalculadoraPrecios.ValorServicio2(servicio2Seleccionado, dias);
				lblMostrarValorS2.setText("$: " + valorServicio2);
				recalcularTotalServicios();
			}
		});
		servicio2.setBounds(229, 122, 97, 23);

		JCheckBox servicio3 = new JCheckBox("Jacuzzi");
		servicio3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicios.add(new SerJacuzzi());
				servicio3Seleccionado = servicio3.isSelected();
				valorServicio3 = CalculadoraPrecios.ValorServicio3(servicio3Seleccionado, dias);
				lblMostrarValorS3.setText("$: " + valorServicio3);
				recalcularTotalServicios();
			}
		});
		servicio3.setBounds(229, 148, 97, 23);

		JCheckBox servicio4 = new JCheckBox("Lavanderia");
		servicio4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicios.add(new SerLavanderia());
				servicio4Seleccionado = servicio4.isSelected();
				valorServicio4 = CalculadoraPrecios.ValorServicio4(servicio4Seleccionado, dias);
				lblMostrarValorS4.setText("$: " + valorServicio4);
				recalcularTotalServicios();
			}
		});
		servicio4.setBounds(229, 173, 97, 23);

		JCheckBox servicio5 = new JCheckBox("Tour");
		servicio5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicios.add(new SerTour());
				servicio5Seleccionado = servicio5.isSelected();
				valorServicio5 = CalculadoraPrecios.ValorServicio5(servicio5Seleccionado, dias);
				lblMostrarValorS5.setText("$: " + valorServicio5);
				recalcularTotalServicios();
			}
		});
		servicio5.setBounds(229, 199, 97, 23);
		
		//For para dependiendo del la habitacion que se haya seleccionado, se mire cuales tiene disponibles, y se seleccione
		for(Services select : servicios){
			if(select.getNombreSer() == "Barra"){
				servicio1.setSelected(true);
				servicio1.setEnabled(false);
				lblMostrarValorS1.setText("Incluido");
			}
			else if(select.getNombreSer() == "Buffet"){
				servicio2.setSelected(true);
				servicio2.setEnabled(false);
				lblMostrarValorS2.setText("Incluido");
			}
			else if(select.getNombreSer() == "Jacuzzi"){
				servicio3.setSelected(true);
				servicio3.setEnabled(false);
				lblMostrarValorS3.setText("Incluido");
			}
			else if(select.getNombreSer() == "Lavanderia"){
				servicio4.setSelected(true);
				servicio4.setEnabled(false);
				lblMostrarValorS4.setText("Incluido");
			}
			else if(select.getNombreSer() == "Tour"){
				servicio5.setSelected(true);
				servicio5.setEnabled(false);
				lblMostrarValorS5.setText("Incluido");
			}
		}

		contentPane.add(servicio1);
		contentPane.add(servicio2);
		contentPane.add(servicio3);
		contentPane.add(servicio4);
		contentPane.add(servicio5);

		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preReserva.getHabitacion() == null) {
					JOptionPane.showMessageDialog(null,
							"Seleccione el tipo de habitación que va a reservar antes de continuar", "Habitacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					preReserva.setFechaInicio(fechaInicio);
					preReserva.setPrecioReserva(valorReserva);
					preReserva.setPrecioServicesAdd(valorServicio1 + valorServicio2 + valorServicio3 + valorServicio4 + valorServicio5);
					preReserva.setTotal(totalServicios);
					Pago pago = new Pago(current,preReserva);
					pago.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(110, 315, 89, 23);
		contentPane.add(btnNewButton);

		JLabel precioReserva = new JLabel("Valor de reserva:");
		precioReserva.setBounds(229, 75, 97, 14);
		contentPane.add(precioReserva);

		JLabel lblNewLabel_3 = new JLabel("Total a pagar:");
		lblNewLabel_3.setBounds(229, 279, 244, 14);
		contentPane.add(lblNewLabel_3);

		// Agregue este boton por que me parecería importante que se puedan agregar mas
		// de una habitacion que se desee reservar pero de momento no hace nada
		JButton btnAgregarHab = new JButton("Agregar otra habitación");
		btnAgregarHab.setBounds(214, 315, 147, 23);
		contentPane.add(btnAgregarHab);

	}

	// Metodo que permite calcular el total de todos los servicios para
	// posteriormente mostrar en un label
	public void recalcularTotalServicios() {
		totalServicios = valorReserva + valorServicio1 + valorServicio2 + valorServicio3 + valorServicio4 + valorServicio5;
		lblMostrarTotal.setText(String.format("$ %.2f", totalServicios));
	}
}
