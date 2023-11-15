package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;


import logic.*;
/**
* Esta clase se encarga de terminar la reservación
* Donde se eligen los servicios que se quieran añadir o quitar
* Una vez el usuario termine detalles, se le confirma y se genera factura
* Y por último, se guarda en el archivo de reservaciones
*/
public class VentanaHabitacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean servicio1Seleccionado = false;
    private boolean servicio2Seleccionado = false;
    private boolean servicio3Seleccionado = false;
    private double valorServicio1 = 0;
    private double valorServicio2 = 0;
    private double valorServicio3 = 0;
    private long dias;

	private ArrayList<Services> servicios = new ArrayList<>();

	LocalDate fechaInicio;
	LocalDate fechaFin;


    //Falta añadir el ID o el tipo de la habitacón para obtener la imagen y el precio por noche
	public VentanaHabitacion (Usuario current, Reserva preReserva) {
		// Operaciones de inicio de ventana

		fechaInicio = preReserva.getFechaInicio();
		fechaFin 	= preReserva.getFechaFin();

		//Obtener los servicios por defecto de cada de habitacion
		ServicesReturn serviciosDefecto = new ServicesReturn();
		servicios = new ArrayList<>(serviciosDefecto.SerPorDefecto(preReserva.getHabitacion()));

	    // Calcular la diferencia entre las fechas
	    Period periodo = Period.between(fechaInicio, fechaFin);
	    // Obtener la cantidad de días del periodo
	    dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola usuario: "+current.getNombreUsuario());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 238, 33);
		contentPane.add(lblNewLabel);
		
		//Colocar condicional para el tipo de habitacion!!!!
		JLabel Imagen = new JLabel();
		Imagen.setBounds(10, 55, 191, 138);
		ImageIcon img1 = new ImageIcon("src/img/room1.jpg");
		Image imgIns = img1.getImage();
		Image newImg = imgIns.getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon finalImage = new ImageIcon(newImg);
		Imagen.setIcon(finalImage);
		contentPane.add(Imagen);
		
		JLabel lblNewLabel_1 = new JLabel("FechaCheck-In: "+fechaInicio);
		lblNewLabel_1.setBounds(229, 35, 179, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FechaCheck-Out: "+fechaFin);
		lblNewLabel_2.setBounds(229, 55, 179, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblMostrarValorR = new JLabel("New label");
		lblMostrarValorR.setBounds(359, 75, 46, 14);
		contentPane.add(lblMostrarValorR);
		
		JLabel lblMostrarTotal = new JLabel("New label");
		lblMostrarTotal.setBounds(359, 279, 46, 14);
		contentPane.add(lblMostrarTotal);
		
	    /*
	     * CalculadoraPrecios.ValorReserva(dias, precioXnoche)
	     * Cambiar el valor del total y del valor de la reserva
		*/
		JLabel lblMostrarValorS1 = new JLabel("$: "+valorServicio1);
		lblMostrarValorS1.setBounds(359, 100, 65, 14);
		contentPane.add(lblMostrarValorS1);
		
		JLabel lblMostrarValorS2 = new JLabel("$: "+valorServicio2);
		lblMostrarValorS2.setBounds(359, 126, 46, 14);
		contentPane.add(lblMostrarValorS2);
		
		JLabel lblMostrarValorS3 = new JLabel("$: "+valorServicio3);
		lblMostrarValorS3.setBounds(362, 152, 46, 14);
		contentPane.add(lblMostrarValorS3);
		
		JLabel lblMostrarValorS3_1 = new JLabel("$: 0");
		lblMostrarValorS3_1.setBounds(362, 177, 46, 14);
		contentPane.add(lblMostrarValorS3_1);
		
		JLabel lblMostrarValorS3_1_1 = new JLabel("$: 0");
		lblMostrarValorS3_1_1.setBounds(362, 203, 46, 14);
		contentPane.add(lblMostrarValorS3_1_1);
		
		JLabel lblMostrarValorS3_1_1_1 = new JLabel("$: 0");
		lblMostrarValorS3_1_1_1.setBounds(362, 228, 46, 14);
		contentPane.add(lblMostrarValorS3_1_1_1);
		
		JCheckBox servicio1 = new JCheckBox("Servicio1");
		servicio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                servicio1Seleccionado = servicio1.isSelected();
                valorServicio1 =CalculadoraPrecios.ValorServicio1(servicio1Seleccionado, dias);
                lblMostrarValorS1.setText("$: " + valorServicio1);
            }
        });
		servicio1.setBounds(229, 96, 97, 23);
		contentPane.add(servicio1);
		
		JCheckBox servicio2 = new JCheckBox("Servicio2");
		servicio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                servicio2Seleccionado = servicio2.isSelected();
                valorServicio2 =CalculadoraPrecios.ValorServicio2(servicio1Seleccionado, dias);
                lblMostrarValorS2.setText("$: " + valorServicio2);
            }
        });
		servicio2.setBounds(229, 122, 97, 23);
		contentPane.add(servicio2);
		
		JCheckBox servicio3 = new JCheckBox("Servicio3");
		servicio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                servicio3Seleccionado = servicio3.isSelected();
                valorServicio3 =CalculadoraPrecios.ValorServicio3(servicio1Seleccionado, dias);
                lblMostrarValorS3.setText("$: " + valorServicio3);
            }
        });
		servicio3.setBounds(229, 148, 97, 23);
		contentPane.add(servicio3);

		JCheckBox chckbxServicio = new JCheckBox("Servicio4");
		chckbxServicio.setBounds(229, 173, 97, 23);
		contentPane.add(chckbxServicio);

		JCheckBox chckbxServicio_2 = new JCheckBox("Servicio5");
		chckbxServicio_2.setBounds(229, 199, 97, 23);
		contentPane.add(chckbxServicio_2);

		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Crear el objeto reserva/recibo con los respectivos valores
			}
		});
		btnNewButton.setBounds(284, 315, 89, 23);
		contentPane.add(btnNewButton);

		JCheckBox chckbxServicio_1_1 = new JCheckBox("Servicio6");
		chckbxServicio_1_1.setBounds(229, 224, 97, 23);
		contentPane.add(chckbxServicio_1_1);
		
		JLabel precioReserva = new JLabel("Valor de reserva:");
		precioReserva.setBounds(229, 75, 97, 14);
		contentPane.add(precioReserva);
		
		JLabel lblNewLabel_3 = new JLabel("Total a pagar:");
		lblNewLabel_3.setBounds(229, 279, 97, 14);
		contentPane.add(lblNewLabel_3);
		
	}
}
