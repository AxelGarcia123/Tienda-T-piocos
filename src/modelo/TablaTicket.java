package modelo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaTicket {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaTicket(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (Exception e) {
			e.toString();
		} 
	}
	
	public String guardar(Ticket ticket) {
		String sql = "insert into ticket values(null,'" + ticket.getFecha() + "','" + ticket.getTotal() + "','" + 
				ticket.getClaveEmpleado() + "')";
		try {
			statement.executeUpdate(sql);
			return "Producto registrado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public int getCodigoTicket(float precio) {
		String sql = "select folio_tic from ticket where total_tic='"+ precio + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("folio_tic");
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
}