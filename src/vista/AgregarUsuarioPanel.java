package vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import a.Modelo.Consulta;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarUsuarioPanel extends JPanel {
	
	private static final long serialVersionUID = -4869686066977683583L;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public int modoPanel=0;
	
	private JTextField rutTextField;
	private JTextField nombreTextField;
	private JTextField apellidosTextField;
	private JTextField numTelefonoTextField;
	private JTextField emailTextField;
	private Consulta consulta = new Consulta();
	private JLabel lblAlertaRUT;
	private JLabel lblAlertaNombre;
	private JLabel lblAlertaNumTel;
	private JLabel lblAlertaEmail;
	private JLabel lblAlertaApellidos;
	private JPanel lineaEmail;
	private JPanel lineaRut;
	private JPanel lineaNombre;
	private JPanel lineaNumTel;
	private JPanel lineaApellidos;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private String rutAntiguo;

	public AgregarUsuarioPanel(int modo, JComponent[] paneles,JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modoPanel = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblAgregarUsuario = new JLabel("Usuario\r\n");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarUsuario.setBounds(215, 11, 302, 55);
		add(lblAgregarUsuario);
		
		JLabel lblRut = new JLabel("RUT");
		lblRut.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblRut.setForeground(Color.WHITE);
		lblRut.setBounds(136, 140, 62, 14);
		add(lblRut);
		
		lineaRut = new JPanel();
		lineaRut.setPreferredSize(new Dimension(0, 3));
		lineaRut.setBackground(Color.WHITE);
		lineaRut.setBounds(136, 177, 214, 3);
		add(lineaRut);
		GroupLayout gl_lineaRut = new GroupLayout(lineaRut);
		gl_lineaRut.setHorizontalGroup(
			gl_lineaRut.createParallelGroup(Alignment.LEADING)
				.addGap(0, 441, Short.MAX_VALUE)
				.addGap(0, 441, Short.MAX_VALUE)
		);
		gl_lineaRut.setVerticalGroup(
			gl_lineaRut.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaRut.setLayout(gl_lineaRut);
		
		rutTextField = new JTextField();
		rutTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarRut();
			}
		});
		rutTextField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		verificarRut();
        	}
        });
		rutTextField.setText("EJ: 12.345.678-9");
		rutTextField.setOpaque(false);
		rutTextField.setForeground(new Color(170, 170, 170));
		rutTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rutTextField.setCaretColor(Color.WHITE);
		rutTextField.setBorder(null);
		rutTextField.setBackground(new Color(51, 51, 51));
		rutTextField.setBounds(136, 153, 214, 21);
		eventoCambiarJTextField(rutTextField, rutTextField.getText(), 30);
		add(rutTextField);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblNombre.setBounds(136, 191, 62, 14);
		add(lblNombre);
		
		lineaNombre = new JPanel();
		lineaNombre.setPreferredSize(new Dimension(0, 3));
		lineaNombre.setBackground(Color.WHITE);
		lineaNombre.setBounds(136, 228, 214, 3);
		add(lineaNombre);
		GroupLayout gl_lineaNombre = new GroupLayout(lineaNombre);
		gl_lineaNombre.setHorizontalGroup(
			gl_lineaNombre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaNombre.setVerticalGroup(
			gl_lineaNombre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaNombre.setLayout(gl_lineaNombre);
		
		nombreTextField = new JTextField();
		nombreTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarNombre();
			}
		});
		nombreTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarNombre();
			}
		});
		nombreTextField.setText("EJ: Pedro");
		nombreTextField.setOpaque(false);
		nombreTextField.setForeground(new Color(170, 170, 170));
		nombreTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		nombreTextField.setCaretColor(Color.WHITE);
		nombreTextField.setBorder(null);
		nombreTextField.setBackground(new Color(51, 51, 51));
		nombreTextField.setBounds(136, 204, 214, 21);
		eventoCambiarJTextField(nombreTextField, nombreTextField.getText(),20);
		add(nombreTextField);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblApellidos.setBounds(381, 191, 62, 14);
		add(lblApellidos);
		
		lineaApellidos = new JPanel();
		lineaApellidos.setPreferredSize(new Dimension(0, 3));
		lineaApellidos.setBackground(Color.WHITE);
		lineaApellidos.setBounds(381, 228, 214, 3);
		add(lineaApellidos);
		GroupLayout gl_lineaApellidos = new GroupLayout(lineaApellidos);
		gl_lineaApellidos.setHorizontalGroup(
			gl_lineaApellidos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaApellidos.setVerticalGroup(
			gl_lineaApellidos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaApellidos.setLayout(gl_lineaApellidos);
		
		apellidosTextField = new JTextField();
		apellidosTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarApellidos();
			}
		});
		apellidosTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarApellidos();
			}
		});
		apellidosTextField.setText("EJ: Rodriguez Diaz");
		apellidosTextField.setOpaque(false);
		apellidosTextField.setForeground(new Color(170, 170, 170));
		apellidosTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		apellidosTextField.setCaretColor(Color.WHITE);
		apellidosTextField.setBorder(null);
		apellidosTextField.setBackground(new Color(51, 51, 51));
		apellidosTextField.setBounds(381, 204, 214, 21);
		eventoCambiarJTextField(apellidosTextField, apellidosTextField.getText(), 50);
		add(apellidosTextField);
		
		JLabel lblNumeroTelefonico = new JLabel("Numero Telefonico");
		lblNumeroTelefonico.setForeground(Color.WHITE);
		lblNumeroTelefonico.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblNumeroTelefonico.setBounds(136, 247, 94, 14);
		add(lblNumeroTelefonico);
		
		lineaNumTel = new JPanel();
		lineaNumTel.setPreferredSize(new Dimension(0, 3));
		lineaNumTel.setBackground(Color.WHITE);
		lineaNumTel.setBounds(136, 284, 214, 3);
		add(lineaNumTel);
		GroupLayout gl_lineaNumTel = new GroupLayout(lineaNumTel);
		gl_lineaNumTel.setHorizontalGroup(
			gl_lineaNumTel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaNumTel.setVerticalGroup(
			gl_lineaNumTel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaNumTel.setLayout(gl_lineaNumTel);
		
		numTelefonoTextField = new JTextField();
		numTelefonoTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarNumeroTelefonico();
			}
		});
		numTelefonoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarNumeroTelefonico();
			}
		});
		numTelefonoTextField.setText("EJ: +56912345678 ");
		numTelefonoTextField.setOpaque(false);
		numTelefonoTextField.setForeground(new Color(170, 170, 170));
		numTelefonoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		numTelefonoTextField.setCaretColor(Color.WHITE);
		numTelefonoTextField.setBorder(null);
		numTelefonoTextField.setBackground(new Color(51, 51, 51));
		numTelefonoTextField.setBounds(136, 260, 214, 21);
		eventoCambiarJTextField(numTelefonoTextField, numTelefonoTextField.getText(), 25);
		add(numTelefonoTextField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblEmail.setBounds(381, 247, 62, 14);
		add(lblEmail);
		
		lineaEmail = new JPanel();
		lineaEmail.setPreferredSize(new Dimension(0, 3));
		lineaEmail.setBackground(Color.WHITE);
		lineaEmail.setBounds(381, 284, 214, 3);
		add(lineaEmail);
		GroupLayout gl_lineaEmail = new GroupLayout(lineaEmail);
		gl_lineaEmail.setHorizontalGroup(
			gl_lineaEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaEmail.setVerticalGroup(
			gl_lineaEmail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaEmail.setLayout(gl_lineaEmail);
		
		emailTextField = new JTextField();
		emailTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarEmail();
			}
		});
		emailTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarEmail();
			}
		});
		emailTextField.setText("EJ: ejemplo@ejemplo.com ");
		emailTextField.setOpaque(false);
		emailTextField.setForeground(new Color(170, 170, 170));
		emailTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		emailTextField.setCaretColor(Color.WHITE);
		emailTextField.setBorder(null);
		emailTextField.setBackground(new Color(51, 51, 51));
		emailTextField.setBounds(381, 260, 214, 21);
		eventoCambiarJTextField(emailTextField, emailTextField.getText(), 50);
		add(emailTextField);
		
		JButton btnAgregarUsuario = new JButton("AGREGAR USUARIO");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		eventoExpandirDisminuirTamañoBoton(btnAgregarUsuario, 15);
		btnAgregarUsuario.setBorder(null);
		btnAgregarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarUsuario.setBackground(Color.WHITE);
		btnAgregarUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarUsuario.setBounds(215, 458, 302, 64);
		add(btnAgregarUsuario);
		btnVolver = new JButton("");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setBorder(null);
		addEventoBotonEnteredAndExited(btnVolver);
		btnVolver.setBackground(new Color(51,51,51));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paneles[1].setVisible(true);
				paneles[0].setBounds(929, 39, 732, 558);
			}
		});
		btnVolver.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/volver-white.png")));
		btnVolver.setBounds(0, 510, 68, 48);
		add(btnVolver);
		
		lblAlertaRUT = new JLabel("");
		lblAlertaRUT.setVisible(false);
		lblAlertaRUT.setToolTipText("Hay un error de formato");
		lblAlertaRUT.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaRUT.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaRUT.setBounds(96, 153, 30, 27);
		add(lblAlertaRUT);
		
		lblAlertaNombre = new JLabel("");
		lblAlertaNombre.setVisible(false);
		lblAlertaNombre.setToolTipText("Hay un error de formato");
		lblAlertaNombre.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaNombre.setBounds(96, 204, 30, 27);
		add(lblAlertaNombre);
		
		lblAlertaNumTel = new JLabel("");
		lblAlertaNumTel.setVisible(false);
		lblAlertaNumTel.setToolTipText("Hay un error de formato");
		lblAlertaNumTel.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaNumTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaNumTel.setBounds(96, 260, 30, 27);
		add(lblAlertaNumTel);
		
		lblAlertaEmail = new JLabel("");
		lblAlertaEmail.setVisible(false);
		lblAlertaEmail.setToolTipText("Hay un error de formato");
		lblAlertaEmail.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaEmail.setBounds(602, 260, 30, 27);
		add(lblAlertaEmail);
		
		lblAlertaApellidos = new JLabel("");
		lblAlertaApellidos.setVisible(false);
		lblAlertaApellidos.setToolTipText("Hay un error de formato");
		lblAlertaApellidos.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaApellidos.setBounds(602, 204, 30, 27);
		add(lblAlertaApellidos);
		
		if (modo == 2) {
			btnAgregarUsuario.setText("MODIFICAR USUARIO");
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		nombreTextField.setForeground(Color.WHITE);
		nombreTextField.setText(elementoSeleccionado.get(0));
		apellidosTextField.setForeground(Color.WHITE);
		apellidosTextField.setText(elementoSeleccionado.get(1));
		rutTextField.setForeground(Color.WHITE);
		rutTextField.setText(elementoSeleccionado.get(2));
		rutAntiguo = elementoSeleccionado.get(2);
		numTelefonoTextField.setForeground(Color.WHITE);
		numTelefonoTextField.setText(elementoSeleccionado.get(3));
		emailTextField.setForeground(Color.WHITE);
		emailTextField.setText(elementoSeleccionado.get(4));
	}
	
	private void agregarDatos() {
		agregarDatosTablaUsuario();
	}

	private void agregarDatosTablaUsuario() {
		if (modoPanel == 1) {
    		consulta.addUsuario(nombreTextField.getText(),apellidosTextField.getText(),rutTextField.getText(),numTelefonoTextField.getText(),emailTextField.getText());    		
		} else if (modoPanel == 2){
			consulta.updtUsuario(rutTextField.getText(), rutAntiguo, nombreTextField.getText(), apellidosTextField.getText(),
					numTelefonoTextField.getText(), emailTextField.getText());
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarRut() && verificarNombre() && verificarApellidos() && verificarNumeroTelefonico() && verificarEmail()) {
			return true;
		}else {
			return false;	
		}
	}

	public boolean verificarEmail() {
		if(emailTextField.getText().length()<50) {
			 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailTextField.getText());
			 if(!matcher.find()) {
				 lineaEmail.setBackground(new Color(255,0,0));
				 lblAlertaEmail.setVisible(true);
				 return false;
			 }else {
				 lineaEmail.setBackground(new Color(50,205,50));
				 lblAlertaEmail.setVisible(false);
				 return true;
			 }
		}
		lblAlertaEmail.setVisible(true);
		lineaEmail.setBackground(new Color(255,0,0));
		return false;
	}

	private boolean verificarNumeroTelefonico() {
		if(!numTelefonoTextField.getText().matches("\\+((569)|(562)){1}[0-9]{8}")) { 
			setErroneo(lineaNumTel, lblAlertaNumTel);
			return false;
		}
		setAcertado(lineaNumTel, lblAlertaNumTel);
		return true;
	}
	
	private boolean verificarApellidos() {
		if(!apellidosTextField.getText().matches("[a-zA-Z ]{1,50}") || apellidosTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaApellidos, lblAlertaApellidos);
			return false;
		}
		setAcertado(lineaApellidos, lblAlertaApellidos);
		return true;
	}

	private boolean verificarNombre() {
		if(!nombreTextField.getText().matches("[a-zA-Z]{1,20}")) {
			setErroneo(lineaNombre, lblAlertaNombre);
			return false;
		}
		setAcertado(lineaNombre, lblAlertaNombre);
		return true;
	}

	private boolean verificarRut() {
		if(rutTextField.getText().charAt(0) == '0') {
			setErroneo(lineaRut, lblAlertaRUT);
			return false;
		}
		if(rutTextField.getText().matches("[0-9]{1,2}[.][1-9][0-9]{2}[.][1-9][0-9]{2}[-]([0-9]|(k|K))")) {
			setAcertado(lineaRut,lblAlertaRUT);
			return true;
		}
		setErroneo(lineaRut, lblAlertaRUT);
		return false;
	}
	
	public void setAcertado(JPanel panel, JLabel label){
		label.setVisible(false);
		panel.setBackground(new Color(50,205,50));
	}
	
	public void setErroneo(JPanel panel, JLabel label) {
		label.setVisible(true);
		panel.setBackground(new Color(255,0,0));
	}
	
	public void addEventoBotonEnteredAndExited(JButton boton){
		boton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			boton.setBackground(new Color(31,31,31));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			boton.setBackground(new Color(51,51,51));
		}
	});
	}
	
	private void eventoCambiarJTextField(JTextField txtUser, String relleno, int maxCaracteres) {
		txtUser.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		String text = txtUser.getText();
        		if (text.length() == 0 || text.length() >maxCaracteres) {
        			if(text.length() == 0) {
        				txtUser.setText(relleno);
        				txtUser.setForeground(new Color(170, 170, 170));
        			}
        		} else {
        			txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        	@Override
        	public void focusGained(FocusEvent e) {
        		txtUser.getText();
        		Color color = new Color(170, 170, 170);
        		if (txtUser.getForeground().equals(color) && txtUser.getText().length() < maxCaracteres) {
        			txtUser.setText("");
        			txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        });
	}
	
	private void eventoExpandirDisminuirTamañoBoton(JButton boton, int pixeles) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	
				boton.setBounds(
						(int)boton.getBounds().getX()-pixeles/2,
						(int)boton.getBounds().getY()-pixeles/2,
						(int)boton.getBounds().getWidth()+pixeles,
						(int)boton.getBounds().getHeight()+pixeles);
				boton.setFont(new Font("Roboto Light", Font.BOLD, 27));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boton.setBounds(
						(int)boton.getBounds().getX()+pixeles/2,
						(int)boton.getBounds().getY()+pixeles/2,
						(int)boton.getBounds().getWidth()-pixeles,
						(int)boton.getBounds().getHeight()-pixeles);
				boton.setFont(new Font("Roboto Light", Font.PLAIN, 25));
			}
		});
	}
}
