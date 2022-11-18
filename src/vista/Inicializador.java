package vista;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controlador.ControladorLogin;

public class Inicializador {
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new ControladorLogin();
    }
}