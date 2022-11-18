package vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.io.IOException;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPasswordField txtPassword;
	public JTextField txtUser;
	public JButton btnLogin;
	public JLabel lblErrorMessage;
	public JLabel lblErrorImage;
	public JLabel lblLoadingImage;
	public JLabel lblConectando;
	public JPanel downPanelUser;
	public JPanel downPanelPassword;
	public JPanel botonX;
	public JLabel lblX;
	public JPanel header;
	public JLabel lblErrorConexion;
	
    public Login() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/iloveny-icon.png")));
    	setUndecorated(true);
    	getContentPane().setBackground(new Color(51,51,51));
        try {
		initialize();
	} catch (IOException e) {
		e.printStackTrace();
	}
    }

    private void initialize() throws IOException {
    	 setResizable(false);
        setVisible(true);
        setBounds(100, 100, 473, 652);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);
        
        downPanelUser = new JPanel();
        downPanelPassword = new JPanel();
        
        JLabel lblLogin = new JLabel();
        lblLogin.setVerticalAlignment(SwingConstants.CENTER);
        lblLogin.setText("INICIO DE SESI\u00D3N");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
        lblLogin.setBounds(0, 170, 467, 35);
        getContentPane().add(lblLogin);
        
        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setIcon(new ImageIcon(Login.class.getResource("/imagenes/person-icon.png")));
        lblImagen.setBounds(0, 31, 467, 128);
        getContentPane().add(lblImagen);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(51,51,51));
        panel.setBounds(78, 216, 314, 346);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblPasswordImage = new JLabel();
        lblPasswordImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblPasswordImage.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lock.png")));
        lblPasswordImage.setBounds(0, 106, 18, 41);
        panel.add(lblPasswordImage);
        
        JLabel lblUserImage = new JLabel();
        lblUserImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserImage.setIcon(new ImageIcon(Login.class.getResource("/imagenes/person.png")));
        lblUserImage.setBounds(0, 60, 24, 41);
        panel.add(lblUserImage);
        
        lblErrorImage = new JLabel();
        lblErrorImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblErrorImage.setIcon(new ImageIcon(Login.class.getResource("/imagenes/error.png")));
        lblErrorImage.setBounds(0, 158, 24, 21);
        panel.add(lblErrorImage);
        
        lblErrorMessage = new JLabel("Acceso denegado");
        lblErrorMessage.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setBounds(34, 158, 280, 21);
        panel.add(lblErrorMessage);
        
        lblConectando = new JLabel("Conectando...");
        lblConectando.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblConectando.setForeground(Color.LIGHT_GRAY);
        lblConectando.setBounds(34, 158, 280, 21);
        panel.add(lblConectando);
        
        //lblLoadingImage.setVisible(false);
        lblConectando.setVisible(false);
        lblErrorImage.setVisible(false);
        lblErrorMessage.setVisible(false);
        
        txtUser = new JTextField();
        txtUser.setForeground(new Color(170, 170, 170));
        txtUser.setText("Usuario");
        txtUser.setCaretColor(Color.WHITE);
        txtUser.setBounds(41, 66, 273, 21);
        panel.add(txtUser);
        txtUser.setOpaque(false);
        txtUser.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtUser.setBorder(null);
        txtUser.setBackground(new Color(51, 51, 51));
        
        downPanelUser.setBounds(-89, 98, 441, 3);
        panel.add(downPanelUser);
        downPanelUser.setPreferredSize(new Dimension(0, 3));
        downPanelUser.setBackground(new Color(51, 255, 204));
        GroupLayout gl_downPanelUser = new GroupLayout(downPanelUser);
        gl_downPanelUser.setHorizontalGroup(
        	gl_downPanelUser.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 441, Short.MAX_VALUE)
        		.addGap(0, 441, Short.MAX_VALUE)
        );
        gl_downPanelUser.setVerticalGroup(
        	gl_downPanelUser.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 3, Short.MAX_VALUE)
        		.addGap(0, 3, Short.MAX_VALUE)
        );
        downPanelUser.setLayout(gl_downPanelUser);
        
        txtPassword = new JPasswordField();
        txtPassword.setCaretColor(Color.WHITE);
        txtPassword.setBounds(41, 112, 273, 21);
        panel.add(txtPassword);
        txtPassword.setText("password");
        txtPassword.setForeground(new Color(170, 170, 170));
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtPassword.setBorder(null);
        txtPassword.setBackground(new Color(51, 51, 51));
        
        downPanelPassword.setBounds(-67, 144, 441, 3);
        panel.add(downPanelPassword);
        downPanelPassword.setPreferredSize(new Dimension(0, 3));
        downPanelPassword.setBackground(new Color(51, 255, 204));
        GroupLayout gl_downPanelPassword = new GroupLayout(downPanelPassword);
        gl_downPanelPassword.setHorizontalGroup(
        	gl_downPanelPassword.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 441, Short.MAX_VALUE)
        		.addGap(0, 441, Short.MAX_VALUE)
        );
        gl_downPanelPassword.setVerticalGroup(
        	gl_downPanelPassword.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 3, Short.MAX_VALUE)
        		.addGap(0, 3, Short.MAX_VALUE)
        );
        downPanelPassword.setLayout(gl_downPanelPassword);
        
        btnLogin = new JButton();
        btnLogin.setFocusPainted(false);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setBounds(0, 271, 314, 40);
        panel.add(btnLogin);
        btnLogin.setText("INGRESAR");
        btnLogin.setBorderPainted(false);
        btnLogin.setBorder(null);
        btnLogin.setBackground(new Color(0, 153, 153));
        
        lblErrorConexion = new JLabel();
        lblErrorConexion.setVerticalAlignment(SwingConstants.CENTER);
        lblErrorConexion.setText("Se ha detectado un error de conexion");
        lblErrorConexion.setHorizontalAlignment(SwingConstants.CENTER);
        lblErrorConexion.setForeground(Color.WHITE);
        lblErrorConexion.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        lblErrorConexion.setBounds(0, 225, 314, 35);
        lblErrorConexion.setVisible(false);
        panel.add(lblErrorConexion);
        
        lblLoadingImage = new JLabel("");
        lblLoadingImage.setIcon(new ImageIcon(Login.class.getResource("/imagenes/loading-icon.gif")));
        lblLoadingImage.setBounds(0, 158, 24, 21);
        lblLoadingImage.setVisible(false);
        panel.add(lblLoadingImage);
        
        header = new JPanel();
        header.setBounds(0, 0, 473, 35);
        header.setBackground(new Color(51,51,51));
        getContentPane().add(header);
        header.setLayout(null);
        
        botonX = new JPanel();
        botonX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botonX.setBackground(new Color(51,51,51));
        botonX.setBounds(446, 0, 27, 27);
        header.add(botonX);
        botonX.setLayout(null);
        
        lblX = new JLabel("X");
        lblX.setHorizontalAlignment(SwingConstants.CENTER);
        lblX.setForeground(Color.WHITE);
        lblX.setFont(new Font("Roboto", Font.BOLD, 15));
        lblX.setBounds(0, 0, 27, 27);
        botonX.add(lblX);
    }
}
