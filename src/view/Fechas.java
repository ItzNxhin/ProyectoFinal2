package view;

//Libreias
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

import data.*;
import logic.*;

public class Fechas extends JFrame  {

	//Ir a FechaReserva
	private ArrayList<FechaReservas> fechas = new ArrayList<>();
	private ReservasExistentes archFExistentes = new ReservasExistentes();
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

				if(dateEntrada.getDate().after(dateSalida.getDate())){
					JOptionPane.showMessageDialog(null, "No se puede reservar, la fecha de salida ocurre antes que la de entrada", getTitle(), JOptionPane.INFORMATION_MESSAGE);
				}
				else if(dateEntrada.getDate().before(new Date()) || dateSalida.getDate().before(new Date()) ){
					JOptionPane.showMessageDialog(null, "No se puede reservar, es imposible hacer una reservacion en el pasado", getTitle(), JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					Reservas reserva = new Reservas(dateEntrada.getDate(),dateSalida.getDate());
					reserva.setVisible(true);
					dispose();
					
				}
			}
		});
		btnPrueba.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPrueba.setBounds(142, 189, 89, 23);
		contentPane.add(btnPrueba);
		
	}

	public void leer() throws ClassNotFoundException, IOException{
		fechas = new ArrayList<>(archFExistentes.leer());
	}

}
