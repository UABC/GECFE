/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.gecfe.server;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gecfe.client.GECFEService;
import com.gecfe.shared.EquipoDTO;
import com.gecfe.shared.UsuarioDTO;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mysql.jdbc.Connection;

public class GECFEServiceImpl extends RemoteServiceServlet implements
		GECFEService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsuarioDTO usuario;
	FachadaDAO fachadaDAO;

	@Override
	public UsuarioDTO consultarUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		fachadaDAO = new FachadaDAO();
		try {
			usuario = fachadaDAO.ConsultarUsuario(nombreUsuario);

		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return usuario;
	}

	@Override
	public EquipoDTO ingresarEquipo(EquipoDTO equipo) {
		// TODO Auto-generated method stub
		fachadaDAO = new FachadaDAO();
		EquipoDTO auxilixarEquipoDTO = null;
		try {
			auxilixarEquipoDTO = fachadaDAO.ConsultarEquipo(equipo.getFolio());
			if ( auxilixarEquipoDTO == null) {
				System.out.println("no existe");
				fachadaDAO.AltaEquipo(equipo);
				auxilixarEquipoDTO = fachadaDAO.ConsultarEquipo(equipo.getFolio());
			}else if (auxilixarEquipoDTO != null){
				System.out.println("ya existe");
				auxilixarEquipoDTO = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auxilixarEquipoDTO;
	}
}
