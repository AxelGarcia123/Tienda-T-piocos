package modelo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaRenglonTicket {
	private Connection conexion;
	private java.sql.Statement statement;

	public TablaRenglonTicket(Connection conexion) {
		super();
		this.conexion = conexion;

		try {
			statement = conexion.createStatement();
		} catch (Exception e) {
			e.toString();
		} 
	}
	
	public String guardar(RenglonTicket renglon) {
		String sql = "insert into renglonticket values(null,'" + renglon.getCantidad() + "','" + renglon.getCodigoBarra() + "','" + 
				renglon.getFolioTicket() + "','" + renglon.getClaveEmpleado() +"')";
		try {
			statement.executeUpdate(sql);
			return "Producto registrado";
		} catch (SQLException e) {
			System.out.println(e.toString());
			return sql.toString();
		}
	}
	
	public List<DatosRenglonTicket> getDatos(){
		String sql = "select t.folio_tic, nom_pro, cant_rentic, pventa_pro, fecha_tic, total_tic, nombre_emp from ticket t "
				+ "join renglonticket rt on t.folio_tic = rt.folio_tic join producto p on rt.codbar_pro = p.codbar_pro "
				+ "join empleado e on rt.cve_emp = e.cve_emp where fecha_tic = curdate()";
		try {
			ResultSet rs = statement.executeQuery(sql);
			List<DatosRenglonTicket> datos = new ArrayList<>();
			while (rs.next()) {
				DatosRenglonTicket dato = new DatosRenglonTicket();
				dato.setNombreProducto(rs.getString("nom_pro"));
				dato.setCantidad(rs.getFloat("cant_rentic"));
				dato.setPrecioVenta(rs.getFloat("pventa_pro"));
				dato.setFechaVenta(rs.getDate("fecha_tic"));
				dato.setTotalVenta(rs.getFloat("total_tic"));
				dato.setNombreEmpleado(rs.getString("nombre_emp"));
				dato.setNumeroTicket(rs.getInt("folio_tic"));
				datos.add(dato);
			}
			return datos;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}