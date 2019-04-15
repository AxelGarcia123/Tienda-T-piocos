package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.BaseDatos;
import modelo.TablaEmpleado;
import modelo.TablaProducto;

public class VentanaPrincipal1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private VentanaInicioSesion inicio;
	private VistaRegistrarProducto ventanaProducto;
	private BaseDatos baseDatos;
	private TablaProducto tablaProducto;
	private TablaEmpleado tablaEmpleado;
	private RegistroProducto registroProducto;
	private VentanaNuevoUsuario nuevoUsuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal1 frame = new VentanaPrincipal1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		baseDatos = new BaseDatos("tiendita", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");

		baseDatos.hacerConexion();
		tablaProducto = new TablaProducto(baseDatos.getConexion());
		tablaEmpleado = new TablaEmpleado(baseDatos.getConexion());
		
		inicio = new VentanaInicioSesion();
		inicio.getBotonNuevoUsuario().addActionListener(this);
		inicio.getBotonSesion().addActionListener(this);
		contentPane.add(inicio, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inicio.getBotonNuevoUsuario()) {
			contentPane.remove(inicio);
			repaint();
			nuevoUsuario();
		}
		
		if(e.getSource() == inicio.getBotonSesion()) {
			
		}
	}

	public void nuevoUsuario() {
		if(nuevoUsuario == null) {
			nuevoUsuario = new VentanaNuevoUsuario();
			nuevoUsuario.getRegistrar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!nuevoUsuario.camposVacios()) {
						//tablaEmpleado.guardar(nuevoUsuario.registrarEmpleado());
						JOptionPane.showMessageDialog(null, "Empleado registrado.");
						contentPane.remove(nuevoUsuario);
						nuevoUsuario = null;
						contentPane.add(inicio, BorderLayout.CENTER);
						repaint();
					}
				}
			});
			
			nuevoUsuario.getCancelar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					contentPane.remove(nuevoUsuario);
					nuevoUsuario = null;
					repaint();
					contentPane.add(inicio, BorderLayout.CENTER);
				}
			});
			contentPane.add(nuevoUsuario, BorderLayout.CENTER);
			setVisible(true);
		}
	}
}