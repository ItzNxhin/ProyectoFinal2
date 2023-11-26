package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ManejoExc.PasswordExcepcion;
import ManejoExc.UserNotFoundExcepcion;
import logic.Usuario;
import view.Saludo;
//Se me olvido formatear el codigo antes de subirlo, puede que presente mala indentación
public class GestorArchivo {
	//El siguiente metodo se encarga de agregar los nuevos usuarios al archivo
	public static void agregarDatos (Usuario usuario) {
		try {
	        ArrayList<Usuario> usuarios;
	        File archivo = new File("DBUsers.ser");

		//Lectura del archivo y recuperacion de los datos en el ArrayList
	        if (archivo.exists() && archivo.length() > 0) {
	            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
	                usuarios = (ArrayList<Usuario>) in.readObject();
	            } catch (IOException | ClassNotFoundException e) {
	                e.printStackTrace();
	                usuarios = new ArrayList<>();
	            }
	        } else {
	            usuarios = new ArrayList<>();
	        }
		//Añade el nuevo usuario al ArrayList
	       usuarios.add(usuario);
		//Guarda el nuevo ArrayList que contiene la información del nuevo usuario y usuarios anteriores
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DBUsers.ser"))) {
	            out.writeObject(usuarios);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	//El siguiente metodo se encarga de iniciar sesión 
	public static boolean iniciarSesion(String correo, String contrasena) {
        try {
        	int id;
            	ArrayList<Usuario> usuarios;
            	File archivo = new File("DBUsers.ser");

            if (archivo.exists() && archivo.length() > 0) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                    usuarios = (ArrayList<Usuario>) in.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    usuarios = new ArrayList<>();
                }
            } else {
                usuarios = new ArrayList<>();
            }
	/*
 	Luego de leer el archivo y almacenar los datos tal como el metodo anterior, el programa empieza a recorrer el ArrayList
  	buscando un correo que coincida con el correo que se le paso como parametro, si el programa encuentra una coincidencia, 
   	pasa a evaluar la contraseña; si la contraseña es correcta guarda la posicion del usuario y crea la ventana "Saludo".
	*/
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);
                if (u.getEmail().equals(correo)) {
                    if (u.getContrasena().equals(contrasena)) {
                        id = i; // Inicio de sesión exitoso, se retorna la posición del usuario
                        Usuario current = usuarios.get(id);
                        Saludo ventana = new Saludo(current);
                        ventana.setVisible(true);
                        return true;
                    } else {
                        throw new PasswordExcepcion();
                    }
                }
            }
            throw new UserNotFoundExcepcion();
        } catch (PasswordExcepcion e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (UserNotFoundExcepcion e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return false;
    }
	//Metodo para verificar si un correo ya existen en la base de datos (Archivo serializable)
	public static boolean existeCorreo(String correo) {
        try {
            ArrayList<Usuario> usuarios;
            File archivo = new File("DBUsers.ser");

            if (archivo.exists() && archivo.length() > 0) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
		// Lee los usuarios almacenados en el archivo
                    usuarios = (ArrayList<Usuario>) in.readObject();
                } catch (IOException | ClassNotFoundException e) {
		// Si hay un error al leer el archivo, imprime el error y retorna false
                    e.printStackTrace();
                    return false;
                }
            } else {
		// Si el archivo no existe o está vacío, retorna false
                return false;
            }

            // Recorre el ArrayList para verificar si el correo ya existe
            for (Usuario u : usuarios) {
                if (u.getEmail().equals(correo)) {
		// Si encuentra una coincidencia, retorna true indicando que el correo ya existe
                    return true; 
                }
            }
	// Si no encuentra ninguna coincidencia, retorna false indicando que el correo no existe
            return false;
        } catch (Exception e) {
	// Si hay un error inesperado, imprime el error y retorna false
            e.printStackTrace();
            return false;
        }
    }
	//Metodo para cambiar la contraseña
	public static void changePassword (Usuario user, String contraseña) {
		try {
	        ArrayList<Usuario> usuarios;
	        File archivo = new File("DBUsers.ser");

		//Lectura del archivo y recuperacion de los datos en el ArrayList
	        if (archivo.exists() && archivo.length() > 0) {
	            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
	                usuarios = (ArrayList<Usuario>) in.readObject();
	            } catch (IOException | ClassNotFoundException e) {
	                e.printStackTrace();
	                usuarios = new ArrayList<>();
	            }
	        } else {
	            usuarios = new ArrayList<>();
	        }

	        for(Usuario k : usuarios){
				if(k.getEmail().equals(user.getEmail())){
					k.setContrasena(contraseña);
				}
			}
	       JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito", "Atención",
					JOptionPane.INFORMATION_MESSAGE);
	       Saludo ventana = new Saludo(user);
           ventana.setVisible(true);
		//Guarda el nuevo ArrayList que contiene la información del nuevo usuario y usuarios anteriores
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DBUsers.ser"))) {
	            out.writeObject(usuarios);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

