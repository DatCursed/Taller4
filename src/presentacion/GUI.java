/*
David Rodríguez Sebastían Guevara
21.806.579-1
ICCI
*/

package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dominio.Administrador;
import Dominio.Coordinador;
import Dominio.Estudiante;
import Dominio.Sistema;
import Dominio.Usuario;
import Logica.SistemaImpl;

public class GUI extends JFrame {
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private Sistema sistema;
	
	public GUI() {
		this.sistema = SistemaImpl.getInstance();
		ventana();
		componentes();
	}

	private void componentes() {
		JPanel panelUsuario = new JPanel();
		panelUsuario.add(new JLabel("Usuario / RUT:"));
		txtUsuario = new JTextField(15);
		panelUsuario.add(txtUsuario);
		add(panelUsuario);
		
		JPanel panelContraseña = new JPanel();
		panelContraseña.add(new JLabel("Contraseña: "));
		txtContraseña = new JTextField(15);
		panelContraseña.add(txtContraseña);
		add(panelContraseña);
		
		JPanel panelBoton = new JPanel();
		JButton botonera = new JButton("Ingresar");
		botonera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verificar();
			}
		});
		
		panelBoton.add(botonera);
		add(panelBoton);
	}

	private void verificar() {
		String usuario = txtUsuario.getText();
		String contraseña = txtContraseña.getText();
		
		Usuario u = sistema.login(usuario, contraseña);
		
		if (u != null) {
			JOptionPane.showMessageDialog(this, "Bienvenido " + u.getUsername());
			this.dispose();
			
			String rol = u.getRol();
			
			switch (rol.toLowerCase()) {
			case "estudiante":
				new GUIEstudiante((Estudiante) u).setVisible(true);
				break;
			case "admin":
				new GUIAdmin((Administrador) u).setVisible(true);
				break;
			case "coordinador":
				new GUICoordinador((Coordinador) u).setVisible(true);
				break;
			default:
				JOptionPane.showMessageDialog(this, "Error: Rol no reconocido " + "(" + rol + ")");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void ventana() {
		setTitle("AcademiCore");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4,1));
	}
	
}
