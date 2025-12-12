package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Logica.Estudiante;

public class GUIEstudiante extends JFrame {
	private Estudiante estudiante;
	
	public GUIEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
		setTitle("Menú Estudiante");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(4, 1));
		add(new JLabel("Bienvenido: " + estudiante.getNombre(), SwingConstants.CENTER));
		add(new JLabel("Carrera: " + estudiante.getCarrera(), SwingConstants.CENTER));
		add(new JLabel("Semestre: " + estudiante.getSemestre(), SwingConstants.CENTER));
	}
}
