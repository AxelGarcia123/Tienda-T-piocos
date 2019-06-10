package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.layout.element.Paragraph;

import modelo.Compra;
import modelo.Producto;
import modelo.RenglonTicket;
import modelo.TablaProducto;
import modelo.Ticket;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;

public class VentanaVenta extends JPanel implements ActionListener {
	private JButton botonComprar;
	private JLabel datoEmpleado;
	private JLabel datoFecha;
	private JLabel datoTotal;
	private JLabel datoTotalAPagar;
	private JTextField editRecibido;
	private JLabel datoCambio;
	private JTable tablaCompras;
	private JButton botonAgregar;
	private List<Compra> compras;
	private float total = 0;
	private JButton botonCancelar;
	private JSpinner cantidadProducto;
	private JPanel panel_4;
	private JButton btnEliminarCompra;
	private JComboBox<String> editProducto;
	

	public VentanaVenta() {
		setLayout(new BorderLayout(0, 0));
		compras = new ArrayList<>();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(lblProducto);
		
		editProducto = new JComboBox<String>();
		editProducto.setBorder(new LineBorder(new Color(155, 38, 182)));
		panel.add(editProducto);

		cantidadProducto = new JSpinner();
		cantidadProducto.setBorder(new LineBorder(new Color(155, 38, 182)));
		cantidadProducto.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		cantidadProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel.add(cantidadProducto);

		botonAgregar = new JButton("Agregar");
		botonAgregar.setBorderPainted(false);
		botonAgregar.setBackground(new Color(155, 38, 182));
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
		lblEncargado.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_2.add(lblEncargado);

		datoEmpleado = new JLabel("");
		datoEmpleado.setFont(new Font("Roboto", Font.PLAIN, 20));
		datoEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoEmpleado);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_2.add(lblFecha);

		datoFecha = new JLabel("");
		datoFecha.setFont(new Font("Roboto", Font.PLAIN, 20));
		datoFecha.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoFecha);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_2.add(lblTotal);

		datoTotal = new JLabel("");
		datoTotal.setFont(new Font("Roboto", Font.PLAIN, 20));
		datoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoTotal);

		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_2.add(lblTotalAPagar);

		datoTotalAPagar = new JLabel("");
		datoTotalAPagar.setFont(new Font("Roboto", Font.PLAIN, 20));
		datoTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoTotalAPagar);

		JLabel lblRecibido = new JLabel("Recibido:");
		lblRecibido.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_2.add(lblRecibido);

		editRecibido = new JTextField();
		editRecibido.setBorder(new LineBorder(new Color(155, 38, 182)));
		editRecibido.addActionListener(this);
		editRecibido.setToolTipText("");
		editRecibido.setFont(new Font("Roboto", Font.PLAIN, 20));
		editRecibido.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(editRecibido);
		editRecibido.setColumns(10);

		JLabel lbCambio = new JLabel("Cambio:");
		lbCambio.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_2.add(lbCambio);

		datoCambio = new JLabel("");
		datoCambio.setFont(new Font("Roboto", Font.PLAIN, 20));
		datoCambio.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(datoCambio);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);

		botonComprar = new JButton("Comprar");
		botonComprar.setBorderPainted(false);
		botonComprar.setBackground(new Color(155, 38, 182));
		botonComprar.setForeground(Color.WHITE);
		botonComprar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_3.add(botonComprar);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBorderPainted(false);
		botonCancelar.setBackground(new Color(155, 38, 182));
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.addActionListener(this);
		botonCancelar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_3.add(botonCancelar);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		tablaCompras = new JTable();
		tablaCompras.setFont(new Font("Roboto", Font.PLAIN, 18));
		scrollPane.setViewportView(tablaCompras);

		panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);

		btnEliminarCompra = new JButton("Eliminar Compra");
		btnEliminarCompra.setForeground(Color.WHITE);
		btnEliminarCompra.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnEliminarCompra.setBackground(new Color(155, 38, 182));
		panel_4.add(btnEliminarCompra);
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

		int filas =  modelo.getRowCount();
		btnEliminarCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(filas != 0) {
					eliminarPedido(tablaCompras, modelo, compras);
				}
			}
		});
	}

	public Compra getDatosCompra(String nombre, TablaProducto producto) {
		Compra compra = new Compra();
		compra.setCodigoBarras(producto.getCodigoBarras(nombre));
		compra.setNombreProducto(nombre);
		int cantidad = (int) cantidadProducto.getValue();
		compra.setCantidadProducto(cantidad);
		compra.setPrecioProducto(producto.getPrecio(nombre));
		compra.setTotalProducto(cantidad * producto.getPrecio(nombre));
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
		return editProducto.getSelectedItem().toString();
	}
	
	public JComboBox<String> getCampoProducto() {
		return editProducto;
	}
	
	public JSpinner getCantidadProducto() {
		return cantidadProducto;
	}
	
	public int getCantidad() {
		int cantidad = (int) cantidadProducto.getValue();
		return cantidad;
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
		return datoTotalAPagar.getText().isEmpty() || datoCambio.getText().isEmpty() || editRecibido.getText().isEmpty()
				|| compras.isEmpty() || datoTotalAPagar.getText().equals("0.0");
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

	public void eliminarPedido(JTable tblDetalle, DefaultTableModel modelo, List<Compra> compras) {
		modelo = (DefaultTableModel) tblDetalle.getModel();
		int fila = tblDetalle.getSelectedRow();
		if (fila >= 0) {
			
			String nombreProducto = (String) modelo.getValueAt(tblDetalle.getSelectedRow(), 1);
			String precio = (String) modelo.getValueAt(tblDetalle.getSelectedRow(), 4);
			float totalProducto = Float.parseFloat(precio);
			totalProducto = Float.parseFloat(datoTotal.getText()) - totalProducto;
			datoTotal.setText(String.valueOf(totalProducto));
			datoTotalAPagar.setText(String.valueOf(totalProducto));
			total = totalProducto;
			
			int []filasselec = tblDetalle.getSelectedRows();
			for (int i=0; i<filasselec. length;i++) {
				modelo.removeRow(filasselec[i]);
			}
			
			for (Compra compra2 : compras) {
				if(compra2.getNombreProducto().equals(nombreProducto)) {
					compras.remove(compra2);
					break;
				}
			}
		}
	}
	
	public void buscarProducto(List<Producto> productos, JComboBox<String> datos) {
		for (Producto producto : productos) {
			datos.addItem(producto.getNombre());
		}
	}
	
	public void limpiar() {
		datoTotal.setText(null);
		datoTotalAPagar.setText(null);
		datoCambio.setText(null);
		compras.clear();
		editProducto.requestFocus();
		tablaCompras.clearSelection();
		editRecibido.setText(null);
		total = 0;
	}
	
	public static void generarTicket(List<RenglonTicket> list,double total) {
		Document documento = new Document();

		FileOutputStream ficheroPdf;
		try {
			ficheroPdf = new FileOutputStream("ticket.pdf");
			PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
			documento.open();
			for (RenglonTicket r : list) {
				documento.add(new Paragraph(r.getCodigoBarra()+"          "+r.getCantidad()));

			}
			documento.add(new Paragraph("\nTotal:         "+total));
			documento.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generarTicket() throws FileNotFoundException {
		PdfWriter writer = new PdfWriter("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\Ticket.pdf");
		PdfDocument document = new PdfDocument(writer);
		// Se crea el documento
		Document documento = new Document(document);
		documento.add(new Paragraph("Hola mundo"));
		documento.close();
	}
}