package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class MenuLateral extends JPanel {
	private JButton botonVentas;
	private JButton botonVentasDelDia;
	private JButton botonProductos;
	private JButton botonInventario;
	private JButton botonInicio;
	
	public MenuLateral() {
		setLayout(new GridLayout(5, 0, 0, 100));
		
		botonVentas = new JButton("Ventas");
		botonVentas.setBackground(new Color(0, 112, 192));
		botonVentas.setForeground(Color.WHITE);
		botonVentas.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonVentas);
		
		botonVentasDelDia = new JButton("Ventas del d\u00EDa");
		botonVentasDelDia.setBackground(new Color(0, 112, 192));
		botonVentasDelDia.setForeground(Color.WHITE);
		botonVentasDelDia.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonVentasDelDia);
		
		botonProductos = new JButton("Productos");
		botonProductos.setBackground(new Color(0, 112, 192));
		botonProductos.setForeground(Color.WHITE);
		botonProductos.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonProductos);
		
		botonInventario = new JButton("Inventario");
		botonInventario.setBackground(new Color(0, 112, 192));
		botonInventario.setForeground(Color.WHITE);
		botonInventario.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonInventario);
		
		botonInicio = new JButton("Inicio");
		botonInicio.setBackground(new Color(0, 112, 192));
		botonInicio.setForeground(Color.WHITE);
		botonInicio.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonInicio);
	}
	
	public JButton getVentas() {
		return botonVentas;
	}
	
	public JButton getVentasDelDia() {
		return botonVentasDelDia;
	}
	
	public JButton getProductos() {
		return botonProductos;
	}
	
	public JButton getInventario() {
		return botonInventario;
	}
	
	public JButton getBotonInicio() {
		return botonInicio;
	}
}