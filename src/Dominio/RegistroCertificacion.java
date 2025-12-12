package Dominio;

public class RegistroCertificacion {
	private Certificacion certificacion;
	private String fecha;
	private String estado;
	private int progreso;
	
	public RegistroCertificacion(Certificacion certificacion, String fecha, String estado, int progreso) {
		this.certificacion = certificacion;
		this.fecha = fecha;
		this.estado = estado;
		this.progreso = progreso;
	}

	public Certificacion getCertificacion() {
		return certificacion;
	}

	public String getFecha() {
		return fecha;
	}

	public String getEstado() {
		return estado;
	}

	public int getProgreso() {
		return progreso;
	}
	
	
}
