package logic;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Esta clase se encarga de poder almacenar los intervalos de fechas, y que habitacion tiene esa fecha 
 */
public class FechaReservas implements Serializable{

    private LocalDate inicio;
    private LocalDate fin;
    private HabAbstract habitacion;
    
    public FechaReservas(HabAbstract hab, LocalDate ini, LocalDate fin){
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

    public LocalDate getInicio() {
        return this.inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return this.fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
    
}
