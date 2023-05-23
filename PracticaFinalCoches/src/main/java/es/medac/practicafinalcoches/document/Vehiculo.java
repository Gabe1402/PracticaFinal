/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.document;

/**
 * Clase que refleja la tabla Vehiculo de la BD
 * @author bapsy
 */
public class Vehiculo {
    private int IdVehiculo;
    private String Matricula;
    private String Marca;
    private String Modelo;
    private String Anio;
    private String Color;
    
    
    public Vehiculo(){
        super();
        this.IdVehiculo=IdVehiculo;
        this.Matricula=Matricula;
        this.Marca= Marca;   
        this.Modelo=Modelo;
        this.Anio=Anio;
        this.Color=Color;     
    }
    
    public Vehiculo(int IdVehiculo,String Matricula,String Marca, String Modelo, String Anio, String Color){
        super();
        this.IdVehiculo=IdVehiculo;
        this.Matricula=Matricula;
        this.Marca= Marca;   
        this.Modelo=Modelo;
        this.Anio=Anio;
        this.Color=Color; 
    }
    public int getIdVehiculo (){
        return IdVehiculo;
    }
     public String getMatricula(){
        return Matricula;
    }
    public String getModelo(){
        return Modelo;
    }
    public String getAnio(){
        return Anio;
    }
    public String getColor(){
        return Color;
    }
    
    public void setIdVehiculo( int IdVehiculo){
        this.IdVehiculo=IdVehiculo;
    }
    public void setmatricula( String Matricula){
        this.Matricula= Matricula;
    }
    public void setModelo( String Modelo){
        this.Modelo= Modelo;
    }
    public void setAnio( String Anio){
        this.Anio= Anio;
    }
    public void setColor( String Color){
        this.Color= Color;
    }
    
    @Override
    public String toString(){
        
        return "IdVehiculo "+IdVehiculo+" la matricula es "+Matricula+" modelo "+ Modelo + " el año es " + Anio+ " el color es "+ Color ;
        
    }
}
