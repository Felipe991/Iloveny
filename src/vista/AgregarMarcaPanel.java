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

public class AgregarMarcaPanel extends JPanel {

	private static final long serialVersionUID = -5578566432967000551L;
	public int modo;
	ArrayList<String> elementoSeleccionado;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	private JTextField marcaTextField;
	private JLabel lblAlertaMarca;
	private JPanel lineaMarca;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	
	public AgregarMarcaPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		this.elementoSeleccionado = elementoSeleccionado;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblAgregarMarca = new JLabel("Marca");
		lblAgregarMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarMarca.setForeground(Color.WHITE);
		lblAgregarMarca.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblAgregarMarca.setBounds(199, 11, 302, 55);
		add(lblAgregarMarca);
		
		JLabel lblMarca = new JLabel("Nombre marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblMarca.setBounds(250, 211, 106, 14);
		add(lblMarca);
		
		marcaTextField = new JTextField();
		marcaTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				verificarMarca();
			}
		});
		marcaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarMarca();
			}
		});
		marcaTextField.setToolTipText("");
		marcaTextField.setText("EJ: Nike");
		marcaTextField.setOpaque(false);
		marcaTextField.setForeground(new Color(170, 170, 170));
		marcaTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		marcaTextField.setCaretColor(Color.WHITE);
		marcaTextField.setBorder(null);
		marcaTextField.setBackground(new Color(51, 51, 51));
		marcaTextField.setBounds(250, 222, 214, 21);
		eventoCambiarJTextField(marcaTextField, marcaTextField.getText(), 20);
		add(marcaTextField);
		
		lineaMarca = new JPanel();
		lineaMarca.setPreferredSize(new Dimension(0, 3));
		lineaMarca.setBackground(Color.WHITE);
		lineaMarca.setBounds(248, 248, 214, 3);
		add(lineaMarca);
		GroupLayout gl_lineaMarca = new GroupLayout(lineaMarca);
		gl_lineaMarca.setHorizontalGroup(
			gl_lineaMarca.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaMarca.setVerticalGroup(
			gl_lineaMarca.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaMarca.setLayout(gl_lineaMarca);
		
		JButton btnAgregarMarca = new JButton("AGREGAR MARCA");
		btnAgregarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarMarca.setBorder(null);
		btnAgregarMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarMarca.setBackground(Color.WHITE);
		btnAgregarMarca.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarMarca.setBounds(199, 455, 302, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarMarca, 15);
		add(btnAgregarMarca);
		
		lblAlertaMarca = new JLabel("");
		lblAlertaMarca.setVisible(false);
		lblAlertaMarca.setToolTipText("Hay un error de formato");
		lblAlertaMarca.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaMarca.setBounds(215, 224, 30, 27);
		add(lblAlertaMarca);
		
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
		marcaTextField.setText(elementoSeleccionado.get(1));
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
		agregarDatosTablaMarca();
	}
	
	private void agregarDatosTablaMarca() {
		if (modo == 1) {
			consulta.addMarca(marcaTextField.getText());
		} else if(modo == 2) {
			consulta.updtMarca(marcaTextField.getText(), Integer.parseInt(elementoSeleccionado.get(0)));
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarMarca()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarMarca() {
		if(!marcaTextField.getText().matches("[a-zA-Z ]{1,20}") || marcaTextField.getText().charAt(0) == ' ') {
			setErroneo(lineaMarca, lblAlertaMarca);
			return false;
		}
		lblAlertaMarca.setVisible(false);
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
