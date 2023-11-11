package view;

//Libreias
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

public class Fechas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Esta ventana se encarga de pedir las fechas de reservacion del hotel
	 * Donde se ingresan las fechas con una libriaria Referecial(JCalendar) para un mejor manejo
	 * Las fechas se comprueban que sean posibles, es decir, que sea la salida despues que la entrada, y que sea posterior a la fecha de hoy
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

		//Boton para reservar
		JButton btnPrueba = new JButton("Prueba");
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dateEntrada.getDate().before(dateSalida.getDate())){
					Reservas reserva = new Reservas();
					reserva.setVisible(true);
					reserva.setDates(dateEntrada.getDate(),dateSalida.getDate());
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
