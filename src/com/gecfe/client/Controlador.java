package com.gecfe.client;

import java.util.Date;

import com.gecfe.shared.EquipoDTO;
import com.gecfe.shared.UsuarioDTO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class Controlador implements EntryPoint {

	UsuarioDTO usuario;

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		crearInicioSesion();
	}

	public void crearInicioSesion() {

		Element centro = RootPanel.get("centro").getElement();
		Element div = DOM.createDiv();
		div.setId("recuadro");
		centro.appendChild(div);

		Label lbUsuario = new Label("Usuario: ");
		lbUsuario.addStyleName("lbUsuario");

		final TextBox tbUsuario = new TextBox();

		tbUsuario.addStyleName("tbUsuario");

		Label lbContrasena = new Label("Contraseña: ");
		lbContrasena.addStyleName("lbContrasena");

		final PasswordTextBox ptbContrasena = new PasswordTextBox();

		ptbContrasena.addStyleName("ptbContrasena");

		Button btnIniciarSesion = new Button("Iniciar Sesión");

		btnIniciarSesion.addStyleName("btnIniciarSesion");
		btnIniciarSesion.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				GECFEServiceAsync gecfeService = GWT.create(GECFEService.class);
				gecfeService.consultarUsuario(tbUsuario.getText(),
						new AsyncCallback<UsuarioDTO>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onSuccess(UsuarioDTO result) {
								// TODO Auto-generated method stub
								if (result != null) {
									if (result.getContrasenia().equals(
											ptbContrasena.getText())) {

										RootPanel.get("centro").getElement()
												.setInnerHTML("");
										crearMenu();
									} else {
										Window.alert("Usuario o Contraseña Incorrecta");
									}
								} else {
									Window.alert("Usuario o Contraseña Incorrecta");
								}
							}
						});
			}
		});

		RootPanel.get("centro").add(lbUsuario);
		RootPanel.get("centro").add(tbUsuario);
		RootPanel.get("centro").add(lbContrasena);
		RootPanel.get("centro").add(ptbContrasena);
		RootPanel.get("centro").add(btnIniciarSesion);

	}

	public void crearMenu() {

		// eventos

		Command cmdAgregarEquipo = new Command() {
			public void execute() {
				crearFormularioEquipo();
			}
		};

		Command cmdEliminarEquipo = new Command() {
			public void execute() {
				Window.alert("You selected Eliminar Equipo!");
			}
		};

		Command cmdModificarEquipo = new Command() {
			public void execute() {
				Window.alert("You selected Modificar Equipo!");
			}
		};

		Command cmdVisualizarEquipo = new Command() {
			public void execute() {
				Window.alert("You selected Visualizar Equipo!");
			}
		};

		Command cmdEliminarUsuario = new Command() {
			public void execute() {
				Window.alert("You selected Eliminar Usuario!");
			}
		};

		Command cmdAgregarUsuario = new Command() {
			public void execute() {
				Window.alert("You selected Agregar Usuario!");
			}
		};

		Command cmdModificarUsuario = new Command() {
			public void execute() {
				Window.alert("You selected Modificar Usuario!");
			}
		};

		Command cmdVisualizarUsuario = new Command() {
			public void execute() {
				Window.alert("You selected Visualizar Usuario!");
			}
		};

		Command cmdAgregarReporte = new Command() {
			public void execute() {
				Window.alert("You selected Agregar Reporte!");
			}
		};

		// Menu

		MenuBar menuEquipos = new MenuBar(true);
		menuEquipos.addItem("Agregar                  ", cmdAgregarEquipo);
		menuEquipos.addItem("Eliminar                 ", cmdEliminarEquipo);
		menuEquipos.addItem("Modificar                ", cmdModificarEquipo);
		menuEquipos.addItem("Visualizar               ", cmdVisualizarEquipo);

		MenuBar menuUsuarios = new MenuBar(true);
		menuUsuarios.addItem("Agregar                 ", cmdAgregarUsuario);
		menuUsuarios.addItem("Eliminar                ", cmdEliminarUsuario);
		menuUsuarios.addItem("Modificar               ", cmdModificarUsuario);
		menuUsuarios.addItem("Visualizar              ", cmdVisualizarUsuario);

		MenuBar menuReportes = new MenuBar(true);
		menuReportes.addItem("Agregar                 ", cmdAgregarReporte);

		MenuBar menu = new MenuBar();
		menu.addItem("Equipos", menuEquipos);
		menu.addItem("Usuarios", menuUsuarios);
		menu.addItem("Reportes", menuReportes);

		RootPanel.get("centro").add(menu);

	}

	public void crearFormularioEquipo() {

		Element centro = RootPanel.get("centro").getElement();
		Element div = DOM.createDiv();
		div.setId("recuadroFormulario");
		centro.appendChild(div);

		final DateBox dateBox = new DateBox();
		dateBox.addStyleName("dateBox");
		dateBox.setFormat(new DateBox.DefaultFormat(DateTimeFormat
				.getFormat(PredefinedFormat.YEAR_MONTH_NUM_DAY)));
		dateBox.setValue(new Date());

		Label lbSolicitante = new Label("Solicitante: ");
		lbSolicitante.addStyleName("lbSolicitante");

		final TextBox tbSolicitante = new TextBox();
		tbSolicitante.addStyleName("tbSolicitante");

		Label lbDireccion = new Label("Dirección: ");
		lbDireccion.addStyleName("lbDireccion");

		final TextBox tbDireccion = new TextBox();
		tbDireccion.addStyleName("tbDireccion");

		Label lbExpedicion = new Label("No. Folio: ");
		lbExpedicion.addStyleName("lbExpedicion");

		final TextBox tbExpedicion = new TextBox();
		tbExpedicion.addStyleName("tbExpedicion");

		Label lbZona = new Label("Zona: ");
		lbZona.addStyleName("lbZona");

		final ListBox lsbZona = new ListBox();
		lsbZona.addStyleName("lsbZona");
		lsbZona.addItem("Seleccione una zona...");
		lsbZona.addItem("Mexical (MXL)");
		lsbZona.addItem("La Paz (LPZ)");
		lsbZona.addItem("San Luis (SNL)");
		lsbZona.addItem("Tijuana (TIJ)");
		lsbZona.addItem("Ensenada (EDA)");

		Label lbRecepcion = new Label("Medio de Recepción ");
		lbRecepcion.addStyleName("lbRecepcion");

		final RadioButton rbPaqueteria = new RadioButton("Paqueteria",
				"Paqueteria");
		rbPaqueteria.addStyleName("rbPaqueteria");

		final RadioButton rbPersonal = new RadioButton("Personal", "Personal");
		rbPersonal.addStyleName("rbPersonal");

		Label lbCondicion = new Label("Condiciones fisicas del instrumento ");
		lbCondicion.addStyleName("lbCondicion");

		final RadioButton rbBuenEstado = new RadioButton("Buen Estado",
				"Buen Estado");
		rbBuenEstado.addStyleName("rbBuenEstado");

		final RadioButton rbMalEstado = new RadioButton("Mal Estado",
				"Mal Estado");
		rbMalEstado.addStyleName("rbMalEstado");

		Label lbNombre = new Label("Nombre: ");
		lbNombre.addStyleName("lbNombre");

		final ListBox lsbNombre = new ListBox();
		lsbNombre.addItem("Seleccione una nombre...");
		lsbNombre.addItem("WATHORIMETRO PATRON");
		lsbNombre.addItem("EQ. PORTATIL DE CALIBRACION");
		lsbNombre.addItem("MULTIMETRO DE GANCHO");
		lsbNombre.addItem("INDICADOR DE FASE");
		lsbNombre.addItem("MULTIMETRO DE GANCHO (ANALOGO)");
		lsbNombre.addItem("PROBADOR DE T.P.s");
		lsbNombre.addItem("TTR");
		lsbNombre.addItem("AMPERIMETRO");
		lsbNombre.addItem("PROBADOR DE T.C.s");
		lsbNombre.addItem("MULTIMETRO DIGITAL");
		lsbNombre.addItem("VOLMETRO");
		lsbNombre.addItem("MEDIDOR KWH");
		lsbNombre.addStyleName("tbNombre");

		Label lbMarca = new Label("Marca: ");
		lbMarca.addStyleName("lbMarca");

		final ListBox lsbMarca = new ListBox();
		lsbMarca.addItem("Seleccione una marca...");
		lsbMarca.addItem("RADIAN");
		lsbMarca.addItem("PROBEWELL");
		lsbMarca.addItem("GB-INSTRUMENTS");
		lsbMarca.addItem("KYORUTSU");
		lsbMarca.addItem("SCIENTIFIC COLUMBUS");
		lsbMarca.addItem("AMPROBE");
		lsbMarca.addItem("FLUKE");
		lsbMarca.addItem("WECO");
		lsbMarca.addItem("HALO");
		lsbMarca.addItem("HASTING");
		lsbMarca.addItem("BK");
		lsbMarca.addItem("STEREN");
		lsbMarca.addItem("YOCOGAWA");
		lsbMarca.addItem("MASTECH");
		lsbMarca.addItem("PROAM");
		lsbMarca.addItem("A.W.SPERRY");
		lsbMarca.addItem("TESCO");
		lsbMarca.addStyleName("tbMarca");

		Label lbModelo = new Label("Modelo: ");
		lbModelo.addStyleName("lbModelo");

		final ListBox lsbModelo = new ListBox();
		lsbModelo.addItem("Seleccione un modelo...");
		lsbModelo.addItem("RM-10-06");
		lsbModelo.addItem("RM-12");
		lsbModelo.addItem("MT-1");
		lsbModelo.addItem("GSM-620");
		lsbModelo.addItem("8031");
		lsbModelo.addItem("MAV-3");
		lsbModelo.addItem("ACD-11");
		lsbModelo.addItem("RS-3");
		lsbModelo.addItem("9390");
		lsbModelo.addItem("MT-1/NT");
		lsbModelo.addStyleName("tbModelo");

		Label lbNoSerie = new Label("No. Serie: ");
		lbNoSerie.addStyleName("lbNoSerie");

		final TextBox tbNoSerie = new TextBox();
		tbNoSerie.addStyleName("tbNoSerie");

		Label lbTitulo = new Label("Recepción de Instrumentos de Medida ");
		lbTitulo.addStyleName("lbTitulo");

		Button btnAgregar = new Button("Agregar Equipo");
		btnAgregar.addStyleName("btnAgregar");

		rbPaqueteria.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (rbPaqueteria.getValue()) {
					rbPersonal.setChecked(false);
				} else {

					rbPaqueteria.setChecked(false);
				}
			}
		});

		rbPersonal.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (rbPersonal.getValue()) {
					rbPaqueteria.setChecked(false);
				} else {

					rbPersonal.setChecked(false);
				}
			}
		});

		rbBuenEstado.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (rbBuenEstado.getValue()) {
					rbMalEstado.setChecked(false);
				} else {

					rbBuenEstado.setChecked(false);
				}
			}
		});

		rbMalEstado.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (rbMalEstado.getValue()) {
					rbBuenEstado.setChecked(false);
				} else {

					rbMalEstado.setChecked(false);
				}
			}
		});

		btnAgregar.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String[] result = dateBox.getValue().toGMTString().split(" ");

				EquipoDTO equipo = new EquipoDTO();
				equipo.setFechaRecepcion(result[0] + " " + result[1] + " "
						+ result[2]);
				equipo.setSolicitante(tbSolicitante.getText());
				equipo.setDireccion(tbDireccion.getText());
				equipo.setFolio(tbExpedicion.getText());
				equipo.setZona(lsbZona.getItemText(lsbZona.getSelectedIndex()));
				if (rbPaqueteria.getValue()) {
					equipo.setMedioRecepcion(rbPaqueteria.getText());

				} else {
					equipo.setMedioRecepcion(rbPersonal.getText());

				}

				if (rbBuenEstado.getValue()) {
					equipo.setCondiciones(rbBuenEstado.getText());

				} else {
					equipo.setCondiciones(rbMalEstado.getText());

				}
				equipo.setNombre(lsbNombre.getItemText(lsbNombre
						.getSelectedIndex()));
				equipo.setMarca(lsbMarca.getItemText(lsbMarca
						.getSelectedIndex()));
				equipo.setModelo(lsbModelo.getItemText(lsbModelo
						.getSelectedIndex()));
				equipo.setNoSerie(tbNoSerie.getText());
				Window.alert(equipo.toString());

				GECFEServiceAsync gecfeService = GWT.create(GECFEService.class);

				gecfeService.ingresarEquipo(equipo,
						new AsyncCallback<EquipoDTO>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Window.alert("Error al dar de alta el equipo 2");
							}

							@Override
							public void onSuccess(EquipoDTO result) {
								// TODO Auto-generated method stub
								if (result != null) {

									Window.alert("Exito al dar de alta el equipo ");
								} else {
									Window.alert("Error al dar de alta el equipo, ya existe ese folio");
								}
							}
						});
			}
		});
		RootPanel.get("centro").add(lbSolicitante);
		RootPanel.get("centro").add(tbSolicitante);
		RootPanel.get("centro").add(lbDireccion);
		RootPanel.get("centro").add(tbDireccion);
		RootPanel.get("centro").add(lbRecepcion);
		RootPanel.get("centro").add(rbPaqueteria);
		RootPanel.get("centro").add(rbPersonal);
		RootPanel.get("centro").add(lbCondicion);
		RootPanel.get("centro").add(rbBuenEstado);
		RootPanel.get("centro").add(rbMalEstado);
		RootPanel.get("centro").add(lbNombre);
		RootPanel.get("centro").add(lsbNombre);
		RootPanel.get("centro").add(lbMarca);
		RootPanel.get("centro").add(lsbMarca);
		RootPanel.get("centro").add(lbModelo);
		RootPanel.get("centro").add(lsbModelo);
		RootPanel.get("centro").add(lbNoSerie);
		RootPanel.get("centro").add(tbNoSerie);
		RootPanel.get("centro").add(btnAgregar);
		RootPanel.get("centro").add(lbTitulo);
		RootPanel.get("centro").add(lbExpedicion);
		RootPanel.get("centro").add(tbExpedicion);
		RootPanel.get("centro").add(lbZona);
		RootPanel.get("centro").add(lsbZona);
		RootPanel.get("centro").add(dateBox);

		// div.appendChild(lbSolicitante.getElement());
		// div.appendChild(tbSolicitante.getElement());

	}
}
