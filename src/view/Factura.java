package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

/**
 * Esta clase se encarga de mostrar la factura
 */
public class Factura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private long dias;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int k = 0;
	
	/**
	 * Esta es la construccion de la ventana
	 * @param current Usuario
	 * @param reserva Reserva a mostrar
	 * @param nombre Nombre del usuario
	 */
	public Factura(Usuario current, Reserva reserva, String nombre) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		fechaInicio = reserva.getFechaInicio();
		fechaFin = reserva.getFechaFin();
		dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		
		//Fechas
		JLabel lblCheckOut = new JLabel(""+fechaFin);
		lblCheckOut.setForeground(Color.WHITE);
		lblCheckOut.setFont(new Font("Arvo", Font.BOLD | Font.ITALIC, 12));
		lblCheckOut.setBounds(405, 116, 126, 14);
		contentPane.add(lblCheckOut);
		
		JLabel lblCheackIn = new JLabel(""+fechaInicio);
		lblCheackIn.setForeground(new Color(255, 255, 255));
		lblCheackIn.setFont(new Font("Arvo", Font.BOLD | Font.ITALIC, 12));
		lblCheackIn.setBounds(405, 98, 126, 14);
		contentPane.add(lblCheackIn);
		
		//Index de los servicios
		JLabel lblS1_2 = new JLabel();
		lblS1_2.setText("1");
		lblS1_2.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS1_2.setBounds(58, 293, 41, 14);

		JLabel lblS2_2 = new JLabel();
		lblS2_2.setText("2");
		lblS2_2.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS2_2.setBounds(58, 321, 41, 14);
		
		JLabel lblS3_2 = new JLabel();
		lblS3_2.setText("3");
		lblS3_2.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS3_2.setBounds(58, 348, 41, 14);

		JLabel lblS4_2 = new JLabel();
		lblS4_2.setText("4");
		lblS4_2.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS4_2.setBounds(58, 375, 41, 14);
		
		JLabel lblS5_2 = new JLabel();
		lblS5_2.setText("5");
		lblS5_2.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS5_2.setBounds(58, 405, 41, 14);

		//Nombres de servicios
		JLabel lblS5 = new JLabel();
		lblS5.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS5.setBounds(139, 405, 127, 14);
		contentPane.add(lblS5);
		
		JLabel lblS4 = new JLabel();
		lblS4.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS4.setBounds(139, 375, 127, 14);
		contentPane.add(lblS4);
		
		JLabel lblS3 = new JLabel();
		lblS3.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS3.setBounds(139, 348, 127, 14);
		contentPane.add(lblS3);
		
		JLabel lblS2 = new JLabel();
		lblS2.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS2.setBounds(139, 321, 127, 14);
		contentPane.add(lblS2);
		
		JLabel lblS1 = new JLabel();
		lblS1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS1.setBounds(139, 293, 127, 14);
		contentPane.add(lblS1);

		//Precio de los servicios
		JLabel lblS5_1 = new JLabel();
		lblS5_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS5_1.setBounds(289, 405, 127, 14);
		contentPane.add(lblS5_1);
		
		JLabel lblS4_1 = new JLabel();
		lblS4_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS4_1.setBounds(289, 375, 127, 14);
		contentPane.add(lblS4_1);

		JLabel lblS3_1 = new JLabel();
		lblS3_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS3_1.setBounds(289, 348, 127, 14);
		contentPane.add(lblS3_1);
		
		JLabel lblS2_1 = new JLabel();
		lblS2_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS2_1.setBounds(289, 321, 89, 14);
		contentPane.add(lblS2_1);
		
		JLabel lblS1_1 = new JLabel();
		lblS1_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS1_1.setBounds(289, 293, 80, 14);
		contentPane.add(lblS1_1);

		//Precio total de los servicios
		JLabel lblS3_1_1 = new JLabel();
		lblS3_1_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS3_1_1.setBounds(405, 348, 127, 14);
		contentPane.add(lblS3_1_1);
		
		JLabel lblS4_1_1 = new JLabel();
		lblS4_1_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS4_1_1.setBounds(405, 375, 127, 14);
		contentPane.add(lblS4_1_1);
		
		JLabel lblS5_1_1 = new JLabel();
		lblS5_1_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS5_1_1.setBounds(405, 405, 127, 14);
		contentPane.add(lblS5_1_1);
		
		JLabel lblS2_1_1 = new JLabel();
		lblS2_1_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS2_1_1.setBounds(405, 321, 89, 14);
		contentPane.add(lblS2_1_1);
		
		JLabel lblS1_1_1 = new JLabel();
		lblS1_1_1.setFont(new Font("Arvo", Font.BOLD, 11));
		lblS1_1_1.setBounds(405, 293, 80, 14);
		contentPane.add(lblS1_1_1);

		//Listas de los anteriores JLbales
		JLabel[] labelsIndex = {lblS1_2, lblS2_2, lblS3_2, lblS4_2, lblS5_2 };
		JLabel[] labelsPrecios = {lblS1_1, lblS2_1, lblS3_1, lblS4_1, lblS5_1 };
		JLabel[] labelsPreciosTotal = {lblS1_1_1, lblS2_1_1, lblS3_1_1, lblS4_1_1, lblS5_1_1 };
		JLabel[] labelsNombres = {lblS1, lblS2, lblS3, lblS4, lblS5 };

		//Ciclos que le van poniendo los nombres y el respectivo precio a los JLabels dependiendo de los servicos en las reserva
		for(Services i : reserva.getServices()){
			labelsNombres[k].setText(i.getNombreSer());
			labelsPrecios[k].setText("$ "+i.getPrecioSer());
			labelsPreciosTotal[k].setText("$ "+(dias*i.getPrecioSer()));
			contentPane.add(labelsIndex[k]);
			k++;
		}

		if(reserva.getHabitacion().getNombre().equals("Habitacion Presidencial")){
            lblS1_1.setText("Incluido");
            lblS2_1.setText("Incluido");
            lblS3_1.setText("Incluido");
			lblS1_1_1.setText("0");
            lblS2_1_1.setText("0");
            lblS3_1_1.setText("0");
        }
        else if(reserva.getHabitacion().getNombre().equals("Habitacion Premium")){
            lblS1_1.setText("Incluido");
            lblS2_1.setText("Incluido");
			lblS1_1_1.setText("0");
            lblS2_1_1.setText("0");
        }
        else if(reserva.getHabitacion().getNombre().equals("Habitacion Vip")){
            lblS1_1.setText("Incluido");
			lblS1_1_1.setText("0");
        }

		JLabel lblHabitacion = new JLabel(reserva.getHabitacion().getNombre());
		lblHabitacion.setFont(new Font("Arvo", Font.BOLD, 11));
		lblHabitacion.setBounds(123, 245, 302, 14);
		contentPane.add(lblHabitacion);

		JLabel lblPersonas = new JLabel(""+reserva.getHabitacion().getPersonas());
		lblPersonas.setFont(new Font("Arvo", Font.BOLD, 11));
		lblPersonas.setBounds(441, 245, 68, 14);
		contentPane.add(lblPersonas);
		
		JLabel lblValorReserva = new JLabel("$ "+reserva.getPrecioReserva());
		lblValorReserva.setFont(new Font("Arvo", Font.PLAIN, 11));
		lblValorReserva.setBounds(379,459 , 345, 14);
		contentPane.add(lblValorReserva);
		
		JLabel lblValorServicios = new JLabel("$ " + reserva.getPrecioServicesAdd() );
		lblValorServicios.setFont(new Font("Arvo", Font.PLAIN, 11));
		lblValorServicios.setBounds(379, 486, 345, 14);
		contentPane.add(lblValorServicios);
		
		JLabel lblTotalPagar = new JLabel("$ "+reserva.getTotal());
		lblTotalPagar.setFont(new Font("Arvo", Font.BOLD, 18));
		lblTotalPagar.setBounds(379, 519, 202, 14);
		contentPane.add(lblTotalPagar);
															
		JLabel lblNombre = new JLabel(reserva.getUsaurio().getNombreUsuario());
		lblNombre.setFont(new Font("Arvo", Font.BOLD, 14));
		lblNombre.setBounds(35, 141, 292, 18);
		contentPane.add(lblNombre);

		JLabel lblEmail = new JLabel(reserva.getUsaurio().getEmail());
		lblEmail.setFont(new Font("Arvo", Font.BOLD, 14));
		lblEmail.setBounds(35, 183, 292, 25);
		contentPane.add(lblEmail);
		
		
		//Datos de las persona (Tarjeta de credito ****1234 y nombre)
		JLabel lblNombrePago = new JLabel(reserva.getNombreReal());
		lblNombrePago.setBounds(79, 499, 155, 14);
		contentPane.add(lblNombrePago);
		
		String numeroTarjeta = reserva.getTarjetaCre();
		int longitud = numeroTarjeta.length();
		String ult4 = "**** **** ****" + numeroTarjeta.substring(longitud - 4);
		
		JLabel lblTarjetaCre = new JLabel(ult4);
		lblTarjetaCre.setBounds(79, 482, 126, 14);
		contentPane.add(lblTarjetaCre);
		
		//Boton salir
		JButton btnVolver = new JButton("SALIR");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "SALIR", JOptionPane.YES_NO_OPTION);
				if(op == JOptionPane.YES_OPTION){
					Saludo frame = new Saludo(current);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.setFont(new Font("Arvo", Font.BOLD, 18));
		btnVolver.setBackground(new Color(255, 205, 8));
		btnVolver.setBounds(325, 561, 160, 25);
		contentPane.add(btnVolver);
		
		//Boton ver facturas
		JButton btnVerFacturas = new JButton("VER FACTURAS");
		btnVerFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerFacturas facturita = null;
				try {
					facturita = new VerFacturas(current);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				facturita.setVisible(true);
				dispose();
			}
		});
		btnVerFacturas.setForeground(new Color(0, 0, 0));
		btnVerFacturas.setFont(new Font("Arvo", Font.BOLD, 18));
		btnVerFacturas.setBackground(new Color(255, 205, 8));
		btnVerFacturas.setBounds(300, 597, 213, 25);
		contentPane.add(btnVerFacturas);
		

		//Fondo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 541, 667);
		ImageIcon factura = new ImageIcon(Factura.class.getResource("/img/Factura.png"));
        Image facturaIcon = factura.getImage();
        Image facturaScaled = facturaIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgFinal = new ImageIcon(facturaScaled);
        lblNewLabel.setIcon(imgFinal);
		contentPane.add(lblNewLabel);	
		
	}
}
