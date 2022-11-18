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

public class AgregarRegistroCompraPanel extends JPanel {

	private static final long serialVersionUID = -1178501338264937978L;
	public int modo;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	
	private JLabel lblAlertaArticulo;
	private JComboBox articuloCB;
	private JTextField fechaPedidaTextField;
	private JLabel lblAlertaFechaPedida;
	private JTextField unidadesAdquiridasTextField;
	private JTextField costoUnitarioTextField;
	private JTextField fechaReciboTextField;
	private JLabel lblAlertaFechaRecibo;
	private JLabel lblAlertaCostoUnitario;
	private JComboBox proveedorCB;
	private JLabel lblAlertaProveedor;
	private JPanel lineaFechaPedida;
	private JPanel lineaUnidadesAdquiridas;
	private JPanel lineaCostoUnitario;
	private JPanel lineaFechaRecibo;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private String nombreAdmin;
	private JLabel lblAlertaUnidadesAdquirida;
	private int idProveedor;
	private int idCompraAntiguo;
	private int unidadesAdquiridasAntigua;
	private int stock;
	
	public AgregarRegistroCompraPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, String nombreAdmin, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		this.nombreAdmin = nombreAdmin;
		
		lblAlertaProveedor = new JLabel("");
		lblAlertaProveedor.setVisible(false);
		lblAlertaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaProveedor.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaProveedor.setBounds(604, 177, 30, 27);
		add(lblAlertaProveedor);
		
		JLabel lblAgregarUsuario = new JLabel("Registro Compra");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarUsuario.setBounds(155, 11, 441, 55);
		add(lblAgregarUsuario);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblArticulo.setBounds(138, 155, 62, 14);
		add(lblArticulo);
		
		JLabel lblUnidadesAdquiridas = new JLabel("Unidades adquiridas");
		lblUnidadesAdquiridas.setForeground(Color.WHITE);
		lblUnidadesAdquiridas.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblUnidadesAdquiridas.setBounds(138, 267, 132, 14);
		add(lblUnidadesAdquiridas);
		
		lineaUnidadesAdquiridas = new JPanel();
		lineaUnidadesAdquiridas.setPreferredSize(new Dimension(0, 3));
		lineaUnidadesAdquiridas.setBackground(Color.WHITE);
		lineaUnidadesAdquiridas.setBounds(138, 304, 49, 3);
		add(lineaUnidadesAdquiridas);
		GroupLayout gl_lineaUnidadesAdquiridas = new GroupLayout(lineaUnidadesAdquiridas);
		gl_lineaUnidadesAdquiridas.setHorizontalGroup(
			gl_lineaUnidadesAdquiridas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaUnidadesAdquiridas.setVerticalGroup(
			gl_lineaUnidadesAdquiridas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaUnidadesAdquiridas.setLayout(gl_lineaUnidadesAdquiridas);
		
		unidadesAdquiridasTextField = new JTextField();
		unidadesAdquiridasTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				verificarUnidadesAdquiridas();
			}
		});
		unidadesAdquiridasTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarUnidadesAdquiridas();
			}
		});
		unidadesAdquiridasTextField.setText("1");
		unidadesAdquiridasTextField.setOpaque(false);
		unidadesAdquiridasTextField.setForeground(new Color(170, 170, 170));
		unidadesAdquiridasTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		unidadesAdquiridasTextField.setCaretColor(Color.WHITE);
		unidadesAdquiridasTextField.setBorder(null);
		unidadesAdquiridasTextField.setBackground(new Color(51, 51, 51));
		unidadesAdquiridasTextField.setBounds(138, 280, 49, 21);
		eventoCambiarJTextField(unidadesAdquiridasTextField, unidadesAdquiridasTextField.getText(), 50);
		add(unidadesAdquiridasTextField);
		
		DefaultComboBoxModel modelo = crearModeloComboBoxArticulo();
		articuloCB = new JComboBox(new String[] {});
		articuloCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarArticulo();
			}
		});
		articuloCB.setModel(modelo);
		articuloCB.setBounds(138, 180, 214, 21);
		add(articuloCB);
		
		JLabel lblCostoUnitario = new JLabel("Costo unitario (CLP)");
		lblCostoUnitario.setForeground(Color.WHITE);
		lblCostoUnitario.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblCostoUnitario.setBounds(383, 267, 106, 14);
		add(lblCostoUnitario);
		
		costoUnitarioTextField = new JTextField();
		costoUnitarioTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarCostoUnitario();
			}
		});
		costoUnitarioTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarCostoUnitario();
			}
		});
		costoUnitarioTextField.setText("1000");
		costoUnitarioTextField.setOpaque(false);
		costoUnitarioTextField.setForeground(new Color(170, 170, 170));
		costoUnitarioTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		costoUnitarioTextField.setCaretColor(Color.WHITE);
		costoUnitarioTextField.setBorder(null);
		costoUnitarioTextField.setBackground(new Color(51, 51, 51));
		costoUnitarioTextField.setBounds(383, 280, 96, 21);
		eventoCambiarJTextField(costoUnitarioTextField, costoUnitarioTextField.getText(), 50);
		add(costoUnitarioTextField);
		
		lineaCostoUnitario = new JPanel();
		lineaCostoUnitario.setPreferredSize(new Dimension(0, 3));
		lineaCostoUnitario.setBackground(Color.WHITE);
		lineaCostoUnitario.setBounds(383, 304, 96, 3);
		add(lineaCostoUnitario);
		GroupLayout gl_lineaCostoUnitario = new GroupLayout(lineaCostoUnitario);
		gl_lineaCostoUnitario.setHorizontalGroup(
			gl_lineaCostoUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaCostoUnitario.setVerticalGroup(
			gl_lineaCostoUnitario.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaCostoUnitario.setLayout(gl_lineaCostoUnitario);
		
		JLabel lblFechaPedida = new JLabel("Fecha pedida");
		lblFechaPedida.setForeground(Color.WHITE);
		lblFechaPedida.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblFechaPedida.setBounds(138, 212, 106, 14);
		add(lblFechaPedida);
		
		fechaPedidaTextField = new JTextField();
		fechaPedidaTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarFechaPedida();
			}
		});
		fechaPedidaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarFechaPedida();
			}
		});
		fechaPedidaTextField.setToolTipText("");
		fechaPedidaTextField.setText("AAAA-MM-DD");
		fechaPedidaTextField.setOpaque(false);
		fechaPedidaTextField.setForeground(new Color(170, 170, 170));
		fechaPedidaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fechaPedidaTextField.setCaretColor(Color.WHITE);
		fechaPedidaTextField.setBorder(null);
		fechaPedidaTextField.setBackground(new Color(51, 51, 51));
		fechaPedidaTextField.setBounds(138, 225, 214, 21);
		eventoCambiarJTextField(fechaPedidaTextField, fechaPedidaTextField.getText(), 20);
		add(fechaPedidaTextField);
		
		lineaFechaPedida = new JPanel();
		lineaFechaPedida.setPreferredSize(new Dimension(0, 3));
		lineaFechaPedida.setBackground(Color.WHITE);
		lineaFechaPedida.setBounds(138, 249, 214, 3);
		add(lineaFechaPedida);
		GroupLayout gl_lineaFechaPedida = new GroupLayout(lineaFechaPedida);
		gl_lineaFechaPedida.setHorizontalGroup(
			gl_lineaFechaPedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaFechaPedida.setVerticalGroup(
			gl_lineaFechaPedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaFechaPedida.setLayout(gl_lineaFechaPedida);
		
		JLabel lblFechaRecibo = new JLabel("Fecha recibo");
		lblFechaRecibo.setForeground(Color.WHITE);
		lblFechaRecibo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblFechaRecibo.setBounds(383, 212, 106, 14);
		add(lblFechaRecibo);
		
		fechaReciboTextField = new JTextField();
		fechaReciboTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarFechaRecibo();
			}
		});
		fechaReciboTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarFechaRecibo();
			}
		});
		fechaReciboTextField.setText("AAAA-MM-DD");
		fechaReciboTextField.setOpaque(false);
		fechaReciboTextField.setForeground(new Color(170, 170, 170));
		fechaReciboTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		fechaReciboTextField.setCaretColor(Color.WHITE);
		fechaReciboTextField.setBorder(null);
		fechaReciboTextField.setBackground(new Color(51, 51, 51));
		fechaReciboTextField.setBounds(383, 225, 214, 21);
		eventoCambiarJTextField(fechaReciboTextField, fechaReciboTextField.getText(), 20);
		add(fechaReciboTextField);
		
		lineaFechaRecibo = new JPanel();
		lineaFechaRecibo.setPreferredSize(new Dimension(0, 3));
		lineaFechaRecibo.setBackground(Color.WHITE);
		lineaFechaRecibo.setBounds(383, 249, 214, 3);
		add(lineaFechaRecibo);
		GroupLayout gl_lineaFechaRecibo = new GroupLayout(lineaFechaRecibo);
		gl_lineaFechaRecibo.setHorizontalGroup(
			gl_lineaFechaRecibo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaFechaRecibo.setVerticalGroup(
			gl_lineaFechaRecibo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaFechaRecibo.setLayout(gl_lineaFechaRecibo);
		
		JButton btnAgregarRegistroCompra = new JButton("AGREGAR REGISTRO COMPRA");
		btnAgregarRegistroCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarRegistroCompra.setBorder(null);
		btnAgregarRegistroCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarRegistroCompra.setBackground(Color.WHITE);
		btnAgregarRegistroCompra.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarRegistroCompra.setBounds(138, 458, 458, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarRegistroCompra, 15);
		add(btnAgregarRegistroCompra);
		
		lblAlertaFechaPedida = new JLabel("");
		lblAlertaFechaPedida.setVisible(false);
		lblAlertaFechaPedida.setToolTipText("Hay un error de formato");
		lblAlertaFechaPedida.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaFechaPedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaFechaPedida.setBounds(99, 222, 30, 27);
		add(lblAlertaFechaPedida);
		
		lblAlertaUnidadesAdquirida = new JLabel("");
		lblAlertaUnidadesAdquirida.setVisible(false);
		lblAlertaUnidadesAdquirida.setToolTipText("Hay un error de formato");
		lblAlertaUnidadesAdquirida.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaUnidadesAdquirida.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaUnidadesAdquirida.setBounds(98, 280, 30, 27);
		add(lblAlertaUnidadesAdquirida);
		
		lblAlertaCostoUnitario = new JLabel("");
		lblAlertaCostoUnitario.setVisible(false);
		lblAlertaCostoUnitario.setToolTipText("Hay un error de formato");
		lblAlertaCostoUnitario.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaCostoUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaCostoUnitario.setBounds(489, 280, 30, 27);
		add(lblAlertaCostoUnitario);
		
		lblAlertaFechaRecibo = new JLabel("");
		lblAlertaFechaRecibo.setVisible(false);
		lblAlertaFechaRecibo.setToolTipText("Hay un error de formato");
		lblAlertaFechaRecibo.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaFechaRecibo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaFechaRecibo.setBounds(604, 225, 30, 27);
		add(lblAlertaFechaRecibo);
		
		lblAlertaArticulo = new JLabel("");
		lblAlertaArticulo.setVisible(false);
		lblAlertaArticulo.setToolTipText("Hay un error de formato");
		lblAlertaArticulo.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaArticulo.setBounds(98, 174, 30, 27);
		add(lblAlertaArticulo);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblProveedor.setBounds(383, 155, 62, 14);
		add(lblProveedor);
		
		DefaultComboBoxModel modelo2 = crearModeloComboBoxProveedor();
		proveedorCB = new JComboBox(new Object[]{});
		proveedorCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarProveedor();
			}
		});
		proveedorCB.setModel(modelo2);
		proveedorCB.setBounds(383, 180, 214, 21);
		add(proveedorCB);
		
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
		unidadesAdquiridasAntigua = Integer.parseInt(elementoSeleccionado.get(3));
		idCompraAntiguo = Integer.parseInt(elementoSeleccionado.get(7));
		setIndiceElementoSeleccionado(articuloCB, elementoSeleccionado.get(0));
		setIndiceElementoSeleccionado(proveedorCB, elementoSeleccionado.get(2));
		idProveedor = Integer.parseInt(obtenerIdEnString(proveedorCB.getSelectedItem().toString()));
		cambiarColorTextFieldsBlanco();
		fechaPedidaTextField.setText(elementoSeleccionado.get(5));
		fechaReciboTextField.setText(elementoSeleccionado.get(6));
		unidadesAdquiridasTextField.setText(elementoSeleccionado.get(3));
		costoUnitarioTextField.setText(elementoSeleccionado.get(4));
		this.stock = consulta.getArticuloStock(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())));
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
	
	private boolean verificarProveedor() {
		if(proveedorCB.getSelectedIndex() == 0) {
			lblAlertaProveedor.setVisible(true);
			return false;
		}
		lblAlertaProveedor.setVisible(false);
		return true;
	}

	private DefaultComboBoxModel crearModeloComboBoxProveedor() {
		ArrayList<?> proveedores = consulta.getProveedor();
		if(proveedores.size()>0) {
			existenRutsSinDireccion = true;
			String[] listaProveedores = new String[proveedores.size()+1];
			listaProveedores[0] = "Seleccione...";
			for(int i=1; i<=proveedores.size();i++) {
				listaProveedores[i] = proveedores.get(i-1).toString();
				StringBuilder builder = new StringBuilder(listaProveedores[i]);
				for (int j = 0; j < builder.toString().length(); j++) {
					if (builder.charAt(j) == '[' || builder.charAt(j) == ']' || builder.charAt(j) == ',') {
						builder.deleteCharAt(j);
					}
				}
				listaProveedores[i] = builder.toString();
			}
			return new DefaultComboBoxModel(listaProveedores);
		}else {
			lblAlertaProveedor.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No hay proveedores"});
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
			lblAlertaArticulo.setVisible(true);
			return new DefaultComboBoxModel(new String[] {"No existen articulos"});
		}
	}

	private void agregarDatos() {
		agregarDatosTablaRegistroCompra();
	}
	
	private void agregarDatosTablaRegistroCompra() {
		if (modo == 1) {
			int stock = consulta.getArticuloStock(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())));
			consulta.addRegistroCompra(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())), nombreAdmin,
					Integer.parseInt(obtenerIdEnString(proveedorCB.getSelectedItem().toString())),
					Integer.parseInt(unidadesAdquiridasTextField.getText()), Integer.parseInt(costoUnitarioTextField.getText()), fechaPedidaTextField.getText(),
					fechaReciboTextField.getText());
			consulta.updtStockArticulo(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())), stock+Integer.parseInt(unidadesAdquiridasTextField.getText()));
		} else if(modo == 2) {
			consulta.updtRegistroCompra(nombreAdmin, idProveedor, Integer.parseInt(unidadesAdquiridasTextField.getText()),
					Integer.parseInt(costoUnitarioTextField.getText()), fechaPedidaTextField.getText(), fechaReciboTextField.getText(),
					Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())), idCompraAntiguo);
			consulta.updtStockArticulo(Integer.parseInt(obtenerIdEnString(articuloCB.getSelectedItem().toString())), getNewStock(stock,
					Integer.parseInt(unidadesAdquiridasTextField.getText()), unidadesAdquiridasAntigua));
		}
	}
	
	private int getNewStock(int stock, int cNueva, int cAntigua) {
		if (cNueva > cAntigua) {
			return stock+(cNueva-cAntigua);
		} else if (cNueva < cAntigua) {
			return stock-(cAntigua-cNueva);
		} else if (cNueva == cAntigua) {
			return stock;
		}
		return stock;
	}
	
	private boolean verificarFechas() {
		try {
			Date fechaRecibo = new SimpleDateFormat("yyyy-MM-dd").parse(fechaReciboTextField.getText());
			Date fechaPedida = new SimpleDateFormat("yyyy-MM-dd").parse(fechaPedidaTextField.getText());
			if (fechaRecibo.compareTo(fechaPedida) < 0) {
				setErroneo(lineaFechaPedida, lblAlertaFechaPedida);
				setErroneo(lineaFechaRecibo, lblAlertaFechaRecibo);
				Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
				JOptionPane.showMessageDialog(null, "La fecha de recibo no puede ser antes de la fecha de pedido","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return true;
	}

	private boolean isTodoCorrecto() {
		if (modo == 1) {
			if(verificarUnidadesAdquiridas() && verificarCostoUnitario() && verificarArticulo() && verificarFechaPedida() && verificarFechaRecibo() && verificarProveedor()
					&& verificarFechas()) {
				return true;
			}
		} else if (modo == 2) {
			if(verificarUnidadesAdquiridas() && verificarCostoUnitario() && verificarArticulo() && verificarFechaPedida() && verificarFechaRecibo() && verificarProveedor()
					&& verificarFechas() && verificarStock()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificarStock() {
		if (getNewStock(this.stock,Integer.parseInt(unidadesAdquiridasTextField.getText()), unidadesAdquiridasAntigua) < 0) {
			setErroneo(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
			Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
			JOptionPane.showMessageDialog(null, "Las unidades adquiridas son mayores al stock disponible: " + stock,"Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
			return false;
		} else {
			setAcertado(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
			return true;
		}
	}
	
	private boolean verificarFechaRecibo() {
		if(!fechaReciboTextField.getText().matches("^([2][0][0-3][0-9])[-]([0][1-9]|[1][0-2])[-]([0][1-9]|[1-2][0-9]|[3][0-1])$")) {
			lblAlertaFechaRecibo.setVisible(true);
			setErroneo(lineaFechaRecibo, lblAlertaFechaRecibo);
			return false;
		}
		setAcertado(lineaFechaRecibo, lblAlertaFechaRecibo);
		lblAlertaFechaRecibo.setVisible(false);
		return true;
	}
	
	private boolean verificarFechaPedida() {
		if(!fechaPedidaTextField.getText().matches("^([2][0][0-3][0-9])[-]([0][1-9]|[1][0-2])[-]([0][1-9]|[1-2][0-9]|[3][0-1])$")) {
			setErroneo(lineaFechaPedida, lblAlertaFechaPedida);
			return false;
		}
		setAcertado(lineaFechaPedida, lblAlertaFechaPedida);
		return true;
	}

	private boolean verificarArticulo() {
		if(articuloCB.getSelectedIndex() == 0) {
			lblAlertaArticulo.setVisible(true);
			return false;
		}
		lblAlertaArticulo.setVisible(false);
		return true;
	}

	private boolean verificarCostoUnitario() {
		if(!costoUnitarioTextField.getText().matches("[0-9]{1,10}") || costoUnitarioTextField.getText().charAt(0) == '0' ) {
			setErroneo(lineaCostoUnitario, lblAlertaCostoUnitario);
			return false;
		}
		setAcertado(lineaCostoUnitario, lblAlertaCostoUnitario);
		return true;
	}

	private boolean verificarUnidadesAdquiridas() {
		if(!unidadesAdquiridasTextField.getText().matches("[0-9]{1,5}") || unidadesAdquiridasTextField.getText().charAt(0) == '0') {
			setErroneo(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
			return false;
		}
		setAcertado(lineaUnidadesAdquiridas, lblAlertaUnidadesAdquirida);
		return true;
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
