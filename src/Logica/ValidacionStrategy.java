package Logica;

import Dominio.Certificacion;
import Dominio.Estudiante;

public interface ValidacionStrategy {
	boolean validar(Estudiante e, Certificacion c);
}
