package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VistaRegistrarProducto extends JPanel implements ActionListener{
	private JLabel datoRegistroProductos;
	private JButton botonNuevoProducto;
	private RegistroProducto registroProducto;

	public VistaRegistrarProducto() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		datoRegistroProductos = new JLabel("Registro de Productos");
		panel.add(datoRegistroProductos);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		botonNuevoProducto = new JButton("Nuevo Producto");
		botonNuevoProducto.addActionListener(this);
		panel_2.add(botonNuevoProducto);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public JButton getButton() {
		return botonNuevoProducto;
	}
}