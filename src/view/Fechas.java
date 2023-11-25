package view;

//Libreias
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.io.FileNotFoundException;
import java.util.Date;

import com.toedter.calendar.JDateChooser;


import logic.Usuario;
import java.awt.Color;
import java.awt.Font;

public class Fechas extends JFrame  {

	//Ir a FechaReserva
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Esta ventana se encarga de pedir las fechas de reservacion del hotel
	 * Donde se ingresan las fechas con una libriaria Referecial(JCalendar) para un mejor manejo
	 * Las fechas se comprueban que sean posibles, es decir, que sea la salida despues que la entrada, y que sea posterior a la fecha de hoy
	 */
	public Fechas(Usuario current) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setFont(new Font("Arvo", Font.BOLD, 18));
		btnCancelar.setBackground(new Color(255, 205, 8));
		btnCancelar.setBounds(650, 570, 160, 54);
		contentPane.add(btnCancelar);

		//Fechas Entrada y salida
		JDateChooser dateEntrada = new JDateChooser();
		dateEntrada.setForeground(new Color(0, 0, 0));
		dateEntrada.setBounds(881, 388, 300, 37);
		contentPane.add(dateEntrada);
		
		JDateChooser dateSalida = new JDateChooser();
		dateSalida.setBounds(881, 473, 300, 37);
		contentPane.add(dateSalida);

		//Boton para reservar
		JButton btnPrueba = new JButton("SIGUIENTE");
		btnPrueba.setForeground(new Color(0, 0, 0));
		btnPrueba.setBackground(new Color(255, 205, 8));
		btnPrueba.setFont(new Font("Arvo", Font.BOLD, 18));
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dateEntrada.getDate().after(dateSalida.getDate())){
					JOptionPane.showMessageDialog(null, "No se puede reservar, la fecha de salida ocurre antes que la de entrada", getTitle(), JOptionPane.INFORMATION_MESSAGE);
				}
				else if(dateEntrada.getDate().before(new Date()) || dateSalida.getDate().before(new Date()) ){
					JOptionPane.showMessageDialog(null, "No se puede reservar, es imposible hacer una reservacion en el pasado", getTitle(), JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					Reservas reserva;
					try {
						reserva = new Reservas(dateEntrada.getDate(),dateSalida.getDate(), current);
						reserva.setVisible(true);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
			}
		});
		btnPrueba.setBounds(991, 570, 160, 54);
		contentPane.add(btnPrueba);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1264, 681);
		ImageIcon factura = new ImageIcon(Fechas.class.getResource("/img/fechas.png"));
        Image facturaIcon = factura.getImage();
        Image facturaScaled = facturaIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgFinal = new ImageIcon(facturaScaled);
        lblNewLabel.setIcon(imgFinal);
		contentPane.add(lblNewLabel);	
		
	}
}
