package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuLateral extends JPanel {
	private JButton botonVentas;
	private JButton botonVentasDelDia;
	private JButton botonListaProductos;
	private JButton botonInventario;
	private JButton botonInicio;
	private JButton botonExistencia;
	private JPanel panel;
	private JLabel label;
	private JLabel datoNombreEmpleado;
	private JButton botonRegistrarProducto;
	private JButton botonGraficas;
	private JButton botonReportes;
	
	public MenuLateral() {
		setBackground(new Color(158, 38, 182));
		setLayout(new GridLayout(10, 0, 0, 25));
		
		panel = new JPanel();
		panel.setBackground(new Color(158, 38, 182));
		add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-contactos-32.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		datoNombreEmpleado = new JLabel("Nombre pendiente");
		datoNombreEmpleado.setFont(new Font("Roboto", Font.PLAIN, 15));
		datoNombreEmpleado.setForeground(Color.WHITE);
		datoNombreEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(datoNombreEmpleado);
		
		botonVentas = new JButton("Ventas");
		botonVentas.setHorizontalAlignment(SwingConstants.LEFT);
		botonVentas.setBorderPainted(false);
		botonVentas.setContentAreaFilled(false);
		botonVentas.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-carrito-de-compras-32.png"));
		botonVentas.setBackground(new Color(158, 38, 182));
		botonVentas.setForeground(Color.WHITE);
		botonVentas.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonVentas);
		
		botonVentasDelDia = new JButton("Ventas del d\u00EDa");
		botonVentasDelDia.setHorizontalAlignment(SwingConstants.LEFT);
		botonVentasDelDia.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-calendario-26.png"));
		botonVentasDelDia.setContentAreaFilled(false);
		botonVentasDelDia.setBorderPainted(false);
		botonVentasDelDia.setBackground(new Color(158, 38, 182));
		botonVentasDelDia.setForeground(Color.WHITE);
		botonVentasDelDia.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonVentasDelDia);
		
		botonRegistrarProducto = new JButton("Registrar Producto");
		botonRegistrarProducto.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-botella-de-soda-32.png"));
		botonRegistrarProducto.setHorizontalAlignment(SwingConstants.LEFT);
		botonRegistrarProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		botonRegistrarProducto.setForeground(Color.WHITE);
		botonRegistrarProducto.setContentAreaFilled(false);
		botonRegistrarProducto.setBorderPainted(false);
		botonRegistrarProducto.setBackground(Color.WHITE);
		add(botonRegistrarProducto);
		
		botonListaProductos = new JButton("Lista de Productos");
		botonListaProductos.setHorizontalAlignment(SwingConstants.LEFT);
		botonListaProductos.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-m\u00E1quina-expendedora-50.png"));
		botonListaProductos.setContentAreaFilled(false);
		botonListaProductos.setBorderPainted(false);
		botonListaProductos.setBackground(new Color(158, 38, 182));
		botonListaProductos.setForeground(Color.WHITE);
		botonListaProductos.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonListaProductos);
		
		botonInventario = new JButton("Inventario");
		botonInventario.setHorizontalAlignment(SwingConstants.LEFT);
		botonInventario.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-almac\u00E9n-24.png"));
		botonInventario.setContentAreaFilled(false);
		botonInventario.setBorderPainted(false);
		botonInventario.setBackground(new Color(158, 38, 182));
		botonInventario.setForeground(Color.WHITE);
		botonInventario.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonInventario);
		
		botonExistencia = new JButton("Productos Disponibles");
		botonExistencia.setHorizontalAlignment(SwingConstants.LEFT);
		botonExistencia.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-producto-50.png"));
		botonExistencia.setContentAreaFilled(false);
		botonExistencia.setBorderPainted(false);
		botonExistencia.setForeground(Color.WHITE);
		botonExistencia.setFont(new Font("Roboto", Font.PLAIN, 15));
		botonExistencia.setBackground(new Color(155, 38, 182));
		add(botonExistencia);
		
		botonGraficas = new JButton("Gr\u00E1ficas");
		botonGraficas.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-gr\u00E1fico-de-barras-50.png"));
		botonGraficas.setForeground(Color.WHITE);
		botonGraficas.setFont(new Font("Roboto", Font.PLAIN, 15));
		botonGraficas.setBorderPainted(false);
		botonGraficas.setContentAreaFilled(false);
		botonGraficas.setHorizontalAlignment(SwingConstants.LEFT);
		add(botonGraficas);
		
		botonInicio = new JButton("Inicio");
		botonInicio.setHorizontalAlignment(SwingConstants.LEFT);
		botonInicio.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-casa-32.png"));
		botonInicio.setContentAreaFilled(false);
		botonInicio.setBorderPainted(false);
		botonInicio.setBackground(new Color(158, 38, 182));
		botonInicio.setForeground(Color.WHITE);
		botonInicio.setFont(new Font("Roboto", Font.PLAIN, 15));
		add(botonInicio);
		
		botonReportes = new JButton("Reportes");
		botonReportes.setForeground(Color.WHITE);
		botonReportes.setFont(new Font("Roboto", Font.PLAIN, 15));
		botonReportes.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-historial-de-pedidos-50.png"));
		botonReportes.setContentAreaFilled(false);
		botonReportes.setBorderPainted(false);
		botonReportes.setHorizontalAlignment(SwingConstants.LEFT);
		add(botonReportes);
	}
	
	public JButton getVentas() {
		return botonVentas;
	}
	
	public JButton getVentasDelDia() {
		return botonVentasDelDia;
	}
	
	public JButton getProductos() {
		return botonListaProductos;
	}
	
	public JButton getInventario() {
		return botonInventario;
	}
	
	public JButton getBotonInicio() {
		return botonInicio;
	}
	
	public JButton getBotonRegistrart() {
		return botonRegistrarProducto;
	}
	
	public JButton getBotonExistencia() {
		return botonExistencia;
	}
	
	public JButton getBotonGraficas() {
		return botonGraficas;
	}
	
	public JLabel getDatoEmpleado() {
		return datoNombreEmpleado;
	}
}