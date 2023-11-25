package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.HabAbstract;
import logic.Reserva;
import logic.Usuario;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Factura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private HabAbstract habitacion;
	
	Reserva reservacion = new Reserva();




	/**
	 * Esta ventana se encargará de mostrar la factura con los pagos totales al usuario
	 * String tipoHabitacion, double precioHabitacion, double servicios, String nombre
	 * current, habitacion.getNombre(), habitacion.getPrecio(), totalServicios, textNombre.getText()
	 */
	public Factura(Usuario current, Reserva reserva, String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHabitacion = new JLabel("Tipo de habitación: " + reserva.getHabitacion().getNombre());
		lblHabitacion.setBounds(48, 129, 345, 14);
		contentPane.add(lblHabitacion);
		
		JLabel lblValorReserva = new JLabel("Valor de la reserva: $" + reserva.getPrecioReserva());
		lblValorReserva.setBounds(48, 160, 345, 14);
		contentPane.add(lblValorReserva);
		
		JLabel lblValorServicios = new JLabel("Valor de los servicios adicionales: $" + reserva.getPrecioServicesAdd() );
		lblValorServicios.setBounds(48, 199, 345, 14);
		contentPane.add(lblValorServicios);
		
		JLabel lblTotalPagar = new JLabel("Total pagado: $" + reserva.getTotal());
		lblTotalPagar.setBounds(48, 237, 202, 14);
		contentPane.add(lblTotalPagar);
		
		JLabel lblNombre = new JLabel("Nombre: " + nombre);
		lblNombre.setBounds(48, 94, 292, 14);
		contentPane.add(lblNombre);
		
		JButton btnTerminar = new JButton("Volver a la ventana principal");
		btnTerminar.setBounds(150, 294, 89, 23);
		contentPane.add(btnTerminar);
	}
}
