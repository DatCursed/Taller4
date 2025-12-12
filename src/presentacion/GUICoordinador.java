package presentacion;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Dominio.Coordinador;

public class GUICoordinador extends JFrame {
	private Coordinador coordinador;
	
	public GUICoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
		setTitle("Menú Coordinador");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(4, 1));
	}
}
