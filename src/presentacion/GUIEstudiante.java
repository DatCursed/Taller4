package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Dominio.Administrador;
import Dominio.Coordinador;
import Dominio.Estudiante;
import Dominio.Sistema;
import Dominio.Usuario;
import Logica.SistemaImpl;

public class GUIEstudiante extends JFrame {
	private Estudiante estudiante;
	private Sistema sistema;
	
	public GUIEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
		this.sistema = SistemaImpl.getInstance();
		abrirVentana();
		abrirComponentes();
	}

	private void abrirComponentes() {
		JTabbedPane tabs = new JTabbedPane();
		
		tabs.addTab("Mi perfil", crearPanelPerfil());
		tabs.addTab("Malla Curricular", crearPanelMalla());
		tabs.addTab("Certificaciones", crearPanelCertificaciones());
		
		add(tabs);
	}

	private Component crearPanelCertificaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	private Component crearPanelMalla() {
		// TODO Auto-generated method stub
		return null;
	}

	private JPanel crearPanelPerfil() {
		JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		panel.add(new JLabel("Nombre: " + estudiante.getNombre()));
		panel.add(new JLabel("RUT: " + estudiante.getRut()));
		panel.add(new JLabel("Carrera: " + estudiante.getCarrera()));
		panel.add(new JLabel("Semestre actual: " + estudiante.getSemestre()));
		panel.add(new JLabel("Correo: " + estudiante.getCorreo()));
		
		double promedio = sistema.calcularPromedio(estudiante);
		JLabel jlpromedio = new JLabel("Promedio General: " + String.format("%.1f", promedio));
		jlpromedio.setFont(new Font("Arial", Font.BOLD, 16));
		jlpromedio.setForeground(new Color(0, 102, 204));
		panel.add(jlpromedio);
		
		return panel;
	}

	private void abrirVentana() {
		setTitle("Menú de Estudiante");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
