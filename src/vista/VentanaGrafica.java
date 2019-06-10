package vista;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import modelo.ProductoVendido;
import modelo.TipoProducto;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaGrafica extends JPanel {
	private JButton botonGraficar;
	private JComboBox<String> tiposProductos;
	private JPanel panelGrafica;
	private JButton botonGraficarTodo;

	public VentanaGrafica() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(158, 38, 182));
		add(panel, BorderLayout.NORTH);

		JLabel lblGrficas = new JLabel("Gr\u00E1ficas");
		lblGrficas.setForeground(Color.WHITE);
		lblGrficas.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel.add(lblGrficas);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);

		JLabel lblProductoMsVendido = new JLabel("Producto m\u00E1s vendido.");
		lblProductoMsVendido.setFont(new Font("Roboto", Font.PLAIN, 17));
		panel_2.add(lblProductoMsVendido);

		JLabel lblTipo = new JLabel("   Tipo:");
		lblTipo.setFont(new Font("Roboto", Font.PLAIN, 17));
		panel_2.add(lblTipo);

		tiposProductos = new JComboBox<String>();
		tiposProductos.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(tiposProductos);

		botonGraficar = new JButton("Graficar");
		botonGraficar.setForeground(Color.WHITE);
		botonGraficar.setFont(new Font("Roboto", Font.PLAIN, 15));
		botonGraficar.setBackground(new Color(158, 38, 182));
		panel_2.add(botonGraficar);
		
		botonGraficarTodo = new JButton("Graficar Todo");
		botonGraficarTodo.setForeground(Color.WHITE);
		botonGraficarTodo.setFont(new Font("Roboto", Font.PLAIN, 15));
		botonGraficarTodo.setBackground(new Color(158, 38, 182));
		panel_2.add(botonGraficarTodo);

		panelGrafica = new JPanel();
		panel_1.add(panelGrafica, BorderLayout.CENTER);

	}
	
	public void mostrarTipos(List<TipoProducto> tipos) {
		for (TipoProducto tipoProducto : tipos) {
			tiposProductos.addItem(tipoProducto.getTipo());
		}
	}

	public void mostrarGrafica(List<ProductoVendido> vendidos, String tipo) {
		panelGrafica.removeAll();
		repaint();
		
		JFreeChart grafica;
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		
		for (ProductoVendido productoVendido : vendidos) {
			String nombre = productoVendido.getNombreProducto();
			int cantidad = productoVendido.getCantidad();
			datos.addValue(cantidad, tipo, nombre);
		}
		
		grafica = ChartFactory.createBarChart("Productos",
				"Nombre del Producto", "Ventas", datos,
				PlotOrientation.HORIZONTAL, true, true, false);
		
		ChartPanel panel = new ChartPanel(grafica);
		panelGrafica.add(panel);
	}
	
	public void mostrarGraficaTodo(List<ProductoVendido> vendidos) {
		panelGrafica.removeAll();
		repaint();
		
		JFreeChart grafica;
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		
		for (ProductoVendido productoVendido : vendidos) {
			String nombre = productoVendido.getNombreProducto();
			int cantidad = productoVendido.getCantidad();
			String tipo = productoVendido.getTipo();
			datos.addValue(cantidad, tipo, nombre);
		}
		
		grafica = ChartFactory.createBarChart("Productos",
				"Nombre del Producto", "Ventas", datos,
				PlotOrientation.HORIZONTAL, true, true, false);
		
		ChartPanel panel = new ChartPanel(grafica);
		panelGrafica.add(panel);
	}
	
	public JButton getBotonGraficar() {
		return botonGraficar;
	}
	
	public String getTipo() {
		return tiposProductos.getSelectedItem().toString();
	}
	
	public JButton getGraficarTodo() {
		return botonGraficarTodo;
	}
}