package modelo;

public class Registro {
	private String nombreUsuario;
	private String correoElectronico;
	private String password;
	private int claveEmpleado;
	
	public Registro() {
		
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getClaveEmpleado() {
		return claveEmpleado;
	}
	public void setClaveEmpleado(int claveEmpleado) {
		this.claveEmpleado = claveEmpleado;
	}
}