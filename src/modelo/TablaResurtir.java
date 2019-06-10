package modelo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaResurtir {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaResurtir(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (Exception e) {
			e.toString();
		} 
	}
	
	public String guardar(Resurtir resurtir) {
		String sql = "insert into resurtir values(null,'" + resurtir.getFechaResurtido() + "','" + resurtir.getCantidadResurtirda() + "','" + 
				resurtir.getPrecioUnidad() + "','" + resurtir.getFechaCaducidad() + "','" + resurtir.getCodigoProducto() +"')";
		try {
			statement.executeUpdate(sql);
			return "Producto resurtido";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
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
	//select fecha_res, cant_res, ppu_res, fechacad_res, nom_pro from resurtir join producto on resurtir.codbar_pro = producto.codbar_pro
	public List<Resurtir> getResurtidos(){
		String sql = "select * from resurtir";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<Resurtir> resurtidos = new ArrayList<>();
			while (rs.next()) {
				Resurtir resurtir = new Resurtir();
				resurtir.setFechaResurtido(rs.getDate("fecha_res"));
				resurtir.setCantidadResurtirda(Integer.parseInt(rs.getString("cant_res")));
				resurtir.setPrecioUnidad(Float.parseFloat(rs.getString("ppu_res")));
				resurtir.setFechaCaducidad(rs.getDate("fechacad_res"));
				resurtir.setCodigoProducto(new BigInteger(rs.getString("codbar_pro")));
				resurtidos.add(resurtir);
			}
			return resurtidos;
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
	
	public int getCantidad(BigInteger codigo) {
		String sql = "select cant_res from resurtir where codbar_pro='"+ codigo + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("cant_res");
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	
	public void actualizar(int datoNuevo, int datoViejo, BigInteger codigo) {
		String sql = "update resurtir set cant_res ='"+ datoNuevo +"' where codbar_pro ='"+ codigo +"' and cant_res ='"+ datoViejo +"'";
		try {
			statement.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}