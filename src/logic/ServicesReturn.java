package logic;

import java.util.ArrayList;

/**
 * Esta clase devuelve los servicios por defecto para cada tipo de habitación.
 */
public class ServicesReturn {
	
	//Constructor por defecto
    public ServicesReturn(){}
    
    /**
     * Este método devuelve los servicios por defecto para un tipo de habitación dado.
     * @param hab El tipo de habitación.
     * @return Una lista de servicios por defecto para el tipo de habitación dado.
     */
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
