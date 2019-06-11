package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.Resurtir;

import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ResurtirProducto extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField editCantidad;
	private JTextField editPrecio;
	private RSDateChooser fechaResurtido;
	private RSDateChooser fechaCaducidad;
	private JButton botonResurtir;
	private JButton botonCancelar;
	private String nombreProducto;
	private JLabel datoProducto;

	public ResurtirProducto(String nombreProducto) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\attachment_38986924.jpg"));
		this.nombreProducto = nombreProducto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(158, 38, 182));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblResurtirProducto = new JLabel("Resurtir Producto");
		lblResurtirProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblResurtirProducto.setForeground(Color.WHITE);
		panel.add(lblResurtirProducto);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 2, 0, 50));
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblProducto);
		
		datoProducto = new JLabel("");
		datoProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(datoProducto);
		
		JLabel lblCantidadResurtida = new JLabel("Cantidad Resurtida:");
		lblCantidadResurtida.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblCantidadResurtida);
		
		editCantidad = new JTextField();
		editCantidad.addActionListener(this);
		editCantidad.setBorder(new LineBorder(new Color(158, 38, 182)));
		editCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		editCantidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editCantidad);
		editCantidad.setColumns(10);
		
		JLabel lblFechaDeResurtido = new JLabel("Fecha de Resurtido:");
		lblFechaDeResurtido.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblFechaDeResurtido);
		
		fechaResurtido = new RSDateChooser();
		fechaResurtido.setColorForeground(new Color(158, 38, 182));
		fechaResurtido.setColorButtonHover(new Color(158, 38, 182));
		fechaResurtido.setColorBackground(new Color(158, 38, 182));
		panel_1.add(fechaResurtido);
		
		JLabel lblPrecioPorUnidad = new JLabel("Precio por Unidad:");
		lblPrecioPorUnidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblPrecioPorUnidad);
		
		editPrecio = new JTextField();
		editPrecio.addActionListener(this);
		editPrecio.setBorder(new LineBorder(new Color(158, 38, 182)));
		editPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		editPrecio.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editPrecio);
		editPrecio.setColumns(10);
		
		JLabel lblFechaDeCaducidad = new JLabel("Fecha de Caducidad:");
		lblFechaDeCaducidad.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblFechaDeCaducidad);
		
		fechaCaducidad = new RSDateChooser();
		fechaCaducidad.setColorForeground(new Color(158, 38, 182));
		fechaCaducidad.setColorButtonHover(new Color(158, 38, 182));
		fechaCaducidad.setColorBackground(new Color(158, 38, 182));
		panel_1.add(fechaCaducidad);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		botonResurtir = new JButton("Resurtir");
		botonResurtir.setForeground(Color.WHITE);
		botonResurtir.setBackground(new Color(158, 38, 182));
		botonResurtir.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(botonResurtir);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setBackground(new Color(158, 38, 182));
		botonCancelar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(botonCancelar);
		setLocationRelativeTo(null);
		datoProducto.setText(nombreProducto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editCantidad) {
			if(editCantidad.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
				editCantidad.requestFocus();
			}
			else
				fechaResurtido.requestFocus();
		}
		
		if(e.getSource() == editPrecio) {
			if(editPrecio.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
				editPrecio.requestFocus();
			}
			else
				fechaCaducidad.requestFocus();
		}
		
		if(e.getSource() == botonCancelar) {
			System.exit(0);
		}
	}
	
	public Resurtir registrarResurtir(BigInteger codigoBarras) {
		Resurtir resurtir = new Resurtir();
		resurtir.setCodigoProducto(codigoBarras);
		resurtir.setCantidadResurtirda(Integer.parseInt(editCantidad.getText()));
		
		String formatoFecha = "yyyyMMdd";
		Date fecha = fechaResurtido.getDatoFecha();
		
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
		String prueba1 = String.valueOf(formateador.format(fecha));
		
		Date fechaCad = fechaCaducidad.getDatoFecha();
		String prueba2 = String.valueOf(formateador.format(fechaCad));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = null;
        Date parsed2 = null;
		try {
			parsed = format.parse(prueba1);
			parsed2 = format.parse(prueba2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        java.sql.Date sql1 = new java.sql.Date(parsed2.getTime());
		
		resurtir.setFechaResurtido(sql);
		resurtir.setPrecioUnidad(Float.parseFloat(editPrecio.getText()));
		resurtir.setFechaCaducidad(sql1);

		return resurtir;
	}
	
	public JButton getBotonResurtir() {
		return botonResurtir;
	}
	
	public JButton getBotonCancelar() {
		return botonCancelar;
	}
	
	public void limpiarVentana() {
		this.dispose();
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	public int getCantidad() {
		return Integer.parseInt(editCantidad.getText());
	}
	
	public JTextField getCampoCantidad() {
		return editCantidad;
	}
}