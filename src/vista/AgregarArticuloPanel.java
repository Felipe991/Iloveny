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

public class AgregarArticuloPanel extends JPanel {

	private static final long serialVersionUID = -4579039619021999060L;
	public int modo;
	public boolean existenRutsSinDireccion;
	ArrayList<String> elementoSeleccionado;
	public Consulta consulta = new Consulta();
	
	private JLabel lblAlertaMarca;
	private JComboBox MarcaCB;
	private JTextField descripcionTextField;
	private JLabel lblAlertaDescripcion;
	private JTextField stockTextField;
	private JTextField precioTextField;
	private JLabel lblAlertaPrecioUnitario;
	private JLabel lblAlertaStock;
	private JComboBox tipoObjetoCB;
	private JLabel lblAlertaTipoObjeto;
	private JPanel lineaDescripcion;
	private JPanel lineaStock;
	private JPanel lineaPrecioUnitario;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private JTextField txtRutaImg;
	private JPanel lineaRutaImg;
	public JLabel lblAlertaURL;
	
	public AgregarArticuloPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		this.elementoSeleccionado = elementoSeleccionado;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		lblAlertaTipoObjeto = new JLabel("");
		lblAlertaTipoObjeto.setVisible(false);
		lblAlertaTipoObjeto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaTipoObjeto.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaTipoObjeto.setBounds(604, 177, 30, 27);
		add(lblAlertaTipoObjeto);
		
		JLabel lblAgregarArticulo = new JLabel("Art\u00EDculo");
		lblAgregarArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarArticulo.setForeground(Color.WHITE);
		lblAgregarArticulo.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarArticulo.setBounds(215, 11, 302, 55);
		add(lblAgregarArticulo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblMarca.setBounds(138, 155, 62, 14);
		add(lblMarca);
		
		//TODO
		DefaultComboBoxModel modeloMarca = crearModeloComboBoxMarca();
		MarcaCB = new JComboBox(new Object[]{});
		MarcaCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarMarca();
			}
		});
		MarcaCB.setModel(modeloMarca);
		MarcaCB.setBounds(138, 180, 214, 21);
		add(MarcaCB);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblStock.setBounds(383, 260, 106, 14);
		add(lblStock);
		
		stockTextField = new JTextField();
		stockTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				verificarStock();
			}
		});
		stockTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarStock();
			}
		});
		stockTextField.setText("EJ: 2");
		stockTextField.setOpaque(false);
		stockTextField.setForeground(new Color(170, 170, 170));
		stockTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		stockTextField.setCaretColor(Color.WHITE);
		stockTextField.setBorder(null);
		stockTextField.setBackground(new Color(51, 51, 51));
		stockTextField.setBounds(383, 270, 47, 21);
		eventoCambiarJTextField(stockTextField, stockTextField.getText(), 50);
		add(stockTextField);
		
		lineaStock = new JPanel();
		lineaStock.setPreferredSize(new Dimension(0, 3));
		lineaStock.setBackground(Color.WHITE);
		lineaStock.setBounds(383, 294, 47, 3);
		add(lineaStock);
		GroupLayout gl_lineaStock = new GroupLayout(lineaStock);
		gl_lineaStock.setHorizontalGroup(
			gl_lineaStock.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaStock.setVerticalGroup(
			gl_lineaStock.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaStock.setLayout(gl_lineaStock);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblDescripcion.setBounds(138, 212, 106, 14);
		add(lblDescripcion);
		
		descripcionTextField = new JTextField();
		descripcionTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarDescripcion();
			}
		});
		descripcionTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarDescripcion();
			}
		});
		descripcionTextField.setToolTipText("");
		descripcionTextField.setText("EJ: Anillo de Onyx");
		descripcionTextField.setOpaque(false);
		descripcionTextField.setForeground(new Color(170, 170, 170));
		descripcionTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		descripcionTextField.setCaretColor(Color.WHITE);
		descripcionTextField.setBorder(null);
		descripcionTextField.setBackground(new Color(51, 51, 51));
		descripcionTextField.setBounds(138, 225, 214, 21);
		eventoCambiarJTextField(descripcionTextField, descripcionTextField.getText(), 50);
		add(descripcionTextField);
		
		lineaDescripcion = new JPanel();
		lineaDescripcion.setPreferredSize(new Dimension(0, 3));
		lineaDescripcion.setBackground(Color.WHITE);
		lineaDescripcion.setBounds(138, 249, 214, 3);
		add(lineaDescripcion);
		GroupLayout gl_lineaDescripcion = new GroupLayout(lineaDescripcion);
		gl_lineaDescripcion.setHorizontalGroup(
			gl_lineaDescripcion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaDescripcion.setVerticalGroup(
			gl_lineaDescripcion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaDescripcion.setLayout(gl_lineaDescripcion);
		
		JLabel lblPrecioUnitario = new JLabel("Precio unitario (CLP)");
		lblPrecioUnitario.setForeground(Color.WHITE);
		lblPrecioUnitario.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblPrecioUnitario.setBounds(383, 212, 106, 14);
		add(lblPrecioUnitario);
		
		precioTextField = new JTextField();
		precioTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarPrecioUnitario();
			}
		});
		precioTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarPrecioUnitario();
			}
		});
		precioTextField.setText("EJ: 2000");
		precioTextField.setOpaque(false);
		precioTextField.setForeground(new Color(170, 170, 170));
		precioTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		precioTextField.setCaretColor(Color.WHITE);
		precioTextField.setBorder(null);
		precioTextField.setBackground(new Color(51, 51, 51));
		precioTextField.setBounds(383, 225, 214, 21);
		eventoCambiarJTextField(precioTextField, precioTextField.getText(), 20);
		add(precioTextField);
		
		lineaPrecioUnitario = new JPanel();
		lineaPrecioUnitario.setPreferredSize(new Dimension(0, 3));
		lineaPrecioUnitario.setBackground(Color.WHITE);
		lineaPrecioUnitario.setBounds(383, 249, 214, 3);
		add(lineaPrecioUnitario);
		GroupLayout gl_lineaPrecioUnitario = new GroupLayout(lineaPrecioUnitario);
		gl_lineaPrecioUnitario.setHorizontalGroup(
			gl_lineaPrecioUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaPrecioUnitario.setVerticalGroup(
			gl_lineaPrecioUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaPrecioUnitario.setLayout(gl_lineaPrecioUnitario);
		
		JButton btnAgregarArticulo = new JButton("AGREGAR ART\u00CDCULO");
		btnAgregarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarArticulo.setBorder(null);
		btnAgregarArticulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarArticulo.setBackground(Color.WHITE);
		btnAgregarArticulo.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarArticulo.setBounds(215, 458, 302, 64);
		eventoExpandirDisminuirTamanoBoton(btnAgregarArticulo, 15);
		add(btnAgregarArticulo);
		
		lblAlertaDescripcion = new JLabel("");
		lblAlertaDescripcion.setVisible(false);
		lblAlertaDescripcion.setToolTipText("Hay un error de formato");
		lblAlertaDescripcion.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaDescripcion.setBounds(99, 225, 30, 27);
		add(lblAlertaDescripcion);
		
		lblAlertaURL = new JLabel("");
		lblAlertaURL.setVisible(false);
		lblAlertaURL.setToolTipText("Hay un error de formato");
		lblAlertaURL.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaURL.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaURL.setBounds(99, 270, 30, 27);
		add(lblAlertaURL);
		
		lblAlertaStock = new JLabel("");
		lblAlertaStock.setVisible(false);
		lblAlertaStock.setToolTipText("Hay un error de formato");
		lblAlertaStock.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaStock.setBounds(431, 270, 30, 27);
		add(lblAlertaStock);
		
		lblAlertaPrecioUnitario = new JLabel("");
		lblAlertaPrecioUnitario.setVisible(false);
		lblAlertaPrecioUnitario.setToolTipText("Hay un error de formato");
		lblAlertaPrecioUnitario.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaPrecioUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaPrecioUnitario.setBounds(604, 225, 30, 27);
		add(lblAlertaPrecioUnitario);
		
		lblAlertaMarca = new JLabel("");
		lblAlertaMarca.setVisible(false);
		lblAlertaMarca.setToolTipText("Hay un error de formato");
		lblAlertaMarca.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaMarca.setBounds(98, 174, 30, 27);
		add(lblAlertaMarca);
		
		JLabel lblTipoObjeto = new JLabel("Tipo de objeto");
		lblTipoObjeto.setForeground(Color.WHITE);
		lblTipoObjeto.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblTipoObjeto.setBounds(383, 155, 134, 14);
		add(lblTipoObjeto);
		
		DefaultComboBoxModel modeloTipo = crearModeloComboBoxTipos();
		tipoObjetoCB = new JComboBox(new Object[]{});
		tipoObjetoCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarTipoObjeto();
			}
		});
		tipoObjetoCB.setModel(modeloTipo);
		tipoObjetoCB.setBounds(383, 180, 214, 21);
		add(tipoObjetoCB);
		
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
		
		JLabel lblRutaImagen = new JLabel("Ruta imagen");
		lblRutaImagen.setForeground(Color.WHITE);
		lblRutaImagen.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblRutaImagen.setBounds(138, 260, 106, 14);
		add(lblRutaImagen);
		
		txtRutaImg = new JTextField();
		txtRutaImg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarURL();
			}
		});
		txtRutaImg.setText("EJ: https://imgur.com/(codigo)");
		txtRutaImg.setOpaque(false);
		txtRutaImg.setForeground(new Color(170, 170, 170));
		txtRutaImg.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtRutaImg.setCaretColor(Color.WHITE);
		txtRutaImg.setBorder(null);
		txtRutaImg.setBackground(new Color(51, 51, 51));
		txtRutaImg.setBounds(138, 273, 214, 21);
		
		add(txtRutaImg);
		
		lineaRutaImg = new JPanel();
		lineaRutaImg.setPreferredSize(new Dimension(0, 3));
		lineaRutaImg.setBackground(Color.WHITE);
		lineaRutaImg.setBounds(138, 294, 214, 3);
		add(lineaRutaImg);
		GroupLayout gl_lineaRutaImg = new GroupLayout(lineaRutaImg);
		gl_lineaRutaImg.setHorizontalGroup(
			gl_lineaRutaImg.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaRutaImg.setVerticalGroup(
			gl_lineaRutaImg.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaRutaImg.setLayout(gl_lineaRutaImg);
		
		if (modo == 2) {
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		cambiarColorTextFieldsBlanco();
		setIndiceElementoSeleccionado(tipoObjetoCB, elementoSeleccionado.get(1));
		setIndiceElementoSeleccionado(MarcaCB, elementoSeleccionado.get(2));
		stockTextField.setText(elementoSeleccionado.get(3));
		precioTextField.setText(elementoSeleccionado.get(4));
		descripcionTextField.setText(elementoSeleccionado.get(5));
		txtRutaImg.setText(elementoSeleccionado.get(6));
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
	
	private boolean verificarTipoObjeto() {
		if(tipoObjetoCB.getSelectedIndex() == 0) {
			lblAlertaTipoObjeto.setVisible(true);
			return false;
		}
		lblAlertaTipoObjeto.setVisible(false);
		return true;
	}

	private boolean verificarURL() {
		if(!txtRutaImg.getText().matches("https://imgur\\.com/[a-zA-Z0-9:]{1,30}")) {
			setErroneo(lineaRutaImg, lblAlertaURL);
			return false;
		}
		setAcertado(lineaRutaImg, lblAlertaURL);
		return true;
	}

	private void agregarDatos() {
		agregarDatosTablaArticulo();
	}
	
	private DefaultComboBoxModel crearModeloComboBoxTipos() {
		ArrayList<?> elementosObtenidos = consulta.getNombresTipoObjeto();
		if(elementosObtenidos.size()>0) {
			String[] listaStringElementosAdquiridos = new String[elementosObtenidos.size()+1];
			listaStringElementosAdquiridos[0] = "Seleccione...";
			for(int i=1; i<=elementosObtenidos.size();i++) {
				listaStringElementosAdquiridos[i] = elementosObtenidos.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaStringElementosAdquiridos);
		}else {
			lblAlertaTipoObjeto.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No existen tipos"});
		}
	}
	
	private DefaultComboBoxModel crearModeloComboBoxMarca() {
		ArrayList<?> elementosObtenidos = consulta.getNombresMarca();
		if(elementosObtenidos.size()>0) {
			String[] listaStringElementosAdquiridos = new String[elementosObtenidos.size()+1];
			listaStringElementosAdquiridos[0] = "Seleccione...";
			for(int i=1; i<=elementosObtenidos.size();i++) {
				listaStringElementosAdquiridos[i] = elementosObtenidos.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaStringElementosAdquiridos);
		}else {
			lblAlertaTipoObjeto.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No existen marcas"});
		}
	}
	
	private void agregarDatosTablaArticulo() {
		if (modo == 1) {
			consulta.addArticulo(Integer.parseInt(obtenerIdEnString(tipoObjetoCB.getSelectedItem().toString())),Integer.parseInt(obtenerIdEnString(MarcaCB.getSelectedItem().toString())), Integer.parseInt(stockTextField.getText()),
					descripcionTextField.getText(), txtRutaImg.getText(), Integer.parseInt(precioTextField.getText()));
		}else {
			consulta.updtArticulo(Integer.parseInt(obtenerIdEnString(tipoObjetoCB.getSelectedItem().toString())), Integer.parseInt(obtenerIdEnString(MarcaCB.getSelectedItem().toString())), Integer.parseInt(stockTextField.getText()),
					Integer.parseInt(precioTextField.getText()), Integer.parseInt(elementoSeleccionado.get(0)), descripcionTextField.getText(),
					txtRutaImg.getText());
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarStock() && verificarMarca() && verificarDescripcion() && verificarPrecioUnitario() && verificarTipoObjeto()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarPrecioUnitario() {
		if(!precioTextField.getText().matches("[0-9]{1,10}") || precioTextField.getText().charAt(0) == '0') {
			setErroneo(lineaPrecioUnitario, lblAlertaPrecioUnitario);
			return false;
		}
		setAcertado(lineaPrecioUnitario, lblAlertaPrecioUnitario);
		return true;
	}
	
	private boolean verificarDescripcion() {
		if(!descripcionTextField.getText().matches("[a-zA-Z0-9ñÑ ]{1,50}")|| descripcionTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaDescripcion, lblAlertaDescripcion);
			return false;
		}
		setAcertado(lineaDescripcion, lblAlertaDescripcion);
		return true;
	}
	
	private boolean verificarMarca() {
		if(MarcaCB.getSelectedIndex() == 0) {
			lblAlertaMarca.setVisible(true);
			return false;
		}
		lblAlertaMarca.setVisible(false);
		return true;
	}

	private boolean verificarStock() {
		if(!stockTextField.getText().matches("[0-9]{1,5}") || stockTextField.getText().charAt(0) == '0') {
			setErroneo(lineaStock, lblAlertaStock);
			return false;
		}
		setAcertado(lineaStock, lblAlertaStock);
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
        		Color color = new Color(170, 170, 170);
        		if (txtUser.getForeground().equals(color) && txtUser.getText().length() < maxCaracteres) {
        			txtUser.setText("");
        			txtUser.setForeground(new Color(255, 255, 255));
        		}
        	}
        });
	}
	
	private void eventoExpandirDisminuirTamanoBoton(JButton boton, int pixeles) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	
				boton.setBounds(
						(int)boton.getBounds().getX()-pixeles/2,
						(int)boton.getBounds().getY()-pixeles/2,
						(int)boton.getBounds().getWidth()+pixeles,
						(int)boton.getBounds().getHeight()+pixeles);
				boton.setFont(new Font("Roboto Light", Font.BOLD, 26));
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
}
