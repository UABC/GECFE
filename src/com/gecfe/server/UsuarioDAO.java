package com.gecfe.server;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gecfe.shared.UsuarioDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesus_Quintero
 */
public class UsuarioDAO{

    private static final String ID = "id"; 
    private static final String NOMBRE = "nombre";
    private static final String APE_PAT = "ape_pat";
    private static final String APE_MAT = "ape_mat";
    private static final String CONTRASENIA = "contrasenia";
    private static final String PUESTO = "puesto";
    
    private static final String SQL_INSERT = "INSERT INTO Usuarios" + 
            "(" + ID + 
            "," + NOMBRE + 
            "," + APE_PAT +
            "," + APE_MAT +
            "," + CONTRASENIA +
            "," + PUESTO +
            ") VALUES (?,?,?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM Usuarios WHERE " +
            NOMBRE + " = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuarios WHERE " +
            ID + " = ?"; 

    private UsuarioDAO() {
    }
    
    private static UsuarioDAO singleton = new UsuarioDAO();
    
    public static UsuarioDAO getInstance(){
        return singleton;
    }

    public static void Agregar(UsuarioDTO dto) throws Exception{       
        PreparedStatement ps = null;
        ps = Conexion.conectar().prepareStatement(SQL_INSERT);
        ps.setString(1, dto.getId());
        ps.setString(2, dto.getNombre());
        ps.setString(3, dto.getApe_pat());
        ps.setString(4, dto.getApe_mat());
        ps.setString(5, dto.getContrasenia());
        ps.setString(6, dto.getPuesto());
        ps.executeUpdate();
        Conexion.cerrar(ps);
    }
    
    public static void Modificar(UsuarioDTO dto, int id) throws Exception{
        PreparedStatement ps = null;
        ps = Conexion.conectar().prepareStatement("update Usuarios set id=?, nombre=?, ape_pat=?, ape_mat=?, contrasenia=?, puesto=?" +
                            "where id= " +id );
        ps.setString(1, dto.getId());
        ps.setString(2, dto.getNombre());
        ps.setString(3, dto.getApe_pat());
        ps.setString(4, dto.getApe_mat());
        ps.setString(5, dto.getContrasenia());
        ps.setString(6, dto.getPuesto());
        ps.executeUpdate();
        Conexion.cerrar(ps);
    }
    
    public static void delete(int id) throws Exception{
        PreparedStatement ps = null;
        ps = Conexion.conectar().prepareStatement(SQL_DELETE);
        ps.setInt(1, id);
        ps.executeUpdate();
        Conexion.cerrar(ps);
    }
    
    public static UsuarioDTO read(String nombre) throws Exception{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioDTO result = null;
        ps = Conexion.conectar().prepareStatement(SQL_READ);
        ps.setString(1,nombre);
        rs = ps.executeQuery();
        if(rs.next()){
            result = getObject(rs);
        }
        Conexion.cerrar(ps);
        Conexion.cerrar(rs);
        return result;
    }
    
    private static UsuarioDTO getObject(ResultSet rs) throws Exception{
        UsuarioDTO dtoUsuario = new UsuarioDTO();
        dtoUsuario.setId(rs.getString(ID));
        dtoUsuario.setNombre(rs.getString(NOMBRE));
        dtoUsuario.setApe_pat(rs.getString(APE_PAT));
        dtoUsuario.setApe_mat(rs.getString(APE_MAT));
        dtoUsuario.setContrasenia(rs.getString(CONTRASENIA));
        dtoUsuario.setPuesto(rs.getString(PUESTO));
        return dtoUsuario;
    }   
    
}
