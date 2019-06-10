package modelo;

import java.math.BigInteger;
import java.sql.Date;

public class Resurtir {
	private BigInteger codigoProducto;
	private int cantidadResurtirda;
	private Date fechaResurtido;
	private float precioUnidad;
	private Date fechaCaducidad;
	
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
	public Date getFechaResurtido() {
		return fechaResurtido;
	}
	public void setFechaResurtido(Date fechaResurtido) {
		this.fechaResurtido = fechaResurtido;
	}
	public float getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
}