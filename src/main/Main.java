/**
 * Este es un programa para manejar las reservas de un hotel
 * Se hace uso del paradigma de Programacion orientada a objetos
 * Con interfaz grafica y manejo de archivos
 * 
 * @autor Juan Pérez, María Gómez, Carlos Rodríguez
 */
package main;

import view.*;
import java.awt.EventQueue;

public class Main  {
    EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			VentanaInicio frame = new VentanaInicio();
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	});
}

     
}
    
