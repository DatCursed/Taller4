package Singleton;

import java.util.ArrayList;

import Factory.UsuariosFactory;
import Logica.Certificacion;
import Logica.Curso;
import Logica.Estudiante;
import Logica.Nota;
import Logica.RegistroCertificacion;
import Logica.Sistema;
import Logica.Usuario;

public class SistemaImpl implements Sistema {
	private static Sistema instance;
	
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	private ArrayList<Curso> cursos = new ArrayList<>();
	private ArrayList<Certificacion> certificaciones = new ArrayList<>();
	
	public SistemaImpl() {
	}
	
	public static Sistema getInstance() {
		if (instance == null) {
			instance = new SistemaImpl();
		}
		return instance;
	}

	@Override
	public void buildUsuarios(String[] parts) {
		UsuariosFactory factory = new UsuariosFactory();
		Usuario u = factory.buildUsuarios(parts);
		
		if (u.getRol().equalsIgnoreCase("estudiante")) {
			estudiantes.add((Estudiante) u);
		}
		usuarios.add(u);
	}

	@Override
	public void buildCursos(String[] parts) {
		String nrc = parts[0];
		String nombre = parts[1];
		int semestre =  Integer.parseInt(parts[2]);
		int creditos = Integer.parseInt(parts[3]);
		String area = parts[4];
		
		Curso c = new Curso(nrc, nombre, semestre, creditos, area);
		
		if (parts.length > 5) {
			String[] nrcPrerrequisitos = parts[5].split(",");
			for (String codigos: nrcPrerrequisitos) {
				c.getPrerrequisitos().add(codigos);
			}
		}
		cursos.add(c);
	}

	@Override
	public void buildNotas(String[] parts) {
		Estudiante estudianteEncontrado = buscarEstudiante(parts[0]);
		Curso cursoEncontrado = buscarCurso(parts[1]);
		
		if (estudianteEncontrado != null && cursoEncontrado != null) {
			double calificacion = Double.parseDouble(parts[2]);
			String estado = parts[3];
			String semestre = parts[4];
			
			Nota n = new Nota(cursoEncontrado, calificacion, estado, semestre);
			estudianteEncontrado.addNota(n);
		}
	}
	
	private Curso buscarCurso(String nrc) {
		for (Curso c: cursos) {
			if (c.getNrc().equalsIgnoreCase(nrc)) {
				return c;
			}
		}
		return null;
	}
	
	private Estudiante buscarEstudiante(String rut) {
		for (Estudiante e: estudiantes) {
			if (e.getRut().equalsIgnoreCase(rut)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public void buildCertificaciones(String[] parts) {
		String id = parts[0];
		String nombre = parts[1];
		String desc = parts[2];
		int creditosRequeridos = Integer.parseInt(parts[3]);
		int añosValidez = Integer.parseInt(parts[4]);
		
		Certificacion c = new Certificacion(id, nombre, desc, creditosRequeridos, añosValidez);
		certificaciones.add(c);
	}

	@Override
	public void buildAsignaciones(String[] parts) {
		Certificacion certificacionEncontrada = buscarCertificacion(parts[0]);
		Curso cursoEncontrado = buscarCurso(parts[1]);
		
		if (certificacionEncontrada != null && cursoEncontrado != null) {
			certificacionEncontrada.addCursoCertificado(cursoEncontrado);
		}
	}

	private Certificacion buscarCertificacion(String id) {
		for (Certificacion c: certificaciones) {
			if (c.getId().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void buildRegistros(String[] parts) {
		Estudiante estudianteEncontrado = buscarEstudiante(parts[0]);
		Certificacion certificacionEncontrada = buscarCertificacion(parts[1]);
		
		if (estudianteEncontrado != null && certificacionEncontrada != null) {
			String fecha = parts[2];
			String estado = parts[3];
			int progreso = Integer.parseInt(parts[4]);
			
			RegistroCertificacion registro = new RegistroCertificacion(certificacionEncontrada, fecha, estado, progreso);
			estudianteEncontrado.addRegistro(registro);
		}
	}

	@Override
	public Usuario login(String usuario, String contraseña) {
		for (Usuario u: usuarios) {
			if (u.getUsername().equalsIgnoreCase(usuario) && u.getContraseña().equalsIgnoreCase(contraseña)) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public void crearUsuario(Usuario u) {
		usuarios.add(u);
		
		if (u.getRol().equalsIgnoreCase("Estudiante")) {
			estudiantes.add((Estudiante) u);
		}
	}
	
	@Override
	public boolean eliminarUsuario(String username) {
		Usuario u = buscarUsuario(username);
		
		if (u != null) {
			if (u.getRol().equalsIgnoreCase("Estudiante")) {
				estudiantes.remove(u);
			}
			usuarios.remove(u);
			return true;
		}
		return false;
	}
	
	
	
	public Usuario buscarUsuario(String username) {
		for (Usuario u: usuarios) {
			if (u.getUsername().equalsIgnoreCase(username)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean restablecerContraseña(String username, String contraseñaNueva) {
		Usuario u = buscarUsuario(username);
		if (u != null) {
			u.setContraseña(contraseñaNueva);
			return true;
		}
		return false;
	}

}
