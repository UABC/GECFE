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
public class EquipoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String folio;
	private String nombre;
	private String marca;
	private String modelo;
	private String noSerie;
	private String solicitante;
	private String direccion;
	private String zona;
	private String medioRecepcion;
	private String condiciones;
	private String fechaRecepcion;
	

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNoSerie() {
		return noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getMedioRecepcion() {
		return medioRecepcion;
	}

	public void setMedioRecepcion(String medioRecepcion) {
		this.medioRecepcion = medioRecepcion;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}

	public String getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	
	
	

	@Override
	public String toString() {
		return "EquipoDTO [folio=" + folio + ", nombre=" + nombre + ", marca="
				+ marca + ", modelo=" + modelo + ", noSerie=" + noSerie
				+ ", solicitante=" + solicitante + ", direccion=" + direccion
				+ ", zona=" + zona + ", medioRecepcion=" + medioRecepcion
				+ ", condiciones=" + condiciones + ", fecha=" + fechaRecepcion + "]";
	}

	public EquipoDTO(String folio, String nombre, String marca, String modelo,
			String noSerie, String solicitante, String direccion, String zona,
			String medioRecepcion, String condiciones, String fechaRecepcion) {
		super();
		this.folio = folio;
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.noSerie = noSerie;
		this.solicitante = solicitante;
		this.direccion = direccion;
		this.zona = zona;
		this.medioRecepcion = medioRecepcion;
		this.condiciones = condiciones;
		this.fechaRecepcion = fechaRecepcion;
	}

	public EquipoDTO() {
		super();
	}

	

		
	

	
	
}
