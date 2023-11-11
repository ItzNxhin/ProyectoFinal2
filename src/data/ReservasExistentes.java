package data;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logic.FechaReservas;

public class ReservasExistentes {

    public ArrayList<FechaReservas> leer(String ruta) throws IOException, ClassNotFoundException{

        //2
        ArrayList<FechaReservas> list = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream("Fechas.ser");
        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){    
            while (true) {
                FechaReservas persona = (FechaReservas) objectInputStream.readObject();
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

    public void guardar(String ruta, ArrayList<FechaReservas> lista)throws IOException, ClassNotFoundException{
        FileOutputStream fileOutputStream = new FileOutputStream("Fechas.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        if(!lista.isEmpty()){
            for(int i = 0; i < lista.size(); i++){
                objectOutputStream.writeObject(lista.get(i));
        }}
        objectOutputStream.close();
        
    }


    
}
    