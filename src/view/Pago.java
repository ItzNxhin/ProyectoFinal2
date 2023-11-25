package view;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.io.IOException;
import java.util.ArrayList;

import data.ReservasExistentes;
import logic.Reserva;
import logic.Usuario;

public class Pago extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTarjetaCre;
	private JTextField textCVV;
	private JLabel lblTarjetaCre;
	private JLabel lblCsv;
	private String tarjeta;
	private String cvv;
	private JTextField textNombre;
	private ArrayList<Reserva> fechas = new ArrayList<>();
	private ReservasExistentes archFExistentes = new ReservasExistentes();

	/**
	 * Ventana que se encargar de solicitar los datos para el pago de la reservacion
	 * (Tarjeta de credito/Debito)
	 */
	public Pago(Usuario current, Reserva reserva) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textTarjetaCre = new JTextField();
		textTarjetaCre.setBounds(199, 152, 159, 20);
		contentPane.add(textTarjetaCre);
		textTarjetaCre.setColumns(10);

		// Agregar KeyListener para aceptar solo números y limitar a 16 dígitos (Lo
		// normal de las tarjetas)
		textTarjetaCre.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))
						|| textTarjetaCre.getText().length() >= 16) {
					e.consume();
				}
			}
		});

		textCVV = new JTextField();
		textCVV.setBounds(199, 197, 159, 20);
		contentPane.add(textCVV);
		textCVV.setColumns(10);

		// Agregar KeyListener para aceptar solo números y limitar a 3 dígitos (Número
		// de seguridad)

		textCVV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))
						|| textCVV.getText().length() >= 3) {
					e.consume();
				}
			}
		});

		lblTarjetaCre = new JLabel("Tarjeta de Credito/Debito:");
		lblTarjetaCre.setBounds(30, 155, 159, 14);
		contentPane.add(lblTarjetaCre);

		lblCsv = new JLabel("Codigo CVV:");
		lblCsv.setBounds(30, 200, 141, 14);
		contentPane.add(lblCsv);
		
		/*
		 * Verificar que los datos se han ingresado correctamente
		 * Si es así continuar con la factura final
		 * De no ser así solicitar que se ingresen correctamente
		 */
		JButton btnPago = new JButton("Realizar transacción");
		btnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tarjeta = textTarjetaCre.getText();
				cvv = textCVV.getText();

				if (tarjeta.isEmpty() || cvv.isEmpty() || tarjeta.length() < 16 || cvv.length() < 3) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese correctamente los datos solicitados",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					int opcion = JOptionPane.showConfirmDialog(contentPane,
							"¿Está seguro de realizar esta transacción?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						reserva.setUsaurio(current);

						Factura factura = new Factura(current, reserva, textNombre.getText());
						factura.setVisible(true);
						
						try {
							fechas = new ArrayList<>(archFExistentes.leer());
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
						fechas.add(reserva);
						try {
							archFExistentes.guardar(fechas);
						} catch (ClassNotFoundException | IOException e1) {
							e1.printStackTrace();
						}
						dispose();
					}
				}
			}
		});
		btnPago.setBounds(139, 269, 151, 23);
		contentPane.add(btnPago);
		
		textNombre = new JTextField();
		textNombre.setBounds(199, 110, 159, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE)){
					e.consume();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Nombre completo:");
		lblNewLabel.setBounds(30, 113, 101, 14);
		contentPane.add(lblNewLabel);

	}
}
