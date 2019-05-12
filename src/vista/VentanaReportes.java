package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Compra;
import modelo.DatosRenglonTicket;
import modelo.TablaProducto;

public class VentanaReportes extends JPanel {
	private JTable tablaReportes;

	public VentanaReportes() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		tablaReportes = new JTable();
		scrollPane.setViewportView(tablaReportes);
	}
	
	public void mostrarReportes(List<DatosRenglonTicket> reportes) {
		String[] titulos = {"Nombre del Producto", "Cantidad comprada", "Pr\u00e9cio de Venta", "Fecha de Ticket",
		"Total", "Nombre del Empleado"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (DatosRenglonTicket datos: reportes) {
			String[] tupla = {datos.getNombreProducto(), String.valueOf(datos.getCantidad()), 
					String.valueOf(datos.getPrecioVenta()), datos.getFechaVenta(),
					String.valueOf(datos.getTotalVenta()), datos.getNombreEmpleado()};
			modelo.addRow(tupla);
		}
		tablaReportes.setModel(modelo);
	}
}