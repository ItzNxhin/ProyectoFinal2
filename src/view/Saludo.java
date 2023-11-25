package view;

//Libreias
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

//Clase Externa
import logic.Usuario;

public class Saludo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Saludo(Usuario current) {
		
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Saludo usuario
		JLabel lblNewLabel = new JLabel("Hola usuario: " + current.getNombreUsuario());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(106, 11, 238, 33);
		contentPane.add(lblNewLabel);
		
		//Boton reservar
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fechas fechas = new Fechas(current);
				fechas.setVisible(true);
				dispose();
			}
		});
		btnReservar.setBounds(177, 190, 89, 23);
		
		
		contentPane.add(btnReservar);
		
		JButton btnNewButton = new JButton("Ver reservas (Facturas)");
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
		btnNewButton.setBounds(65, 190, 89, 23);
		contentPane.add(btnNewButton);
		/*
		JButton btnCambiarContrasea = new JButton("Cambiar contraseña");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPassword = current.getContraseña();
				CambiarContra cambiar = new CambiarContra(id, currentPassword);
				cambiar.setVisible(true);
				dispose();
			}
		});
		btnCambiarContrasea.setBounds(276, 190, 89, 23);
		contentPane.add(btnCambiarContrasea);
		 * 
		 */
		

	}
}
