package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	private JTextField textFieldLu;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextField textFieldGitHub;
	
	private JLabel textoGenerado;
	private JLabel LuLabel;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblemail;
	private JLabel lblgithub;
	
	private int lu=0;
	private String apellido="";
	private String nombre="";
	private String email = "";
	private String github= "";
	
    DateTimeFormatter fechayhora;
    String horayfechaFormateada;
    
	ImageIcon logoUns;
	public SimplePresentationScreen(Student studentData) {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(705, 308));
		setResizable(false);
		cambiarIcono();
		setContentPane(contentPane);
		init();
		
		//centrar en la pantalla
		this.setLocationRelativeTo(null);
	}
	
	private void init() {
		logoUns = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().
				getResource("/images/logo-Uns.png")).getScaledInstance(200, 200, Image.SCALE_DEFAULT));

		// Tabbed Pane to student personal data
		
		lu=studentData.getId();
		nombre=studentData.getFirstName();
		apellido=studentData.getLastName();
		email=studentData.getMail();
		github=studentData.getGithubURL();
		
		contentPane.setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 239);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, 
				"Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		dibujarElementos();
	}
	private void cambiarIcono() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tdp.png")));
	}
	
	private void dibujarElementos() {
		LuLabel = new JLabel("LU");
		LuLabel.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		LuLabel.setBounds(10, 11, 111, 27);
		tabInformation.add(LuLabel);

		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblApellido.setBounds(10, 49, 111, 27);
		tabInformation.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblNombre.setBounds(10, 87, 111, 27);
		tabInformation.add(lblNombre);
		
		lblemail = new JLabel("E-mail");
		lblemail.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblemail.setBounds(10, 125, 111, 27);
		tabInformation.add(lblemail);
		
		lblgithub = new JLabel("Github URL");
		lblgithub.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblgithub.setBounds(10, 163, 111, 27);
		tabInformation.add(lblgithub);
		
		
		textFieldLu = new JTextField();
		textFieldLu.setEditable(false);
		textFieldLu.setBounds(131, 14, 284, 20);
		tabInformation.add(textFieldLu);
		textFieldLu.setColumns(10);
		textFieldLu.setText(""+lu);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(131, 52, 284, 20);
		tabInformation.add(textFieldApellido);
		textFieldApellido.setText(apellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(131, 90, 284, 20);
		tabInformation.add(textFieldNombre);
		textFieldNombre.setText(nombre);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(131, 128, 284, 20);
		tabInformation.add(textFieldEmail);
		textFieldEmail.setText(email);
		
		textFieldGitHub = new JTextField();
		textFieldGitHub.setEditable(false);
		textFieldGitHub.setColumns(10);
		textFieldGitHub.setBounds(131, 166, 284, 20);
		tabInformation.add(textFieldGitHub);
		textFieldGitHub.setText(github);
		
		contentPane.add(tabbedPane);
		
		JLabel imagen = new JLabel();
		imagen.setBounds(466, 38, 200, 200);
		
		imagen.setIcon(logoUns);
		contentPane.add(imagen);
		

	    fechayhora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
	    horayfechaFormateada = fechayhora.format(LocalDateTime.now());
	    
		textoGenerado = new JLabel("");
		textoGenerado.setText("Esta Ventana fue generada el "+horayfechaFormateada);
		textoGenerado.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		textoGenerado.setBounds(15, 243, 420, 25);
		contentPane.add(textoGenerado);
	}
}
