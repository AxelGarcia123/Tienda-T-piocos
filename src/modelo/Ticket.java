package modelo;

public class Ticket {
	private String fecha;
	private float total;
	private int claveEmpleado;
	
	public Ticket() {
		
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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