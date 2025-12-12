package Logica;

import java.util.ArrayList;

public class Certificacion {
	private String id;
	private String nombre;
	private String descripcion;
	private int creditosRequeridos;
	private int añosValidez;
	private ArrayList<Curso> cursosCertificados;
	
	public Certificacion(String id, String nombre, String descripcion, int creditosRequeridos, int añosValidez) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.creditosRequeridos = creditosRequeridos;
		this.añosValidez = añosValidez;
		this.cursosCertificados = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public int getAñosValidez() {
		return añosValidez;
	}
	
	public ArrayList<Curso> getCursosCertificados() {
		return cursosCertificados;
	}

	public void addCursoCertificado(Curso c) {
		cursosCertificados.add(c);
	}
	
}
