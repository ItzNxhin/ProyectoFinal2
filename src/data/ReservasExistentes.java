package data;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logic.Reserva;


/**
 * Esta clase gestiona las reservas existentes almacenadas en un archivo.
 */
public class ReservasExistentes {

	
	/**
     * Este método lee las reservas existentes del archivo.
     * @return Una lista de reservas.
     * @throws IOException Si ocurre un error de entrada/salida.
     * @throws ClassNotFoundException Si no se encuentra la clase Reserva.
     */
    public ArrayList<Reserva> leer() throws IOException, ClassNotFoundException{

        
        ArrayList<Reserva> list = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream("Fechas.ser");
        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){    
            while (true) {
                Reserva persona = (Reserva) objectInputStream.readObject();
                list.add(persona);
            }    
        }
        catch (EOFException e) {
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //3
        return list;
    }

    
    /**
     * Este método guarda una nueva reserva en el archivo.
     * @param obj La reserva a guardar.
     * @throws IOException Si ocurre un error de entrada/salida.
     * @throws ClassNotFoundException Si no se encuentra la clase Reserva.
     */
    public void guardar(Reserva obj)throws IOException, ClassNotFoundException{

        ArrayList<Reserva> list = new ArrayList<>();
        try {
        	list = leer();
        }catch (Exception e) {
        }
        list.add(obj);
        FileOutputStream fileOutputStream = new FileOutputStream("Fechas.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        if(!list.isEmpty()){
            for(int i = 0; i < list.size(); i++){
                objectOutputStream.writeObject(list.get(i));
        }}
        objectOutputStream.close();
        
    }


    
}
    