package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import modelo.Producto;

import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;

public class VentanaRegistrarProducto extends JPanel implements ActionListener{
	private JTextField editCodigoBarras;
	private JTextField editNombreProducto;
	private JTextField editContenido;
	private JTextField editMarca;
	private JTextField editPrecioVenta;
	private JSpinner editCantidadMaxima;
	private JSpinner editCantidadMinima;
	private JButton botonCancelar;
	private JButton botonRegistrar;
	private JComboBox<String> editProducto;
	private JComboBox<String> editUnidadMedida;
	private JComboBox<String> editPresentacion;

	public VentanaRegistrarProducto() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(155, 38, 182));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblRegistroDeProductos = new JLabel("Registro de Productos");
		lblRegistroDeProductos.setForeground(Color.WHITE);
		lblRegistroDeProductos.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblRegistroDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRegistroDeProductos);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 4, 10, 100));

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras:");
		lblCdigoDeBarras.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblCdigoDeBarras);

		editCodigoBarras = new JTextField();
		editCodigoBarras.addActionListener(this);
		editCodigoBarras.setBorder(new LineBorder(new Color(155, 38, 182)));
		editCodigoBarras.setHorizontalAlignment(SwingConstants.CENTER);
		editCodigoBarras.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editCodigoBarras);
		editCodigoBarras.setColumns(10);

		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto:");
		lblNombreDelProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblNombreDelProducto);

		editNombreProducto = new JTextField();
		editNombreProducto.addActionListener(this);
		editNombreProducto.setBorder(new LineBorder(new Color(155, 38, 182)));
		editNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		editNombreProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editNombreProducto);
		editNombreProducto.setColumns(10);

		JLabel lblTipoDeProducto = new JLabel("Tipo de Producto:");
		lblTipoDeProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblTipoDeProducto);

		editProducto = new JComboBox<String>();
		editProducto.addActionListener(this);
		editProducto.setToolTipText("");
		editProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		editProducto.setBorder(new LineBorder(new Color(155, 38, 182)));
		panel_1.add(editProducto);

		JLabel lblContenido = new JLabel("Contenido:");
		lblContenido.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblContenido);

		editContenido = new JTextField();
		editContenido.addActionListener(this);
		editContenido.setBorder(new LineBorder(new Color(155, 38, 182)));
		editContenido.setHorizontalAlignment(SwingConstants.CENTER);
		editContenido.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editContenido);
		editContenido.setColumns(10);

		JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida:");
		lblUnidadDeMedida.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblUnidadDeMedida);

		editUnidadMedida = new JComboBox<String>();
		editUnidadMedida.addActionListener(this);
		editUnidadMedida.setToolTipText("");
		editUnidadMedida.setFont(new Font("Roboto", Font.PLAIN, 15));
		editUnidadMedida.setBorder(new LineBorder(new Color(155, 38, 182)));
		panel_1.add(editUnidadMedida);

		JLabel lblPresentacin = new JLabel("Presentaci\u00F3n:");
		lblPresentacin.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblPresentacin);

		editPresentacion = new JComboBox<String>();
		editPresentacion.addActionListener(this);
		editPresentacion.setToolTipText("");
		editPresentacion.setFont(new Font("Roboto", Font.PLAIN, 15));
		editPresentacion.setBorder(new LineBorder(new Color(155, 38, 182)));
		panel_1.add(editPresentacion);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblMarca);

		editMarca = new JTextField();
		editMarca.addActionListener(this);
		editMarca.setBorder(new LineBorder(new Color(155, 38, 182)));
		editMarca.setHorizontalAlignment(SwingConstants.CENTER);
		editMarca.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editMarca);
		editMarca.setColumns(10);

		JLabel lblPrecioDeVenta = new JLabel("Precio de Venta:");
		lblPrecioDeVenta.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblPrecioDeVenta);

		editPrecioVenta = new JTextField();
		editPrecioVenta.addActionListener(this);
		editPrecioVenta.setBorder(new LineBorder(new Color(155, 38, 182)));
		editPrecioVenta.setHorizontalAlignment(SwingConstants.CENTER);
		editPrecioVenta.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editPrecioVenta);
		editPrecioVenta.setColumns(10);

		JLabel lblCantidadMnima = new JLabel("Cantidad M\u00EDnima:");
		lblCantidadMnima.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblCantidadMnima);

		editCantidadMinima = new JSpinner();
		editCantidadMinima.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		editCantidadMinima.setBorder(new LineBorder(new Color(155, 38, 182)));
		editCantidadMinima.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editCantidadMinima);

		JLabel lblCantidadMxima = new JLabel("Cantidad M\u00E1xima");
		lblCantidadMxima.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_1.add(lblCantidadMxima);

		editCantidadMaxima = new JSpinner();
		editCantidadMaxima.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		editCantidadMaxima.setBorder(new LineBorder(new Color(155, 38, 182)));
		editCantidadMaxima.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editCantidadMaxima);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);

		botonRegistrar = new JButton("Registrar");
		//botonRegistrar.addActionListener(this);
		botonRegistrar.setForeground(Color.WHITE);
		botonRegistrar.setBackground(new Color(155, 38, 182));
		botonRegistrar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(botonRegistrar);

		botonCancelar = new JButton("Cancelar");
		//botonCancelar.addActionListener(this);
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setBackground(new Color(155, 38, 182));
		botonCancelar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(botonCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editCodigoBarras) {
			if(editCodigoBarras.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				editNombreProducto.requestFocus();
		}

		if(e.getSource() == editNombreProducto) {
			if(editNombreProducto.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				editProducto.requestFocus();
		}
		
		if(e.getSource() == editProducto) {
			
			if(editProducto.getSelectedItem().toString() == "Otro") {
				String datoNuevo = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato:");
				editProducto.addItem(datoNuevo);
				editProducto.setSelectedItem(datoNuevo);
				editContenido.requestFocus();
			}
			
			else
				editContenido.requestFocus();
		}

		if(e.getSource() == editContenido) {
			if(editContenido.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				editUnidadMedida.requestFocus();
		}
		
		if(e.getSource() == editUnidadMedida) {			
			if(editUnidadMedida.getSelectedItem().toString() == "Otro") {
				String datoNuevo = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato:");
				editUnidadMedida.addItem(datoNuevo);
				editUnidadMedida.setSelectedItem(datoNuevo);
				editUnidadMedida.requestFocus();
			}
			
			else
				editPresentacion.requestFocus();
		}
		
		if(e.getSource() == editPresentacion) {			
			if(editPresentacion.getSelectedItem().toString() == "Otro") {
				String datoNuevo = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato:");
				editPresentacion.addItem(datoNuevo);
				editPresentacion.setSelectedItem(datoNuevo);
				editPresentacion.requestFocus();
			}
			
			else
				editMarca.requestFocus();
		}

		if(e.getSource() == editMarca) {
			if(editMarca.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				editPrecioVenta.requestFocus();
		}

		if(e.getSource() == editPrecioVenta) {
			if(editPrecioVenta.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				editCantidadMinima.requestFocus();
		}

		if(e.getSource() == editCantidadMinima) {
			editCantidadMaxima.requestFocus();
		}

		if(e.getSource() == editCantidadMaxima) {
			botonRegistrar.requestFocus();
		}
	}

	public Producto registrarProducto() {
		Producto producto = new Producto();
		producto.setCodigoBarras(new BigInteger(editCodigoBarras.getText()));
		producto.setNombre(editNombreProducto.getText());
		producto.setTipo(editProducto.getSelectedItem().toString());
		producto.setContenido(editContenido.getText());
		producto.setUnidad(editUnidadMedida.getSelectedItem().toString());
		producto.setPresentacion(editPresentacion.getSelectedItem().toString());
		producto.setMarca(editMarca.getText());
		producto.setPrecioVenta(Double.parseDouble(editPrecioVenta.getText()));
		int min = (int) editCantidadMinima.getValue();
		int max = (int) editCantidadMaxima.getValue();
		producto.setCantidadMinima(min);
		producto.setCantidadMaxima(max);
		producto.setDisponible(0);
		return producto;
	}

	public void limpiarCampos() {
		editCodigoBarras.setText(null);
		editNombreProducto.setText(null);
		editProducto.setSelectedIndex(0);
		editContenido.setText(null);
		editUnidadMedida.setSelectedIndex(0);
		editPresentacion.setSelectedIndex(0);
		editMarca.setText(null);
		editPrecioVenta.setText(null);
		editCantidadMinima.setValue(1);
		editCantidadMaxima.setValue(1);
	}

	public boolean hayCamposVacios() {
		String dato = editProducto.getSelectedItem().toString();
		String dato1 = editUnidadMedida.getSelectedItem().toString();
		String dato2 = editPresentacion.getSelectedItem().toString();
		return editCodigoBarras.getText().isEmpty() || editNombreProducto.getText().isEmpty() || dato.isEmpty()
				|| editContenido.getText().isEmpty() || dato1.isEmpty() || dato2.isEmpty()
				|| editMarca.getText().isEmpty() || editPrecioVenta.getText().isEmpty();
	}

	public void llenarTipo(List<Producto> productos, JComboBox<String> datos) {
		List<String> dato = new ArrayList<String>();
		datos.addItem("");
		for (Producto producto : productos) {
			dato.add(producto.getTipo());
		}
		
		Set<String> hashSet = new HashSet<String>(dato);
        dato.clear();
        dato.addAll(hashSet);
		
		for (String string : dato) {
			datos.addItem(string);
		}
		
		datos.addItem("Otro");
	}
	
	public void llenarMedida(List<Producto> productos, JComboBox<String> datos) {
		List<String> dato = new ArrayList<String>();
		datos.addItem("");
		for (Producto producto : productos) {
			dato.add(producto.getUnidad());
		}
		
		Set<String> hashSet = new HashSet<String>(dato);
        dato.clear();
        dato.addAll(hashSet);
		
		for (String string : dato) {
			datos.addItem(string);
		}
		
		datos.addItem("Otro");
	}
	
	public void llenarPresentacion(List<Producto> productos, JComboBox<String> datos) {
		List<String> dato = new ArrayList<String>();
		datos.addItem("");
		for (Producto producto : productos) {
			dato.add(producto.getPresentacion());
		}
		
		Set<String> hashSet = new HashSet<String>(dato);
        dato.clear();
        dato.addAll(hashSet);
		
		for (String string : dato) {
			datos.addItem(string);
		}
		
		datos.addItem("Otro");
	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public JTextField codigoBarras() {
		return editCodigoBarras;
	}

	public void enfocar() {
		editCodigoBarras.requestFocus();
	}
	
	public JComboBox<String> getTipo() {
		return editProducto;
	}
	
	public JComboBox<String> getUnidadMedida() {
		return editUnidadMedida;
	}
	
	public JComboBox<String> getPresentacion() {
		return editPresentacion;
	}
}