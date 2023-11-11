package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.GestorReservas;
import logic.HabAbstract;
import logic.Usuario;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

import java.util.Date;

public class Reservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Date entrada;
	private Date salida;

	public Reservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JButton btnReservar = new JButton("Realizar reserva");
			btnReservar.addActionListener(new ActionListener() {
				private Usuario usuarioActual;

				public void actionPerformed(ActionEvent e) {
					// Obtén la habitación seleccionada y las fechas de inicio/fin
					HabAbstract habitacionSeleccionada = obtenerHabitacionSeleccionada();
					LocalDate fechaInicio = obtenerFechaInicio();
					LocalDate fechaFin = obtenerFechaFin();

					// Realiza la reserva
					if (habitacionSeleccionada != null && fechaInicio != null && fechaFin != null) {
						GestorReservas.realizarReserva(usuarioActual, habitacionSeleccionada, fechaInicio, fechaFin);
						JOptionPane.showMessageDialog(null, "Reserva realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, complete la información de reserva", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			contentPane.setLayout(null);
			btnReservar.setBounds(160, 207, 111, 23);
			contentPane.add(btnReservar);
		
	}

	//ha cambiado
	//Prueba 2
	// Métodos para obtener la habitación seleccionada y las fechas de inicio/fin

	public void setDates(Date entrada, Date salida){
		this.entrada = entrada;
		this.salida = salida;

	}

    private HabAbstract obtenerHabitacionSeleccionada() {
		return null;
        // Lógica para obtener la habitación seleccionada desde la interfaz
    }

    private LocalDate obtenerFechaInicio() {
		return null;
        // Lógica para obtener la fecha de inicio desde la interfaz
    }

    private LocalDate obtenerFechaFin() {
		return null;
        // Lógica para obtener la fecha de fin desde la interfaz
    }

	 
}
