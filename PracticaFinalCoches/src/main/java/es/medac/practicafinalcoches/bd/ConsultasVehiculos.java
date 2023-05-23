/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.bd;

import java.sql.*;

/**
 * Esta clase contiene los metodos para manipular la informacion en la tabla Vehiculos de la BD
 * @author bapsy
 */
public class ConsultasVehiculos {
    
    /**
    * Este metodo inserta una nueva columna a la tabla
    * @param IdVehiculo Id del vehiculo a insertar
    * @param Matricula Matricula del vehiculo a insertar
    * @param Marca Marca del vehiculo a insertar
    * @param Modelo Modelo del vehiculo a insertar
    * @param Anio Año del vehiculo a insertar
    * @param Color Color del vehiculo a insertar
    * @return Regresa un indicador de que la consulta se realizo correctamente
    */
     public String InsertarVehiculos(int IdVehiculo,String Matricula,String Marca, String Modelo, String Anio, String Color){
       String filasAfectadas = "";
        Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD IdMascota, AliasMascotas, Especie, Raza, ColorPelo, FechaNacimiento,Vacunaciones
        String consulta = "INSERT INTO vehiculo  VALUES ('"+ Matricula+"','"+Marca+"','"+Modelo+"','"+Anio+"','"+Color+"','"+IdVehiculo+"');";
        
        System.out.println(consulta);
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);){
           int rs = ps.executeUpdate(consulta);
           filasAfectadas = rs + " Registro modificado.";
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error consulta insertar mascotoas " + e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return filasAfectadas;
    }//fin del metodo
     
     /**
     * Este metodo busca las columnas que coincidan con la matricula en parametro
     * @param Matricula Matricula a comparar con las columnas
     * @return Regresa el resultado de la consulta SELECT
     */
     public String BuscarVehiculoxMatri (String Matricula) {
        String filasModificadas = "";
         Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM `vehiculo` WHERE Matricula= '"+Matricula+ "'";
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery(consulta);){
            while (rs.next()) {
                filasModificadas += rs.getString("Matricula")+"\t"+rs.getString("Marca")+"\t"+rs.getString("Modelo")+"\t"+
                        rs.getString("Anio")+"\t"+rs.getString("Color")+"\t"+rs.getString("idVehiculo")+"\n";
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error consulta Matricula." + e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return filasModificadas;
        }//fin del metodo
     
     /**
     * Este metodo busca las columnas que coincidan con la marca y el modelo en parametro
     * @param Marca Marca a comparar con las columnas
     * @param Modelo Modelo a comparar con las columnas
     * @return Regresa el resultado de la consulta SELECT
     */
      public String BuscarVehiculoxmarYmod (String Marca, String Modelo) {
        String filasModificadas = " ";
        Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM `vehiculo` WHERE Marca= '"+Marca+"'"+" and modelo = '"+Modelo+"'";
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery(consulta);){
            while (rs.next()) {
                filasModificadas += rs.getString("Matricula")+"\t"+rs.getString("Marca")+"\t"+rs.getString("Modelo")+"\t"+
                        rs.getString("Anio")+"\t"+rs.getString("Color")+"\t"+rs.getString("idVehiculo")+"\n";
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error consulta Marca y modelo." + e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return filasModificadas;
        
        }//fin del metodo
      
     /**
     * Este metodo busca las columnas que coincidan con la marca, el modelo y el año en parametro
     * @param Marca Marca a comparar con las columnas
     * @param Modelo Modelo a comparar con las columnas
     * @param anio Año del vehiculo a comparar con las columnas
     * @return Regresa el resultado de la consulta SELECT
     */
      public String BuscarMaMoAn (String Marca, String Modelo, String anio) {
        String filasModificadas = " ";
         Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM `vehiculo` WHERE Marca= '"+Marca+"'"+" and modelo = '"+Modelo+"'"+"and anio = '"+anio+"'";
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery(consulta);){
            while (rs.next()) {
                filasModificadas += rs.getString("Matricula")+"\t"+rs.getString("Marca")+"\t"+rs.getString("Modelo")+"\t"+
                        rs.getString("Anio")+"\t"+rs.getString("Color")+"\t"+rs.getString("idVehiculo")+"\n";
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error consulta Marca y modelo." + e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return filasModificadas;
        
        }//fin del metodo
     
    /**
    * Este metodo modifica una campo de la columna, esta columna debe ser identificada mediante la condicion
    * @param campoCambio Campo que se busca modificar
    * @param valorMod Valor nuevo que sera introducido a la columna
    * @param condicion Condicion que buscara la columna segun la sentencia pasada
    * @return Regresa un indicador de que la consulta se realizo correctamente
    */ 
    public String ModificarVeh(String campoCambio, String valorMod, String condicion) {
        String filasModificadas = "";
         Conexionsql conexion = new  Conexionsql(); // Creo la conexion a la BD
        String consulta = "UPDATE vehiculo SET '"+campoCambio+"' = '"+valorMod+"' WHERE '"+condicion+"'";
       
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);){
            int rs = ps.executeUpdate(consulta);
            filasModificadas = rs + " Registro modificado.";
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error consulta modificar vehiculo ." + e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return filasModificadas;
        
        }//fin del metodo
        
        /**
        * Metodo que elimina el vehiculo cuyo id coincida con el id en parametro
        * @param IdVehiculo id a comparar con las columnas de la tabla
        * @return Regresa un indicador de que la consulta se realizo correctamente
        */
        public String EliminarVehiculo(int IdVehiculo) {
        String filasEliminadas = " ";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "DELETE FROM vehiculo WHERE idVehiculo = '"+IdVehiculo+"'";
        
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);){
            int rs = ps.executeUpdate(consulta);
            filasEliminadas = rs + " Registro modificado.";
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error consulta borrar vehiculo " + e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return filasEliminadas;
    }//fin del metodo
}//fin de la clase
