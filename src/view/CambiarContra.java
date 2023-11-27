package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.GestorArchivo;
import logic.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Esta ventana se encarga de cambiar la contraseña del usuario
 */
public class CambiarContra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String contraseña;
	private String contraseña2;
	private JTextField textNewContra;
	private JTextField textConfirmaContra;
	private JTextField textFieldContraActual;
	private int k=0;
	private JLabel lblNombre;
	private JLabel lblEmail;

	/**
	 * Esta ventana se encarga de cambiar la contraseña del usuario
	 * @param usuario Usuario
	 */
	public CambiarContra(Usuario usuario) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280,720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEmail = new JLabel(""+usuario.getEmail());
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arvo", Font.BOLD, 18));
		lblEmail.setBounds(210, 522, 377, 36);
		contentPane.add(lblEmail);

		lblNombre = new JLabel(""+usuario.getNombreUsuario());
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arvo", Font.BOLD, 18));
		lblNombre.setBounds(210, 475, 377, 36);
		contentPane.add(lblNombre);
		
		JLabel lblConfirma = new JLabel("Querido usuario, para cambiar su contraseña llene los siguientes campos:");
		lblConfirma.setForeground(new Color(255, 255, 255));
		lblConfirma.setFont(new Font("Arvo", Font.BOLD, 18));
		lblConfirma.setBounds(497, 223, 788, 36);
		contentPane.add(lblConfirma);

		textFieldContraActual = new JTextField();
		textFieldContraActual.setFont(new Font("Arvo", Font.BOLD, 36));
		textFieldContraActual.setColumns(10);
		textFieldContraActual.setBounds(887, 297, 326, 36);
		contentPane.add(textFieldContraActual);
		
		textNewContra = new JTextField();
		textNewContra.setFont(new Font("Arvo", Font.BOLD, 36));
		textNewContra.setBounds(887, 367, 326, 36);
		contentPane.add(textNewContra);
		textNewContra.setColumns(10);
		
		textConfirmaContra = new JTextField();
		textConfirmaContra.setFont(new Font("Arvo", Font.BOLD, 36));
		textConfirmaContra.setBounds(887, 439, 326, 36);
		contentPane.add(textConfirmaContra);
		textConfirmaContra.setColumns(10);
		
		JButton btnNewButton = new JButton("Cambiar contraseña");
		btnNewButton.setBackground(new Color(255, 205, 8));
		btnNewButton.setFont(new Font("Arvo", Font.BOLD, 36));
		btnNewButton.addActionListener(new ActionListener() {
			/*
			 * Con este metodo, confirmamos que se posible cambiar la contraseña; Que la nueva no sea la misma que la actual,
			 * que la nueva contraseña y la confimacion sean las mismas, si no hay ningun error, pasa la nueva contraseña y el usuario a la clase
			 * encargada
			 */
			public void actionPerformed(ActionEvent e) {
				contraseña = textNewContra.getText();
				contraseña2 = textConfirmaContra.getText();
				if(k==3){
					JOptionPane.showMessageDialog(null, "Haz fallado 3 veces colocando tu contraseña actual, vuelve a iniciar sesion.", "Error", JOptionPane.ERROR_MESSAGE);
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
					dispose();
				}
				else if(!textFieldContraActual.getText().equals(usuario.getContrasena())){
					JOptionPane.showMessageDialog(null, "La contraseña actual no coincide, vuelve a intentar", "Error", JOptionPane.ERROR_MESSAGE);
					k++;
				}
				else if (!contraseña.equals(contraseña2)) {
					JOptionPane.showMessageDialog(null, "La confirmación de la contraseña no coincide. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (contraseña.equals(usuario.getContrasena())) {
					JOptionPane.showMessageDialog(null, "Por favor, digite una contraseña diferente a la actual", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (contraseña.equals(contraseña2)){
					GestorArchivo.changePassword(usuario, contraseña);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(597, 541, 451, 53);
		contentPane.add(btnNewButton);

		//Fondo
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1264, 681);
		ImageIcon factura = new ImageIcon(CambiarContra.class.getResource("/img/contra.png"));
        Image facturaIcon = factura.getImage();
        Image facturaScaled = facturaIcon.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
       	ImageIcon imgFinal = new ImageIcon(facturaScaled);
        fondo.setIcon(imgFinal);
		contentPane.add(fondo);
		
	}
}
