package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.BaseDatos;
import modelo.Producto;
import modelo.TablaEmpleado;
import modelo.TablaProducto;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuItem menuRegistrarProducto;
	private VistaRegistrarProducto ventanaProducto;
	private BaseDatos baseDatos;
	private TablaProducto tablaProducto;
	private TablaEmpleado tablaEmpleado;
	private RegistroProducto registroProducto;
	private JLabel datoTitulo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProductos = new JMenu("Productos");
		menuBar.add(mnProductos);
		
		baseDatos = new BaseDatos("tiendita", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");
		
		baseDatos.hacerConexion();
		tablaProducto = new TablaProducto(baseDatos.getConexion());
		tablaEmpleado = new TablaEmpleado(baseDatos.getConexion());
		
		menuRegistrarProducto = new JMenuItem("Registrar producto");
		menuRegistrarProducto.addActionListener(this);
		mnProductos.add(menuRegistrarProducto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setExtendedState(MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 112, 192));
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 3, 400, 0));
		
		JButton btnMenu = new JButton("Men\u00FA");
		btnMenu.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnMenu.setBorderPainted(false);
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setBackground(new Color(0, 112, 192));
		panel_1.add(btnMenu);
		
		datoTitulo = new JLabel("Tienda");
		datoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		datoTitulo.setForeground(Color.WHITE);
		datoTitulo.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(datoTitulo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuRegistrarProducto) {
			registrarProducto();
			datoTitulo.setText("Productos en existencia");
		}
	}
	
	public void registrarProducto() {
		if(ventanaProducto == null) {
			ventanaProducto = new VistaRegistrarProducto();
			
			ventanaProducto.getButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					registroProducto = new RegistroProducto();
					registroProducto.getBotonRegistrar().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							tablaProducto.guardar(registroProducto.registrarProducto());
							registroProducto.limpiarVentana();
						}
					});
					
					registroProducto.getBotonCancelar().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							registroProducto.limpiarVentana();
						}
					});
					
					registroProducto.setVisible(true);
				}
			});
			contentPane.add(ventanaProducto);
			setVisible(true);
		}
	}
	
	/*public void mostrarConsulta(List<Producto> productos) {
		String[] titulos = {"C\u00f3digo de Barras", "Nombre", "Tipo", "Contenido",
				"Unidad de Medida", "Presentaci\u00f3n", "Marca", "Precio de venta"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (Producto producto : productos) {
			String[] tupla = {String.valueOf(producto.getCodigoBarras()), producto.getNombre(), producto.getTipo(), producto.getContenido(),
					libro.getNumeroEdition(), libro.getAnioEdicion(), libro.getIdioma(), libro.getPaisDeOrigen()};
			modelo.addRow(tupla);
		}
		datosGrupo.setModel(modelo);
	}*/
	
	public TablaProducto getTablaProducto() {
		return tablaProducto;
	}
}