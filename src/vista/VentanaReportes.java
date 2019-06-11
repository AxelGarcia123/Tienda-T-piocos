package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Compra;
import modelo.DatosRenglonTicket;
import modelo.TablaProducto;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaReportes extends JPanel {
	private JTable tablaReportes;

	public VentanaReportes() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		tablaReportes = new JTable();
		tablaReportes.setFont(new Font("Roboto", Font.PLAIN, 17));
		scrollPane.setViewportView(tablaReportes);
	}
	
	public void mostrarReportes(List<DatosRenglonTicket> reportes) {
		String[] titulos = {"N\u00famero de ticket","Nombre del Producto", "Cantidad comprada", "Pr\u00e9cio de Venta", "Fecha de Ticket",
		"Total", "Nombre del Empleado"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (DatosRenglonTicket datos: reportes) {
			String[] tupla = {String.valueOf(datos.getNumeroTicket()), datos.getNombreProducto(), String.valueOf(datos.getCantidad()), 
					String.valueOf(datos.getPrecioVenta()), String.valueOf(datos.getFechaVenta()),
					String.valueOf(datos.getTotalVenta()), datos.getNombreEmpleado()};
			modelo.addRow(tupla);
		}
		tablaReportes.setModel(modelo);
	}
}