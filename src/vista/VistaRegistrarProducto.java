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
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VistaRegistrarProducto extends JPanel implements ActionListener{
	private RegistroProducto registroProducto;
	private JTable datosProducto;

	public VistaRegistrarProducto() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(158, 38, 182));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label = new JLabel("Lista de Productos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_2.add(label);

		datosProducto = new JTable();
		datosProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
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
}