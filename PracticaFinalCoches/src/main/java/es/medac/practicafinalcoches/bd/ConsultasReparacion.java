/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.bd;
import java.sql.*;
/**
 * Esta clase contiene los metodos para manipular los datos de la tabla Reparacion
 * @author AngelAdrian
 */
public class ConsultasReparacion {
    
    /**
    * Este metodo inserta una nueva columna a la tabla 
    * @param idCliente idCliente a insertar
    * @param idVehiculo idVehiculo a insertar
    * @param Descripcion Descripcion a insertar
    * @param Fecha Fecha a insertar
    * @param Tiempo Tiempo a insertar
    * @param totalReparacion El total de la reparacion a insertar
    * @return Regresa un indicador de que la consulta se realizo correctamente
    */
    public String InsertarReparacion(int idCliente, int idVehiculo, String Descripcion, String Fecha, int Tiempo, int totalReparacion){
        Conexionsql conexion = new Conexionsql();
        String consulta ="INSERT INTO reparacion(idCliente, idVehiculo, Descripcion, Fecha, Tiempo, totalReparacion) VALUES ('"+idCliente+"',"+"'"+idVehiculo+"',"+"'"+Descripcion+"',"+"'"+Fecha+"',"+"'"+Tiempo+"',"+"'"+totalReparacion+"' )";
        String mensaje;
        try{
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate();
            mensaje="Se ha insertado correctamente";
            ps.close();
        }catch(SQLException e){
            mensaje="Mal: "+e.getMessage();
        }
        
        return mensaje;
        }//fin del metodo
    
    /**
    * Este metodo modifica una campo de la columna, esta columna debe ser identificada mediante la condicion
    * @param campoCambio Campo que se busca modificar
    * @param valorMod Valor nuevo que sera introducido a la columna
    * @param condicion Condicion que buscara la columna segun la sentencia pasada
    * @return Regresa un indicador de que la consulta se realizo correctamente
    */
    public String ModificarReparacion(String campoCambio, String valorMod, String condicion){
        Conexionsql conexion = new Conexionsql();
        String consulta ="UPDATE reparacion set '"+campoCambio+"' = +'"+valorMod+"' where '"+condicion+"'";
        String mensaje;
        try{
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate();
            mensaje="Se ha modificado correctamente";
            ps.close();
        }catch(SQLException e){
            mensaje="Mal: "+e;
        }
        return mensaje;
    }
    
    /**
    * Este metodo busca las columnas que coincidan con el id del cliente en parametro
    * @param idCliente id del cliente de la reparacion a comparar
    * @return Regresa el resultado de la consulta SELECT
    */
    public String ReparacionXCliente(int idCliente) {
        Conexionsql conexion = new Conexionsql();
        String consulta = "SELECT * FROM reparacion where idCliente='"+idCliente+"'";
        String a="";
        try{
            PreparedStatement ps= conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            System.out.println("------TABLA Reparacion-------");
            while(rs.next()){
                a +=rs.getInt("idCliente")+"\t"+rs.getInt("idVehiculo")+"\t"+rs.getString("Descripcion")+"\t"+rs.getString("Fecha")+"\t"
                        +rs.getInt("Tiempo")+"\t"+rs.getInt("totalReparacion")+"\n";
                
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            a +="Error"+e;
        }
        return a;
    }//fin del metodo
    
    /**
    * Este metodo busca las columnas que coincidan con el idVehiculo en parametro
    * @param idVehiculo id del vehiculo a comparar
    * @return Regresa el resultado de la consulta SELECT
    */
    public String ReparacionXVehiculo(int idVehiculo) {
        Conexionsql conexion = new Conexionsql();
        String consulta = "SELECT * FROM reparacion where idVehiculo='"+idVehiculo+"'";
        String a="";
        try{
            PreparedStatement ps= conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            System.out.println("------TABLA Reparacion-------");
            while(rs.next()){
                a +=rs.getInt("idCliente")+"\t"+rs.getInt("idVehiculo")+"\t"+rs.getString("Descripcion")+"\t"+rs.getString("Fecha")+"\t"
                        +rs.getInt("Tiempo")+"\t"+rs.getInt("totalReparacion")+"\n";
                
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            a +="Error"+e;
    }
        return a;
    }//fin del metodo
    
    /**
    * Este metodo busca las columnas que coincidan con la fecha en parametro
    * @param Fecha fecha de la reparacion a comparar
    * @return Regresa el resultado de la consulta SELECT
    */
    public String ReparacionXFecha(String Fecha) {
        Conexionsql conexion = new Conexionsql();
        String consulta = "SELECT * FROM reparacion where Fecha='"+Fecha+"'";
        String a="";
        try{
            PreparedStatement ps= conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            System.out.println("------TABLA Reparacion-------");
            while(rs.next()){
                a +=rs.getInt("idCliente")+"\t"+rs.getInt("idVehiculo")+"\t"+rs.getString("Descripcion")+"\t"+rs.getString("Fecha")+"\t"
                        +rs.getInt("Tiempo")+"\t"+rs.getInt("totalReparacion")+"\n";
                
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            a +="Error"+e;
    }
        return a;
    }//fin del metodo
    
    
}//fin de la clase
