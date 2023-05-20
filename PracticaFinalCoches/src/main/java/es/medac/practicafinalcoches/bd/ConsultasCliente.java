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
public class ConsultasCliente {
    public String insertarClientes(int dni, String nombre, String apellidos, int edad){
        String filasAfectadas = "";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "INSERT INTO Cliente(id, nombre, apellidos, edad) VALUES ('"
                +dni+"','"+nombre+"','"+apellidos+"','"+edad+"')";
        System.out.println(consulta);
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate(consulta);
            filasAfectadas= "Registro insertado " + dni + "," + nombre + "','" + apellidos + "','" + edad;
            ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            filasAfectadas="Error consulta insertar autores " + e.getMessage();
        }
        return filasAfectadas;
    }
    
    
    
    public String modificarNombreAutorPordni(int dni, String nuevoNombre) {
        String filasModificadas = "";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "UPDATE Clientes SET Nombre = '" + nuevoNombre + "' WHERE id = "+dni;
        //System.out.println(consulta);
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            int rs = ps.executeUpdate(consulta);
            filasModificadas= "Registro insertado " + dni + "," + nombre + "','" + apellidos + "','" + edad;
            ps.close();
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return filasModificadas;
    }
    
    
    public String BuscarClientesPorDni() {
        String mensaje= "";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM Cliente WHERE dni = '12345678A';";

        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mensaje= rs.getString("dni") + "," + rs.getString("nombre");
                   
            }
            ps.close();
            rs.close();
            conexion.cerrar();
        } catch (SQLException e) {
            mensaje+="Error:" + e;
        }
        return mensaje;
    }
    
    public String BuscarClientesPorNombreyApellidos() {
        String mensaje="";
        Conexionsql conexion = new Conexionsql(); // Creo la conexion a la BD
        String consulta = "SELECT * FROM Cliente WHERE nombre = 'Juan' AND apellidos = 'Pérez Gómez';";

        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             mensaje= rs.getString("dni") + "," + rs.getString("nombre")+ ","+ rs.getString("apellidos");
            }
            ps.close();
            rs.close();
            conexion.cerrar();
        } catch (SQLException e) {
            mensaje+= "Error: "+ e;
        }
        return mensaje;
    }
}
