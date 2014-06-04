package com.gecfe.server;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gecfe.shared.EquipoDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesus_Quintero
 */
public class EquipoDAO{
    
    private static final String NUM_FOLIO = "Num_folio";
    private static final String NOMBRE = "nombre";
    private static final String MARCA = "marca";
    private static final String MODELO = "modelo";
    private static final String NUMERO_SERIE = "numero_serie";
    private static final String SOLICITANTE = "solicitante";
    private static final String DIRECCION = "direccion";
    private static final String ZONA = "zona";
    private static final String MEDIO_RECEPCION = "medio_recepcion";
    private static final String CONDICIONES = "condiciones";
    private static final String FECHA_RECEPCION = "fecha_recepcion";
    private static final String SQL_INSERT = "INSERT INTO equipos" +
            "(" + NUM_FOLIO +
            "," + NOMBRE +
            "," + MARCA +
            "," + MODELO +
            "," + NUMERO_SERIE +
            "," + SOLICITANTE +
            "," + DIRECCION +
            "," + ZONA + 
            "," + MEDIO_RECEPCION +
            "," + CONDICIONES +
            "," + FECHA_RECEPCION +
            ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    
    private static final String SQL_READ = "SELECT * FROM equipos WHERE " +
            NUM_FOLIO + " = ?";
    private static final String SQL_DELETE = "DELETE FROM equipos WHERE " + 
            NUM_FOLIO + " = ?";

    private EquipoDAO() {
    } 
    
    private static EquipoDAO singleton = new EquipoDAO();
    
    public static EquipoDAO getInstance(){
        return singleton;
    }
    
   public static void Agregar(EquipoDTO dto) throws Exception{       
        PreparedStatement ps = null;
        ps = Conexion.conectar().prepareStatement(SQL_INSERT);
        ps.setString(1, dto.getFolio());
        ps.setString(2, dto.getNombre());
        ps.setString(3, dto.getMarca());
        ps.setString(4, dto.getModelo());
        ps.setString(5, dto.getNoSerie());
        ps.setString(6, dto.getSolicitante());
        ps.setString(7, dto.getDireccion());
        ps.setString(8, dto.getZona());
        ps.setString(9, dto.getMedioRecepcion());
        ps.setString(10, dto.getCondiciones());
        ps.setString(11, dto.getFechaRecepcion());
        ps.executeUpdate();
        Conexion.cerrar(ps);
    }
    
    public static void Modificar(EquipoDTO dto, int id) throws Exception{
        PreparedStatement ps = null;
        ps = Conexion.conectar().prepareStatement("update equipos set num_folio=?, nombre=?, marca=?, modelo=?, numero_serie=?, solicitante=?, direccion=?, zona=?, medio_recepcion=?, condiciones=?, resultado_medida=?, realizo=?, reviso=?, fecha_recepcion=?, fecha_realizacion=?, fecha_revision=?" +
                            "where num_folio= " +id );        
        ps.setString(1, dto.getFolio());
        ps.setString(2, dto.getNombre());
        ps.setString(3, dto.getMarca());
        ps.setString(4, dto.getModelo());
        ps.setString(5, dto.getNoSerie());
        ps.setString(6, dto.getSolicitante());
        ps.setString(7, dto.getDireccion());
        ps.setString(8, dto.getZona());
        ps.setString(9, dto.getMedioRecepcion());
        ps.setString(10, dto.getCondiciones());
        ps.setString(14, dto.getFechaRecepcion());
        ps.executeUpdate();
        Conexion.cerrar(ps);
    }
    
    public static void borrar(int id) throws Exception{
        PreparedStatement ps = null;
        ps = Conexion.conectar().prepareStatement(SQL_DELETE);
        ps.setInt(1, id);
        ps.executeUpdate();
        Conexion.cerrar(ps);
    }
    
    public static EquipoDTO mostrar(String string) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        EquipoDTO result = null;
        ps = Conexion.conectar().prepareStatement(SQL_READ);
        ps.setString(1, string);
        rs = ps.executeQuery();
        if(rs.next()){
            result = getObject(rs);
        }
        Conexion.cerrar(ps);
        Conexion.cerrar(rs);
        return result;
    }
    
    private static EquipoDTO getObject(ResultSet rs) throws Exception{
        EquipoDTO dtoEquipo = new EquipoDTO();
        dtoEquipo.setFolio(rs.getString(NUM_FOLIO));
        dtoEquipo.setNombre(rs.getString(NOMBRE));
        dtoEquipo.setMarca(rs.getString(MARCA));
        dtoEquipo.setModelo(rs.getString(MODELO));
        dtoEquipo.setNoSerie(rs.getString(NUMERO_SERIE));
        dtoEquipo.setSolicitante(rs.getString(SOLICITANTE));
        dtoEquipo.setDireccion(rs.getString(DIRECCION));
        dtoEquipo.setZona(rs.getString(ZONA));
        dtoEquipo.setMedioRecepcion(rs.getString(MEDIO_RECEPCION));
        dtoEquipo.setCondiciones(rs.getString(CONDICIONES));
        dtoEquipo.setFechaRecepcion(rs.getString(FECHA_RECEPCION));
        
        return dtoEquipo;
    }
}
