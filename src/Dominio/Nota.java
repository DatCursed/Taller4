package Dominio;

public class Nota {
	private Curso curso;
	private double calificacion;
	private String estado;
	private String semestre;
	
	public Nota(Curso curso, double calificacion, String estado, String semestre) {
		this.curso = curso;
		this.calificacion = calificacion;
		this.estado = estado;
		this.semestre = semestre;
	}

	public Curso getCurso() {
		return curso;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public String getEstado() {
		return estado;
	}

	public String getSemestre() {
		return semestre;
	}
	
	public boolean aprobado() {
		return estado.equalsIgnoreCase("Aprobado");
	}
}
