package data;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logic.Reserva;

public class ReservasExistentes {

    public ArrayList<Reserva> leer() throws IOException, ClassNotFoundException{

        //2
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

    public void guardar(Reserva obj)throws IOException, ClassNotFoundException{

        ArrayList<Reserva> list = new ArrayList<>();
        try {
            list= leer();
        } catch (Exception e) {
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
    