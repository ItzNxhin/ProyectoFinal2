package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.GestorArchivo;
import logic.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiarContra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String contraseña;
	private String contraseña2;
	private JTextField textNewContra;
	private JTextField textConfirmaContra;
	
	ArrayList<Usuario> usuarios;

	/**
	 * Create the frame.
	 */
	public CambiarContra(int id, String currentPassword) {
		Usuario current = usuarios.get(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirma = new JLabel("Querido usuario, para cambiar su contrasela llene los siguientes campos:");
		lblConfirma.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblConfirma.setBounds(10, 11, 396, 36);
		contentPane.add(lblConfirma);
		
		textNewContra = new JTextField();
		textNewContra.setBounds(187, 79, 213, 20);
		contentPane.add(textNewContra);
		textNewContra.setColumns(10);
		
		textConfirmaContra = new JTextField();
		textConfirmaContra.setBounds(187, 134, 213, 20);
		contentPane.add(textConfirmaContra);
		textConfirmaContra.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Escriba su nueva contraseña");
		lblNewLabel.setBounds(27, 82, 150, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirma la contraseña");
		lblNewLabel_1.setBounds(27, 137, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cambiar contraseña");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contraseña = textNewContra.getText();
				contraseña2 = textConfirmaContra.getText();
				if (!contraseña.equals(contraseña2)) {
					JOptionPane.showMessageDialog(null, "La confirmación de la contraseña no coincide. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (contraseña.equals(currentPassword)) {
					JOptionPane.showMessageDialog(null, "Por favor, digite una contraseña diferente a la actual", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (contraseña.equals(contraseña2)){
					GestorArchivo.changePassword(id, contraseña);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(142, 203, 141, 23);
		contentPane.add(btnNewButton);
	}
}
