/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.bd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bapsy
 */
public class Consultas {
     public String InsertarVehiculos(int IdVehiculo,String Matricula,String Marca, String Modelo, String Anio, String Color){
       String filasAfectadas = "";
        Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD IdMascota, AliasMascotas, Especie, Raza, ColorPelo, FechaNacimiento,Vacunaciones
        String consulta = "INSERT INTO vehiculo  VALUES ('"+ Matricula+"','"+Marca+"','"+Modelo+"','"+Anio+"','"+Color+"+"+IdVehiculo+"');";
        
        System.out.println(consulta);
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
           int rs = ps.executeUpdate(consulta);
            System.out.println(rs+ " Registro insertadoo.");
                      ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error consulta insertar mascotoas " + e.getMessage());
        }
        return filasAfectadas;
    }
     public String BuscarVehiculoxMatri (String Matricula) {
        String filasModificadas = " ";
         Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM `vehiculo` WHERE Matricula= '"+Matricula+ "'";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate(consulta);
             System.out.println(rs+ " Registro encontrado .");
            ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error consulta Matricula." + e.getMessage());
        }
        return filasModificadas;
        
        }
      public String BuscarVehiculoxmarYmod (String Marca, String Modelo) {
        String filasModificadas = " ";
        Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM `vehiculo` WHERE Marca= '"+Marca+"'"+" and modelo = '"+Modelo+"'";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate(consulta);
             System.out.println(rs+ " Registro encontrado .");
            ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error consulta Marca y modelo." + e.getMessage());
        }
        return filasModificadas;
        
        }
      
      public String BuscarMaMoAn (String Marca, String Modelo, String anio) {
        String filasModificadas = " ";
         Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM `vehiculo` WHERE Marca= '"+Marca+"'"+" and modelo = '"+Modelo+"'"+"and anio = '"+anio+"'";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate(consulta);
             System.out.println(rs+ " Registro encontrado .");
            ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error consulta Marca y modelo." + e.getMessage());
        }
        return filasModificadas;
        
        }
     
     
    public String ModificarxIdVehiculo(int IdVehiculo) {
        String filasModificadas = " ";
         Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "UPDATE `vehiculo` SET `IdVehiculo` = '1' WHERE `IdVehiculo` = 3";
       
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate(consulta);
             System.out.println(rs+ " Registro modificado.");
            ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error consulta modificar vehiculo ." + e.getMessage());
        }
        return filasModificadas;
        
        }
    
        public String EliminarVehiculo(int IdVehiculo) {
        String filasEliminadas = " ";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "DELETE FROM `vehiculo` WHERE `IdVehiculo` = 3";
        
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate(consulta);
            System.out.println(rs+ " Registro eliminado.");
            ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error consulta borrar vehiculo " + e.getMessage());
        }
        return filasEliminadas;
    }
       
}
