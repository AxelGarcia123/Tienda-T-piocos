package modelo;

import java.sql.Date;

public class Ticket {
	private Date fecha;
	private float total;
	private int claveEmpleado;
	
	public Ticket() {
		
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getClaveEmpleado() {
		return claveEmpleado;
	}
	public void setClaveEmpleado(int claveEmpleado) {
		this.claveEmpleado = claveEmpleado;
	}
}