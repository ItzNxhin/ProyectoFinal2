package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.HabAbstract;
import logic.Reserva;
import logic.Usuario;

import javax.swing.JLabel;

public class Factura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private HabAbstract habitacion;
	
	Reserva reservacion = new Reserva();




	/**
	 * Esta ventana se encargará de mostrar la factura con los pagos totales al usuario
	 */
	public Factura(Usuario current, String tipoHabitacion, double precioHabitacion, double servicios, String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHabitacion = new JLabel("Tipo de habitación: " + tipoHabitacion);
		lblHabitacion.setBounds(48, 129, 345, 14);
		contentPane.add(lblHabitacion);
		
		JLabel lblValorReserva = new JLabel("Valor de la reserva: $" + precioHabitacion);
		lblValorReserva.setBounds(48, 160, 202, 14);
		contentPane.add(lblValorReserva);
		
		JLabel lblValorServicios = new JLabel("Valor de los servicios: $" + servicios );
		lblValorServicios.setBounds(48, 199, 202, 14);
		contentPane.add(lblValorServicios);
		
		JLabel lblTotalPagar = new JLabel("Total pagado: $" + (precioHabitacion + servicios));
		lblTotalPagar.setBounds(48, 237, 202, 14);
		contentPane.add(lblTotalPagar);
		
		JLabel lblNombre = new JLabel("Nombre: " + nombre);
		lblNombre.setBounds(48, 94, 292, 14);
		contentPane.add(lblNombre);
	}
}
