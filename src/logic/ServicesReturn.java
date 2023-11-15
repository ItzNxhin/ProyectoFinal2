package logic;

import java.util.ArrayList;

public class ServicesReturn {
    public ServicesReturn(){}
    public ArrayList<Services> SerPorDefecto(HabAbstract hab){
        ArrayList<Services> servicios = new ArrayList<>();
        if(hab.getNombre().equals("Habitacion Presidencial")){
            servicios.add(new SerBuffet());
            servicios.add(new SerLavanderia());
            servicios.add(new SerBarraLibre());
        }
        else if(hab.getNombre().equals("Habitacion Premium")){
            servicios.add(new SerBuffet());
            servicios.add(new SerLavanderia());
        }
        else if(hab.getNombre().equals("Habitacion Vip")){
            servicios.add(new SerBuffet());
        }
        return servicios;
    }
    
}
