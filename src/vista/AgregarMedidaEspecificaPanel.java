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

public class AgregarMedidaEspecificaPanel extends JPanel {

	private static final long serialVersionUID = -3746277232928924825L;
	public int modo;
	ArrayList<String> elementoSeleccionado;
	public boolean existenArticuloSinMedidaEspecifica;
	public Consulta consulta = new Consulta();
	private JTextField medidaTextField;
	private JLabel lblAlertaMedida;
	private JComboBox ArticuloSinMedidaEspCB;
	private JLabel lblAlertaArticuloSinMedidaEsp;
	private JPanel lineaMedida;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	
	public AgregarMedidaEspecificaPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		this.elementoSeleccionado = elementoSeleccionado;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		lblAlertaArticuloSinMedidaEsp = new JLabel("");
		lblAlertaArticuloSinMedidaEsp.setVisible(false);
		lblAlertaArticuloSinMedidaEsp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaArticuloSinMedidaEsp.setIcon(new ImageIcon(AgregarDireccionPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaArticuloSinMedidaEsp.setBounds(82, 173, 30, 27);
		add(lblAlertaArticuloSinMedidaEsp);
		
		JLabel lblAgregarUsuario = new JLabel("Medida Especifica\r\n");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarUsuario.setBounds(135, 11, 461, 55);
		add(lblAgregarUsuario);
		
		JLabel lblMedida = new JLabel("Medida");
		lblMedida.setForeground(Color.WHITE);
		lblMedida.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblMedida.setBounds(382, 154, 106, 14);
		add(lblMedida);
		
		medidaTextField = new JTextField();
		medidaTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarMedidaE();
			}
		});
		medidaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarMedidaE();
			}
		});
		medidaTextField.setToolTipText("a");
		medidaTextField.setText("EJ: Talla 40");
		medidaTextField.setOpaque(false);
		medidaTextField.setForeground(new Color(170, 170, 170));
		medidaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		medidaTextField.setCaretColor(Color.WHITE);
		medidaTextField.setBorder(null);
		medidaTextField.setBackground(new Color(51, 51, 51));
		medidaTextField.setBounds(382, 169, 214, 21);
		eventoCambiarJTextField(medidaTextField, medidaTextField.getText(), 20);
		add(medidaTextField);
		
		lineaMedida = new JPanel();
		lineaMedida.setPreferredSize(new Dimension(0, 3));
		lineaMedida.setBackground(Color.WHITE);
		lineaMedida.setBounds(382, 197, 214, 3);
		add(lineaMedida);
		GroupLayout gl_lineaMedida = new GroupLayout(lineaMedida);
		gl_lineaMedida.setHorizontalGroup(
			gl_lineaMedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaMedida.setVerticalGroup(
			gl_lineaMedida.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaMedida.setLayout(gl_lineaMedida);
		
		JButton btnAgregarDireccion = new JButton("AGREGAR MEDIDA ESPECIFICA");
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
		btnAgregarDireccion.setBounds(154, 458, 424, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarDireccion, 15);
		add(btnAgregarDireccion);
		
		lblAlertaMedida = new JLabel("");
		lblAlertaMedida.setVisible(false);
		lblAlertaMedida.setToolTipText("Hay un error de formato");
		lblAlertaMedida.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaMedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaMedida.setBounds(598, 173, 30, 27);
		add(lblAlertaMedida);
		
		JLabel lblArticuloSinMedidaEsp = new JLabel("Id Articulos:");
		lblArticuloSinMedidaEsp.setForeground(Color.WHITE);
		lblArticuloSinMedidaEsp.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblArticuloSinMedidaEsp.setBounds(122, 154, 167, 14);
		add(lblArticuloSinMedidaEsp);
		
		DefaultComboBoxModel modelo = crearModeloComboBoxId();
		ArticuloSinMedidaEspCB = new JComboBox(new Object[]{});
		ArticuloSinMedidaEspCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarArticulo();
			}
		});
		ArticuloSinMedidaEspCB.setModel(modelo);
		ArticuloSinMedidaEspCB.setBounds(122, 179, 214, 21);
		add(ArticuloSinMedidaEspCB);
		
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
		ArticuloSinMedidaEspCB.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...",elementoSeleccionado.get(0) + " ("+elementoSeleccionado.get(1)+")"}));
		ArticuloSinMedidaEspCB.setSelectedIndex(1);
		ArticuloSinMedidaEspCB.setEnabled(false);
		medidaTextField.setText(elementoSeleccionado.get(2));
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
		ArrayList<?> elementosObetenidos = consulta.getIdArticuloSinMedidaEspecifica();
		if(elementosObetenidos.size()>0) {
			existenArticuloSinMedidaEspecifica = true;
			String[] listasMedidas = new String[elementosObetenidos.size()+1];
			listasMedidas[0] = "Seleccione...";
			for(int i=1; i<=elementosObetenidos.size();i++) {
				listasMedidas[i] = elementosObetenidos.get(i-1).toString();
			}
			return new DefaultComboBoxModel(listasMedidas);
		}else {
			lblAlertaArticuloSinMedidaEsp.setVisible(true);
			existenArticuloSinMedidaEspecifica = false;
			return new DefaultComboBoxModel(new String[] {"No existen articulos sin medida especifica"});
		}
	}

	private void agregarDatos() {
		agregarDatosTablaMedidaE();
	}
	
	private void agregarDatosTablaMedidaE() {
		if (modo == 1) {
			consulta.addMedidaE(medidaTextField.getText(), Integer.parseInt((String)ArticuloSinMedidaEspCB.getSelectedItem())); 
		} else if(modo == 2) {
			consulta.updtMedidaE(medidaTextField.getText(), Integer.parseInt(elementoSeleccionado.get(0)));
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarArticulo() && verificarMedidaE()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarMedidaE() {
		if(!medidaTextField.getText().matches("[a-zA-Z0-9 ]{1,30}") || medidaTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaMedida, lblAlertaMedida);
			return false;
		}
		setAcertado(lineaMedida, lblAlertaMedida);
		return true;
	}

	private boolean verificarArticulo() {
		if(ArticuloSinMedidaEspCB.getSelectedIndex() == 0) {
			lblAlertaArticuloSinMedidaEsp.setVisible(true);
			return false;
		}
		lblAlertaArticuloSinMedidaEsp.setVisible(false);
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

}
