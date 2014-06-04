package com.gecfe.shared;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesus_Quintero
 */
public class UsuarioDTO implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String nombre;
    private String ape_pat;
    private String ape_mat;
    private String contrasenia;
    private String puesto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_pat() {
        return ape_pat;
    }

    public void setApe_pat(String ape_pat) {
        this.ape_pat = ape_pat;
    }

    public String getApe_mat() {
        return ape_mat;
    }

    public void setApe_mat(String ape_mat) {
        this.ape_mat = ape_mat;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", nombre=" + nombre + ", ape_pat=" + ape_pat + ", ape_mat=" + ape_mat + ", contrasenia=" + contrasenia + ", puesto=" + puesto + '}';
    }
    
    
}
