package view;

//Libreias
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

//Clase Externa
import logic.Usuario;

public class Saludo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Esta ventana es la principal para el usuario, donde se le permite:
	 * Reservar
	 * Ver las resrevas existentes del usuario (Facturas)
	 * Ver habitaciones y servicios
	 * Cambiar contraseña
	 * @param current
	 */
	public Saludo(Usuario current) {
		
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Saludo usuario
		JLabel lblNewLabel = new JLabel("Hola " + current.getNombreUsuario()+" ¿Listo para tener las vacaciones de tus sueños?");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arvo", Font.BOLD, 30));
		lblNewLabel.setBounds(222, 47, 1090, 46);
		contentPane.add(lblNewLabel);
		
		//Boton reservar
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fechas fechas = new Fechas(current);
				fechas.setVisible(true);
				dispose();
			}
		});
		btnReservar.setBounds(683, 501, 218, 71);
		// Establecer el fondo del botón como transparente
		btnReservar.setOpaque(false);
		// Hacer que el contenido del botón sea transparente
		btnReservar.setContentAreaFilled(false);
		btnReservar.setBorderPainted(false);
		contentPane.add(btnReservar);
		
		JButton btnNewButton = new JButton("Consultar reservas");
		btnNewButton.setFont(new Font("Arvo", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(208, 169, 51));
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(0, 265, 249, 57);
		contentPane.add(btnNewButton);
		
		JButton btnCambiarContrasea = new JButton("Cambiar contraseña");
		btnCambiarContrasea.setFont(new Font("Arvo", Font.BOLD, 18));
		btnCambiarContrasea.setBackground(new Color(208, 169, 51));
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String currentPassword = current.getContraseña();
				CambiarContra cambiar = new CambiarContra(id, currentPassword);
				cambiar.setVisible(true);
				dispose();
				*/
			}
		});
		btnCambiarContrasea.setBounds(0, 321, 249, 57);
		contentPane.add(btnCambiarContrasea);
		
		JButton btnInfoHab = new JButton("Conoce las habitaciones");
		btnInfoHab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInfoHab.setFont(new Font("Arvo", Font.BOLD, 16));
		btnInfoHab.setBackground(new Color(208, 169, 51));
		btnInfoHab.setBounds(0, 153, 249, 57);
		contentPane.add(btnInfoHab);

		JButton btnInfoSer = new JButton("Conoce los servicos");
  	btnInfoSer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInfoSer.setFont(new Font("Arvo", Font.BOLD, 16));
		btnInfoSer.setBackground(new Color(208, 169, 51));
		btnInfoSer.setBounds(0, 209, 249, 57);
		contentPane.add(btnInfoSer);

		
		JButton btnNewButton_1 = new JButton("Cerrar sesión");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(208, 169, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres cerrar sesión?", "Atención", JOptionPane.YES_NO_OPTION);
				if (valor == JOptionPane.YES_OPTION) {
					VentanaInicio inicio = new VentanaInicio();
					inicio.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arvo", Font.BOLD, 18));
		btnNewButton_1.setBounds(0, 377, 249, 57);
		contentPane.add(btnNewButton_1);

		// Cargar la imagen y configurar el fondo
		ImageIcon imagenFondo = new ImageIcon(Saludo.class.getResource("/img/backgroundSaludo.png"));
		Image img = imagenFondo.getImage();
		Image imgEscalada = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);
		JLabel etiquetaFondo = new JLabel(imagenEscalada);
		etiquetaFondo.setBounds(0, 0, getWidth(), getHeight());
		((JPanel) getContentPane()).setOpaque(false);
		contentPane.add(etiquetaFondo);
	}
}
