package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Producto;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RegistroProducto extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField editCodigoBarras;
	private JTextField editNombreProducto;
	private JTextField editTipoProducto;
	private JTextField editContenidoProducto;
	private JTextField editUnidadMedida;
	private JTextField editPresentacion;
	private JTextField editMarca;
	private JTextField editPrecioVenta;
	private JButton botonRegistrar;
	private JButton botonCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroProducto frame = new RegistroProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistroProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 112, 192));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNuevoProducto = new JLabel("Nuevo Producto");
		lblNuevoProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNuevoProducto.setForeground(Color.WHITE);
		panel.add(lblNuevoProducto);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(8, 2, 0, 20));
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de barras");
		lblCdigoDeBarras.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblCdigoDeBarras);
		
		editCodigoBarras = new JTextField();
		editCodigoBarras.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editCodigoBarras.setHorizontalAlignment(SwingConstants.CENTER);
		editCodigoBarras.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editCodigoBarras);
		editCodigoBarras.setColumns(10);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del producto");
		lblNombreDelProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblNombreDelProducto);
		
		editNombreProducto = new JTextField();
		editNombreProducto.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		editNombreProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editNombreProducto);
		editNombreProducto.setColumns(10);
		
		JLabel lblTipoDeProducto = new JLabel("Tipo de producto");
		lblTipoDeProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblTipoDeProducto);
		
		editTipoProducto = new JTextField();
		editTipoProducto.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editTipoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		editTipoProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editTipoProducto);
		editTipoProducto.setColumns(10);
		
		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblContenido);
		
		editContenidoProducto = new JTextField();
		editContenidoProducto.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editContenidoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		editContenidoProducto.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editContenidoProducto);
		editContenidoProducto.setColumns(10);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de medida");
		lblUnidadDeMedida.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblUnidadDeMedida);
		
		editUnidadMedida = new JTextField();
		editUnidadMedida.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editUnidadMedida.setHorizontalAlignment(SwingConstants.CENTER);
		editUnidadMedida.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editUnidadMedida);
		editUnidadMedida.setColumns(10);
		
		JLabel lblPresentacin = new JLabel("Presentaci\u00F3n");
		lblPresentacin.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblPresentacin);
		
		editPresentacion = new JTextField();
		editPresentacion.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editPresentacion.setHorizontalAlignment(SwingConstants.CENTER);
		editPresentacion.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editPresentacion);
		editPresentacion.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblMarca);
		
		editMarca = new JTextField();
		editMarca.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editMarca.setHorizontalAlignment(SwingConstants.CENTER);
		editMarca.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editMarca);
		editMarca.setColumns(10);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de Venta");
		lblPrecioDeVenta.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(lblPrecioDeVenta);
		
		editPrecioVenta = new JTextField();
		editPrecioVenta.setBorder(new LineBorder(new Color(0, 112, 192), 1));
		editPrecioVenta.setHorizontalAlignment(SwingConstants.CENTER);
		editPrecioVenta.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_1.add(editPrecioVenta);
		editPrecioVenta.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		botonRegistrar = new JButton("Registrar");
		botonRegistrar.setBackground(new Color(0, 112, 192));
		botonRegistrar.setForeground(Color.WHITE);
		botonRegistrar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(botonRegistrar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBackground(new Color(0, 112, 192));
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Roboto", Font.PLAIN, 15));
		panel_2.add(botonCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public Producto registrarProducto() {
		Producto producto = new Producto();
		producto.setCodigoBarras(new BigInteger(editCodigoBarras.getText()));
		producto.setNombre(editNombreProducto.getText());
		producto.setTipo(editTipoProducto.getText());
		producto.setContenido(editContenidoProducto.getText());
		producto.setUnidad(editUnidadMedida.getText());
		producto.setPresentacion(editPresentacion.getText());
		producto.setMarca(editMarca.getText());
		producto.setPrecioVenta(Double.parseDouble(editPrecioVenta.getText()));
		
		return producto;
	}
	
	public void limpiarVentana() {
		this.dispose();
	}
	
	public JButton getBotonCancelar() {
		return botonCancelar;
	}
	
	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}
}
