package Controlador;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.Login;
import a.Modelo.Consulta;

public class ControladorLogin {
	
	private int xMouse;
	private int yMouse;

	public ControladorLogin() {
		Login login = new Login();
		Consulta consulta = new Consulta();
		eventoBotonX(login);
		eventoHeader(login);
		eventoCambioColorBtnLogin(login);
		eventoCambiarTxtUser(login);
		eventoCambiarTxtPassword(login);
		eventoClickBtnLogin(login,consulta);
	}
	
	private void eventoHeader(Login login) {
		login.header.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		int x = e.getXOnScreen();
        		int y = e.getYOnScreen();
        		login.setLocation(x - xMouse, y- yMouse);
        	}
        });
       login.header.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		xMouse= e.getX();
        		yMouse= e.getY();
        	}
        });
	}

	private void eventoBotonX(Login login) {
		login.botonX.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		login.botonX.setBackground(new Color(255,0,0));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		login.botonX.setBackground(new Color(51,51,51));
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		login.botonX.setBackground(new Color(139,0,0));
        	}
        });
	}

	private void eventoCambiarTxtPassword(Login login) {
		login.txtPassword.addFocusListener(new FocusAdapter() {
	       	 @Override
	       	 public void focusLost(FocusEvent e) {
	         		String text = String.valueOf(login.txtPassword.getPassword());
	         		
	         		// cambiar downPanelUser a color rojo, si el usuario es incorrecto.
	         		if (text.length() == 0 || text.length() >16) {
	         			login.txtPassword.setForeground(new Color(170, 170, 170));
	         			if(text.length() == 0) {
	         				login.txtPassword.setText("password");
	         			}
	         			login.downPanelPassword.setBackground(Color.RED);
	         		} else {
	         			login.txtPassword.setForeground(new Color(255, 255, 255));
	         			login.downPanelPassword.setBackground(Color.GREEN);
	         		}
	         	}
	         	@Override
	         	public void focusGained(FocusEvent e) {
	         		Color color = new Color(170, 170, 170);
	         		if (login.txtPassword.getForeground().equals(color)) {
	         			login.txtPassword.setText("");
	         			login.txtPassword.setForeground(new Color(255, 255, 255));
	         		}
	         	}
	        });
	}

	private void eventoCambiarTxtUser(Login login) {
		login.txtUser.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		String text = login.txtUser.getText();
        		if (text.length() == 0 || text.length() >20) {
        			if(text.length() == 0) {
        				login.txtUser.setText("Usuario");
        				login.txtUser.setForeground(new Color(170, 170, 170));
        			}
        			login.downPanelUser.setBackground(Color.RED);
        		} else {
        			login.txtUser.setForeground(new Color(255, 255, 255));
        			login.downPanelUser.setBackground(Color.GREEN);
        		}
        	}
        	@Override
        	public void focusGained(FocusEvent e) {
        		Color color = new Color(170, 170, 170);
        		if (login.txtUser.getForeground().equals(color) && login.txtUser.getText().length() < 20) {
        			login.txtUser.setText("");
        			login.txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        });
	}

	private void mostrarAlerta(boolean isPositivo) throws HeadlessException, IOException {
		if(isPositivo) {
			Icon icon = new ImageIcon(Login.class.getResource("/imagenes/success-icon.png"));
			JOptionPane.showMessageDialog(null, "Bienvenido","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
		} else {
			Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
			JOptionPane.showMessageDialog(null, "Credenciales no encontradas","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
		}
	}
	
	private void eventoClickBtnLogin(Login login, final Consulta consulta) {
		login.btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		login.lblConectando.setVisible(true);
  			login.lblLoadingImage.setVisible(true);
  			login.lblErrorConexion.setVisible(false);
  			login.lblLoadingImage.setVisible(true);
  			login.lblErrorMessage.setVisible(false);
        		Thread t1 = new Thread() {
        			@Override
        			public void run() {
        				try {
	        				if(consulta.verificarAdmin(login.txtUser.getText(), String.valueOf(login.txtPassword.getPassword()))) {
	        	        			System.out.println("Logeado dentro del sistema.");
	        	        			login.lblErrorImage.setVisible(false);
	        	        			login.lblErrorMessage.setVisible(false);
	        	        			login.downPanelUser.setBackground(Color.GREEN);
	        	        			login.downPanelPassword.setBackground(Color.GREEN);
	        	 				try {
	        	 					login.lblErrorConexion.setVisible(false);
	               					login.lblConectando.setVisible(false);
	               					login.lblLoadingImage.setVisible(false);
	        						mostrarAlerta(true);
	        					} catch (HeadlessException e) {
	        						e.printStackTrace();
	        					} catch (IOException e) {
	        						e.printStackTrace();
	        					}
	        	        			new ControladorAdministracion(login.txtUser.getText());
	        	        			login.setVisible(false);
	        	        		} else {
	        	        			System.out.println("No existe / mala contrasena");
	        	        			login.lblConectando.setVisible(false);
	               	  			login.lblLoadingImage.setVisible(false);
	        	        			login.lblErrorImage.setVisible(true);
	        	        			login.lblErrorMessage.setVisible(true);
	        	        			login.downPanelUser.setBackground(Color.RED);
	        	        			login.downPanelPassword.setBackground(Color.RED);
	        	 				try {
	        						mostrarAlerta(false);
	        					} catch (HeadlessException e) {
	        						e.printStackTrace();
	        					} catch (IOException e) {
	        						e.printStackTrace();
	        					}
	        	        		}
        				} catch (Exception e) {
        					login.lblErrorConexion.setVisible(true);
        					login.lblConectando.setVisible(false);
               	  			login.lblLoadingImage.setVisible(false);
        				}
        			}
        			
        		};
        		t1.start();
        	}
        });
	}

	private void eventoCambioColorBtnLogin(Login login) {
		login.btnLogin.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		login.btnLogin.setBackground(new Color(0, 200, 200));
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		login.btnLogin.setBackground(new Color(0, 153, 153));
	    	}
	    });
	}
	
}
