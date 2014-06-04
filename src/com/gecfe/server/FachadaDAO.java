package com.gecfe.server;

import com.gecfe.shared.EquipoDTO;
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
public class FachadaDAO {
    
    public void AltaUsuario(UsuarioDTO usr) throws Exception{
        UsuarioDAO.Agregar(usr);
    }
    
    public void BajaUsuario(int id) throws Exception{
        UsuarioDAO.delete(id);
    }
    
    public void ModificarUsuario(UsuarioDTO usr, int id) throws Exception{
        UsuarioDAO.Modificar(usr, id);
    }
    
    public UsuarioDTO ConsultarUsuario(String nombre) throws Exception{
      return  UsuarioDAO.read(nombre);
    }
    
    public void AltaEquipo(EquipoDTO eqp) throws Exception{
        EquipoDAO.Agregar(eqp);
    }
    
    public void BajaEquipo(int id) throws Exception{
        EquipoDAO.borrar(id);
    }
    
    public void ModificarEquipo(EquipoDTO eqp, int id) throws Exception{
        EquipoDAO.Modificar(eqp, id);
    }
    
    public EquipoDTO ConsultarEquipo(String string) throws Exception{
        return EquipoDAO.mostrar(string);
    }
    
    
    
}
