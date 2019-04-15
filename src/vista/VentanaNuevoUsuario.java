package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import modelo.Empleado;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class VentanaNuevoUsuario extends JPanel implements ActionListener{
	private JButton botonRegistrar;
	private JButton botonCancelar;
	private JTextField editNombre;
	private JTextField editPaterno;
	private JTextField editCorreo;
	private JPasswordField editPassword;
	private JPasswordField editPassword2;
	private String password = "";
	private JComboBox<String> editEmpleadoAdmin;
	private JTextField editMaterno;

	public VentanaNuevoUsuario() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 60, 64));
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setFont(new Font("Roboto", Font.PLAIN, 25));
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setForeground(Color.WHITE);
		panel.add(lblNuevoUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 60, 64));
		add(panel_1, BorderLayout.SOUTH);
		
		botonRegistrar = new JButton("Registrar");
		botonRegistrar.addActionListener(this);
		botonRegistrar.setBackground(new Color(0, 176, 225));
		botonRegistrar.setForeground(Color.WHITE);
		panel_1.add(botonRegistrar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(this);
		botonCancelar.setBackground(new Color(0, 176, 225));
		botonCancelar.setForeground(Color.WHITE);
		panel_1.add(botonCancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 60, 64));
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(7, 2, 0, 20));
		
		JLabel lblNombre = new JLabel("NOMBRE(S)");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblNombre);
		
		editNombre = new JTextField();
		editNombre.addActionListener(this);
		editNombre.setHorizontalAlignment(SwingConstants.CENTER);
		editNombre.setCaretColor(Color.WHITE);
		editNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editNombre.setBackground(new Color(0, 60, 64));
		editNombre.setFont(new Font("Roboto", Font.PLAIN, 14));
		editNombre.setForeground(Color.WHITE);
		panel_2.add(editNombre);
		editNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("APELLIDO PATERNO");
		lblApellidoPaterno.setForeground(Color.WHITE);
		lblApellidoPaterno.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblApellidoPaterno.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblApellidoPaterno);
		
		editPaterno = new JTextField();
		editPaterno.addActionListener(this);
		editPaterno.setHorizontalAlignment(SwingConstants.CENTER);
		editPaterno.setCaretColor(Color.WHITE);
		editPaterno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editPaterno.setBackground(new Color(0, 60, 64));
		editPaterno.setFont(new Font("Roboto", Font.PLAIN, 14));
		editPaterno.setForeground(Color.WHITE);
		panel_2.add(editPaterno);
		editPaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("APELLIDO MATERNO");
		lblApellidoMaterno.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoMaterno.setForeground(Color.WHITE);
		lblApellidoMaterno.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblApellidoMaterno);
		
		editMaterno = new JTextField();
		editMaterno.setHorizontalAlignment(SwingConstants.CENTER);
		editMaterno.addActionListener(this);
		editMaterno.setForeground(Color.WHITE);
		editMaterno.setFont(new Font("Roboto", Font.PLAIN, 14));
		editMaterno.setColumns(10);
		editMaterno.setCaretColor(Color.WHITE);
		editMaterno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editMaterno.setBackground(new Color(0, 60, 64));
		panel_2.add(editMaterno);
		
		JLabel lblCorreoElectrnico = new JLabel("CORREO ELECTR\u00D3NICO");
		lblCorreoElectrnico.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblCorreoElectrnico.setForeground(Color.WHITE);
		lblCorreoElectrnico.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblCorreoElectrnico);
		
		editCorreo = new JTextField();
		editCorreo.addActionListener(this);
		editCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		editCorreo.setCaretColor(Color.WHITE);
		editCorreo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editCorreo.setBackground(new Color(0, 60, 64));
		editCorreo.setFont(new Font("Roboto", Font.PLAIN, 14));
		editCorreo.setForeground(Color.WHITE);
		panel_2.add(editCorreo);
		editCorreo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblContrasea);
		
		editPassword = new JPasswordField();
		editPassword.addActionListener(this);
		editPassword.setHorizontalAlignment(SwingConstants.CENTER);
		editPassword.setCaretColor(Color.WHITE);
		editPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editPassword.setBackground(new Color(0, 60, 64));
		editPassword.setFont(new Font("Roboto", Font.PLAIN, 14));
		editPassword.setForeground(Color.WHITE);
		panel_2.add(editPassword);
		
		JLabel lblRepetirContrasea = new JLabel("REPETIR CONTRASE\u00D1A");
		lblRepetirContrasea.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblRepetirContrasea.setForeground(Color.WHITE);
		lblRepetirContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblRepetirContrasea);
		
		editPassword2 = new JPasswordField();
		editPassword2.addActionListener(this);
		editPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		editPassword2.setCaretColor(Color.WHITE);
		editPassword2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
		editPassword2.setBackground(new Color(0, 60, 64));
		editPassword2.setFont(new Font("Roboto", Font.PLAIN, 14));
		editPassword2.setForeground(Color.WHITE);
		panel_2.add(editPassword2);
		
		editEmpleadoAdmin = new JComboBox<String>();
		editEmpleadoAdmin.addActionListener(this);
		editEmpleadoAdmin.setForeground(Color.WHITE);
		editEmpleadoAdmin.setBackground(new Color(0, 60, 64));
		editEmpleadoAdmin.setFont(new Font("Roboto", Font.PLAIN, 15));
		editEmpleadoAdmin.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Empleado"}));
		panel_2.add(editEmpleadoAdmin);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editNombre) {
			if(editNombre.getText().isEmpty()) {
				editNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Nombre\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else {
				editNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				editPaterno.requestFocus();
			}
		}
		
		if(e.getSource() == editPaterno) {
			if(editPaterno.getText().isEmpty()) {
				editPaterno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Apellidos\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else {
				editPaterno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				editMaterno.requestFocus();
			}
		}
		
		if(e.getSource() == editMaterno) {
			if(editMaterno.getText().isEmpty()) {
				editMaterno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Apellido Materno\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else {
				editMaterno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				editCorreo.requestFocus();
			}
		}
		
		if(e.getSource() == editCorreo) {
			if(editCorreo.getText().isEmpty()) {
				editCorreo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Correo Electrónico\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else {
				editCorreo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				editPassword.requestFocus();
			}
		}
		
		if(e.getSource() == editPassword) {
			password = String.valueOf(editPassword.getPassword());
			if(password.isEmpty()) {
				editPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Contraseña\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else {
				editPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				editPassword2.requestFocus();
			}
		}
		
		if(e.getSource() == editPassword2) {
			String password2 = String.valueOf(editPassword2.getPassword());
			if(password2.isEmpty()) {
				editPassword2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "El campo \"Repetir Contraseña\" no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			}
			else if(!password.equals(password2)) {
				editPassword2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(213, 0, 0)));
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", null, JOptionPane.ERROR_MESSAGE);
				editPassword2.setText(null);
			}
			else {
				editPassword2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(1, 87, 115)));
				editEmpleadoAdmin.requestFocus();
			}
		}
		
		if(e.getSource() == editEmpleadoAdmin) {
			botonRegistrar.requestFocus();
		}
	}
	
	public Empleado registrarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setPaterno(editPaterno.getText());
		empleado.setMaterno(editMaterno.getText());
		empleado.setNombre(editNombre.getText());
		empleado.setCargo((String) editEmpleadoAdmin.getSelectedItem());
		return empleado;
	}
	
	public boolean camposVacios() {
		return editNombre.getText().isEmpty() || editPaterno.getText().isEmpty() || editMaterno.getText().isEmpty()
				|| editCorreo.getText().isEmpty() || editPassword.getText().isEmpty() || editPassword2.getText().isEmpty();
	}
	
	public JButton getRegistrar() {
		return botonRegistrar;
	}
	
	public JButton getCancelar() {
		return botonCancelar;
	}
	
	public void enfocarCursor() {
		editNombre.requestFocus();
	}
}