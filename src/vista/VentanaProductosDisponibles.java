package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.Producto;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaProductosDisponibles extends JPanel implements ActionListener{
	private JLabel datoNombre;
	private JLabel datoCodigoBarras;
	private JLabel datoNombreProducto;
	private JLabel datoTipoProducto;
	private JLabel datoContenido;
	private JLabel datoUnidadMedida;
	private JLabel datoPresentacion;
	private JLabel datoMarca;
	private JLabel datoPrecioVenta;
	private JLabel datoMinimo;
	private JLabel datoMaximo;
	private JLabel datoDisponible;
	private JComboBox<String> busqueda;
	private JButton botonBuscar;
	private JPanel panel_3;
	private JButton botonAceptar;
	private JButton botonSalir;
	private JButton botonResurtir;
	private JComboBox<String> editBuscar;

	public VentanaProductosDisponibles() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(158, 38, 182));
		panel.add(panel_1, BorderLayout.NORTH);

		JLabel lblProductosDisponibles = new JLabel("Productos Disponibles");
		lblProductosDisponibles.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblProductosDisponibles.setForeground(Color.WHITE);
		panel_1.add(lblProductosDisponibles);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_3.add(lblBuscarPor);

		busqueda = new JComboBox<String>();
		busqueda.setBorder(new LineBorder(new Color(155, 38, 182)));
		busqueda.addActionListener(this);
		busqueda.setFont(new Font("Roboto", Font.PLAIN, 15));
		busqueda.setModel(new DefaultComboBoxModel<String>(new String[] {"-----------------------", "Nombre del Producto", "C\u00F3digo de Barras"}));
		busqueda.setToolTipText("");
		panel_3.add(busqueda);

		datoNombre = new JLabel("Buscar:");
		datoNombre.setFont(new Font("Roboto", Font.PLAIN, 15));
		datoNombre.setVisible(false);
		panel_3.add(datoNombre);
		
		editBuscar = new JComboBox<String>();
		editBuscar.setFont(new Font("Roboto", Font.PLAIN, 15));
		editBuscar.setBorder(new LineBorder(new Color(155, 38, 182)));
		editBuscar.setVisible(false);
		panel_3.add(editBuscar);

		botonBuscar = new JButton("Buscar");
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setBackground(new Color(158, 38, 182));
		botonBuscar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_3.add(botonBuscar);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(12, 2, 0, 0));

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras:");
		lblCdigoDeBarras.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoDeBarras.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblCdigoDeBarras);

		datoCodigoBarras = new JLabel("");
		datoCodigoBarras.setHorizontalAlignment(SwingConstants.CENTER);
		datoCodigoBarras.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoCodigoBarras);

		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto:");
		lblNombreDelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblNombreDelProducto);

		datoNombreProducto = new JLabel("");
		datoNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		datoNombreProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoNombreProducto);

		JLabel lblTipoDeProducto = new JLabel("Tipo de Producto:");
		lblTipoDeProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblTipoDeProducto);

		datoTipoProducto = new JLabel("");
		datoTipoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		datoTipoProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoTipoProducto);

		JLabel lblContenido = new JLabel("Contenido:");
		lblContenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblContenido.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblContenido);

		datoContenido = new JLabel("");
		datoContenido.setHorizontalAlignment(SwingConstants.CENTER);
		datoContenido.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoContenido);

		JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida:");
		lblUnidadDeMedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidadDeMedida.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblUnidadDeMedida);

		datoUnidadMedida = new JLabel("");
		datoUnidadMedida.setHorizontalAlignment(SwingConstants.CENTER);
		datoUnidadMedida.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoUnidadMedida);

		JLabel lblPresentacin = new JLabel("Presentaci\u00F3n");
		lblPresentacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresentacin.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblPresentacin);

		datoPresentacion = new JLabel("");
		datoPresentacion.setHorizontalAlignment(SwingConstants.CENTER);
		datoPresentacion.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoPresentacion);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblMarca);

		datoMarca = new JLabel("");
		datoMarca.setHorizontalAlignment(SwingConstants.CENTER);
		datoMarca.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoMarca);

		JLabel lblPrcioDeVenta = new JLabel("Pr\u00E9cio de Venta:");
		lblPrcioDeVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrcioDeVenta.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblPrcioDeVenta);

		datoPrecioVenta = new JLabel("");
		datoPrecioVenta.setHorizontalAlignment(SwingConstants.CENTER);
		datoPrecioVenta.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoPrecioVenta);

		JLabel lblCantidadMnima = new JLabel("Cantidad M\u00EDnima:");
		lblCantidadMnima.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadMnima.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblCantidadMnima);

		datoMinimo = new JLabel("");
		datoMinimo.setHorizontalAlignment(SwingConstants.CENTER);
		datoMinimo.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoMinimo);

		JLabel lblCantidadMxima = new JLabel("Cantidad M\u00E1xima:");
		lblCantidadMxima.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadMxima.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblCantidadMxima);

		datoMaximo = new JLabel("");
		datoMaximo.setHorizontalAlignment(SwingConstants.CENTER);
		datoMaximo.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoMaximo);

		JLabel lblDisponibleParaVender = new JLabel("Disponible para Vender:");
		lblDisponibleParaVender.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibleParaVender.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(lblDisponibleParaVender);

		datoDisponible = new JLabel("");
		datoDisponible.setHorizontalAlignment(SwingConstants.CENTER);
		datoDisponible.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_4.add(datoDisponible);
		
		JLabel label = new JLabel("");
		panel_4.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		botonResurtir = new JButton("Resurtir Producto");
		botonResurtir.setForeground(Color.WHITE);
		botonResurtir.setBackground(new Color(158, 38, 182));
		botonResurtir.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_6.add(botonResurtir);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.SOUTH);
		
		botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(this);
		botonAceptar.setBackground(new Color(158, 38, 182));
		botonAceptar.setForeground(Color.WHITE);
		botonAceptar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_5.add(botonAceptar);
		
		botonSalir = new JButton("Salir");
		botonSalir.setBackground(new Color(158, 38, 182));
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_5.add(botonSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == botonAceptar) {
			if(datoContenido == null) {
				busqueda.requestFocus();
			}
			else {
				limpiarDatos();
				busqueda.requestFocus();
			}
		}
	}
	
	public void mostrarProducto(Producto producto) {
		datoCodigoBarras.setText(producto.getCodigoBarras().toString());
		datoNombreProducto.setText(producto.getNombre());
		datoTipoProducto.setText(producto.getTipo());
		datoContenido.setText(producto.getContenido());
		datoUnidadMedida.setText(producto.getUnidad());
		datoPresentacion.setText(producto.getPresentacion());
		datoMarca.setText(producto.getMarca());
		datoPrecioVenta.setText(String.valueOf(producto.getPrecioVenta()));
		datoMinimo.setText(String.valueOf(producto.getCantidadMinima()));
		datoMaximo.setText(String.valueOf(producto.getCantidadMaxima()));
		datoDisponible.setText(String.valueOf(producto.getDisponible()));
	}
	
	public void limpiarDatos() {
		datoCodigoBarras.setText(null);
		datoNombreProducto.setText(null);
		datoTipoProducto.setText(null);
		datoContenido.setText(null);
		datoUnidadMedida.setText(null);
		datoPresentacion.setText(null);
		datoMarca.setText(null);
		datoPrecioVenta.setText(null);
		datoMinimo.setText(null);
		datoMaximo.setText(null);
		datoDisponible.setText(null);
	}
	
	public void buscarPorNombre(List<Producto> productos, JComboBox<String> datos) {
		for (Producto producto : productos) {
			datos.addItem(producto.getNombre());
		}
	}
	
	public void buscarPorCodigo(List<Producto> productos, JComboBox<String> datos) {
		for (Producto producto : productos) {
			datos.addItem(producto.getCodigoBarras().toString());
		}
	}
	
	public JLabel getDatoNombre() {
		return datoNombre;
	}
	
	public String getCombo() {
		return busqueda.getSelectedItem().toString();
	}
	
	public JComboBox<String> getCampo() {
		return editBuscar;
	}
	
	public JButton getBoton() {
		return botonBuscar;
	}
	
	public JLabel getDatoDisponible() {
		return datoDisponible;
	}
	
	public JButton getBotonSalir() {
		return botonSalir;
	}
	
	public JButton getBotonResurtir() {
		return botonResurtir;
	}
	
	public JLabel getNombre() {
		return datoNombreProducto;
	}
	
	public JComboBox<String> getBusqueda() {
		return busqueda;
	}
} 