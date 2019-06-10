package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Compra;
import modelo.Resurtir;
import modelo.TablaProducto;
import modelo.Ticket;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class VentanaVenta extends JPanel implements ActionListener {
	private JTextField editProducto;
	private JButton botonComprar;
	private JLabel datoEmpleado;
	private JLabel datoFecha;
	private JLabel datoTotal;
	private JLabel datoTotalAPagar;
	private JTextField editRecibido;
	private JLabel datoCambio;
	private JTable tablaCompras;
	private JTextField editCantidad;
	private JButton botonAgregar;
	private List<Compra> compras;
	private float total = 0;
	private JButton botonCancelar;

	public VentanaVenta() {
		setLayout(new BorderLayout(0, 0));
		compras = new ArrayList<>();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(lblProducto);

		editProducto = new JTextField();
		editProducto.setBorder(new LineBorder(new Color(0, 112, 192)));
		editProducto.setHorizontalAlignment(SwingConstants.CENTER);
		editProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		editProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel.add(editProducto);
		editProducto.setColumns(10);

		editCantidad = new JTextField();
		editCantidad.setBorder(new LineBorder(new Color(0, 112, 192)));
		editCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		editCantidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		editCantidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel.add(editCantidad);
		editCantidad.setColumns(10);

		botonAgregar = new JButton("Agregar");
		botonAgregar.setBackground(new Color(0, 112, 192));
		botonAgregar.setForeground(Color.WHITE);
		botonAgregar.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-carrito-de-compras-32.png"));
		botonAgregar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel.add(botonAgregar);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(6, 2, 0, 50));

		JLabel lblEncargado = new JLabel("Encargado:");
		lblEncargado.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblEncargado);

		datoEmpleado = new JLabel("");
		datoEmpleado.setFont(new Font("Roboto", Font.PLAIN, 15));
		datoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoEmpleado);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblFecha);

		datoFecha = new JLabel("");
		datoFecha.setFont(new Font("Roboto", Font.PLAIN, 15));
		datoFecha.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoFecha);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblTotal);

		datoTotal = new JLabel("");
		datoTotal.setFont(new Font("Roboto", Font.PLAIN, 15));
		datoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoTotal);

		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblTotalAPagar);

		datoTotalAPagar = new JLabel("");
		datoTotalAPagar.setFont(new Font("Roboto", Font.PLAIN, 15));
		datoTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoTotalAPagar);

		JLabel lblRecibido = new JLabel("Recibido:");
		lblRecibido.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lblRecibido);

		editRecibido = new JTextField();
		editRecibido.setBorder(new LineBorder(new Color(0, 112, 192)));
		editRecibido.addActionListener(this);
		editRecibido.setToolTipText("");
		editRecibido.setFont(new Font("Roboto", Font.PLAIN, 15));
		editRecibido.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(editRecibido);
		editRecibido.setColumns(10);

		JLabel lbCambio = new JLabel("Cambio:");
		lbCambio.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(lbCambio);

		datoCambio = new JLabel("");
		datoCambio.setFont(new Font("Roboto", Font.PLAIN, 15));
		datoCambio.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoCambio);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);

		botonComprar = new JButton("Comprar");
		botonComprar.setBackground(new Color(0, 112, 192));
		botonComprar.setForeground(Color.WHITE);
		botonComprar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_3.add(botonComprar);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBackground(new Color(0, 112, 192));
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.addActionListener(this);
		botonCancelar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_3.add(botonCancelar);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		tablaCompras = new JTable();
		tablaCompras.setFont(new Font("Roboto", Font.PLAIN, 18));
		scrollPane.setViewportView(tablaCompras);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == editRecibido) {
			if(editRecibido.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "No se ha registrado pago alguno.", null, JOptionPane.ERROR_MESSAGE);
			else {
				datoCambio.setText(String.valueOf(Float.parseFloat(editRecibido.getText()) - total));
				botonComprar.requestFocus();
			}
		}

		if(e.getSource() == botonComprar) {
			if(datoTotalAPagar.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "No se ha hecho ninguna compra.", null, JOptionPane.ERROR_MESSAGE);
		}

		if(e.getSource() == botonCancelar) {
			datoTotal.setText(null);
			datoTotalAPagar.setText(null);
			datoCambio.setText(null);
			compras.clear();
			editProducto.requestFocus();
			tablaCompras.clearSelection();
			total = 0;
		}
	}

	public void mostrarCompras(String nombre, TablaProducto producto, boolean aux) {
		String[] titulos = {"C\u00f3digo", "Nombre del producto", "Cantidad", "Pr\u00e9cio",
		"Total"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
		compras.add(getDatosCompra(nombre, producto));

		for (Compra compra : compras) {
			String[] tupla = {String.valueOf(compra.getCodigoBarras()), compra.getNombreProducto(), 
					String.valueOf(compra.getCantidadProducto()), String.valueOf(compra.getPrecioProducto()),
					String.valueOf(compra.getTotalProducto())};
			modelo.addRow(tupla);
		}
		tablaCompras.setModel(modelo);
		if(aux) {
			modelo.setRowCount(0);
			total = 0;
		}
	}

	public Compra getDatosCompra(String nombre, TablaProducto producto) {
		Compra compra = new Compra();
		compra.setCodigoBarras(producto.getCodigoBarras(nombre));
		compra.setNombreProducto(nombre);
		if(editCantidad.getText().isEmpty())
			editCantidad.setText("1");
		compra.setCantidadProducto(Integer.parseInt(editCantidad.getText()));
		compra.setPrecioProducto(producto.getPrecio(nombre));
		compra.setTotalProducto(Integer.parseInt(editCantidad.getText()) * producto.getPrecio(nombre));
		total += compra.getTotalProducto();
		datosPrecio(total);
		return compra;
	}

	public Ticket getTicket(int clave) {
		Ticket ticket = new Ticket();
		String fechaDeVenta = eliminaContenido(datoFecha.getText(), " ");
		
		String formatoFecha = "yyyyMMdd";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = null;
		try {
			parsed = format.parse(dateFormat.format(date));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		
		ticket.setFecha(sql);
		ticket.setTotal(Float.parseFloat(datoTotalAPagar.getText()));
		ticket.setClaveEmpleado(clave);
		return ticket;
	}

	public void agregarDatos(String nombre) {
		datoEmpleado.setText(nombre);
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		datoFecha.setText(hourdateFormat.format(date));
	}

	public void datosPrecio(float total) {
		datoTotal.setText(String.valueOf(total));
		datoTotalAPagar.setText(String.valueOf(total));
	}

	public Float totalPrecio() {
		return Float.parseFloat(datoTotalAPagar.getText());
	}

	public String getNombre() {
		return editProducto.getText();
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public JButton getBotonComprar() {
		return botonComprar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public boolean datosVacios() {
		return datoTotalAPagar.getText().isEmpty() || datoCambio.getText().isEmpty() || editRecibido.getText().isEmpty();
	}

	private String eliminaContenido(String text, String sep){     
		if (text != null && text.contains(sep)) {     
			int position = text.indexOf(sep);
			text = text.substring(0, position +1);              
		}
		return text;
	}

	public List<Compra> compras() {
		return compras;
	}
}