package logic;

import java.util.Date;
import java.io.Serializable;
/**
 * Esta clase se encarga de poder almacenar los intervalos de fechas, y que habitacion tiene esa fecha 
 */
public class FechaReservas implements Serializable{

    private Date inicio;
    private Date fin;
    private HabAbstract habitacion;
    
    public FechaReservas(HabAbstract hab, Date ini, Date fin){
        this.inicio = ini;
        this.fin= fin;
        this.habitacion = hab;
        }
   
    public HabAbstract getHabitacion() {
        return this.habitacion;
    }

    public void setHabitacion(HabAbstract habitacion) {
        this.habitacion = habitacion;
    }

    public Date getInicio() {
        return this.inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return this.fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
    
}
