package modelo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaEmpleado {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaEmpleado(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (Exception e) {
			e.toString();
		} 
	}
	
	public String guardar(Empleado empleado) {
		String sql = "insert into empleado values(null,'" + empleado.getPaterno() + "','" + empleado.getMaterno() + "','" + 
				empleado.getNombre() + "','" + empleado.getCargo() + "')";
		try {
			statement.executeUpdate(sql);
			return "Producto registrado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public boolean existe(String nombreUsuario) {
		String sql = "select * from empleado where nombre_emp='"+ nombreUsuario + "'";
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
	
	public int getCodigoEmpleado(String nombre) {
		String sql = "select cve_emp from empleado where nombre_emp='"+ nombre + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("cve_emp");
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Error en getCodigoBarras" +e.toString());
			return 0;
		}
	}
	
	public String getNombre(String nombreUsuario) {
		String sql = "select nombre_emp, paterno_emp, materno_emp from registro join "
				+ "empleado on registro.cve_emp = empleado.cve_emp where nombreusuario='"+ nombreUsuario + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String nombre = "";
				nombre += rs.getString("nombre_emp") + " ";
				nombre += rs.getString("paterno_emp") + " ";
				nombre += rs.getString("materno_emp") + " ";
				return nombre;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}