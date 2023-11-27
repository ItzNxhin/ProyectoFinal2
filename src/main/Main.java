/**
 * Este es un programa para manejar las reservas de un hotel
 * Se hace uso del paradigma de Programacion orientada a objetos
 * Con interfaz grafica y manejo de archivos
 * 
 * @autor Nahin Peñaranda, Juan Arismendi, Juan Bedoya
 */
package main;

import view.*;
import java.awt.EventQueue;


/**
 * Esta es la clase principal que inicia la aplicación.
 */
public class Main  {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				VentanaInicio frame = new VentanaInicio();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
		
	}

     

    
