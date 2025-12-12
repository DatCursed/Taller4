package Logica;

import java.util.ArrayList;

public class Estudiante extends Usuario {
	private String rut, nombre, carrera;
	private int semestre;
	private String correo;
	private ArrayList<Curso> asignaturasCursadas;
	private ArrayList<Certificacion> certificaciones;
	
	public Estudiante(String username, String contraseña, String rol, String rut, String nombre, String carrera,
			int semestre, String correo) {
		super(username, contraseña, rol);
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.semestre = semestre;
		this.correo = correo;
		this.asignaturasCursadas = new ArrayList<>();
		this.certificaciones = new ArrayList<>();
	}


	public String getRut() {
		return rut;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public int getSemestre() {
		return semestre;
	}

	public String getCorreo() {
		return correo;
	}

	public ArrayList<Curso> getAsignaturasCursadas() {
		return asignaturasCursadas;
	}

	public ArrayList<Certificacion> getCertificaciones() {
		return certificaciones;
	}
	
	
	
	
	
}
