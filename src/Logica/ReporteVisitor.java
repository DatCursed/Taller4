package Logica;

import Dominio.Certificacion;

public class ReporteVisitor implements Visitor {
	private String reporte = "";
	
	@Override
	public void visit(Certificacion c) {
		reporte = "=== REPORTE DE CERTIFICACION ===";
		
		reporte += "ID: " + c.getId() + "\n";
		reporte += "Nombre: " + c.getNombre() + "\n";
		reporte += "Descripción: " + c.getDescripcion() + "\n";
		reporte += "Créditos Requeridos: " + c.getCreditosRequeridos() + "\n";
		
		int cantidadCursos = 0;
		if (c.getCursosCertificados() != null) {
			
		}

		reporte += "Total Asignaturas: " + cantidadCursos + "\n";
		reporte += "====================";
	}

	public String getReporte() {
		return reporte;
	}
	
	

}
