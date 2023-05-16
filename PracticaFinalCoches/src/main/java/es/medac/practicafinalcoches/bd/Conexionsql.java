/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author medac
 */
public class Conexionsql {
        protected Connection conexionSQL;
    private final String URL = "jdbc:mysql://localhost/tallercoches";
    private final String USUARIO = "medac";
    private final String PASSWORD = "1234contra";
    
    public Conexionsql() {
        //conexionSQL = null;
        try {
            //Class.forName(".com.mysql.jdbc.Driver");
            conexionSQL = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConexion(){
        return conexionSQL;
    }
    
    public void cerrar(){
        try {
            if (conexionSQL != null && !conexionSQL.isClosed()){
                conexionSQL.close();
                System.out.println("Se ha cerrado la conexion");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
