package modelo;

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
	
	public List<Producto> getProducto(){
		String sql = "select * from producto";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Producto> productos = new ArrayList<>();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setCodigoBarras(Integer.parseInt(rs.getString("codbar_pro")));
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
}