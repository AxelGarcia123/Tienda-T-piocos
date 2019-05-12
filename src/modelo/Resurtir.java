package modelo;

import java.math.BigInteger;

public class Resurtir {
	private BigInteger codigoProducto;
	private int cantidadResurtirda;
	private String fechaResurtido;
	private float precioUnidad;
	private String fechaCaducidad;
	
	public Resurtir() {
		
	}
	
	public BigInteger getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(BigInteger codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCantidadResurtirda() {
		return cantidadResurtirda;
	}
	public void setCantidadResurtirda(int cantidadResurtirda) {
		this.cantidadResurtirda = cantidadResurtirda;
	}
	public String getFechaResurtido() {
		return fechaResurtido;
	}
	public void setFechaResurtido(String fechaResurtido) {
		this.fechaResurtido = fechaResurtido;
	}
	public float getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
}