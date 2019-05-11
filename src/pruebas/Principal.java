package pruebas;

import modelo.BaseDatos;
import modelo.Producto;
import modelo.TablaProducto;

public class Principal {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos("tiendita", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");

		if (baseDatos.hacerConexion().equals("exito")) {
			Producto producto = new Producto();
			//producto.setCodigoBarras(123);
			producto.setNombre("sdf");
			producto.setTipo("sdf");
			producto.setContenido("sdf");
			producto.setUnidad("sdf");
			producto.setPresentacion("sdf");
			producto.setMarca("sdf");
			producto.setPrecioVenta(3.5);
			
			TablaProducto tabla = new TablaProducto(baseDatos.getConexion());
			tabla.guardar(producto);
			System.out.println("Conexion exitosa");
		}
		
		else 
			System.out.println("error de coneccion");
	}
}