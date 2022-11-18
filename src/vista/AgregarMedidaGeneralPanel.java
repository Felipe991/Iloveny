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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarMedidaGeneralPanel extends JPanel {

	private static final long serialVersionUID = 2114849683033413530L;
	public int modo;
	public boolean existenArticulosConMedida;
	ArrayList<String> elementoSeleccionado;
	public Consulta consulta = new Consulta();
	
	private JLabel lblAlertaArticulo;
	private JComboBox ArticuloCB;
	private JTextField altoTextField;
	private JLabel lblAlertaAlto;
	private JLabel lblAlertaLargo;
	private JTextField largoTextField;
	private JTextField anchoTextField;
	private JLabel lblAlertaAncho;
	private JPanel lineaAlto;
	private JPanel lineaLargo;
	private JPanel lineaAncho;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	
	public AgregarMedidaGeneralPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		this.elementoSeleccionado = elementoSeleccionado;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblAgregarMedidaGeneral = new JLabel("Medida General");
		lblAgregarMedidaGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarMedidaGeneral.setForeground(Color.WHITE);
		lblAgregarMedidaGeneral.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarMedidaGeneral.setBounds(200, 11, 302, 55);
		add(lblAgregarMedidaGeneral);
		
		JLabel lblArticulo = new JLabel("Art\u00EDculo");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblArticulo.setBounds(312, 153, 62, 14);
		add(lblArticulo);
		
		JLabel lblLargo = new JLabel("Largo (cm)");
		lblLargo.setForeground(Color.WHITE);
		lblLargo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblLargo.setBounds(309, 212, 62, 14);
		add(lblLargo);
		
		lineaLargo = new JPanel();
		lineaLargo.setPreferredSize(new Dimension(0, 3));
		lineaLargo.setBackground(Color.WHITE);
		lineaLargo.setBounds(312, 252, 50, 3);
		add(lineaLargo);
		GroupLayout gl_lineaLargo = new GroupLayout(lineaLargo);
		gl_lineaLargo.setHorizontalGroup(
			gl_lineaLargo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaLargo.setVerticalGroup(
			gl_lineaLargo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaLargo.setLayout(gl_lineaLargo);
		
		largoTextField = new JTextField();
		largoTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarTextFieldSoloNumeros(largoTextField,lblAlertaLargo,lineaLargo);
			}
		});
		largoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarTextFieldSoloNumeros(largoTextField,lblAlertaLargo,lineaLargo);
			}
		});
		largoTextField.setText("EJ: 15");
		largoTextField.setOpaque(false);
		largoTextField.setForeground(new Color(170, 170, 170));
		largoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		largoTextField.setCaretColor(Color.WHITE);
		largoTextField.setBorder(null);
		largoTextField.setBackground(new Color(51, 51, 51));
		largoTextField.setBounds(312, 225, 50, 21);
		eventoCambiarJTextField(largoTextField, largoTextField.getText(), 50);
		add(largoTextField);
		
		ArticuloCB = new JComboBox();
		ArticuloCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCB(ArticuloCB, lblAlertaArticulo);
			}
		});
		ArticuloCB.setModel(crearModeloComboBoxId());
		ArticuloCB.setBounds(240, 180, 214, 21);
		add(ArticuloCB);
		
		JLabel lblAlto = new JLabel("Alto (cm)");
		lblAlto.setForeground(Color.WHITE);
		lblAlto.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblAlto.setBounds(240, 212, 49, 14);
		add(lblAlto);
		
		altoTextField = new JTextField();
		altoTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarTextFieldSoloNumeros(altoTextField,lblAlertaAlto,lineaAlto);
			}
		});
		altoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarTextFieldSoloNumeros(altoTextField,lblAlertaAlto,lineaAlto);
			}
		});
		altoTextField.setToolTipText("");
		altoTextField.setText("EJ: 14");
		altoTextField.setOpaque(false);
		altoTextField.setForeground(new Color(170, 170, 170));
		altoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		altoTextField.setCaretColor(Color.WHITE);
		altoTextField.setBorder(null);
		altoTextField.setBackground(new Color(51, 51, 51));
		altoTextField.setBounds(239, 225, 50, 21);
		eventoCambiarJTextField(altoTextField, altoTextField.getText(), 20);
		add(altoTextField);
		
		lineaAlto = new JPanel();
		lineaAlto.setPreferredSize(new Dimension(0, 3));
		lineaAlto.setBackground(Color.WHITE);
		lineaAlto.setBounds(239, 252, 50, 3);
		add(lineaAlto);
		GroupLayout gl_lineaAlto = new GroupLayout(lineaAlto);
		gl_lineaAlto.setHorizontalGroup(
			gl_lineaAlto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaAlto.setVerticalGroup(
			gl_lineaAlto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaAlto.setLayout(gl_lineaAlto);
		
		JLabel lblAncho = new JLabel("Ancho(cm)");
		lblAncho.setForeground(Color.WHITE);
		lblAncho.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblAncho.setBounds(383, 212, 62, 14);
		add(lblAncho);
		
		anchoTextField = new JTextField();
		anchoTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarTextFieldSoloNumeros(anchoTextField,lblAlertaAncho,lineaAncho);
			}
		});
		anchoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarTextFieldSoloNumeros(anchoTextField,lblAlertaAncho,lineaAncho);
			}
		});
		anchoTextField.setText("EJ: 10");
		anchoTextField.setOpaque(false);
		anchoTextField.setForeground(new Color(170, 170, 170));
		anchoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		anchoTextField.setCaretColor(Color.WHITE);
		anchoTextField.setBorder(null);
		anchoTextField.setBackground(new Color(51, 51, 51));
		anchoTextField.setBounds(383, 225, 50, 21);
		eventoCambiarJTextField(anchoTextField, anchoTextField.getText(), 20);
		add(anchoTextField);
		
		lineaAncho = new JPanel();
		lineaAncho.setPreferredSize(new Dimension(0, 3));
		lineaAncho.setBackground(Color.WHITE);
		lineaAncho.setBounds(383, 252, 50, 3);
		add(lineaAncho);
		GroupLayout gl_lineaAncho = new GroupLayout(lineaAncho);
		gl_lineaAncho.setHorizontalGroup(
			gl_lineaAncho.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaAncho.setVerticalGroup(
			gl_lineaAncho.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaAncho.setLayout(gl_lineaAncho);
		
		JButton btnAgregarMedidaGeneral = new JButton("AGREGAR MEDIDA GENERAL");
		btnAgregarMedidaGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarMedidaGeneral.setBorder(null);
		btnAgregarMedidaGeneral.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarMedidaGeneral.setBackground(Color.WHITE);
		btnAgregarMedidaGeneral.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarMedidaGeneral.setBounds(155, 457, 402, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarMedidaGeneral, 15);
		add(btnAgregarMedidaGeneral);
		
		lblAlertaAlto = new JLabel("");
		lblAlertaAlto.setVisible(false);
		lblAlertaAlto.setToolTipText("Hay un error de formato");
		lblAlertaAlto.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaAlto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaAlto.setBounds(249, 266, 30, 27);
		add(lblAlertaAlto);
		
		lblAlertaLargo = new JLabel("");
		lblAlertaLargo.setVisible(false);
		lblAlertaLargo.setToolTipText("Hay un error de formato");
		lblAlertaLargo.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaLargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaLargo.setBounds(322, 266, 30, 27);
		add(lblAlertaLargo);
		
		lblAlertaAncho = new JLabel("");
		lblAlertaAncho.setVisible(false);
		lblAlertaAncho.setToolTipText("Hay un error de formato");
		lblAlertaAncho.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaAncho.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaAncho.setBounds(393, 266, 30, 27);
		add(lblAlertaAncho);
		
		lblAlertaArticulo = new JLabel("");
		lblAlertaArticulo.setVisible(false);
		lblAlertaArticulo.setToolTipText("Hay un error de formato");
		lblAlertaArticulo.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaArticulo.setBounds(200, 174, 30, 27);
		add(lblAlertaArticulo);
		
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
		ArticuloCB.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...",elementoSeleccionado.get(0)+ " ("+elementoSeleccionado.get(1)+")"}));
		ArticuloCB.setSelectedIndex(1);
		ArticuloCB.setEnabled(false);
		altoTextField.setText(elementoSeleccionado.get(2));
		anchoTextField.setText(elementoSeleccionado.get(3));
		largoTextField.setText(elementoSeleccionado.get(4));
	}

	private void cambiarColorTextFieldsBlanco() {
		Component[] componentes = this.getComponents();
		for(int i = 0; i<componentes.length;i++) {
			if(componentes[i].getClass().equals(JTextField.class)) {
				componentes[i].setForeground(Color.WHITE);
			}
		}
	}

	private DefaultComboBoxModel crearModeloComboBoxId() {
		ArrayList<?> elementosObetenidos = consulta.getIdArticuloSinMedidaGeneral();
		if(elementosObetenidos.size()>0) {
			existenArticulosConMedida = true;
			String[] listasMedidas = new String[elementosObetenidos.size()+1];
			listasMedidas[0] = "Seleccione...";
			for(int i=1; i<=elementosObetenidos.size();i++) {
				listasMedidas[i] = elementosObetenidos.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listasMedidas);
		}else {
			lblAlertaArticulo.setVisible(true);
			existenArticulosConMedida = false;
			return new DefaultComboBoxModel(new String[] {"No existen articulos sin medida especifica"});
		}
	}

	private void agregarDatos() {
		agregarDatosTablaMedidaGeneral();
	}
	
	private void agregarDatosTablaMedidaGeneral() {
		if (modo == 1) {
			consulta.addMedidaG(Integer.parseInt(largoTextField.getText()), Integer.parseInt(altoTextField.getText()), 
								Integer.parseInt(anchoTextField.getText()), obtenerIdSeleccionado());
		} else if(modo == 2) {
			consulta.updtMedidaG(Integer.parseInt(largoTextField.getText()), Integer.parseInt(altoTextField.getText()), 
								Integer.parseInt(anchoTextField.getText()), Integer.parseInt(elementoSeleccionado.get(0)));
		}
	}

	private int obtenerIdSeleccionado() {
		String opcionSeleccionada = (String)ArticuloCB.getSelectedItem();
		String idString = obtenerIdEnString(opcionSeleccionada);
		int id = Integer.parseInt(idString);
		return id;
	}

	private String obtenerIdEnString(String opcionSeleccionada) {
		char[] caracteres = opcionSeleccionada.toCharArray();
		String id = "";
		for(char c : caracteres) {
			if(c == ' ') {
				break;
			}
			id+= c;
		}
		return id;
	}

	private boolean isTodoCorrecto() {
		if(verificarTextFieldSoloNumeros(altoTextField,lblAlertaAlto,lineaAlto) && verificarCB(ArticuloCB, lblAlertaArticulo) && verificarTextFieldSoloNumeros(anchoTextField,lblAlertaAncho,lineaAncho) && verificarTextFieldSoloNumeros(largoTextField,lblAlertaLargo,lineaLargo)) {
			return true;
		}
		return false;
	}

	private boolean verificarCB(JComboBox comboBox, JLabel alerta) {
		if(comboBox.getSelectedIndex() == 0) {
			alerta.setVisible(true);
			return false;
		}
		alerta.setVisible(false);
		return true;
	}

	private boolean verificarTextFieldSoloNumeros(JTextField textfield,JLabel alerta, JPanel linea) {
		if(!textfield.getText().matches("[0-9]{1,5}") || textfield.getText().charAt(0) == '0') {
			setErroneo(linea, alerta);
			return false;
		}
		setAcertado(linea, alerta);
		lblAlertaLargo.setVisible(false);
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
