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
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import a.Modelo.Consulta;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarRegistroVentaPanel extends JPanel {

	private static final long serialVersionUID = -5223254028468888947L;
	public int modo;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	
	private JLabel lblAlertaRut;
	private JComboBox rutCB;
	private JTextField fechaTextField;
	private JLabel lblAlertaFecha;
	private JTextField cantidadVendidaTextField;
	private JLabel lblAlertaCantidadVendida;
	private JComboBox articuloCB;
	private JLabel lblAlertaArticulo;
	private JPanel lineaFecha;
	private JPanel lineaCantidadVendida;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private static int stock;
	private int idVenta;
	private int cantidadAntigua;
	
	public AgregarRegistroVentaPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		lblAlertaArticulo = new JLabel("");
		lblAlertaArticulo.setVisible(false);
		lblAlertaArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaArticulo.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaArticulo.setBounds(604, 177, 30, 27);
		add(lblAlertaArticulo);
		
		JLabel lblAgregarUsuario = new JLabel("Agregar Registro Venta");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarUsuario.setBounds(138, 11, 459, 55);
		add(lblAgregarUsuario);
		
		JLabel lblRut = new JLabel("RUT");
		lblRut.setForeground(Color.WHITE);
		lblRut.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblRut.setBounds(138, 155, 62, 14);
		add(lblRut);
		
		DefaultComboBoxModel modelo = crearModeloComboBoxRut();
		rutCB = new JComboBox(new String[] {});
		rutCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCB(rutCB,lblAlertaRut);
			}
		});
		rutCB.setModel(modelo);
		rutCB.setBounds(138, 180, 214, 21);
		add(rutCB);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblFecha.setBounds(138, 212, 106, 14);
		add(lblFecha);
		
		fechaTextField = new JTextField();
		fechaTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarFecha();
			}
		});
		fechaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarFecha();
			}
		});
		fechaTextField.setToolTipText("");
		fechaTextField.setText("AAAA-MM-DD");
		fechaTextField.setOpaque(false);
		fechaTextField.setForeground(new Color(170, 170, 170));
		fechaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fechaTextField.setCaretColor(Color.WHITE);
		fechaTextField.setBorder(null);
		fechaTextField.setBackground(new Color(51, 51, 51));
		fechaTextField.setBounds(138, 225, 214, 21);
		eventoCambiarJTextField(fechaTextField, fechaTextField.getText(), 20);
		add(fechaTextField);
		
		lineaFecha = new JPanel();
		lineaFecha.setPreferredSize(new Dimension(0, 3));
		lineaFecha.setBackground(Color.WHITE);
		lineaFecha.setBounds(138, 249, 214, 3);
		add(lineaFecha);
		GroupLayout gl_lineaFecha = new GroupLayout(lineaFecha);
		gl_lineaFecha.setHorizontalGroup(
			gl_lineaFecha.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaFecha.setVerticalGroup(
			gl_lineaFecha.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaFecha.setLayout(gl_lineaFecha);
		
		JLabel lblCantidadVendida = new JLabel("Cantidad vendida");
		lblCantidadVendida.setForeground(Color.WHITE);
		lblCantidadVendida.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCantidadVendida.setBounds(383, 212, 106, 14);
		add(lblCantidadVendida);
		
		cantidadVendidaTextField = new JTextField();
		cantidadVendidaTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCantidadVendida();
			}
		});
		cantidadVendidaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarCantidadVendida();
			}
		});
		cantidadVendidaTextField.setText("EJ: 2");
		cantidadVendidaTextField.setOpaque(false);
		cantidadVendidaTextField.setForeground(new Color(170, 170, 170));
		cantidadVendidaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cantidadVendidaTextField.setCaretColor(Color.WHITE);
		cantidadVendidaTextField.setBorder(null);
		cantidadVendidaTextField.setBackground(new Color(51, 51, 51));
		cantidadVendidaTextField.setBounds(383, 225, 80, 21);
		eventoCambiarJTextField(cantidadVendidaTextField, cantidadVendidaTextField.getText(), 20);
		add(cantidadVendidaTextField);
		
		lineaCantidadVendida = new JPanel();
		lineaCantidadVendida.setPreferredSize(new Dimension(0, 3));
		lineaCantidadVendida.setBackground(Color.WHITE);
		lineaCantidadVendida.setBounds(383, 249, 80, 3);
		add(lineaCantidadVendida);
		GroupLayout gl_lineaCantidadVendida = new GroupLayout(lineaCantidadVendida);
		gl_lineaCantidadVendida.setHorizontalGroup(
			gl_lineaCantidadVendida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaCantidadVendida.setVerticalGroup(
			gl_lineaCantidadVendida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaCantidadVendida.setLayout(gl_lineaCantidadVendida);
		
		JButton btnAgregarRegistroVenta = new JButton("AGREGAR REGISTRO VENTA");
		btnAgregarRegistroVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarRegistroVenta.setBorder(null);
		btnAgregarRegistroVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarRegistroVenta.setBackground(Color.WHITE);
		btnAgregarRegistroVenta.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarRegistroVenta.setBounds(138, 458, 459, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarRegistroVenta, 15);
		add(btnAgregarRegistroVenta);
		
		lblAlertaFecha = new JLabel("");
		lblAlertaFecha.setVisible(false);
		lblAlertaFecha.setToolTipText("Hay un error de formato");
		lblAlertaFecha.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaFecha.setBounds(99, 222, 30, 27);
		add(lblAlertaFecha);
		
		lblAlertaCantidadVendida = new JLabel("");
		lblAlertaCantidadVendida.setVisible(false);
		lblAlertaCantidadVendida.setToolTipText("Hay un error de formato");
		lblAlertaCantidadVendida.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaCantidadVendida.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaCantidadVendida.setBounds(473, 229, 30, 27);
		add(lblAlertaCantidadVendida);
		
		lblAlertaRut = new JLabel("");
		lblAlertaRut.setVisible(false);
		lblAlertaRut.setToolTipText("Hay un error de formato");
		lblAlertaRut.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaRut.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaRut.setBounds(98, 174, 30, 27);
		add(lblAlertaRut);
		
		JLabel lblArticulo = new JLabel("Articulos con stock");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblArticulo.setBounds(383, 155, 144, 14);
		add(lblArticulo);
		
		DefaultComboBoxModel modelo2 = crearModeloComboBoxArticulo();
		articuloCB =  new JComboBox(new Object[]{});
		articuloCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCB(articuloCB,lblAlertaArticulo);
			}
		});
		articuloCB.setModel(modelo2);
		articuloCB.setBounds(383, 180, 214, 21);
		add(articuloCB);
		
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
			btnAgregarRegistroVenta.setText("MODIFICAR REGISTRO VENTA");
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setIndiceElementoSeleccionado(JComboBox comboBox, String elementoABuscar) {
	        for (int i = 0; i < comboBox.getItemCount(); i++) {
	            if (comboBox.getItemAt(i).toString().contains(elementoABuscar)) {
	                comboBox.setSelectedIndex(i);
	                break;
	            }
	        }
	    } 
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		cantidadAntigua = Integer.parseInt(elementoSeleccionado.get(3));
		idVenta = Integer.parseInt(elementoSeleccionado.get(4));
		cambiarColorTextFieldsBlanco();
		fechaTextField.setText(elementoSeleccionado.get(2));
		cantidadVendidaTextField.setText(elementoSeleccionado.get(3));
		setIndiceElementoSeleccionado(articuloCB, obtenerIdEnString(articuloCB.getSelectedItem().toString()));
		setIndiceElementoSeleccionado(rutCB, elementoSeleccionado.get(1));
		for (int i = 0; i < articuloCB.getItemCount(); i++) {
			if (articuloCB.getItemAt(i).toString().contains(elementoSeleccionado.get(0))) {
				articuloCB.setSelectedIndex(i);
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
	
	private DefaultComboBoxModel crearModeloComboBoxRut() {
		ArrayList<?> ruts = consulta.getRuts();
		if(ruts.size()>0) {
			String[] listaRuts = new String[ruts.size()+1];
			listaRuts[0] = "Seleccione...";
			for(int i=1; i<=ruts.size();i++) {
				listaRuts[i] = ruts.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaRuts);
		}else {
			lblAlertaRut.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No existen ruts"});
		}
	}
	
	private DefaultComboBoxModel crearModeloComboBoxArticulo() {
		ArrayList<?> articulo = consulta.getDescripcionArticulosConStock();
		if(articulo.size()>0) {
			String[] listaArticulos = new String[articulo.size()+1];
			listaArticulos[0] = "Seleccione...";
			for(int i=1; i<=articulo.size();i++) {
				listaArticulos[i] = articulo.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listaArticulos);
		}else {
			lblAlertaRut.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No existen articulos"});
		}
	}

	private void agregarDatos() {
		agregarDatosTablaRegistroVenta();
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
	
	private void agregarDatosTablaRegistroVenta() {
		if (modo == 1) {
			consulta.addRegistroVenta(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())), rutCB.getSelectedItem().toString(), Integer.parseInt(cantidadVendidaTextField.getText()), fechaTextField.getText());
			consulta.updtStockArticulo(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())), stock-Integer.parseInt(cantidadVendidaTextField.getText()));
		} else if(modo == 2) {
			consulta.updtRegistroVenta(Integer.parseInt(cantidadVendidaTextField.getText()), fechaTextField.getText(),
					Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())), rutCB.getSelectedItem().toString(), idVenta);
			consulta.updtStockArticulo(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())),
					getNewStock(stock, cantidadAntigua, Integer.parseInt(cantidadVendidaTextField.getText())));
		}
	}
	
	private int getNewStock(int stock, int cantidadAntigua, int cantidadNueva) {
		if (cantidadNueva > cantidadAntigua) {
			return stock-(cantidadNueva-cantidadAntigua);
		} else if (cantidadAntigua > cantidadNueva) {
			return stock-(cantidadAntigua-cantidadNueva);
		} else if (cantidadAntigua == cantidadNueva) {
			return stock;
		}
		return stock;
	}

	private boolean isTodoCorrecto() {
		stock = consulta.getArticuloStock(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())));
		if (verificarCantidadVendida() && verificarCB(rutCB,lblAlertaRut) && verificarCB(articuloCB,lblAlertaArticulo) && verificarFecha() &&
				verificarStock(stock)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean verificarStock(int stock) {
		if (modo == 1) {
			if (stock < Integer.parseInt(cantidadVendidaTextField.getText())) {
				setErroneo(lineaCantidadVendida, lblAlertaCantidadVendida);
				Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
				JOptionPane.showMessageDialog(null, "Las unidades adquiridas son mayores al stock disponible: " + stock,"Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
				return false;
			} else {
				setAcertado(lineaCantidadVendida, lblAlertaCantidadVendida);
				return true;
			}
		} else if (modo == 2) {
			if (getNewStock(stock, cantidadAntigua, Integer.parseInt(cantidadVendidaTextField.getText())) < 0) {
				setErroneo(lineaCantidadVendida, lblAlertaCantidadVendida);
				Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
				JOptionPane.showMessageDialog(null, "Las unidades adquiridas son mayores al stock disponible: " + stock,"Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
				return false;
			} else {
				setAcertado(lineaCantidadVendida, lblAlertaCantidadVendida);
				return true;
			}
		}
		return false;
	}
	
	private boolean verificarCantidadVendida() {
		if(!cantidadVendidaTextField.getText().matches("[0-9]{1,5}") || cantidadVendidaTextField.getText().charAt(0) == '0') {
			lblAlertaCantidadVendida.setVisible(true);
			setErroneo(lineaCantidadVendida, lblAlertaCantidadVendida);
			return false;
		}
		setAcertado(lineaCantidadVendida, lblAlertaCantidadVendida);
		lblAlertaCantidadVendida.setVisible(false);
		return true;
	}
	
	private boolean verificarFecha() {
		if(!fechaTextField.getText().matches("^([2][0][0-3][0-9])[-]([0][1-9]|[1][0-2])[-]([0][1-9]|[1-2][0-9]|[3][0-1])$")) {
			setErroneo(lineaFecha, lblAlertaFecha);
			return false;
		}
		setAcertado(lineaFecha, lblAlertaFecha);
		return true;
	}

	private boolean verificarCB(JComboBox comboBox, JLabel label) {
		if(comboBox.getSelectedIndex() == 0) {
			label.setVisible(true);
			return false;
		}
		label.setVisible(false);
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
