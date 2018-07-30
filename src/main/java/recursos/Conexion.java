/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc lenovo
 */
public class Conexion {

    public static Connection conexion;

    public static final String URL = "jdbc:mysql://localhost:3307/mydbjdbc?useSSL=true";
    public static final String USUARIO = "root";
    public static final String CLAVE = "boris1012";
    
   

    public static Connection establecerConexionbd() throws Exception{

        try {
        conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        

        } catch (Exception e) {

            throw e;
        }
        
       return conexion; 
      
    }

    public void finalizarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
          
            e.printStackTrace();
        }

    }

    public Connection getConexion() {
        return conexion;
    }

}
