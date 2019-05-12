package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class VentanaTitulo extends JPanel {
	private JLabel datoTienda;
	private JButton botonMenu;

	public VentanaTitulo() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 112, 192));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 5, 200, 0));
		
		botonMenu = new JButton("");
		botonMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		botonMenu.setContentAreaFilled(false);
		botonMenu.setBorderPainted(false);
		botonMenu.setSize(new Dimension(1, 1));
		botonMenu.setIcon(new ImageIcon("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\icons8-men\u00FA-24.png"));
		botonMenu.setBackground(new Color(0, 112, 192));
		panel.add(botonMenu);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		datoTienda = new JLabel("Tienda");
		datoTienda.setForeground(Color.WHITE);
		datoTienda.setFont(new Font("Roboto", Font.PLAIN, 20));
		datoTienda.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(datoTienda);
	}
	
	public JLabel getTitulo() {
		return datoTienda;
	}
	
	public JButton getBotonMenu() {
		return botonMenu;
	}
}