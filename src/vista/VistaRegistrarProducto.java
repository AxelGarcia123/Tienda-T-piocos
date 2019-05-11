package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Producto;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class VistaRegistrarProducto extends JPanel implements ActionListener{
	private JButton botonNuevoProducto;
	private RegistroProducto registroProducto;
	private JTable datosProducto;

	public VistaRegistrarProducto() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(3, 4, 1000, 0));

		JLabel label = new JLabel("");
		panel_2.add(label);

		JLabel label_1 = new JLabel("");
		panel_2.add(label_1);

		botonNuevoProducto = new JButton("Nuevo Producto");
		botonNuevoProducto.setBackground(new Color(0, 112, 192));
		botonNuevoProducto.setForeground(Color.WHITE);
		botonNuevoProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		botonNuevoProducto.addActionListener(this);
		panel_2.add(botonNuevoProducto);

		JLabel label_2 = new JLabel("");
		panel_2.add(label_2);

		datosProducto = new JTable();
		datosProducto.setFont(new Font("Roboto", Font.PLAIN, 11));
		JScrollPane panelTabla = new JScrollPane(datosProducto);
		panel_1.add(panelTabla, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void mostrarProductos(List<Producto> productos) {
		String[] titulos = {"C\u00f3digo de Barras", "Nombre", "Tipo", "Contenido",
				"Unidad de Medida", "Presentaci\u00f3n", "Marca", "Precio de venta"};

		DefaultTableModel modelo = new DefaultTableModel(titulos, 0);

		for (Producto producto : productos) {
			String[] tupla = {String.valueOf(producto.getCodigoBarras()), producto.getNombre(), producto.getTipo(), producto.getContenido(),
					producto.getUnidad(), producto.getPresentacion(), producto.getMarca(), String.valueOf(producto.getPrecioVenta())};
			modelo.addRow(tupla);
		}
		datosProducto.setModel(modelo);
	}

	public JButton getButton() {
		return botonNuevoProducto;
	}
}