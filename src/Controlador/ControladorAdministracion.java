package Controlador;

import vista.Administracion;

public class ControladorAdministracion {

	public ControladorAdministracion(String nombreAdmin) {
		Administracion administracion = new Administracion(nombreAdmin);
		administracion.setVisible(true);
	}
	
}
