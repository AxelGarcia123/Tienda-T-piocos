package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import modelo.AutoCompletion;
import modelo.BaseDatos;
import modelo.Compra;
import modelo.RenglonTicket;
import modelo.TablaEmpleado;
import modelo.TablaProducto;
import modelo.TablaRenglonTicket;
import modelo.TablaResurtir;
import modelo.TablaTicket;
import java.awt.Toolkit;

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
	private VentanaRegistrarProducto registrarProducto;
	private VentanaProductosDisponibles productoD;
	private ResurtirProducto registroP;
	private VentanaGrafica grafica;
	private boolean aux = false;
	private int limite = 0;
	private String puesto = "";

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\iconos\\attachment_38986924.jpg"));
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
				puesto = tablaRegistro.tipoEmpleado(inicio.getPassword(), inicio.getNombreUsuario().getText());
				if(puesto.equals("Administrador")) {
					contentPane.removeAll();
					setExtendedState(MAXIMIZED_BOTH);
					titulo = new VentanaTitulo();
					contentPane.add(titulo, BorderLayout.NORTH);

					titulo.getBotonMenu().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							mostrarMenuLateral();
						}
					});
				}
				else if(tablaRegistro.tipoEmpleado(inicio.getPassword(), inicio.getNombreUsuario().getText()).equals("Empleado")) {
					contentPane.removeAll();
					setExtendedState(MAXIMIZED_BOTH);
					ventas();
					ventanaInicial = new VentanaInicial();
					contentPane.add(ventanaInicial, BorderLayout.NORTH);
				}
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
			menuLateral.getDatoEmpleado().setText(tablaEmpleado.getNombre(inicio.getNombreUsuario().getText()));
			menuLateral.getProductos().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registroProductos();
				}
			});

			menuLateral.getBotonRegistrart().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registrarProductos();
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

			menuLateral.getBotonExistencia().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					productosDisponibles();
				}
			});
			
			menuLateral.getBotonGraficas().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					graficas();
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

	public void registroProductos() {
		contentPane.removeAll();
		reportes = null;
		venta = null;
		registroProducto = null;
		ventanaInventario = null;
		ventanaProducto = null;
		registrarProducto = null;
		productoD = null;
		registroP = null;
		grafica = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();
		
		if(ventanaProducto == null) {
			ventanaProducto = new VistaRegistrarProducto();
			ventanaProducto.mostrarProductos(tablaProducto.getProductos());
			contentPane.add(ventanaProducto);
			setVisible(true);
		}
	}

	public void registrarProductos() {
		contentPane.removeAll();
		reportes = null;
		venta = null;
		registroProducto = null;
		ventanaInventario = null;
		ventanaProducto = null;
		registrarProducto = null;
		productoD = null;
		registroP = null;
		grafica = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();

		if(registrarProducto == null) {
			registrarProducto = new VentanaRegistrarProducto();
			registrarProducto.codigoBarras().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!tablaProducto.existeCodigo(registrarProducto.codigoBarras().getText())) {

					}
					else 
						JOptionPane.showMessageDialog(null, "Ya existe un producto con ese C\u00f3digo de Barras.", null, JOptionPane.ERROR_MESSAGE);
				}
			});
			
			registrarProducto.llenarTipo(tablaProducto.getListaProductos(), registrarProducto.getTipo());
			AutoCompletion.enable(registrarProducto.getTipo());
			
			registrarProducto.llenarMedida(tablaProducto.getListaProductos(), registrarProducto.getUnidadMedida());
			AutoCompletion.enable(registrarProducto.getUnidadMedida());
			
			registrarProducto.llenarPresentacion(tablaProducto.getListaProductos(), registrarProducto.getPresentacion());
			AutoCompletion.enable(registrarProducto.getPresentacion());

			registrarProducto.getBotonRegistrar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!tablaProducto.existeCodigo(registrarProducto.codigoBarras().getText())) {
						if(!registrarProducto.hayCamposVacios()) {
							tablaProducto.guardar(registrarProducto.registrarProducto());
							JOptionPane.showMessageDialog(null, "El producto se ha registrado");
							registrarProducto.limpiarCampos();
						}
						else
							JOptionPane.showMessageDialog(null, "Hay campos vacios que no pueden quedar así.", null, JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Ya existe un producto con ese C\u00f3digo de Barras.", null, JOptionPane.ERROR_MESSAGE);
						registrarProducto.enfocar();
					}
				}
			});

			contentPane.add(registrarProducto);
			setVisible(true);
		}
	}

	public void inventario() {
		contentPane.removeAll();
		reportes = null;
		venta = null;
		registroProducto = null;
		ventanaInventario = null;
		ventanaProducto = null;
		registrarProducto = null;
		productoD = null;
		registroP = null;
		grafica = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();

		if(ventanaInventario == null) {
			ventanaInventario = new VentanaInventario();
			ventanaInventario.mostrarResurtidos(tablaResurtir.getResurtidos(), tablaResurtir);
			
			ventanaInventario.buscarProducto(tablaProducto.getListaProductos(), ventanaInventario.getCampoProducto());
			AutoCompletion.enable(ventanaInventario.getCampoProducto());
			
			ventanaInventario.getCampoProducto().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!ventanaInventario.getCampoProducto().getSelectedItem().toString().isEmpty()) {
						if(tablaResurtir.existe(ventanaInventario.getCampoProducto().getSelectedItem().toString())) {
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
						if(tablaResurtir.existe(ventanaInventario.getCampoProducto().getSelectedItem().toString())) {
							int cantidad = ventanaInventario.getCantidadResurtir();
							if(tablaProducto.getMax(tablaResurtir.getCodigoBarras(ventanaInventario.getCampoProducto().getSelectedItem().toString())) > cantidad) {
								tablaResurtir.guardar(ventanaInventario.registrarResurtir(tablaResurtir.getCodigoBarras(ventanaInventario.getCampoProducto().getSelectedItem().toString())));
								ventanaInventario.mostrarResurtidos(tablaResurtir.getResurtidos(), tablaResurtir);

								int resurtido = ventanaInventario.getCantidad();
								int nuevoDato = cantidadNueva(ventanaInventario.getCampoProducto().getSelectedItem().toString(), resurtido);
								tablaProducto.actualizar(nuevoDato, tablaResurtir.getCodigoBarras(ventanaInventario.getCampoProducto().getSelectedItem().toString()));

								ventanaInventario.limpiarCampos();
								JOptionPane.showMessageDialog(null, "Producto registrado");
							}
							else {
								int input = JOptionPane.showConfirmDialog(null, "El producto estar\u00e1 en sobreexistencia.\n¿Desea continuar?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if(input == JOptionPane.YES_OPTION) {
									tablaResurtir.guardar(ventanaInventario.registrarResurtir(tablaResurtir.getCodigoBarras(ventanaInventario.getCampoProducto().getSelectedItem().toString())));
									ventanaInventario.mostrarResurtidos(tablaResurtir.getResurtidos(), tablaResurtir);

									int resurtido = ventanaInventario.getCantidad();
									int nuevoDato = cantidadNueva(ventanaInventario.getCampoProducto().getSelectedItem().toString(), resurtido);
									tablaProducto.actualizar(nuevoDato, tablaResurtir.getCodigoBarras(ventanaInventario.getCampoProducto().getSelectedItem().toString()));

									ventanaInventario.limpiarCampos();
									JOptionPane.showMessageDialog(null, "Producto registrado");
								}
								else {
									ventanaInventario.enfocarCantidad();
								}
							}
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
		if(puesto.equals("Empleado")) {
			
		}
		
		else if(puesto.equals("Administrador")) {
			contentPane.removeAll();
			reportes = null;
			venta = null;
			registroProducto = null;
			ventanaInventario = null;
			ventanaProducto = null;
			registrarProducto = null;
			productoD = null;
			registroP = null;
			grafica = null;
			borrarMenu();
			contentPane.add(titulo, BorderLayout.NORTH);
			repaint();
		}
		//VENTAS LO DE COMBO BOX
		if(venta == null) {
			venta = new VentanaVenta();
			venta.agregarDatos(tablaEmpleado.getNombre(inicio.getNombreUsuario().getText()));
			
			venta.buscarProducto(tablaProducto.getListaProductos(), venta.getCampoProducto());
			AutoCompletion.enable(venta.getCampoProducto());
			
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
						float total = venta.getTicket(tablaRegistro.getCodigoEmpleado(inicio.getNombreUsuario().getText())).getTotal();
						tablaTicket.guardar(venta.getTicket(tablaRegistro.getCodigoEmpleado(inicio.getNombreUsuario().getText())));
						datosTicket(venta.compras(), tablaTicket.getCodigoTicket(venta.totalPrecio()),tablaRegistro.getCodigoEmpleado(inicio.getNombreUsuario().getText()));
						venta.mostrarCompras(venta.getNombre(), tablaProducto, aux);
						venta.limpiar();
						JOptionPane.showMessageDialog(null, "Compra hecha");
						aux = false;
						venta.generarTicket(renglonTicket.getDatosTicketPrecio(total), total, tablaTicket.getCodigoTicket(total), "Casa Abdalá", renglonTicket.getDatosTicket(total));
						venta.mostrarTicket(tablaTicket.getCodigoTicket(total));
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

	public void productosDisponibles() {
		contentPane.removeAll();
		reportes = null;
		venta = null;
		registroProducto = null;
		ventanaInventario = null;
		ventanaProducto = null;
		registrarProducto = null;
		productoD = null;
		registroP = null;
		grafica = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();

		if(productoD == null) {
			productoD = new VentanaProductosDisponibles();
			
			productoD.getBusqueda().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(String.valueOf(productoD.getBusqueda().getSelectedItem()).equals("Nombre del Producto")) {
						productoD.getDatoNombre().setVisible(true);
						productoD.getCampo().setVisible(true);
						productoD.buscarPorNombre(tablaProducto.getListaProductos(), productoD.getCampo());
						AutoCompletion.enable(productoD.getCampo());
					}
					
					else if(String.valueOf(productoD.getBusqueda().getSelectedItem()).equals("Código de Barras")) {
						productoD.getDatoNombre().setVisible(true);
						productoD.getCampo().setVisible(true);
						productoD.buscarPorCodigo(tablaProducto.getListaProductos(), productoD.getCampo());
						AutoCompletion.enable(productoD.getCampo());
					}
					
					else if(String.valueOf(productoD.getBusqueda().getSelectedItem()).equals("-----------------------")) {
						productoD.getDatoNombre().setVisible(false);
						productoD.getCampo().setVisible(false);
					}
				}
			});
			
			productoD.getBoton().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String nombre = (String) productoD.getCampo().getSelectedItem();
					String data = productoD.getCombo();
					if(!data.equals("-----------------------")) {
						if(!nombre.isEmpty()) {
							if(data.equalsIgnoreCase("Nombre del Producto")) {
								if(tablaProducto.existe(nombre)) {
									if(tablaProducto.getProductByName(nombre).getDisponible() <= tablaProducto.getProductByName(nombre).getCantidadMinima()) {
										productoD.getDatoDisponible().setForeground(new Color(247, 70, 53));
										productoD.mostrarProducto(tablaProducto.getProductByName(nombre));
										JOptionPane.showMessageDialog(null, "Resurtir pronto "+ nombre);
									}
									else {
										productoD.getDatoDisponible().setForeground(new Color(0, 0, 0));
										productoD.mostrarProducto(tablaProducto.getProductByName(nombre));
									}
								}
								else
									JOptionPane.showMessageDialog(null, "Ese producto no existe.", null, JOptionPane.ERROR_MESSAGE);
							}
							else {
								if(tablaProducto.existeCodigo(nombre)) {
									productoD.mostrarProducto(tablaProducto.getProductByCodebar(new BigInteger(nombre)));
								}
								else
									JOptionPane.showMessageDialog(null, "Ese producto no existe.", null, JOptionPane.ERROR_MESSAGE);
							}
						}
						else
							JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Seleccione un m\u00e9todo de b\u00fasqueda.", null, JOptionPane.ERROR_MESSAGE);
				}
			});

			productoD.getBotonResurtir().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registroP = new ResurtirProducto(productoD.getNombre().getText());
					registroP.getBotonResurtir().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							int cantidad = tablaProducto.getMax(tablaProducto.getCodigoBarras(productoD.getNombre().getText()));
							if(registroP.getCantidad() < cantidad) {
								tablaResurtir.guardar(registroP.registrarResurtir(tablaResurtir.getCodigoBarras(registroP.getNombreProducto())));
								int resurtir = registroP.getCantidad();
								int nuevoDato = cantidadNueva(registroP.getNombreProducto(), resurtir);
								tablaProducto.actualizar(nuevoDato, tablaResurtir.getCodigoBarras(registroP.getNombreProducto()));
								registroP.limpiarVentana();
							}
							else {
								int input = JOptionPane.showConfirmDialog(null, "El producto estar\u00e1 en sobreexistencia.\n¿Desea continuar?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if(input == JOptionPane.YES_OPTION) {
									tablaResurtir.guardar(registroP.registrarResurtir(tablaResurtir.getCodigoBarras(registroP.getNombreProducto())));
									int resurtir = registroP.getCantidad();
									int nuevoDato = cantidadNueva(registroP.getNombreProducto(), resurtir);
									tablaProducto.actualizar(nuevoDato, tablaResurtir.getCodigoBarras(registroP.getNombreProducto()));
									registroP.limpiarVentana();
								}
								else {
									registroP.getCampoCantidad().requestFocus();
								}
							}
						}
					});

					registroP.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							registroP.limpiarVentana();
						}
					});

					registroP.setVisible(true);
				}
			});

			contentPane.add(productoD);
			setVisible(true);
		}
	}

	public void ventanaReportes() {
		
		contentPane.removeAll();
		reportes = null;
		venta = null;
		registroProducto = null;
		ventanaInventario = null;
		ventanaProducto = null;
		registrarProducto = null;
		productoD = null;
		registroP = null;
		grafica = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();
		
		if(reportes == null) {
			reportes = new VentanaReportes();
			reportes.mostrarReportes(renglonTicket.getDatos());
			contentPane.add(reportes, BorderLayout.CENTER);
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
		registrarProducto = null;
		productoD = null;
		registroP = null;
		grafica = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();
	}
	
	public void graficas() {
		contentPane.removeAll();
		reportes = null;
		venta = null;
		registroProducto = null;
		ventanaInventario = null;
		ventanaProducto = null;
		registrarProducto = null;
		productoD = null;
		registroP = null;
		grafica = null;
		borrarMenu();
		contentPane.add(titulo, BorderLayout.NORTH);
		repaint();
		
		if(grafica == null) {
			grafica = new VentanaGrafica();
			
			grafica.mostrarTipos(tablaProducto.getTipoProducto());
			grafica.getBotonGraficar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String tipo = grafica.getTipo();
					grafica.mostrarGrafica(tablaProducto.getProductoVendido(tipo), tipo);
				}
			});
			
			grafica.getGraficarTodo().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					grafica.mostrarGraficaTodo(tablaProducto.getProductosTodos());
				}
			});
			contentPane.add(grafica);
			setVisible(true);
		}
	}

	public void datosTicket(List<Compra> compras, int ticket, int empleado) {
		RenglonTicket datos = new RenglonTicket();
		for(Compra compra : compras) {
			datos.setCantidad(compra.getCantidadProducto());
			datos.setCodigoBarra(compra.getCodigoBarras());
			datos.setFolioTicket(ticket);
			datos.setClaveEmpleado(empleado);
			int cantidadAnterior = tablaProducto.getCantidad(compra.getCodigoBarras());
			int nuevoDato = cantidadAnterior - compra.getCantidadProducto();
			tablaProducto.actualizar(nuevoDato, compra.getCodigoBarras());
			renglonTicket.guardar(datos);
		}
	}

	public int cantidadNueva(String nombre, int cantidad) {
		int nuevoDato = tablaProducto.getCantidad(tablaResurtir.getCodigoBarras(nombre));
		nuevoDato += cantidad;
		return nuevoDato;
	}
}