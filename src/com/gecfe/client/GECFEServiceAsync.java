package com.gecfe.client;

import com.gecfe.shared.EquipoDTO;
import com.gecfe.shared.UsuarioDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GECFEServiceAsync {

	void consultarUsuario(String nombreUsuario,
			AsyncCallback<UsuarioDTO> callback);

	void ingresarEquipo(EquipoDTO equipo, AsyncCallback<EquipoDTO> callback);

}
