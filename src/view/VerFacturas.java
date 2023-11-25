package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
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

		int reservaCount = 1;

		// Recorre todo el array de lasreservas y verifica cual reserva corresponde con
		// cual usuario
		for (Reserva factura : reservitas) {
			if (current.getEmail().equals(factura.getUsaurio().getEmail())) {
				JButton btnReserva = new JButton("Reserva " + reservaCount);
				btnReserva.setBounds(10, 10 + (reservaCount - 1) * 30, 120, 23);
				contentPane.add(btnReserva);

				// Asociar ActionListener al botón
				btnReserva.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mostrarFactura(factura);
					}
				});

				reservaCount++;
			}
		}
	}
	
	// Método para mostrar la factura cuando se hace clic en un botón
    private void mostrarFactura(Reserva factura) {
        Factura facturaWindow = new Factura(factura.getUsaurio(), factura, factura.getUsaurio().getNombreUsuario());
        facturaWindow.setVisible(true);
        dispose();  // Cierra la ventana actual si es necesario
    }
	
}
