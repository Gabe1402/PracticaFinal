/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.practicafinalcoches.bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta clase crea la conexion a la base de datos
 * @author Gabriel
 */
public class Conexionsql {
    //campos de la clase
    protected Connection conexionSQL;
    private final String URL = "jdbc:mysql://localhost/tallercoches";
    private final String USUARIO = "medac";
    private final String PASSWORD = "1234contra";
    
    /**
    * Constructor de la clase que se conecta a la base de datos
    */
    public Conexionsql() {
        //conexionSQL = null;
        try {
            //Class.forName(".com.mysql.jdbc.Driver");
            conexionSQL = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//fin del constructor
    
    /**
    * Regresa la variable conexionSQL, que se encuentra conectada con la BD
    * @return Regresa la variable conexionSQL
    */
    public Connection getConexion(){
        return conexionSQL;
    }//fin del metodo
    
    /**
    * Comprueba si la variable esta cerrada, o no inicializada, y la cierra, en caso de que ambas sean falsas
    */
    public void cerrar(){
        try {
            if (conexionSQL != null && !conexionSQL.isClosed()){
                conexionSQL.close();
                System.out.println("Se ha cerrado la conexion");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//fin del metodo
}//fin de la clase
