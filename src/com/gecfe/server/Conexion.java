package com.gecfe.server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jesus_Quintero
 */
public class Conexion {

    private static Connection conexion;

    private Conexion() {

    }
    
    public static Connection conectar() {

        /*String usr = "root";
        String pwd = "";
       
        //String url = "jdbc:mysql://localhost/gecfe";
        String driver = "com.mysql.jdbc.Driver";*/

   String usr = "dsaldana";
       String pwd = "saldana";
        String url = "jdbc:mysql://computacion.mxl.uabc.mx:3306/gecfe";
        String driver = "com.mysql.jdbc.Driver";

        
        try {
            if (conexion == null) {
                Class.forName(driver);
                
                conexion = DriverManager.getConnection(url, usr, pwd);
            }
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Error");
        }
        System.out.println("Exito");
        return conexion;
    }

    public static void cerrar(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    public static void cerrar(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }
}
