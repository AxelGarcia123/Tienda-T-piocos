package pruebas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import modelo.BaseDatos;
import modelo.Producto;
import modelo.TablaProducto;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		PdfWriter writer = new PdfWriter("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Tienda\\Ticket.pdf");
		PdfDocument document = new PdfDocument(writer);
		// Se crea el documento
		Document documento = new Document();
		documento.add(new Paragraph("Hola mundo"));
		documento.close();
		System.out.println("Correcto");
	}
}