package modelo;

public class DatosRenglonTicket {
	private String nombreProducto;
	private float cantidad;
	private float precioVenta;
	private String fechaVenta;
	private float totalVenta;
	private String nombreEmpleado;
	
	public DatosRenglonTicket() {
		
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public float getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
}