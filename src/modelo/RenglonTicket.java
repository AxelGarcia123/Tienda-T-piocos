package modelo;

import java.math.BigInteger;

public class RenglonTicket {
	private int cantidad;
	private BigInteger codigoBarra;
	private int folioTicket;
	private int claveEmpleado;
	
	public RenglonTicket() {
		
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigInteger getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(BigInteger codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public int getFolioTicket() {
		return folioTicket;
	}
	public void setFolioTicket(int folioTicket) {
		this.folioTicket = folioTicket;
	}
	public int getClaveEmpleado() {
		return claveEmpleado;
	}
	public void setClaveEmpleado(int claveEmpleado) {
		this.claveEmpleado = claveEmpleado;
	}
}