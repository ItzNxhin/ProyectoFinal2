package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import data.ReservasExistentes;
import logic.Reserva;
import logic.Usuario;

import javax.swing.JLabel;

public class VerFacturas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JLabel lblVerFacturas;
	JLabel lblPre;

	StringBuilder facturasStr = new StringBuilder();

	ArrayList<Reserva> reservitas = new ArrayList<>();
	ReservasExistentes r = new ReservasExistentes();

	/**
	 * Create the frame.
	 */
	public VerFacturas(Usuario current) throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblVerFacturas = new JLabel();
		lblVerFacturas.setBounds(10, 47, 414, 73);
		contentPane.add(lblVerFacturas);
		
		lblPre = new JLabel("");
		lblPre.setBounds(50, 250, 615, 407);
		


		try {
			reservitas = r.leer();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		int reservaCount = 1;

		/*
		 * Ciclo 'for' que se encarga de generar botones por cada Factura generado por el usuario.
		 * Se hace uso de JButtons generados de manera dinámica.
		 */
		for (Reserva factura : reservitas) {
			if (current.getEmail().equals(factura.getUsaurio().getEmail())) {
				JButton btnReserva = new JButton(reservaCount + "."  +  " Reserva " + factura.getFechaInicio() + " --- " +  factura.getFechaFin() + " ------ TOTAL: $" + factura.getTotal() );
				btnReserva.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnReserva.setBackground(new Color(255, 204, 0));
				btnReserva.setBounds(700, 250 + (reservaCount - 1) * 30, 500, 23);
				btnReserva.setHorizontalAlignment(JButton.LEFT);
				contentPane.add(btnReserva);
				
				btnReserva.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						if (factura.getHabitacion().getNombre().equals("Habitacion Presidencial")) {
							ImageIcon prev = new ImageIcon(VerFacturas.class.getResource("/img/habPresidencial.jpg"));
							Image preImg = prev.getImage();
							Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon imgFinal1 = new ImageIcon(prescaled);
							lblPre.setIcon(imgFinal1);
							contentPane.add(lblPre);	
							getLayeredPane().add(lblPre, Integer.valueOf(1));
						} else if (factura.getHabitacion().getNombre().equals("Habitacion Premium")) {
							ImageIcon prev = new ImageIcon(VerFacturas.class.getResource("/img/habPremium.jpg"));
							Image preImg = prev.getImage();
							Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon imgFinal1 = new ImageIcon(prescaled);
							lblPre.setIcon(imgFinal1);
							contentPane.add(lblPre);	
							getLayeredPane().add(lblPre, Integer.valueOf(1));				
						} else if (factura.getHabitacion().getNombre().equals("Habitacion Vip")) {
							ImageIcon prev = new ImageIcon(VerFacturas.class.getResource("/img/habVip.jpg"));
							Image preImg = prev.getImage();
							Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon imgFinal1 = new ImageIcon(prescaled);
							lblPre.setIcon(imgFinal1);
							contentPane.add(lblPre);	
							getLayeredPane().add(lblPre, Integer.valueOf(1));	
						} else if (factura.getHabitacion().getNombre().equals("Habitacion Lite")) {
							ImageIcon prev = new ImageIcon(VerFacturas.class.getResource("/img/habLite.jpeg"));
							Image preImg = prev.getImage();
							Image prescaled = preImg.getScaledInstance(lblPre.getWidth(), lblPre.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon imgFinal1 = new ImageIcon(prescaled);
							lblPre.setIcon(imgFinal1);
							contentPane.add(lblPre);	
							getLayeredPane().add(lblPre, Integer.valueOf(1));	
						}
						
					}
					
				});
				
				

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
		
		
		
		
		
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1350, 729);
		ImageIcon facturas = new ImageIcon(VerFacturas.class.getResource("/img/Facturasfondo.png"));
		Image facturasIcon = facturas.getImage();
		Image facturasScaled = facturasIcon.getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imgFinal = new ImageIcon(facturasScaled);
		lblFondo.setIcon(imgFinal);		
		contentPane.add(lblFondo);
	}
	
	// Método para mostrar la factura cuando se hace clic en un botón
    private void mostrarFactura(Reserva factura) {
        Factura facturaWindow = new Factura(factura.getUsaurio(), factura, factura.getUsaurio().getNombreUsuario());
        facturaWindow.setVisible(true);
        dispose();  // Cierra la ventana actual si es necesario
    }
    
   
    
}