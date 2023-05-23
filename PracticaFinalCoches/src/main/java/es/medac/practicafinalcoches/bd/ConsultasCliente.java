/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.bd;

import java.sql.*;

/**
 * Esta clase contiene los metodos para trabajar con los datos  de la tabla cliente en la BD
 * @author Pablo
 */
public class ConsultasCliente {
    
    //Campos de la clase
    /**
    * Metodo que inserta una columna a la tabla
    * @param dni DNI en la tabla
    * @param nombre Nombre en la tabla  
    * @param apellidos Apellidos en la tabla
    * @param edad Edad en la tabla
    * @param idCliente id del Cliente en la tabla
    * @return Regresa un indicador de que se ha insertado nuevos parametros
    */
    public String insertarClientes(String dni, String nombre, String apellidos, int edad, int idCliente){
        String filasAfectadas = "";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "INSERT INTO Cliente(DNI, nombre, apellidos, edad, IdCliente) VALUES ('"
                +dni+"','"+nombre+"','"+apellidos+"','"+edad+"','"+idCliente+"')";
        System.out.println(consulta);
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);){
            int rs = ps.executeUpdate(consulta);
            filasAfectadas= "Registro insertado " + dni + "," + nombre + "','" + apellidos + "','" + edad;
            ps.close();
        } catch (SQLException e) {
            filasAfectadas="Error consulta insertar autores " + e.getMessage();
        } finally {
            conexion.cerrar();
        }
        return filasAfectadas;
    } //fin del metodo
    
    
    /**
    * Metodo que modifica el nombre de una columna identificada por su ID
    * @param dni ID por el que se busca la tabla
    * @param nuevoNombre Nombre actualizado a insertar
    * @return Regresa un indicador de cuantas lineas se han modificado con la consulta
    */
    public String modificarNombreAutorPordni(int dni, String nuevoNombre) {
        String filasModificadas = "";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "UPDATE Clientes SET Nombre = '" + nuevoNombre + "' WHERE id = '"+dni+"'";
        //System.out.println(consulta);
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta)){
            int rs = ps.executeUpdate(consulta);
            filasModificadas= "Registro insertado: " + nuevoNombre;
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            conexion.cerrar();
        }
        return filasModificadas;
    }//fin del metodo
    
    /**
    * Metodo que busca las columnas que coincidan con el DNI en parametro
    * @param dni DNI que se compara con las columnas de la BD
    * @return Regresa el resultado de la consulta SELECT
    */
    public String BuscarClientesPorDni(String dni) {
        String mensaje= "";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM Cliente WHERE dni = '"+dni+"';";

        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta); ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                mensaje= rs.getString("dni") + "," + rs.getString("nombre")+"\n";
                   
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            mensaje+="Error:" + e;
        } finally {
            conexion.cerrar();
        }
        return mensaje;
    }//fin del metodo
    
    /**
    * Metodo que busca las columnas que coincidan con el nombre y apellido en parametro
    * @param nombre Nombre a comparar con las columnas
    * @param apellidos Apellidos a comparar con las columnas
    * @return Regresa el resultado de la consulta SELECT
    */
    public String BuscarClientesPorNombreyApellidos(String nombre, String apellidos) {
        String mensaje="";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM Cliente WHERE nombre = '"+nombre+"' AND apellidos = '"+apellidos+"';";

        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta); ResultSet rs = ps.executeQuery();){
            while (rs.next()) {
             mensaje= rs.getString("dni") + "," + rs.getString("nombre")+ ","+ rs.getString("apellidos")+"\n";
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            mensaje+= "Error: "+ e;
        } finally {
            conexion.cerrar();
        }
        return mensaje;
    }//fin del metodo
    
    /**
    * Metodo que elimina el cliente cuyo id coincida con el id en parametro
    * @param idCliente id a comparar con las columnas de la tabla
    * @return Regresa el resultado de la consulta SELECT
    */
    public String EliminarCliente(int idCliente) {
        String filasEliminadas = "";
        String consulta = "Delete From Cliente Where idCliente = '"+idCliente+"'";
        Conexionsql conexion = new Conexionsql();
        
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
