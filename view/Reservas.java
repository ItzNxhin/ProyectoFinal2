package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Reservas() {
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
				JOptionPane.showMessageDialog(null, dateEntrada.getDate(), getTitle(), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnPrueba.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPrueba.setBounds(142, 189, 89, 23);
		contentPane.add(btnPrueba);

		JButton btnReservar = new JButton("Realizar reserva");
		btnReservar.addActionListener(new ActionListener() {
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
	
    // Métodos para obtener la habitación seleccionada y las fechas de inicio/fin
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
