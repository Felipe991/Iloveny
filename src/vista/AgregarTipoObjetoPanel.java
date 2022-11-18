package vista;

import java.awt.Color;
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

public class AgregarTipoObjetoPanel extends JPanel {

	private static final long serialVersionUID = 701965601888238099L;
	public int modo;
	public boolean existenRutsSinDireccion;
	public Consulta consulta = new Consulta();
	private JTextField tipoObjetoTextField;
	private JLabel lblAlertaTipoObjeto;
	private JPanel lineaTipoObjeto;
	private JButton btnVolver;
	public JButton btnRefrezcar;
	private int idTipoObjeto;
	
	public AgregarTipoObjetoPanel(int modo, JComponent[] paneles, JButton btnRefrezcar, ArrayList<String> elementoSeleccionado) {
		this.modo = modo;
		this.btnRefrezcar = btnRefrezcar;
		setBounds(0,0,732,558);
		setBackground(new Color(51,51,51));
		setLayout(null);
		
		JLabel lblTipoObjeto = new JLabel("Tipo de Objeto");
		lblTipoObjeto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoObjeto.setForeground(Color.WHITE);
		lblTipoObjeto.setFont(new Font("Roboto Medium", Font.PLAIN, 41));
		lblTipoObjeto.setBounds(199, 11, 302, 55);
		add(lblTipoObjeto);
		
		JLabel lblObjeto = new JLabel("Tipo de objeto");
		lblObjeto.setForeground(Color.WHITE);
		lblObjeto.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblObjeto.setBounds(250, 211, 106, 14);
		add(lblObjeto);
		
		tipoObjetoTextField = new JTextField();
		tipoObjetoTextField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		verificarTipoObjeto();
        	}
        });
		tipoObjetoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				verificarTipoObjeto();
			}
		});
		tipoObjetoTextField.setToolTipText("");
		tipoObjetoTextField.setText("EJ: Cinturon");
		tipoObjetoTextField.setOpaque(false);
		tipoObjetoTextField.setForeground(new Color(170, 170, 170));
		tipoObjetoTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tipoObjetoTextField.setCaretColor(Color.WHITE);
		tipoObjetoTextField.setBorder(null);
		tipoObjetoTextField.setBackground(new Color(51, 51, 51));
		tipoObjetoTextField.setBounds(250, 222, 214, 21);
		eventoCambiarJTextField(tipoObjetoTextField, tipoObjetoTextField.getText(), 20);
		add(tipoObjetoTextField);
		
		lineaTipoObjeto = new JPanel();
		lineaTipoObjeto.setPreferredSize(new Dimension(0, 3));
		lineaTipoObjeto.setBackground(Color.WHITE);
		lineaTipoObjeto.setBounds(248, 248, 214, 3);
		add(lineaTipoObjeto);
		GroupLayout gl_lineaTipoObjeto = new GroupLayout(lineaTipoObjeto);
		gl_lineaTipoObjeto.setHorizontalGroup(
			gl_lineaTipoObjeto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 214, Short.MAX_VALUE)
				.addGap(0, 214, Short.MAX_VALUE)
		);
		gl_lineaTipoObjeto.setVerticalGroup(
			gl_lineaTipoObjeto.createParallelGroup(Alignment.LEADING)
				.addGap(0, 3, Short.MAX_VALUE)
				.addGap(0, 3, Short.MAX_VALUE)
		);
		lineaTipoObjeto.setLayout(gl_lineaTipoObjeto);
		
		JButton btnAgregarTipoObjeto = new JButton("AGREGAR TIPO OBJETO");
		btnAgregarTipoObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isTodoCorrecto()) {
					agregarDatos();
					btnRefrezcar.doClick();
					paneles[1].setVisible(true);
					paneles[0].setBounds(929, 39, 732, 558);
				}
			}
		});
		btnAgregarTipoObjeto.setBorder(null);
		btnAgregarTipoObjeto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarTipoObjeto.setBackground(Color.WHITE);
		btnAgregarTipoObjeto.setFont(new Font("Roboto Light", Font.PLAIN, 25));
		btnAgregarTipoObjeto.setBounds(199, 455, 302, 64);
		eventoExpandirDisminuirTamañoBoton(btnAgregarTipoObjeto, 15);
		add(btnAgregarTipoObjeto);
		
		lblAlertaTipoObjeto = new JLabel("");
		lblAlertaTipoObjeto.setVisible(false);
		lblAlertaTipoObjeto.setToolTipText("Hay un error de formato");
		lblAlertaTipoObjeto.setIcon(new ImageIcon(AgregarUsuarioPanel.class.getResource("/imagenes/alert-icon-white.png")));
		lblAlertaTipoObjeto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertaTipoObjeto.setBounds(215, 224, 30, 27);
		add(lblAlertaTipoObjeto);
		
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
			btnAgregarTipoObjeto.setText("MODIFICAR TIPO OBJETO");
			setElementos(elementoSeleccionado);
		}
	}
	
	private void setElementos(ArrayList<String> elementoSeleccionado) {
		idTipoObjeto = Integer.parseInt(elementoSeleccionado.get(0));
		tipoObjetoTextField.setForeground(Color.WHITE);
		tipoObjetoTextField.setText(elementoSeleccionado.get(1));
	}

	private void agregarDatos() {
		agregarDatosTablaMarca();
	}
	
	private void agregarDatosTablaMarca() {
		if (modo == 1) {
			consulta.addTipoObj(tipoObjetoTextField.getText());
		} else if(modo == 2) {
			consulta.updtTipoObj(tipoObjetoTextField.getText(), idTipoObjeto);
		}
	}

	private boolean isTodoCorrecto() {
		if(verificarTipoObjeto()) {
			return true;
		}
		return false;
	}
	
	private boolean verificarTipoObjeto() {
		if(!tipoObjetoTextField.getText().matches("[a-zA-Z ]{1,20}") || tipoObjetoTextField.getText().charAt(0) == '0') {
			lblAlertaTipoObjeto.setVisible(true);
			setErroneo(lineaTipoObjeto, lblAlertaTipoObjeto);
			return false;
		}
		setAcertado(lineaTipoObjeto, lblAlertaTipoObjeto);
		lblAlertaTipoObjeto.setVisible(false);
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
