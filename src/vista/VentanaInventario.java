package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Producto;
import modelo.Resurtir;
import modelo.TablaResurtir;

import java.util.Date;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class VentanaInventario extends JPanel implements ActionListener{
	private JTextField editProducto;
	private JTextField editCantidad;
	private JTextField editPrecioUnidad;
	private JTable tablaResurtir;
	private JButton botonResurtir;
	private JButton botonRegistrar;
	private JButton botonCancelar;
	private RSDateChooser editFechaResurtir;
	private RSDateChooser editFechaCaducidad;

	public VentanaInventario() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		botonResurtir = new JButton("Resurtir");
		botonResurtir.setBackground(new Color(0, 112, 192));
		botonResurtir.setForeground(Color.WHITE);
		botonResurtir.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel.add(botonResurtir);

		botonRegistrar = new JButton("Registrar Producto");
		botonRegistrar.setBackground(new Color(0, 112, 192));
		botonRegistrar.setForeground(Color.WHITE);
		botonRegistrar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel.add(botonRegistrar);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBackground(new Color(0, 112, 192));
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel.add(botonCancelar);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(10, 1, 10, 30));

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProducto);

		editProducto = new JTextField();
		editProducto.setBorder(new LineBorder(new Color(0, 112, 192)));
		editProducto.addActionListener(this);
		editProducto.setHorizontalAlignment(SwingConstants.CENTER);
		editProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editProducto);
		editProducto.setColumns(10);

		JLabel lblCantidadResurtida = new JLabel("Cantidad Resurtida:");
		lblCantidadResurtida.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblCantidadResurtida.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCantidadResurtida);

		editCantidad = new JTextField();
		editCantidad.setBorder(new LineBorder(new Color(0, 112, 192)));
		editCantidad.addActionListener(this);
		editCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		editCantidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editCantidad);
		editCantidad.setColumns(10);

		JLabel lblFechaDeResurtido = new JLabel("Fecha de resurtido:");
		lblFechaDeResurtido.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblFechaDeResurtido.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblFechaDeResurtido);

		editFechaResurtir = new RSDateChooser();
		panel_1.add(editFechaResurtir);

		JLabel lblPrcioPorUnidad = new JLabel("Pr\u00E9cio por unidad:");
		lblPrcioPorUnidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblPrcioPorUnidad.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblPrcioPorUnidad);

		editPrecioUnidad = new JTextField();
		editPrecioUnidad.setBorder(new LineBorder(new Color(0, 112, 192)));
		editPrecioUnidad.addActionListener(this);
		editPrecioUnidad.setHorizontalAlignment(SwingConstants.CENTER);
		editPrecioUnidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editPrecioUnidad);
		editPrecioUnidad.setColumns(10);

		JLabel lblFechaDeCaducidad = new JLabel("Fecha de Caducidad");
		lblFechaDeCaducidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblFechaDeCaducidad.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblFechaDeCaducidad);

		editFechaCaducidad = new RSDateChooser();
		panel_1.add(editFechaCaducidad);

		tablaResurtir = new JTable();
		tablaResurtir.setFont(new Font("Roboto", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tablaResurtir);
		add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == editCantidad) {
			if(editCantidad.getText().isEmpty()) 
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				editFechaResurtir.requestFocus();
		}

		if(e.getSource() == editFechaResurtir) {
			editPrecioUnidad.requestFocus();
		}

		if(e.getSource() == editPrecioUnidad) {
			JOptionPane.showMessageDialog(null, editFechaResurtir.getDatoFecha());
			if(editPrecioUnidad.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
			else
				editFechaCaducidad.requestFocus();
		}

		if(e.getSource() == editFechaCaducidad) {
			botonResurtir.requestFocus();
		}
	}

	public Resurtir registrarResurtir(BigInteger codigoBarras) {
		Resurtir resurtir = new Resurtir();
		resurtir.setCodigoProducto(codigoBarras);
		resurtir.setCantidadResurtirda(Integer.parseInt(editCantidad.getText()));
		
		String formatoFecha = "yyyy/MM/dd";
		Date fecha = editFechaResurtir.getDatoFecha();
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
		
		resurtir.setFechaResurtido(formateador.format(fecha));
		resurtir.setPrecioUnidad(Float.parseFloat(editPrecioUnidad.getText()));
		
		Date fechaCaducidad = editFechaCaducidad.getDatoFecha();
		resurtir.setFechaCaducidad(formateador.format(fechaCaducidad));

		return resurtir;
	}
	
	public void mostrarResurtidos(List<Resurtir> resurtidos, TablaResurtir tabla) {
		String[] titulos = {"Producto", "Fecha de resurtido", "Cantidad Resurtida", "Pr\u00e9cio por unidad",
				"Fecha de Caducidad"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (Resurtir resurtir : resurtidos) {
			String[] tupla = {tabla.nombreProducto(resurtir.getCodigoProducto()), resurtir.getFechaResurtido(), 
					String.valueOf(resurtir.getCantidadResurtirda()), String.valueOf(resurtir.getPrecioUnidad()),
					resurtir.getFechaCaducidad()};
			modelo.addRow(tupla);
		}
		tablaResurtir.setModel(modelo);
	}

	public boolean camposVacios() {
		String fechaResurtir = String.valueOf(editFechaResurtir.getDatoFecha());
		String fechaCaducidad = String.valueOf(editFechaCaducidad.getDatoFecha());
		return editProducto.getText().isEmpty() || editCantidad.getText().isEmpty() || editPrecioUnidad.getText().isEmpty()
				|| fechaResurtir.isEmpty() || fechaCaducidad.isEmpty();
	}
	
	public void limpiarCampos() {
		editProducto.setText(null);
		editCantidad.setText(null);
		editPrecioUnidad.setText(null);
		editFechaResurtir.setDatoFecha(null);
		editFechaCaducidad.setDatoFecha(null);
	}

	public JButton getBotonResurtir() {
		return botonResurtir;
	}

	public JButton getBotonRegistrarProducto() {
		return botonRegistrar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public JTextField getCampoProducto() {
		return editProducto;
	}

	public void enfocarCantidad() {
		editCantidad.requestFocus();
	}
	
	public void enfocarCursor() {
		editProducto.requestFocus();
	}
}