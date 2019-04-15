package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField editNombreUsuario;
	private JPasswordField editContrasenia;
	private JRadioButton radioRecuerdame;
	private JButton botonIngresar;
	private JButton botonNuevoUsuario;
	private VentanaNuevoUsuario nuevoUsuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 176, 225));
		contentPane.add(panel);
		
		JLabel lblLogotipoPendiente = new JLabel("LOGOTIPO PENDIENTE");
		lblLogotipoPendiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogotipoPendiente.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblLogotipoPendiente.setForeground(Color.WHITE);
		panel.add(lblLogotipoPendiente);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(00, 60, 64));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblIniciarSesin = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciarSesin.setFont(new Font("Roboto", Font.PLAIN, 25));
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblIniciarSesin);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(00, 60, 64));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		botonIngresar = new JButton("Iniciar Sesi\u00F3n");
		botonIngresar.addActionListener(this);
		botonIngresar.setBackground(new Color(0, 176, 225));
		botonIngresar.setForeground(Color.WHITE);
		panel_3.add(botonIngresar);
		
		botonNuevoUsuario = new JButton("Nuevo Usuario");
		botonNuevoUsuario.addActionListener(this);
		botonNuevoUsuario.setForeground(Color.WHITE);
		botonNuevoUsuario.setBackground(new Color(0, 176, 225));
		panel_3.add(botonNuevoUsuario);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(00, 60, 64));
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JLabel lblCorreoElectrnico = new JLabel("NOMBRE DE USUARIO");
		lblCorreoElectrnico.setBounds(25, 28, 211, 39);
		lblCorreoElectrnico.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblCorreoElectrnico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoElectrnico.setForeground(Color.WHITE);
		panel_4.add(lblCorreoElectrnico);
		
		editNombreUsuario = new JTextField();
		editNombreUsuario.addActionListener(this);
		editNombreUsuario.setBounds(25, 72, 211, 39);
		editNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		editNombreUsuario.setCaretColor(Color.WHITE);
		editNombreUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editNombreUsuario.setForeground(Color.WHITE);
		editNombreUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		editNombreUsuario.setBackground(new Color(0, 60, 64));
		panel_4.add(editNombreUsuario);
		editNombreUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setBounds(25, 122, 211, 39);
		lblContrasea.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblContrasea);
		
		editContrasenia = new JPasswordField();
		editContrasenia.addActionListener(this);
		editContrasenia.setBounds(25, 157, 211, 39);
		editContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		editContrasenia.setCaretColor(Color.WHITE);
		editContrasenia.setForeground(Color.WHITE);
		editContrasenia.setFont(new Font("Roboto", Font.PLAIN, 14));
		editContrasenia.setColumns(10);
		editContrasenia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editContrasenia.setBackground(new Color(0, 60, 64));
		panel_4.add(editContrasenia);
		
		radioRecuerdame = new JRadioButton("Recu\u00E9rdame");
		radioRecuerdame.setBounds(25, 203, 119, 39);
		radioRecuerdame.setForeground(Color.WHITE);
		radioRecuerdame.setFont(new Font("Roboto", Font.PLAIN, 12));
		radioRecuerdame.setHorizontalAlignment(SwingConstants.LEFT);
		radioRecuerdame.setBackground(new Color(0, 60, 64));
		panel_4.add(radioRecuerdame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editNombreUsuario) {
			if(editNombreUsuario.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else 
				editContrasenia.requestFocus();
		}
		
		if(e.getSource() == editContrasenia) {
			String password = String.valueOf(editContrasenia.getPassword());
			
			if(password.isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				botonIngresar.requestFocus();
		}
		
		if(e.getSource() == botonIngresar) {
			String password = String.valueOf(editContrasenia.getPassword());
			
			if(editNombreUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo \"Nombre de Usuario\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
				editNombreUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				editNombreUsuario.requestFocus();
			}
			
			else if(password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo \"Contraseña\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
				editContrasenia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				editContrasenia.requestFocus();
			}
			
			else {
				
			}
		}
		
		if(e.getSource() == botonNuevoUsuario) {
			contentPane.remove(panel_1);
			repaint();
			registrarUsuario();
		}
	}
	
	private void registrarUsuario() {
		if(nuevoUsuario == null) {
			nuevoUsuario = new VentanaNuevoUsuario();
			nuevoUsuario.getRegistrar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Usuario nuevo registrado");
					contentPane.remove(nuevoUsuario);
					nuevoUsuario = null;
					repaint();
					contentPane.add(panel_1);
					setVisible(true);
				}
			});
			
			nuevoUsuario.getCancelar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					contentPane.remove(nuevoUsuario);
					nuevoUsuario = null;
					repaint();
					contentPane.add(panel_1);
					setVisible(true);
				}
			});
			
			nuevoUsuario.enfocarCursor();
			contentPane.add(nuevoUsuario);
			setVisible(true);
		}
	}
}