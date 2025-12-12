package presentacion;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Dominio.Administrador;
import Dominio.Coordinador;
import Dominio.Estudiante;
import Dominio.Sistema;
import Dominio.Usuario;
import Logica.SistemaImpl;

public class GUIAdmin extends JFrame {
	private Administrador admin;
	private Sistema sistema;
	
	public GUIAdmin(Administrador admin) {
		this.admin = admin;
		this.sistema = SistemaImpl.getInstance();
		abrirVentana();
		abrirComponentes();
	}

	private void abrirComponentes() {
		JButton botonCrear = new JButton("Crear nuevo usuario");
		botonCrear.addActionListener(e -> crearUsuario());
		add(botonCrear);
		
		JButton botonModificar = new JButton("Modificar usuario");
		botonModificar.addActionListener(e -> modificarUsuario());
		add(botonModificar);
		
		JButton botonEliminar = new JButton("Eliminar un usuario");
		botonEliminar.addActionListener(e -> eliminarUsuario());
		add(botonEliminar);
		
		JButton botonReset = new JButton("Restablecer contraseña");
		botonReset.addActionListener(e -> restablecerContraseña());
		add(botonReset);
		
		JButton botonSalir = new JButton("Cerrar sesión");
		botonSalir.addActionListener(e -> {
			this.dispose();
			new GUI().setVisible(true);
		});
		add(botonSalir);
		
	}
	
	private void restablecerContraseña() {
		JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
		
		JTextField txtUsername = new JTextField();
		JTextField txtContraseña = new JTextField();
		
		panel.add(new JLabel("Usuario/RUT"));
		panel.add(txtUsername);
		panel.add(new JLabel("Nueva contraseña"));
		panel.add(txtContraseña);
		
		int resultado = JOptionPane.showConfirmDialog(this, panel, "Restablecer Contraseña", JOptionPane.CANCEL_OPTION);
		
		if (resultado == JOptionPane.OK_OPTION) {
			String username = txtUsername.getText();
			String contraseñaNueva = txtContraseña.getText();
			
			if (!username.isEmpty() && !contraseñaNueva.isEmpty()) {
				boolean exito = sistema.restablecerContraseña(username, contraseñaNueva);
				if (exito) {
					JOptionPane.showMessageDialog(this, "Contraseña actualizada");
				} else {
					JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Debe completar ambos campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void eliminarUsuario() {
		String username = JOptionPane.showInputDialog(this, "Ingrese el Username del usuario que desea modificar");
		
		if (username != null) {
			boolean eliminado = sistema.eliminarUsuario(username);
			
			if (eliminado) {
				JOptionPane.showMessageDialog(this, "Usuario Eliminado.");
			} else {
				JOptionPane.showMessageDialog(this, "Error: Usuario no encontrado.");
			}
		}
	}

	private void modificarUsuario() {
		String username = JOptionPane.showInputDialog(this, "Ingrese el Username del usuario que desea modificar");
		Usuario u = sistema.buscarUsuario(username);
		
		if (u != null) {
			if (u.getRol().equalsIgnoreCase("Estudiante")) {
				modificarEstudiante((Estudiante)u);
			} else if (u.getRol().equalsIgnoreCase("Coordinador")) {
				modificarCoordinador((Coordinador)u);
			} else {
				JOptionPane.showMessageDialog(this, "Usuario no encontrado");
			}
		}
	}
	
	private void modificarCoordinador(Coordinador c) {
		JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
		
		JTextField txtArea = new JTextField(c.getArea());
		JTextField txtContraseña = new JTextField(c.getContraseña());
		
		panel.add(new JLabel("Área de coordinación:"));
		panel.add(txtArea);
		panel.add(new JLabel("Contraseña:"));
		panel.add(txtContraseña);
		
		int reset = JOptionPane.showConfirmDialog(this, panel, "Modificar Coordinador", JOptionPane.CANCEL_OPTION);
		
		if (reset == JOptionPane.OK_OPTION) {
			c.setArea(txtArea.getText());
			c.setContraseña(txtContraseña.getText());
			
			JOptionPane.showMessageDialog(this, "Coordinador modificado");
		}
	}

	private void modificarEstudiante(Estudiante e) {
		JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
		
		JTextField txtNombre = new JTextField(e.getNombre());
		JTextField txtCarrera = new JTextField(e.getCarrera());
		JTextField txtSemestre = new JTextField(String.valueOf(e.getSemestre()));
		JTextField txtCorreo = new JTextField(e.getCorreo());
		JTextField txtContraseña = new JTextField(e.getContraseña());
		
		panel.add(new JLabel("Nombre:"));
		panel.add(txtNombre);
		panel.add(new JLabel("Carrera:"));
		panel.add(txtCarrera);
		panel.add(new JLabel("Semestre:"));
		panel.add(txtSemestre);
		panel.add(new JLabel("Correo:"));
		panel.add(txtCorreo);
		panel.add(new JLabel("Contraseña:"));
		panel.add(txtContraseña);
		
		int reset = JOptionPane.showConfirmDialog(this, panel, "Modificar Estudiante", JOptionPane.CANCEL_OPTION);
		
		if (reset == JOptionPane.OK_OPTION) {
			try {
				e.setNombre(txtNombre.getText());
				e.setCarrera(txtCarrera.getText());
				e.setSemestre(Integer.parseInt(txtSemestre.getText()));
				e.setCorreo(txtCorreo.getText());
				e.setContraseña(txtContraseña.getText());
				
				JOptionPane.showMessageDialog(this, "Estudiante modificado");
			} catch (NumberFormatException err) {
				JOptionPane.showMessageDialog(this, "Error: El semestre debe ser un número");
			}
		}
	}
	
	

	private void crearUsuario() {
		String[] opciones = {"Coordinador", "Estudiante"};
		int tipo = JOptionPane.showOptionDialog(this, "¿Qué tipo de usuario desea crear?", "Crear Usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		switch (tipo) {
		case 0:
			crearCoordinador();
			break;
		case 1:
			crearEstudiante();
			break;
		default:
			System.out.println("Error. Reingresa.");
		}
	}

	private void crearEstudiante() {
		JPanel panelCoordinador = new JPanel(new GridLayout(6, 2, 5, 5));
		
		JTextField txtRut = new JTextField();
		JTextField txtContraseña = new JTextField();
		JTextField txtNombre = new JTextField();
		JTextField txtCarrera = new JTextField();
		JTextField txtSemestre = new JTextField();
		JTextField txtCorreo = new JTextField();
		
		panelCoordinador.add(new JLabel("RUT:"));
		panelCoordinador.add(txtRut);
		
		panelCoordinador.add(new JLabel("Contraseña:"));
		panelCoordinador.add(txtContraseña);	
		
		panelCoordinador.add(new JLabel("Nombre:"));
		panelCoordinador.add(txtNombre);
		
		panelCoordinador.add(new JLabel("Carrera:"));
		panelCoordinador.add(txtCarrera);
		
		panelCoordinador.add(new JLabel("Semestre:"));
		panelCoordinador.add(txtSemestre);	
		
		panelCoordinador.add(new JLabel("Correo"));
		panelCoordinador.add(txtCorreo);
		
		int opcion = JOptionPane.showConfirmDialog(this, panelCoordinador, "Nuevo Estudiante", JOptionPane.OK_CANCEL_OPTION);
		
		if (opcion == JOptionPane.OK_OPTION) {
			try {
				int sem = Integer.parseInt(txtSemestre.getText());
				Estudiante e = new Estudiante(txtRut.getText(), txtContraseña.getText(), "Estudiante", txtRut.getText(), txtNombre.getText(), txtCarrera.getText(), sem, txtCorreo.getText());
				sistema.crearUsuario(e);
				JOptionPane.showMessageDialog(this, "Estudiante creado.");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error: El semestre debe ser un número.");
			}
		}
		
	}

	private void crearCoordinador() {
		JPanel panelCoordinador = new JPanel(new GridLayout(3, 2, 5, 5));
		
		JTextField txtUsuario = new JTextField();
		JTextField txtContraseña = new JTextField();
		JTextField txtArea = new JTextField();
		
		panelCoordinador.add(new JLabel("Usuario:"));
		panelCoordinador.add(txtUsuario);
		
		panelCoordinador.add(new JLabel("Contraseña:"));
		panelCoordinador.add(txtContraseña);	
		
		panelCoordinador.add(new JLabel("Área:"));
		panelCoordinador.add(txtArea);
		
		int opcion = JOptionPane.showConfirmDialog(this, panelCoordinador, "Nuevo Coordinador", JOptionPane.OK_CANCEL_OPTION);
		
		if (opcion == JOptionPane.OK_OPTION) {
			Coordinador c = new Coordinador(txtUsuario.getText(), txtContraseña.getText(), "Coordinador", txtArea.getText());
			sistema.crearUsuario(c);
			JOptionPane.showMessageDialog(this, "Coordinador creado.");
		}
		
	}

	private void abrirVentana() {
		setTitle("Menú de Administrador");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 1, 10, 10));
	}
}
