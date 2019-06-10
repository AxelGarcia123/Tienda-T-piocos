package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;

public class VentanaInicial extends JPanel {
	
	public VentanaInicial() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(158, 38, 182));
		add(panel, BorderLayout.NORTH);
		
		JLabel lblTienda = new JLabel("Tienda");
		lblTienda.setForeground(Color.WHITE);
		lblTienda.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTienda);
		
	}
}