package modelo;

import java.math.BigInteger;

public class Compra {
	private BigInteger codigoBarras;
	private String nombreProducto;
	private int cantidadProducto;
	private float precioProducto;
	private float totalProducto;
	
	public Compra() {
		
	}
	
	public BigInteger getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(BigInteger codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public float getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}
	public float getTotalProducto() {
		return totalProducto;
	}
	public void setTotalProducto(float totalProducto) {
		this.totalProducto = totalProducto;
	}
}