package Logica;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import Singleton.SistemaImpl;

public class App {
	private static Scanner s;
	private static Sistema sistema = SistemaImpl.getInstance();
	
	public static void main(String[] args) throws FileNotFoundException {
		leerArchivos();
	}

	private static void leerArchivos() throws FileNotFoundException {
		leerUsuarios();
		leerEstudiantes();
		leerCursos();
		leerNotas();
		leerCertificaciones();
		leerAsignaciones();
		leerRegistros();
	}
	
	private static void leerRegistros() throws FileNotFoundException {
		s = new Scanner(new File("registros.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildRegistros(parts);
		}
	}

	private static void leerAsignaciones() throws FileNotFoundException {
		s = new Scanner(new File("asignaturas_certificaciones.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildAsignaciones(parts);
		}
	}
	
	private static void leerCertificaciones() throws FileNotFoundException {
		s = new Scanner(new File("certificaciones.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildCertificaciones(parts);
		}
	}

	private static void leerNotas() throws FileNotFoundException {
		s = new Scanner(new File("notas.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildNotas(parts);
		}
	}
	
	private static void leerCursos() throws FileNotFoundException {
		s = new Scanner(new File("cursos.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildCursos(parts);
		}
	}
	
	private static void leerEstudiantes() throws FileNotFoundException {
		s = new Scanner(new File("estudiantes.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildUsuarios(parts);
		}
	}

	private static void leerUsuarios() throws FileNotFoundException {
		s = new Scanner(new File("usuarios.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildUsuarios(parts);
		}
	}

}
