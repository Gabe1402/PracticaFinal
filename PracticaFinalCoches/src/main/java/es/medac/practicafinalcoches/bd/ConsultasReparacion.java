/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.bd;
import java.sql.*;
/**
 *
 * @author Usuario
 */
public class ConsultasReparacion {
    

    public String InsertarReparacion(int idCliente, int idVehiculo, String Descripcion, String Fecha, int Tiempo, int totalReparacion){
        Conexionsql conexion = new Conexionsql();
        String consulta ="INSERT INTO reparacion(idCliente, idVehiculo, Descripcion, Fecha, Tiempo, totalReparacion) VALUES"+"("+idCliente+","+"'"+idVehiculo+"',"+"'"+Descripcion+"',"+"'"+Fecha+"',"+"'"+Tiempo+"',"+"'"+totalReparacion+"' )";
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
        }
    public String ModificarReparacion(int idCliente, int idVehiculo, String Descripcion, String Fecha, int Tiempo, int totalReparacion, int num){
        Conexionsql conexion = new Conexionsql();
        String consulta ="UPDATE reparacion set idCliente="+idCliente+","+"idVehiculo="+idVehiculo+","+"Descripcion="+"'"+Descripcion+"'"+","+"Fecha="+"'"+Fecha+"'"+"totalReparacion="+totalReparacion+" where idCliente="+num;
        String mensaje;
        try{
            PreparedStatement ps= conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate();
            mensaje="Se ha modificado correctamente";
            ps.close();
        }catch(SQLException e){
            mensaje="Mal: "+e;
        }
        return mensaje;
    }
    public String ReparacionXCliente(String dni) throws SQLException{
        Conexionsql conexion = new Conexionsql();
        String consulta = "SELECT * FROM reparacion where DNI="+dni;
        String a="";
        try{
            PreparedStatement ps= conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            System.out.println("------TABLA Reparacion-------");
            while(rs.next()){
                a +=rs.getString("idCliente")+"\t"+rs.getString("idVehiculo")+"\t"+rs.getString("Descripcion")+"\t"+rs.getString("Fecha")+"\t"+rs.getString("totalReparacion")+"\n";
                
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            a +="Error"+e;
    }
        return a;
    }
    public String ReparacionXVehiculo(int idVehiculo) throws SQLException{
        Conexionsql conexion = new Conexionsql();
        String consulta = "SELECT * FROM reparacion where idVehiculo="+idVehiculo;
        String a="";
        try{
            PreparedStatement ps= conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            System.out.println("------TABLA Reparacion-------");
            while(rs.next()){
                a +=rs.getString("idCliente")+"\t"+rs.getString("idVehiculo")+"\t"+rs.getString("Descripcion")+"\t"+rs.getString("Fecha")+"\t"+rs.getString("totalReparacion")+"\n";
                
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            a +="Error"+e;
    }
        return a;
    }
    public String ReparacionXFecha(String Fecha) throws SQLException{
        Conexionsql conexion = new Conexionsql();
        String consulta = "SELECT * FROM reparacion where Fecha="+Fecha;
        String a="";
        try{
            PreparedStatement ps= conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            System.out.println("------TABLA Reparacion-------");
            while(rs.next()){
                a +=rs.getString("idCliente")+"\t"+rs.getString("idVehiculo")+"\t"+rs.getString("Descripcion")+"\t"+rs.getString("Fecha")+"\t"+rs.getString("totalReparacion")+"\n";
                
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            a +="Error"+e;
    }
        return a;
    }
    
    
}
