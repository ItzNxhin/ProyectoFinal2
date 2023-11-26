package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ManejoExc.CampoVacioException;
import ManejoExc.CorreoInvalidoException;
import data.GestorArchivo;

public class VentanaInicio extends JFrame {

	// Atributos necesarioas
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtContra;
	private String correo;
	private String contraseña;
	private JTextField txtEmail;
	private JButton btnLogin;
	private JButton btnInformacion;
	private JButton btnServicios;
	private JButton btnHabitaciones;

	/**
	 * Esta clase se encarga de dar la bienvenida Y el inicio de sesion
	 */
	public VentanaInicio() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);

		txtContra = new JPasswordField();
		txtContra.setForeground(new Color(255, 204, 0));
		txtContra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtContra.setOpaque(false);
        // Establecer el borde con color amarillo
        txtContra.setBorder(new LineBorder(new Color(255, 204, 0), 1));
		txtContra.setBounds(172, 499, 227, 21);
		contentPane.add(txtContra);

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 204, 0));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		// Establecer el fondo transparente
        txtEmail.setOpaque(false);
        // Establecer el borde con color amarillo
        txtEmail.setBorder(new LineBorder(new Color(255, 204, 0), 1));
		txtEmail.setBounds(119, 463, 280, 21);
		contentPane.add(txtEmail);
		
		btnLogin = new JButton("Iniciar Sesión");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correo = txtEmail.getText();
				char[] contra = txtContra.getPassword();
				contraseña = String.valueOf(contra);
				try {
					 if (correo.isEmpty() || contraseña.isEmpty()) {
				            throw new CampoVacioException();
				        }
					if (!correo.contains("@")) {
			            throw new CorreoInvalidoException();
					}
		            if (GestorArchivo.iniciarSesion(correo, contraseña)) {
		            	dispose();
		            }
				} catch (CorreoInvalidoException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (CampoVacioException ex) {
		        	JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setBackground(new Color(255, 204, 0));
		btnLogin.setBounds(100, 531, 299, 45);
		contentPane.add(btnLogin);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearUsuario crear = new VentanaCrearUsuario();
				crear.setVisible(true);
				dispose();
			}
		});
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCrear.setBackground(new Color(255, 204, 0));
		btnCrear.setBounds(259, 615, 140, 32);
		contentPane.add(btnCrear);
		
		btnInformacion = new JButton("");
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInfo info = new VentanaInfo();
				info.setVisible(true);
				dispose();
			}
		});
		btnInformacion.setBounds(1076, 0, 274, 86);
		// Establecer el fondo del botón como transparente
		btnInformacion.setOpaque(false);
        // Hacer que el contenido del botón sea transparente
		btnInformacion.setContentAreaFilled(false);
		btnInformacion.setBorderPainted(false);
		contentPane.add(btnInformacion);
		
		btnServicios = new JButton("");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnServicios.setBounds(787, 0, 286, 86);
		btnServicios.setOpaque(false);
		btnServicios.setContentAreaFilled(false);
		btnServicios.setBorderPainted(false);
		contentPane.add(btnServicios);
		
		btnHabitaciones = new JButton("");
		btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHabitaciones.setBounds(499, 0, 286, 86);
		btnHabitaciones.setOpaque(false);
		btnHabitaciones.setContentAreaFilled(false);
		btnHabitaciones.setBorderPainted(false);
		contentPane.add(btnHabitaciones);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = JOptionPane.showConfirmDialog(null, "¿Estas seguro qure quieres cerrar el programa?", "Warning", JOptionPane.YES_NO_OPTION);
				if (valor == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCerrar.setBackground(new Color(255, 204, 0));
		btnCerrar.setBounds(1226, 673, 114, 45);
		contentPane.add(btnCerrar);

		// Cargar la imagen y configurar el fondo
		ImageIcon imagenFondo = new ImageIcon(VentanaInicio.class.getResource("/img/backgroundInicio.png"));
		Image img = imagenFondo.getImage();
		Image imgEscalada = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);
		JLabel etiquetaFondo = new JLabel(imagenEscalada);
		etiquetaFondo.setBounds(0, 0, getWidth(), getHeight());
		((JPanel) getContentPane()).setOpaque(false);
		contentPane.add(etiquetaFondo);
	}
}
