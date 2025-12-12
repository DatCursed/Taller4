package Logica;

import java.util.ArrayList;

public class Estudiante extends Usuario {
	private String rut, nombre, carrera;
	private int semestre;
	private String correo;
	private ArrayList<Nota> notas;
	private ArrayList<RegistroCertificacion> certificaciones;
	
	public Estudiante(String username, String contraseña, String rol, String rut, String nombre, String carrera,
			int semestre, String correo) {
		super(username, contraseña, rol);
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.semestre = semestre;
		this.correo = correo;
		this.notas = new ArrayList<>();
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

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public ArrayList<RegistroCertificacion> getCertificaciones() {
		return certificaciones;
	}
	
	public void addRegistro(RegistroCertificacion certificacion) {
		certificaciones.add(certificacion);
	}
	
	public void addNota(Nota nota) {
		notas.add(nota);
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
