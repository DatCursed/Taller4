package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Logica.Administrador;

public class GUIAdmin extends JFrame {
	private Administrador admin;
	
	public GUIAdmin(Administrador admin) {
		this.admin = admin;
		setTitle("Menú Administrador");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(4, 1));
	}
}
