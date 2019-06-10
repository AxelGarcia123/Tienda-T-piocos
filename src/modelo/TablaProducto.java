package modelo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaProducto {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaProducto(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (Exception e) {
			e.toString();
		} 
	}

	public String guardar(Producto producto) {
		String sql = "insert into producto values('"+ producto.getCodigoBarras() + "','" + producto.getNombre() + "','" + producto.getTipo() + "','" + 
				producto.getContenido() + "','" + producto.getUnidad() + "','" + producto.getPresentacion() + "','" + producto.getMarca() + 
				"','" + producto.getPrecioVenta() + "','" + producto.getCantidadMinima() + "','"+ producto.getCantidadMaxima() +"','"+
				producto.getDisponible()+"')";
		try {
			statement.executeUpdate(sql);
			return "Producto registrado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public List<Producto> getProductos(){
		String sql = "select * from producto";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Producto> productos = new ArrayList<>();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(new BigInteger(rs.getString("codbar_pro")));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setTipo(rs.getString("tipo_pro"));
				producto.setContenido(rs.getString("contenido_pro"));
				producto.setUnidad(rs.getString("umedida_pro"));
				producto.setPresentacion(rs.getString("presentacion_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPrecioVenta(rs.getFloat("pventa_pro"));
				producto.setCantidadMinima(rs.getInt("min_pro"));
				producto.setCantidadMaxima(rs.getInt("max_pro"));
				producto.setDisponible(rs.getInt("disponible_pro"));
				productos.add(producto);
			}
			return productos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String nombreProducto(BigInteger codigo) {
		String sql = "select nom_pro from producto where codbar_pro='"+ codigo + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getString("nom_pro");
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public BigInteger getCodigoBarras(String nombre) {
		String sql = "select codbar_pro from producto where nom_pro='"+ nombre + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				BigInteger numeroGrande = BigInteger.valueOf(rs.getLong("codbar_pro"));
				return numeroGrande;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error en getCodigoBarras" +e.toString());
			return null;
		}
	}
	
	public float getPrecio(String nombre) {
		String sql = "select pventa_pro from producto where nom_pro='"+ nombre + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getFloat("pventa_pro");
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Error en getCodigoBarras" +e.toString());
			return 0;
		}
	}
	
	public boolean existe(String nombreProducto) {
		String sql = "select * from producto where nom_pro='"+ nombreProducto + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean existeCodigo(String codigoBarras) {
		String sql = "select * from producto where codbar_pro='"+ codigoBarras + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public void actualizar(int datoNuevo, BigInteger codigo) {
		String sql = "update producto set disponible_pro ='"+ datoNuevo +"' where codbar_pro ='"+ codigo +"'";
		try {
			statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public int getCantidad(BigInteger codigo) {
		String sql = "select disponible_pro from producto where codbar_pro='"+ codigo + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("disponible_pro");
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	
	public int getMax(BigInteger codigo) {
		String sql = "select max_pro from producto where codbar_pro='"+ codigo + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("max_pro");
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	
	public int getMin(BigInteger codigo) {
		String sql = "select min_pro from producto where codbar_pro='"+ codigo + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("min_pro");
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	
	public Producto getProductByName(String name) {
		String sql = "select * from producto where nom_pro = '"+ name+ "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(new BigInteger(rs.getString("codbar_pro")));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setTipo(rs.getString("tipo_pro"));
				producto.setContenido(rs.getString("contenido_pro"));
				producto.setUnidad(rs.getString("umedida_pro"));
				producto.setPresentacion(rs.getString("presentacion_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPrecioVenta(rs.getFloat("pventa_pro"));
				producto.setCantidadMinima(rs.getInt("min_pro"));
				producto.setCantidadMaxima(rs.getInt("max_pro"));
				producto.setDisponible(rs.getInt("disponible_pro"));
				return producto;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Producto getProductByCodebar(BigInteger code) {
		String sql = "select * from producto where codbar_pro = '"+ code + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(new BigInteger(rs.getString("codbar_pro")));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setTipo(rs.getString("tipo_pro"));
				producto.setContenido(rs.getString("contenido_pro"));
				producto.setUnidad(rs.getString("umedida_pro"));
				producto.setPresentacion(rs.getString("presentacion_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPrecioVenta(rs.getFloat("pventa_pro"));
				producto.setCantidadMinima(rs.getInt("min_pro"));
				producto.setCantidadMaxima(rs.getInt("max_pro"));
				producto.setDisponible(rs.getInt("disponible_pro"));
				return producto;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<TipoProducto> getTipoProducto() {
		String sql = "select tipo_pro from producto group by tipo_pro";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<TipoProducto> tipos = new ArrayList<TipoProducto>();
			while (rs.next()) {
				TipoProducto tipo = new TipoProducto();
				tipo.setTipo(rs.getString("tipo_pro"));
				tipos.add(tipo);
			}
			return tipos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<ProductoVendido> getProductoVendido(String tipo) {
		String sql = "select nom_pro, sum(cant_rentic), tipo_pro from renglonticket rt join producto p "
				+ "on rt.codbar_pro = p.codbar_pro where tipo_pro = '"+ tipo +"' group by rt.codbar_pro";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<ProductoVendido> vendidos = new ArrayList<ProductoVendido>();
			while (rs.next()) {
				ProductoVendido vendido = new ProductoVendido();
				vendido.setNombreProducto(rs.getString("nom_pro"));
				vendido.setCantidad(rs.getInt("sum(cant_rentic)"));
				vendido.setTipo(rs.getString("tipo_pro"));
				vendidos.add(vendido);
			}
			return vendidos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<ProductoVendido> getProductosTodos() {
		String sql = "select nom_pro, sum(cant_rentic), tipo_pro from renglonticket rt join producto p "
				+ "on rt.codbar_pro = p.codbar_pro group by rt.codbar_pro";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<ProductoVendido> vendidos = new ArrayList<ProductoVendido>();
			while (rs.next()) {
				ProductoVendido vendido = new ProductoVendido();
				vendido.setNombreProducto(rs.getString("nom_pro"));
				vendido.setCantidad(rs.getInt("sum(cant_rentic)"));
				vendido.setTipo(rs.getString("tipo_pro"));
				vendidos.add(vendido);
			}
			return vendidos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public List<Producto> getFiltro(String filtro) {
		String sql = "select * from producto where nom_pro like '%" + filtro +"%'";
		
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Producto> productos = new ArrayList<>();
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(new BigInteger(rs.getString("codbar_pro")));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setTipo(rs.getString("tipo_pro"));
				producto.setContenido(rs.getString("contenido_pro"));
				producto.setUnidad(rs.getString("umedida_pro"));
				producto.setPresentacion(rs.getString("presentacion_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPrecioVenta(rs.getFloat("pventa_pro"));
				producto.setCantidadMinima(rs.getInt("min_pro"));
				producto.setCantidadMaxima(rs.getInt("max_pro"));
				producto.setDisponible(rs.getInt("disponible_pro"));
				productos.add(producto);
			}
			return productos;
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	public List<Producto> getListaProductos() {
		String sql = "select * from producto";
		
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Producto> productos = new ArrayList<>();
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(new BigInteger(rs.getString("codbar_pro")));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setTipo(rs.getString("tipo_pro"));
				producto.setContenido(rs.getString("contenido_pro"));
				producto.setUnidad(rs.getString("umedida_pro"));
				producto.setPresentacion(rs.getString("presentacion_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPrecioVenta(rs.getFloat("pventa_pro"));
				producto.setCantidadMinima(rs.getInt("min_pro"));
				producto.setCantidadMaxima(rs.getInt("max_pro"));
				producto.setDisponible(rs.getInt("disponible_pro"));
				productos.add(producto);
			}
			return productos;
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	public List<Producto> getListaTipo(String dato) {
		String sql = "select * from producto group by '"+ dato +"'";
		
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Producto> productos = new ArrayList<>();
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(new BigInteger(rs.getString("codbar_pro")));
				producto.setNombre(rs.getString("nom_pro"));
				producto.setTipo(rs.getString("tipo_pro"));
				producto.setContenido(rs.getString("contenido_pro"));
				producto.setUnidad(rs.getString("umedida_pro"));
				producto.setPresentacion(rs.getString("presentacion_pro"));
				producto.setMarca(rs.getString("marca_pro"));
				producto.setPrecioVenta(rs.getFloat("pventa_pro"));
				producto.setCantidadMinima(rs.getInt("min_pro"));
				producto.setCantidadMaxima(rs.getInt("max_pro"));
				producto.setDisponible(rs.getInt("disponible_pro"));
				productos.add(producto);
			}
			return productos;
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
}