package view;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.ReservasExistentes;
import logic.Reserva;
import logic.Usuario;

import javax.swing.JLabel;

public class VerFacturas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JLabel lblVerFacturas;

	StringBuilder facturasStr = new StringBuilder();

	ArrayList<Reserva> reservitas = new ArrayList<>();
	ReservasExistentes r = new ReservasExistentes();

	/**
	 * Create the frame.
	 */
	public VerFacturas(Usuario current) throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblVerFacturas = new JLabel();
		lblVerFacturas.setBounds(10, 47, 414, 73);
		contentPane.add(lblVerFacturas);

		try {
			reservitas = r.leer();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		//Recorre todo el array de lasreservas y verifica cual reserva corresponde con cual usuario
		for (Reserva factura : reservitas) {         
            
			if (current.getEmail().equals(factura.getUsaurio().getEmail())) {
				facturasStr.append("Factura: ").append(factura.getHabitacion().getNombre()).append(", Total: ")
						.append(factura.getTotal()).append("<br>").append("Nombre usuario:")
						.append(current.getNombreUsuario()).append("<br>");
			}

		}

		
		lblVerFacturas.setText("<html>" + facturasStr.toString() + "</html>");

	}

}
