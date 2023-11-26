package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio ();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVolver.setBackground(new Color(255, 204, 0));
		btnVolver.setBounds(36, 605, 120, 50);
		contentPane.add(btnVolver);
		
		JButton btnNewButton = new JButton("Crear cuenta ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearUsuario crear = new VentanaCrearUsuario();
				crear.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setBounds(189, 605, 159, 50);
		contentPane.add(btnNewButton);

		// Cargar la imagen y configurar el fondo
		ImageIcon imagenFondo = new ImageIcon("src/img/backgroundInfo.png");
		Image img = imagenFondo.getImage();
		Image imgEscalada = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);
		JLabel etiquetaFondo = new JLabel(imagenEscalada);
		etiquetaFondo.setBounds(0, 0, getWidth(), getHeight());
		((JPanel) getContentPane()).setOpaque(false);
		contentPane.add(etiquetaFondo);
				
	}

}
