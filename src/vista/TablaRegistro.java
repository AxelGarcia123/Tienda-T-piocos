package vista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Registro;

public class TablaRegistro {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaRegistro(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (Exception e) {
			e.toString();
		} 
	}
	
	public String guardar(Registro registro) {
		String sql = "insert into registro values(null,'" + registro.getNombreUsuario() + "','" + registro.getCorreoElectronico() + "','" + 
				registro.getPassword() + "','" + registro.getClaveEmpleado() + "')";
		try {
			statement.executeUpdate(sql);
			return "Producto registrado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public boolean existe(String nombreUsuario) {
		String sql = "select * from registro where nombreusuario='"+ nombreUsuario + "'";
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
	
	public boolean validacion(String password) {
		String sql = "select * from registro where contraseña='"+ password + "'";
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
	
	public int getCodigoEmpleado(String nombreUsuario) {
		String sql = "select cve_emp from registro where nombreusuario='"+ nombreUsuario + "'";
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
}