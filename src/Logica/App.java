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
		
	}

	private static void leerUsuarios() throws FileNotFoundException {
		s = new Scanner(new File("usuarios.txt"));
		
		while (s.hasNextLine()) {
			String[] parts = s.nextLine().split(";");
			sistema.buildUsuarios(parts);
		}
		
	}

}
