package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fechas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Fechas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Fechas Entrada y salida
		JDateChooser dateEntrada = new JDateChooser();
		dateEntrada.setBounds(93, 103, 160, 20);
		contentPane.add(dateEntrada);
		
		JDateChooser dateSalida = new JDateChooser();
		dateSalida.setBounds(93, 134, 160, 20);
		contentPane.add(dateSalida);

		JButton btnPrueba = new JButton("Prueba");
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dateEntrada.getDate().before(dateSalida.getDate())){
					Reservas reserva = new Reservas();
					reserva.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "No se puede reservar", getTitle(), JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnPrueba.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPrueba.setBounds(142, 189, 89, 23);
		contentPane.add(btnPrueba);
		
	}

}
