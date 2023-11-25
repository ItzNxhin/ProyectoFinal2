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
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;

import logic.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		// Obtener la cantidad de días del periodo
		dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		//Obtener el valor de la habitación
		valorReserva = CalculadoraPrecios.ValorReserva(dias, preReserva.getHabitacion());
		totalServicios = valorReserva;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPre = new JLabel("");
		lblPre.setBounds(616, 217, 615, 407);

		JLabel lblNewLabel_1 = new JLabel("Fecha Check-In: " + fechaInicio);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(79, 195, 380, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha Check-Out: "+fechaFin);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(79, 239, 380, 33);
		contentPane.add(lblNewLabel_2);

		JLabel lblMostrarValorR = new JLabel(" $ "+preReserva.getHabitacion().getPrecio());
		lblMostrarValorR.setForeground(new Color(255, 255, 255));
		lblMostrarValorR.setFont(new Font("Arvo", Font.ITALIC, 20));
		lblMostrarValorR.setBounds(405, 550, 169, 33);
		contentPane.add(lblMostrarValorR);

		lblMostrarTotal = new JLabel("0.0");
		lblMostrarTotal.setFont(new Font("Arvo", Font.ITALIC, 20));
		lblMostrarTotal.setForeground(new Color(255, 255, 255));
		lblMostrarTotal.setBounds(405, 605, 169, 33);
		contentPane.add(lblMostrarTotal);

		/*
		 * CalculadoraPrecios.ValorReserva(dias, precioXnoche) Cambiar el valor del
		 * total y del valor de la reserva
		 */
		JLabel lblMostrarValorS1 = new JLabel("$: " + valorServicio1);
		lblMostrarValorS1.setFont(new Font("Arvo", Font.ITALIC, 20));
		lblMostrarValorS1.setForeground(new Color(255, 255, 255));
		lblMostrarValorS1.setBounds(405, 388, 128, 23);
		contentPane.add(lblMostrarValorS1);

		JLabel lblMostrarValorS2 = new JLabel("$: " + valorServicio2);
		lblMostrarValorS2.setForeground(new Color(255, 255, 255));
		lblMostrarValorS2.setFont(new Font("Arvo", Font.ITALIC, 20));
		lblMostrarValorS2.setBounds(405, 288, 128, 23);
		contentPane.add(lblMostrarValorS2);

		JLabel lblMostrarValorS3 = new JLabel("$: " + valorServicio3);
		lblMostrarValorS3.setFont(new Font("Arvo", Font.ITALIC, 20));
		lblMostrarValorS3.setForeground(new Color(255, 255, 255));
		lblMostrarValorS3.setBounds(405, 439, 125, 27);
		contentPane.add(lblMostrarValorS3);

		JLabel lblMostrarValorS4 = new JLabel("$: " + valorServicio4);
		lblMostrarValorS4.setFont(new Font("Arvo", Font.ITALIC, 20));
		lblMostrarValorS4.setForeground(new Color(255, 255, 255));
		lblMostrarValorS4.setBounds(405, 338, 125, 23);
		contentPane.add(lblMostrarValorS4);

		JLabel lblMostrarValorS5 = new JLabel("$: " + valorServicio5);
		lblMostrarValorS5.setForeground(new Color(255, 255, 255));
		lblMostrarValorS5.setFont(new Font("Arvo", Font.ITALIC, 20));
		lblMostrarValorS5.setBounds(405, 484, 125, 23);
		contentPane.add(lblMostrarValorS5);

		JCheckBox servicio1 = new JCheckBox("Barra Libre");
		servicio1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon prev = new ImageIcon(VentanaHabitacion.class.getResource("/img/serBarraLibre.jpeg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal1 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal1);
				contentPane.add(lblPre);	
				getLayeredPane().add(lblPre, Integer.valueOf(1));
			}
		});
		servicio1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicio1Seleccionado = servicio1.isSelected();
				valorServicio1 = CalculadoraPrecios.ValorServicio1(servicio1Seleccionado, dias);
				lblMostrarValorS1.setText("$: " + valorServicio1);
				recalcularTotalServicios();
			}
		});
		servicio1.setBounds(79, 388, 22, 23);

		JCheckBox servicio2 = new JCheckBox("Buffet");
		servicio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon prev = new ImageIcon(Factura.class.getResource("/img/serBuffet.jpg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal1 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal1);
				contentPane.add(lblPre);	
				getLayeredPane().add(lblPre, Integer.valueOf(1));
			}
		});
		servicio2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicio2Seleccionado = servicio2.isSelected();
				valorServicio2 = CalculadoraPrecios.ValorServicio2(servicio2Seleccionado, dias);
				lblMostrarValorS2.setText("$: " + valorServicio2);
				recalcularTotalServicios();
			}
		});
		servicio2.setBounds(79, 288, 22, 23);

		JCheckBox servicio3 = new JCheckBox("Jacuzzi");
		servicio3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon prev = new ImageIcon(VentanaHabitacion.class.getResource("/img/serJacuzzi.jpg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal1 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal1);
				contentPane.add(lblPre);	
				getLayeredPane().add(lblPre, Integer.valueOf(1));
			}
		});
		servicio3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicio3Seleccionado = servicio3.isSelected();
				valorServicio3 = CalculadoraPrecios.ValorServicio3(servicio3Seleccionado, dias);
				lblMostrarValorS3.setText("$: " + valorServicio3);
				recalcularTotalServicios();
			}
		});
		servicio3.setBounds(79, 439, 22, 23);

		JCheckBox servicio4 = new JCheckBox("Lavanderia");
		servicio4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon prev = new ImageIcon(VentanaHabitacion.class.getResource("/img/serLavanderia.jpg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal1 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal1);
				contentPane.add(lblPre);	
				getLayeredPane().add(lblPre, Integer.valueOf(1));	
			}
		});
		servicio4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicio4Seleccionado = servicio4.isSelected();
				valorServicio4 = CalculadoraPrecios.ValorServicio4(servicio4Seleccionado, dias);
				lblMostrarValorS4.setText("$: " + valorServicio4);
				recalcularTotalServicios();
			}
		});
		servicio4.setBounds(79, 338, 22, 23);

		JCheckBox servicio5 = new JCheckBox("Tour");
		servicio5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon prev = new ImageIcon(VentanaHabitacion.class.getResource("/img/serTour.jpeg"));
				Image preImg = prev.getImage();
				Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imgFinal1 = new ImageIcon(prescaled);
				lblPre.setIcon(imgFinal1);
				contentPane.add(lblPre);	
				getLayeredPane().add(lblPre, Integer.valueOf(1));
			}
		});
		servicio5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				servicio5Seleccionado = servicio5.isSelected();
				valorServicio5 = CalculadoraPrecios.ValorServicio5(servicio5Seleccionado, dias);
				lblMostrarValorS5.setText("$: " + valorServicio5);
				recalcularTotalServicios();
			}
		});
		servicio5.setBounds(79, 484, 22, 23);
		
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

		servicio1.setOpaque(false);
		servicio2.setOpaque(false);
		servicio3.setOpaque(false);
		servicio4.setOpaque(false);
		servicio5.setOpaque(false);
		contentPane.add(servicio1);
		contentPane.add(servicio2);
		contentPane.add(servicio3);
		contentPane.add(servicio4);
		contentPane.add(servicio5);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setFont(new Font("Arvo", Font.BOLD, 18));
		btnCancelar.setBackground(new Color(255, 205, 8));
		btnCancelar.setBounds(141, 637, 160, 33);
		contentPane.add(btnCancelar);

		JButton btnPrueba = new JButton("PAGAR");
		btnPrueba.setForeground(new Color(0, 0, 0));
		btnPrueba.setBackground(new Color(255, 205, 8));
		btnPrueba.setFont(new Font("Arvo", Font.BOLD, 18));
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preReserva.getHabitacion() == null) {
					JOptionPane.showMessageDialog(null,
							"Seleccione el tipo de habitación que va a reservar antes de continuar", "Habitacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (servicio1.isSelected() && servicio1.isEnabled()) servicios.add(new SerBarraLibre());
					if (servicio2.isSelected() && servicio2.isEnabled()) servicios.add(new SerBuffet());
					if (servicio3.isSelected() && servicio3.isEnabled()) servicios.add(new SerJacuzzi());
					if (servicio4.isSelected() && servicio4.isEnabled()) servicios.add(new SerLavanderia());
					if (servicio5.isSelected() && servicio5.isEnabled()) servicios.add(new SerTour());
					preReserva.setServices(servicios);
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
		btnPrueba.setBounds(385, 637, 128, 33);
		contentPane.add(btnPrueba);

		JLabel lblfondo = new JLabel("");
		lblfondo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblfondo.setBounds(0, 0, 1264, 681);
		ImageIcon factura = new ImageIcon(VentanaHabitacion.class.getResource("/img/imgVentanaHab.png"));
        Image facturaIcon = factura.getImage();
        Image facturaScaled = facturaIcon.getScaledInstance(lblfondo.getWidth(), lblfondo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgFinal = new ImageIcon(facturaScaled);
        lblfondo.setIcon(imgFinal);
		contentPane.add(lblfondo);	

	}

	// Metodo que permite calcular el total de todos los servicios para
	// posteriormente mostrar en un label
	public void recalcularTotalServicios() {
		totalServicios = valorReserva + valorServicio1 + valorServicio2 + valorServicio3 + valorServicio4 + valorServicio5;
		lblMostrarTotal.setText(String.format("$ %.2f", totalServicios));
	}
}
