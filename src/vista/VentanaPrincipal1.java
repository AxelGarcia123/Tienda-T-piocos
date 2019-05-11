package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import modelo.BaseDatos;
import modelo.Compra;
import modelo.RenglonTicket;
import modelo.TablaEmpleado;
import modelo.TablaProducto;
import modelo.TablaRenglonTicket;
import modelo.TablaResurtir;
import modelo.TablaTicket;

public class VentanaPrincipal1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private VentanaInicioSesion inicio;
	private VistaRegistrarProducto ventanaProducto;
	private VentanaInicial ventanaInicial;
	private BaseDatos baseDatos;
	private TablaProducto tablaProducto;
	private TablaEmpleado tablaEmpleado;
	private TablaResurtir tablaResurtir;
	private TablaRegistro tablaRegistro;
	private TablaTicket tablaTicket;
	private TablaRenglonTicket renglonTicket;
	private RegistroProducto registroProducto;
	private VentanaNuevoUsuario nuevoUsuario;
	private MenuLateral menuLateral;
	private VentanaTitulo titulo;
	private VentanaInventario ventanaInventario;
	private VentanaVenta venta;
	private VentanaReportes reportes;
	private boolean aux = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal1 frame = new VentanaPrincipal1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		baseDatos = new BaseDatos("tiendita", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");

		baseDatos.hacerConexion();
		tablaProducto = new TablaProducto(baseDatos.getConexion());
		tablaEmpleado = new TablaEmpleado(baseDatos.getConexion());
		tablaResurtir = new TablaResurtir(baseDatos.getConexion());
		tablaRegistro = new TablaRegistro(baseDatos.getConexion());
		tablaTicket = new TablaTicket(baseDatos.getConexion());
		renglonTicket = new TablaRenglonTicket(baseDatos.getConexion());

		inicio = new VentanaInicioSesion();
		inicio.getBotonNuevoUsuario().addActionListener(this);
		inicio.getBotonSesion().addActionListener(this);
		contentPane.add(inicio, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inicio.getBotonNuevoUsuario()) {
			contentPane.remove(inicio);
			repaint();
			nuevoUsuario();
		}

		if(e.getSource() == inicio.getBotonSesion()) {
			inicioSesion();
		}
	}

	public void inicioSesion() {
		if(tablaRegistro.existe(inicio.getNombreUsuario().getText())) {
			if(tablaRegistro.validacion(inicio.getPassword())) {
				contentPane.removeAll();
				setExtendedState(MAXIMIZED_BOTH);
				//ventanaInicial = new VentanaInicial();
				titulo = new VentanaTitulo();
				contentPane.add(titulo, BorderLayout.NORTH);
				//contentPane.add(ventanaInicial, BorderLayout.CENTER);

				titulo.getBotonMenu().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						mostrarMenuLateral();
					}
				});
			}
			else {
				JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.", null, JOptionPane.ERROR_MESSAGE);
				inicio.enfocarPassword();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "El nombre de usuario es incorrecto.", null, JOptionPane.ERROR_MESSAGE);
			inicio.enfocar();
		}
	}

	public void nuevoUsuario() {
		if(nuevoUsuario == null) {
			nuevoUsuario = new VentanaNuevoUsuario();
			nuevoUsuario.getRegistrar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!nuevoUsuario.camposVacios()) {
						if(!tablaRegistro.existe(nuevoUsuario.getNombreUsuario())) {
							tablaEmpleado.guardar(nuevoUsuario.registrarEmpleado());
							tablaRegistro.guardar(nuevoUsuario.getRegistro(tablaEmpleado));
							JOptionPane.showMessageDialog(null, "Empleado registrado.");
							contentPane.remove(nuevoUsuario);
							nuevoUsuario = null;
							contentPane.add(inicio, BorderLayout.CENTER);
							repaint();
						}
						else {
							JOptionPane.showMessageDialog(null, "Ese nombre de usuario est\u00e1 en uso.", null, JOptionPane.ERROR_MESSAGE);
							nuevoUsuario.limpiarNombre();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Hay campos vacios que no pueden quedar as\u00ed.", null, JOptionPane.ERROR_MESSAGE);
				}
			});

			nuevoUsuario.getCancelar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					contentPane.remove(nuevoUsuario);
					nuevoUsuario = null;
					repaint();
					contentPane.add(inicio, BorderLayout.CENTER);
				}
			});
			contentPane.add(nuevoUsuario, BorderLayout.CENTER);
			setVisible(true);
		}
	}

	public void mostrarMenuLateral() {
		if(menuLateral == null) {
			menuLateral = new MenuLateral();
			menuLateral.getProductos().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registrarProducto();
				}
			});

			menuLateral.getInventario().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					inventario();
				}
			});

			menuLateral.getVentas().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ventas();
				}
			});
			
			menuLateral.getVentasDelDia().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ventanaReportes();
				}
			});
			
			menuLateral.getBotonInicio().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					inicio();
				}
			});
			contentPane.add(menuLateral, BorderLayout.WEST);
			setVisible(true);
		}

		else if(menuLateral != null) {
			borrarMenu();
		}
	}

	public void borrarMenu() {
		contentPane.remove(menuLateral);
		menuLateral = null;
		repaint();
	}

	public void registrarProducto() {
		if(ventanaProducto == null) {
			//titulo.getTitulo().setText("Registro de productos");
			ventanaProducto = new VistaRegistrarProducto();
			borrarMenu();

			ventanaProducto.mostrarProductos(tablaProducto.getProductos());
			ventanaProducto.getButton().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registroProducto = new RegistroProducto();
					registroProducto.getBotonRegistrar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							tablaProducto.guardar(registroProducto.registrarProducto());
							ventanaProducto.mostrarProductos(tablaProducto.getProductos());
							registroProducto.limpiarVentana();
						}
					});

					registroProducto.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							registroProducto.limpiarVentana();
						}
					});

					registroProducto.setVisible(true);
				}
			});
			contentPane.add(ventanaProducto);
			setVisible(true);
		}
	}

	public void inventario() {
		if(ventanaInventario == null) {
			ventanaInventario = new VentanaInventario();
			borrarMenu();
			ventanaInventario.mostrarResurtidos(tablaResurtir.getResurtidos(), tablaResurtir);
			ventanaInventario.getCampoProducto().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!ventanaInventario.getCampoProducto().getText().isEmpty()) {
						if(tablaResurtir.existe(ventanaInventario.getCampoProducto().getText())) {
							ventanaInventario.enfocarCantidad();
						}
						else
							JOptionPane.showMessageDialog(null, "Ese producto no ha sido registrado.", null, JOptionPane.ERROR_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
				}
			});

			ventanaInventario.getBotonResurtir().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!ventanaInventario.camposVacios()) {
						if(tablaResurtir.existe(ventanaInventario.getCampoProducto().getText())) {
							JOptionPane.showMessageDialog(null, "Producto registrado");
							tablaResurtir.guardar(ventanaInventario.registrarResurtir(tablaResurtir.getCodigoBarras(ventanaInventario.getCampoProducto().getText())));
							ventanaInventario.mostrarResurtidos(tablaResurtir.getResurtidos(), tablaResurtir);
							ventanaInventario.limpiarCampos();
						}
						else {
							JOptionPane.showMessageDialog(null, "Ese producto no ha sido registrado.", null, JOptionPane.ERROR_MESSAGE);
							ventanaInventario.enfocarCursor();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Hay campos vacios que no pueden quedar as\u00ed.", null, JOptionPane.ERROR_MESSAGE);
						ventanaInventario.enfocarCursor();
					}
				}
			});

			ventanaInventario.getBotonRegistrarProducto().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registroProducto = new RegistroProducto();
					registroProducto.getBotonRegistrar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							tablaProducto.guardar(registroProducto.registrarProducto());
							registroProducto.limpiarVentana();
						}
					});

					registroProducto.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							registroProducto.limpiarVentana();
						}
					});

					registroProducto.setVisible(true);
				}
			});

			contentPane.add(ventanaInventario);
			setVisible(true);
		}
	}

	public void ventas() {
		
		if(venta == null) {
			venta = new VentanaVenta();
			borrarMenu();
			venta.agregarDatos(tablaEmpleado.getNombre(inicio.getNombreUsuario().getText()));
			venta.getBotonAgregar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!venta.getNombre().isEmpty()) {
						if(tablaProducto.existe(venta.getNombre())) {
							venta.mostrarCompras(venta.getNombre(), tablaProducto, aux);
						}
						else
							JOptionPane.showMessageDialog(null, "Ese producto no ha sido registrado.", null, JOptionPane.ERROR_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
				}
			});

			venta.getBotonComprar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!venta.datosVacios()) {
						aux = true;
						tablaTicket.guardar(venta.getTicket(tablaRegistro.getCodigoEmpleado(inicio.getNombreUsuario().getText())));
						datosTicket(venta.compras(), tablaTicket.getCodigoTicket(venta.totalPrecio()),tablaRegistro.getCodigoEmpleado(inicio.getNombreUsuario().getText()));
						venta.mostrarCompras(venta.getNombre(), tablaProducto, aux);
						JOptionPane.showMessageDialog(null, "Compra hecha");
						aux = false;
					}
					else
						JOptionPane.showMessageDialog(null, "No se han agregado compras.", null, JOptionPane.ERROR_MESSAGE);
				}
			});

			venta.getBotonCancelar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					aux = true;
					venta.mostrarCompras(venta.getNombre(), tablaProducto, aux);
					aux = false;
				}
			});

			contentPane.add(venta);
			setVisible(true);
		}
	}
	
	public void ventanaReportes() {
		if(reportes == null) {
			reportes = new VentanaReportes();
			reportes.mostrarReportes(renglonTicket.getDatos());
			contentPane.add(reportes);
			setVisible(true);
		}
	}
	
	public void inicio() {
		contentPane.removeAll();
		reportes = null;
		venta = null;
		registroProducto = null;
		ventanaInventario = null;
		ventanaProducto = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();
	}

	public void datosTicket(List<Compra> compras, int ticket, int empleado) {
		RenglonTicket datos = new RenglonTicket();
		for(Compra compra : compras) {
			datos.setCantidad(compra.getCantidadProducto());
			datos.setCodigoBarra(compra.getCodigoBarras());
			datos.setFolioTicket(ticket);
			datos.setClaveEmpleado(empleado);
			int cantidadAnterior = tablaResurtir.getCantidad(compra.getCodigoBarras());
			int nuevoDato = cantidadAnterior - compra.getCantidadProducto();
			tablaResurtir.actualizar(nuevoDato, cantidadAnterior, compra.getCodigoBarras());
			renglonTicket.guardar(datos);
		}
	}
}