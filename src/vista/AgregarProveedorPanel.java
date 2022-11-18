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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import a.Modelo.Consulta;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarProveedorPanel extends JPanel {

	private static final long serialVersionUID = 4153463407399988729L;
	public int modo;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	private JTextField proveedorTextField;
	private JLabel lblAlertaProveedor;
	private JPanel lineaProveedor;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private int idProveedor;
	
	public AgregarProveedorPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblProveedor.setBounds(215, 11, 302, 55);
		add(lblProveedor);
		
		JLabel lblProveedor2 = new JLabel("Proveedor:");
		lblProveedor2.setForeground(Color.WHITE);
		lblProveedor2.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblProveedor2.setBounds(259, 210, 106, 14);
		add(lblProveedor2);
		
		proveedorTextField = new JTextField();
		proveedorTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				verificarProveedor();
			}
		});
		proveedorTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarProveedor();
			}
		});
		proveedorTextField.setToolTipText("");
		proveedorTextField.setText("EJ: Proveedor3");
		proveedorTextField.setOpaque(false);
		proveedorTextField.setForeground(new Color(170, 170, 170));
		proveedorTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		proveedorTextField.setCaretColor(Color.WHITE);
		proveedorTextField.setBorder(null);
		proveedorTextField.setBackground(new Color(51, 51, 51));
		proveedorTextField.setBounds(259, 222, 214, 21);
		eventoCambiarJTextField(proveedorTextField, proveedorTextField.getText(), 20);
		add(proveedorTextField);
		
		lineaProveedor = new JPanel();
		lineaProveedor.setPreferredSize(new Dimension(0, 3));
		lineaProveedor.setBackground(Color.WHITE);
		lineaProveedor.setBounds(259, 248, 214, 3);
		add(lineaProveedor);
		GroupLayout gl_lineaProveedor = new GroupLayout(lineaProveedor);
		gl_lineaProveedor.setHorizontalGroup(
			gl_lineaProveedor.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaProveedor.setVerticalGroup(
			gl_lineaProveedor.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaProveedor.setLayout(gl_lineaProveedor);
		
		JButton btnAgregarProveedor = new JButton("AGREGAR PROVEEDOR");
		btnAgregarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarProveedor.setBorder(null);
		btnAgregarProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarProveedor.setBackground(Color.WHITE);
		btnAgregarProveedor.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarProveedor.setBounds(206, 455, 320, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarProveedor, 15);
		add(btnAgregarProveedor);
		
		lblAlertaProveedor = new JLabel("");
		lblAlertaProveedor.setVisible(false);
		lblAlertaProveedor.setToolTipText("Hay un error de formato");
		lblAlertaProveedor.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaProveedor.setBounds(223, 222, 30, 27);
		add(lblAlertaProveedor);
		
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
			btnAgregarProveedor.setText("EDITAR PROVEEDOR");
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		idProveedor = Integer.parseInt(elementoSeleccionado.get(0));
		cambiarColorTextFieldsBlanco();
		proveedorTextField.setText(elementoSeleccionado.get(1));
	}
	
	private void cambiarColorTextFieldsBlanco() {
		Component[] componentes = this.getComponents();
	        for(int i = 0; i<componentes.length;i++) {
	       	 if(componentes[i].getClass().equals(JTextField.class)) {
	       		 componentes[i].setForeground(Color.WHITE);
	       	 }
	        }
	}
	
	private void agregarDatos() {
		agregarDatosProveedor();
	}
	
	private void agregarDatosProveedor() {
		if (modo == 1) {
			consulta.addProveedor(proveedorTextField.getText());
		} else if(modo == 2) {
			consulta.updtProveedor(idProveedor, proveedorTextField.getText());
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarProveedor()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarProveedor() {
		if(!proveedorTextField.getText().matches("[a-zA-Z0-9 ]{1,20}") && proveedorTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaProveedor, lblAlertaProveedor);
			return false;
		}
		setAcertado(lineaProveedor, lblAlertaProveedor);
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
