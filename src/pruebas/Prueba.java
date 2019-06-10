package pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prueba extends JFrame {

	private JPanel contentPane;
	private JButton botonPrueba;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		RSDateChooser dateChooser = new RSDateChooser();
		contentPane.add(dateChooser, BorderLayout.CENTER);
		
		botonPrueba = new JButton("Prueba");
		botonPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String formatoFecha = "yyyyMMdd";
				Date fecha = dateChooser.getDatoFecha();
				SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
				System.out.println(formateador.format(fecha));
				String prueba1 = String.valueOf(formateador.format(fecha));
				
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		        Date parsed = null;
				try {
					parsed = format.parse(prueba1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		        System.out.println(sql);

				Fecha fechaPruebas = new Fecha();
				fechaPruebas.setFecha(sql);
				System.out.println(fechaPruebas.getFecha());
			}
		});
		contentPane.add(botonPrueba, BorderLayout.SOUTH);
	}
}
