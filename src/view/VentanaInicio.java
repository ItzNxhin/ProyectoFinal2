package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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

	/**
	 * Esta clase se encar de dar la bienvenida Y el inicio de sesion
	 */
	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screenSize.width, 1020);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// Cargar la imagen y configurar el fondo
		ImageIcon imagenFondo = new ImageIcon("src/img/backgroundInicio.png");
		Image img = imagenFondo.getImage();
		Image imgEscalada = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);
		JLabel etiquetaFondo = new JLabel(imagenEscalada);
		etiquetaFondo.setBounds(0, 0, getWidth(), getHeight());
		((JPanel) getContentPane()).setOpaque(false);
		getLayeredPane().add(etiquetaFondo, new Integer(Integer.MIN_VALUE));
		contentPane.setLayout(null);

		txtContra = new JPasswordField();
		txtContra.setForeground(new Color(255, 204, 0));
		txtContra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtContra.setOpaque(false);
        // Establecer el borde con color amarillo
        txtContra.setBorder(new LineBorder(new Color(255, 204, 0), 1));
		txtContra.setBounds(237, 665, 227, 25);
		contentPane.add(txtContra);

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 204, 0));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		// Establecer el fondo transparente
        txtEmail.setOpaque(false);
        // Establecer el borde con color amarillo
        txtEmail.setBorder(new LineBorder(new Color(255, 204, 0), 1));
		txtEmail.setBounds(165, 615, 299, 32);
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
		            GestorArchivo.iniciarSesion(correo, contraseña);
		            dispose();
				} catch (CorreoInvalidoException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (CampoVacioException ex) {
		        	JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setBackground(new Color(255, 204, 0));
		btnLogin.setBounds(158, 713, 386, 51);
		contentPane.add(btnLogin);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearUsuario crear = new VentanaCrearUsuario();
				crear.setExtendedState(JFrame.MAXIMIZED_BOTH);
				crear.setVisible(true);
				dispose();
			}
		});
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCrear.setBackground(new Color(255, 204, 0));
		btnCrear.setBounds(365, 819, 179, 39);
		contentPane.add(btnCrear);
		
		
	}
}
