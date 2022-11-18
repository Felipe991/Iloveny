package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import a.Modelo.Consulta;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarDireccionPanel extends JPanel {

	private static final long serialVersionUID = -7474338284438590427L;
	public int modo;
	ArrayList<String> elementoSeleccionado;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	
	private JLabel lblAlertaRegion;
	private JComboBox RegionCB;
	private JTextField comunaTextField;
	private JLabel lblAlertaComuna;
	private JLabel lblAlertaNombreCalle;
	private JTextField calleTextField;
	private JTextField numCalleTextField;
	private JTextField ciudadTextField;
	private JLabel lblAlertaCiudad;
	private JLabel lblAlertaNumCalle;
	private JComboBox rutCB;
	private JLabel lblAlertaRut;
	private JPanel lineaComuna;
	private JPanel lineaNombreCalle;
	private JPanel lineaNumeroCalle;
	private JPanel lineaCiudad;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	
	@SuppressWarnings("unchecked")
	public AgregarDireccionPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		this.elementoSeleccionado = elementoSeleccionado;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		lblAlertaRut = new JLabel("");
		lblAlertaRut.setVisible(false);
		lblAlertaRut.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaRut.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaRut.setBounds(604, 177, 30, 27);
		add(lblAlertaRut);
		
		JLabel lblAgregarUsuario = new JLabel("Direccion\r\n");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarUsuario.setBounds(215, 11, 302, 55);
		add(lblAgregarUsuario);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setForeground(Color.WHITE);
		lblRegion.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblRegion.setBounds(138, 155, 62, 14);
		add(lblRegion);
		
		JLabel lblCalle = new JLabel("Nombre calle");
		lblCalle.setForeground(Color.WHITE);
		lblCalle.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCalle.setBounds(138, 267, 106, 14);
		add(lblCalle);
		
		lineaNombreCalle = new JPanel();
		lineaNombreCalle.setPreferredSize(new Dimension(0, 3));
		lineaNombreCalle.setBackground(Color.WHITE);
		lineaNombreCalle.setBounds(138, 304, 214, 3);
		add(lineaNombreCalle);
		GroupLayout gl_lineaNombreCalle = new GroupLayout(lineaNombreCalle);
		gl_lineaNombreCalle.setHorizontalGroup(
			gl_lineaNombreCalle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaNombreCalle.setVerticalGroup(
			gl_lineaNombreCalle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaNombreCalle.setLayout(gl_lineaNombreCalle);
		
		calleTextField = new JTextField();
		calleTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCalle();
			}
		});
		calleTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarCalle();
			}
		});
		calleTextField.setText("EJ: Los Arrayanes ");
		calleTextField.setOpaque(false);
		calleTextField.setForeground(new Color(170, 170, 170));
		calleTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		calleTextField.setCaretColor(Color.WHITE);
		calleTextField.setBorder(null);
		calleTextField.setBackground(new Color(51, 51, 51));
		calleTextField.setBounds(138, 280, 214, 21);
		eventoCambiarJTextField(calleTextField, calleTextField.getText(), 50);
		add(calleTextField);
		
		RegionCB = new JComboBox(new String[] {"Seleccione...","Tarapaca", "Antofagasta", "Atacama", "Coquimbo", "Valparaiso",
														"Ohiggins","Maule","Biobio","La Araucania","Los Lagos","Aysen","Magallanes",
														"Metropolitana","Los Rios","Arica y P.","Ñuble"});
		RegionCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarRegion();
			}
		});
		RegionCB.setBounds(138, 180, 214, 21);
		add(RegionCB);
		
		JLabel lblNumeroCalle = new JLabel("Numero calle");
		lblNumeroCalle.setForeground(Color.WHITE);
		lblNumeroCalle.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblNumeroCalle.setBounds(383, 267, 106, 14);
		add(lblNumeroCalle);
		
		numCalleTextField = new JTextField();
		numCalleTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarNumCalle();
			}
		});
		numCalleTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarNumCalle();
			}
		});
		numCalleTextField.setText("EJ: 1234 ");
		numCalleTextField.setOpaque(false);
		numCalleTextField.setForeground(new Color(170, 170, 170));
		numCalleTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		numCalleTextField.setCaretColor(Color.WHITE);
		numCalleTextField.setBorder(null);
		numCalleTextField.setBackground(new Color(51, 51, 51));
		numCalleTextField.setBounds(383, 280, 214, 21);
		eventoCambiarJTextField(numCalleTextField, numCalleTextField.getText(), 50);
		add(numCalleTextField);
		
		lineaNumeroCalle = new JPanel();
		lineaNumeroCalle.setPreferredSize(new Dimension(0, 3));
		lineaNumeroCalle.setBackground(Color.WHITE);
		lineaNumeroCalle.setBounds(383, 304, 214, 3);
		add(lineaNumeroCalle);
		GroupLayout gl_lineaNumeroCalle = new GroupLayout(lineaNumeroCalle);
		gl_lineaNumeroCalle.setHorizontalGroup(
			gl_lineaNumeroCalle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaNumeroCalle.setVerticalGroup(
			gl_lineaNumeroCalle.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaNumeroCalle.setLayout(gl_lineaNumeroCalle);
		
		JLabel lblComuna = new JLabel("Comuna");
		lblComuna.setForeground(Color.WHITE);
		lblComuna.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblComuna.setBounds(138, 212, 106, 14);
		add(lblComuna);
		
		comunaTextField = new JTextField();
		comunaTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarComuna();
			}
		});
		comunaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarComuna();
			}
		});
		comunaTextField.setToolTipText("");
		comunaTextField.setText("EJ: Coquimbo ");
		comunaTextField.setOpaque(false);
		comunaTextField.setForeground(new Color(170, 170, 170));
		comunaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comunaTextField.setCaretColor(Color.WHITE);
		comunaTextField.setBorder(null);
		comunaTextField.setBackground(new Color(51, 51, 51));
		comunaTextField.setBounds(138, 225, 214, 21);
		eventoCambiarJTextField(comunaTextField, comunaTextField.getText(), 20);
		add(comunaTextField);
		
		lineaComuna = new JPanel();
		lineaComuna.setPreferredSize(new Dimension(0, 3));
		lineaComuna.setBackground(Color.WHITE);
		lineaComuna.setBounds(138, 249, 214, 3);
		add(lineaComuna);
		GroupLayout gl_lineaComuna = new GroupLayout(lineaComuna);
		gl_lineaComuna.setHorizontalGroup(
			gl_lineaComuna.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaComuna.setVerticalGroup(
			gl_lineaComuna.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaComuna.setLayout(gl_lineaComuna);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCiudad.setBounds(383, 212, 106, 14);
		add(lblCiudad);
		
		ciudadTextField = new JTextField();
		ciudadTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCiudad();
			}
		});
		ciudadTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarCiudad();
			}
		});
		ciudadTextField.setText("EJ: Ovalle ");
		ciudadTextField.setOpaque(false);
		ciudadTextField.setForeground(new Color(170, 170, 170));
		ciudadTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ciudadTextField.setCaretColor(Color.WHITE);
		ciudadTextField.setBorder(null);
		ciudadTextField.setBackground(new Color(51, 51, 51));
		ciudadTextField.setBounds(383, 225, 214, 21);
		eventoCambiarJTextField(ciudadTextField, ciudadTextField.getText(), 20);
		add(ciudadTextField);
		
		lineaCiudad = new JPanel();
		lineaCiudad.setPreferredSize(new Dimension(0, 3));
		lineaCiudad.setBackground(Color.WHITE);
		lineaCiudad.setBounds(383, 249, 214, 3);
		add(lineaCiudad);
		GroupLayout gl_lineaCiudad = new GroupLayout(lineaCiudad);
		gl_lineaCiudad.setHorizontalGroup(
			gl_lineaCiudad.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaCiudad.setVerticalGroup(
			gl_lineaCiudad.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaCiudad.setLayout(gl_lineaCiudad);
		
		JButton btnAgregarDireccion = new JButton("AGREGAR DIRECCION");
		btnAgregarDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarDireccion.setBorder(null);
		btnAgregarDireccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarDireccion.setBackground(Color.WHITE);
		btnAgregarDireccion.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarDireccion.setBounds(215, 458, 302, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarDireccion, 15);
		add(btnAgregarDireccion);
		
		lblAlertaComuna = new JLabel("");
		lblAlertaComuna.setVisible(false);
		lblAlertaComuna.setToolTipText("Hay un error de formato");
		lblAlertaComuna.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaComuna.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaComuna.setBounds(99, 222, 30, 27);
		add(lblAlertaComuna);
		
		lblAlertaNombreCalle = new JLabel("");
		lblAlertaNombreCalle.setVisible(false);
		lblAlertaNombreCalle.setToolTipText("Hay un error de formato");
		lblAlertaNombreCalle.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaNombreCalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaNombreCalle.setBounds(98, 280, 30, 27);
		add(lblAlertaNombreCalle);
		
		lblAlertaNumCalle = new JLabel("");
		lblAlertaNumCalle.setVisible(false);
		lblAlertaNumCalle.setToolTipText("Hay un error de formato");
		lblAlertaNumCalle.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaNumCalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaNumCalle.setBounds(604, 280, 30, 27);
		add(lblAlertaNumCalle);
		
		lblAlertaCiudad = new JLabel("");
		lblAlertaCiudad.setVisible(false);
		lblAlertaCiudad.setToolTipText("Hay un error de formato");
		lblAlertaCiudad.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaCiudad.setBounds(604, 225, 30, 27);
		add(lblAlertaCiudad);
		
		lblAlertaRegion = new JLabel("");
		lblAlertaRegion.setVisible(false);
		lblAlertaRegion.setToolTipText("Hay un error de formato");
		lblAlertaRegion.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaRegion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaRegion.setBounds(98, 174, 30, 27);
		add(lblAlertaRegion);
		
		JLabel lblRut = new JLabel("RUT");
		lblRut.setForeground(Color.WHITE);
		lblRut.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblRut.setBounds(383, 155, 62, 14);
		add(lblRut);
		
		DefaultComboBoxModel modelo = crearModeloComboBox();
		rutCB = new JComboBox(new Object[]{});
		rutCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarRut();
			}
		});
		rutCB.setModel(modelo);
		rutCB.setBounds(383, 180, 214, 21);
		add(rutCB);
		
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
		
		if (modo == 2) {
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		cambiarColorTextFieldsBlanco();
		rutCB.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...",elementoSeleccionado.get(0)}));
		rutCB.setSelectedIndex(1);
		rutCB.setEnabled(false);
		setIndiceElementoSeleccionado(RegionCB, elementoSeleccionado.get(1));
		numCalleTextField.setText(elementoSeleccionado.get(2));
		calleTextField.setText(elementoSeleccionado.get(3));
		ciudadTextField.setText(elementoSeleccionado.get(4));
		comunaTextField.setText(elementoSeleccionado.get(5));
	}

	private void setIndiceElementoSeleccionado(JComboBox comboBox, String elementoABuscar) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).toString().contains(elementoABuscar)) {
            	comboBox.setSelectedIndex(i);
            	break;
            }
        }
	}

	private void cambiarColorTextFieldsBlanco() {
		Component[] componentes = this.getComponents();
		for(int i = 0; i<componentes.length;i++) {
			if(componentes[i].getClass().equals(JTextField.class)) {
				componentes[i].setForeground(Color.WHITE);
			}
		}
	}
	
	private boolean verificarRut() {
		if(rutCB.getSelectedIndex() == 0) {
			lblAlertaRut.setVisible(true);
			return false;
		}
		lblAlertaRut.setVisible(false);
		return true;
	}

	private DefaultComboBoxModel crearModeloComboBox() {
		ArrayList<?> ruts = consulta.getRutsSinDireccion();
		if(ruts.size()>0) {
			existenRutsSinDireccion = true;
			String[] listaRuts = new String[ruts.size()+1];
			listaRuts[0] = "Seleccione...";
			for(int i=1; i<=ruts.size();i++) {
				listaRuts[i] = ruts.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaRuts);
		}else {
			lblAlertaRut.setVisible(true);
			existenRutsSinDireccion = false;
			return new DefaultComboBoxModel(new String[] {"No existen ruts"});
		}
	}

	private void agregarDatos() {
		agregarDatosTablaDireccion();
	}
	
	private void agregarDatosTablaDireccion() {
		if (modo == 1) {
			consulta.addDireccion((String)rutCB.getSelectedItem(), RegionCB.getSelectedIndex(), Integer.parseInt(numCalleTextField.getText()),calleTextField.getText() , ciudadTextField.getText(), comunaTextField.getText()); 
		} else if(modo == 2) {
			consulta.updtDireccion(RegionCB.getSelectedIndex(), Integer.parseInt(numCalleTextField.getText()), calleTextField.getText() , ciudadTextField.getText(), comunaTextField.getText(), (String)rutCB.getSelectedItem());
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarCalle() && verificarNumCalle() && verificarRegion() && verificarComuna() && verificarCiudad() && verificarRut()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarCiudad() {
		if( !ciudadTextField.getText().matches("[a-zA-Z ]{1,20}") || ciudadTextField.getText().charAt(0) == ' ') {
			lblAlertaCiudad.setVisible(true);
			setErroneo(lineaCiudad, lblAlertaCiudad);
			return false;
		}
		setAcertado(lineaCiudad, lblAlertaCiudad);
		lblAlertaCiudad.setVisible(false);
		return true;
	}
	
	private boolean verificarComuna() {
		if(!comunaTextField.getText().matches("[a-zA-Z ]{1,20}")|| comunaTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaComuna, lblAlertaComuna);
			return false;
		}
		setAcertado(lineaComuna, lblAlertaComuna);
		return true;
	}

	private boolean verificarRegion() {
		if(RegionCB.getSelectedIndex() == 0) {
			lblAlertaRegion.setVisible(true);
			return false;
		}
		lblAlertaRegion.setVisible(false);
		return true;
	}

	private boolean verificarNumCalle() {
		if(!numCalleTextField.getText().matches("[0-9]{1,10}")) {
			setErroneo(lineaNumeroCalle, lblAlertaNumCalle);
			return false;
		}
		setAcertado(lineaNumeroCalle, lblAlertaNumCalle);
		return true;
	}

	private boolean verificarCalle() {
		if(!calleTextField.getText().matches("[a-zA-Z0-9. ]{1,50}") || calleTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaNombreCalle, lblAlertaNombreCalle);
			return false;
		}
		setAcertado(lineaNombreCalle, lblAlertaNombreCalle);
		return true;
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
