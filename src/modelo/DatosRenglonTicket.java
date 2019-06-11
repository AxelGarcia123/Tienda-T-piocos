package modelo;

import java.math.BigInteger;
import java.sql.Date;

public class DatosRenglonTicket {
	private String nombreProducto;
	private float cantidad;
	private float precioVenta;
	private Date fechaVenta;
	private float totalVenta;
	private String nombreEmpleado;
	private int numeroTicket;
	private BigInteger codigoBarra;
	
	public BigInteger getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(BigInteger codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public int getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

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
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
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