/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.document;

/**
 *
 * @author Usuario
 */
public class reparacion {
    int idCliente;
    int idVehiculo;
    String Descripcion;
    String Fecha;
    int Tiempo;
    int totalReparacion;
   
    public reparacion(){
        this.idCliente=0;
        this.idVehiculo=0;
        this.Descripcion="";
        this.Fecha="";
        this.Tiempo=0;
        this.totalReparacion=0;
    }

    public reparacion(int idCliente, int idVehiculo, String Descripcion, String Fecha, int Tiempo, int totalReparacion) {
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
        this.Tiempo = Tiempo;
        this.totalReparacion = totalReparacion;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public int getIdVehiculo() {
        return this.idVehiculo;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public int getTiempo() {
        return this.Tiempo;
    }

    public int getTotalReparacion() {
        return this.totalReparacion;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    public void setTotalReparacion(int totalReparacion) {
        this.totalReparacion = totalReparacion;
    }
    
    
    
}
