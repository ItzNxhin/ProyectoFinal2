package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import ManejoExc.CampoVacioException;
import ManejoExc.CorreoInvalidoException;
import data.GestorArchivo;
import logic.Usuario;

/**
 * En esta clase se muestra la ventana para crear un nuevo usuario
 */
public class VentanaCrearUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtContra;
	private String usuario;
	private String correo;
	private String contraseña;
	private JTextField txtEmail;
	private JButton btnCrear;
	private JButton btnVolver;

	/**
	 * Ventana
	 */
	public VentanaCrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(255, 204, 0));
		txtUser.setBounds(599, 420, 296, 21);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUser.setOpaque(false);
		// Establecer el borde con color amarillo
		txtUser.setBorder(new LineBorder(new Color(255, 204, 0), 1));
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtContra = new JPasswordField();
		txtContra.setForeground(new Color(255, 204, 0));
		txtContra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtContra.setOpaque(false);
		// Establecer el borde con color amarillo
		txtContra.setBorder(new LineBorder(new Color(255, 204, 0), 1));
		txtContra.setBounds(671, 485, 224, 21);
		contentPane.add(txtContra);

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 204, 0));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		// Establecer el fondo transparente
		txtEmail.setOpaque(false);
		// Establecer el borde con color amarillo
		txtEmail.setBorder(new LineBorder(new Color(255, 204, 0), 1));
		txtEmail.setBounds(599, 454, 296, 21);
		contentPane.add(txtEmail);

		btnCrear = new JButton("Crear Cuenta");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario = txtUser.getText();
				correo = txtEmail.getText();
				char[] contra = txtContra.getPassword();
				contraseña = String.valueOf(contra);
				try {
					if (correo.isEmpty() || contraseña.isEmpty() || usuario.isEmpty()) {
						throw new CampoVacioException();
					}
					if (!correo.contains("@")) {
						throw new CorreoInvalidoException();
					}
					if (GestorArchivo.existeCorreo(correo)) {
						JOptionPane.showMessageDialog(null, "El correo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						Usuario user = new Usuario(usuario, correo, contraseña);
						GestorArchivo.agregarDatos(user);
						JOptionPane.showMessageDialog(null, "Usuario creado con éxito", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						VentanaInicio frame = new VentanaInicio();
						frame.setVisible(true);
						dispose();
					}
				} catch (CorreoInvalidoException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (CampoVacioException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCrear.setBackground(new Color(255, 204, 0));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCrear.setBounds(609, 517, 150, 37);
		contentPane.add(btnCrear);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio frame = new VentanaInicio();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBackground(new Color(255, 204, 0));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(1188, 33, 123, 37);
		contentPane.add(btnVolver);
		
		
		// Cargar la imagen y configurar el fondo
		ImageIcon imagenFondo = new ImageIcon(VentanaCrearUsuario.class.getResource("/img/backgroundCrear.png"));
		Image img = imagenFondo.getImage();
		Image imgEscalada = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);
		JLabel etiquetaFondo = new JLabel(imagenEscalada);
		etiquetaFondo.setBounds(0, 0, getWidth(), getHeight());
		((JPanel) getContentPane()).setOpaque(false);
		contentPane.setLayout(null);
		contentPane.add(etiquetaFondo);
	}

}
