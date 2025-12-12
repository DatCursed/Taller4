package Logica;

import Dominio.Certificacion;
import Dominio.Estudiante;
import Dominio.Nota;

public class ValidacionCreditos implements ValidacionStrategy {

	@Override
	public boolean validar(Estudiante e, Certificacion c) {
		int creditosAlumno = 0;
		for (Nota n: e.getNotas()) {
			if (n.getEstado().equalsIgnoreCase("aprobada")) {
				creditosAlumno += n.getCurso().getCreditos();
			}
		}
		return creditosAlumno >= c.getCreditosRequeridos();
	}

}
