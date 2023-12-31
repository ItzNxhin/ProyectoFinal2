package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Esta clase se encarga de mostrar la ventana de la informacion de los servicios
 */
public class InfoServicios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Ventana
	 */
	public InfoServicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(153, 102, 51));
		btnNewButton.setBounds(1251, 11, 89, 23);
		contentPane.add(btnNewButton);

		// Cargar la imagen y configurar el fondo
		ImageIcon imagenFondo = new ImageIcon(InfoServicios.class.getResource("/img/servicios.png"));
		Image img = imagenFondo.getImage();
		Image imgEscalada = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);
		JLabel etiquetaFondo = new JLabel(imagenEscalada);
		etiquetaFondo.setBounds(0, 0, getWidth(), getHeight());
		((JPanel) getContentPane()).setOpaque(false);
		contentPane.add(etiquetaFondo);
	}

}
