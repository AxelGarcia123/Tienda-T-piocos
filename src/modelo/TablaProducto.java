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
				"','" + producto.getPrecioVenta() + "')";
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
				producto.setPrecioVenta(Double.parseDouble(rs.getString("pventa_pro")));
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
	
	public int getPrecio(String nombre) {
		String sql = "select pventa_pro from producto where nom_pro='"+ nombre + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("pventa_pro");
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
}