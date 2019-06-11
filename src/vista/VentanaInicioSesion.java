package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaInicioSesion extends JPanel implements ActionListener{
	private JTextField editNombreUsuario;
	private JPasswordField editPassword;
	private JRadioButton radioRecuerdame;
	private JButton botonInicioSesion;
	private JButton botonNuevoUsuario;

	public VentanaInicioSesion() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 176, 225));
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\attachment_38986924.jpg"));
		label.setBounds(38, 39, 204, 256);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 60, 64));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label_1 = new JLabel("Iniciar Sesi\u00F3n");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Roboto", Font.PLAIN, 25));
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 60, 64));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		botonInicioSesion = new JButton("Iniciar Sesi\u00F3n");
		botonInicioSesion.addActionListener(this);
		botonInicioSesion.setForeground(Color.WHITE);
		botonInicioSesion.setBackground(new Color(0, 176, 225));
		panel_3.add(botonInicioSesion);
		
		botonNuevoUsuario = new JButton("Nuevo Usuario");
		botonNuevoUsuario.addActionListener(this);
		botonNuevoUsuario.setForeground(Color.WHITE);
		botonNuevoUsuario.setBackground(new Color(0, 176, 225));
		panel_3.add(botonNuevoUsuario);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 60, 64));
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JLabel label_2 = new JLabel("NOMBRE DE USUARIO");
		label_2.setBounds(25, 28, 211, 39);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_4.add(label_2);
		
		editNombreUsuario = new JTextField();
		editNombreUsuario.addActionListener(this);
		editNombreUsuario.setBounds(25, 78, 211, 39);
		editNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		editNombreUsuario.setForeground(Color.WHITE);
		editNombreUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		editNombreUsuario.setColumns(10);
		editNombreUsuario.setCaretColor(Color.WHITE);
		editNombreUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editNombreUsuario.setBackground(new Color(0, 60, 64));
		panel_4.add(editNombreUsuario);
		
		JLabel label_3 = new JLabel("CONTRASE\u00D1A");
		label_3.setBounds(35, 143, 211, 39);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_4.add(label_3);
		
		editPassword = new JPasswordField();
		editPassword.addActionListener(this);
		editPassword.setBounds(25, 177, 211, 39);
		editPassword.setHorizontalAlignment(SwingConstants.CENTER);
		editPassword.setForeground(Color.WHITE);
		editPassword.setFont(new Font("Roboto", Font.PLAIN, 14));
		editPassword.setColumns(10);
		editPassword.setCaretColor(Color.WHITE);
		editPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editPassword.setBackground(new Color(0, 60, 64));
		panel_4.add(editPassword);
		
		radioRecuerdame = new JRadioButton("Recu\u00E9rdame");
		radioRecuerdame.setBounds(25, 256, 211, 39);
		radioRecuerdame.setHorizontalAlignment(SwingConstants.LEFT);
		radioRecuerdame.setForeground(Color.WHITE);
		radioRecuerdame.setFont(new Font("Roboto", Font.PLAIN, 12));
		radioRecuerdame.setBackground(new Color(0, 60, 64));
		panel_4.add(radioRecuerdame);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editNombreUsuario) {
			if(editNombreUsuario.getText().isEmpty()) {
				editNombreUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Nombre\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else {
				editNombreUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				editPassword.requestFocus();
			}
		}
		
		if(e.getSource() == editPassword) {
			if(editPassword.getText().isEmpty()) {
				editPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Nombre\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else {
				editPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				botonInicioSesion.requestFocus();
			}
		}
	}
	
	public JButton getBotonSesion() {
		return botonInicioSesion;
	}
	
	public JButton getBotonNuevoUsuario() {
		return botonNuevoUsuario;
	}
	
	public String getPassword() {
		return editPassword.getText();
	}
	
	public JTextField getNombreUsuario() {
		return editNombreUsuario;
	}
	
	public void enfocar() {
		editNombreUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
		editNombreUsuario.setText(null);
		editNombreUsuario.requestFocus();
	}
	
	public void enfocarPassword() {
		editPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
		editPassword.setText(null);
		editPassword.requestFocus();
	}
}