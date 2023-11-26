package data;

import java.io.IOException;
import java.util.ArrayList;

import logic.Reserva;

public class test {
    public static void main(String[] args) {
        ArrayList<Reserva> cositas = new ArrayList<>();

        ReservasExistentes cosa = new ReservasExistentes();
        try {
            cositas=cosa.leer();
        } catch (ClassNotFoundException | IOException e) {
            
            e.printStackTrace();
        }

        for(Reserva i : cositas){
            System.out.println(i.getUsaurio().getEmail() +" "+ i.getHabitacion().getNombre() + " " + i.getFechaInicio() +" " + i.getFechaFin() );
        }
    }
    
}
