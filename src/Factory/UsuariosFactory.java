package Factory;

import java.util.ArrayList;

import Logica.Administrador;
import Logica.Certificacion;
import Logica.Coordinador;
import Logica.Curso;
import Logica.Estudiante;
import Logica.Usuario;

public class UsuariosFactory {
	public static Usuario buildUsuarios(String[] parts) {
		String username = parts[0];
		String contraseña = parts[1];
		String rol = parts[2];
		
		if (parts.length > 4) {
			rol = "estudiante";
		}
		
		switch (rol.toLowerCase()) {
		case "admin":
			return new Administrador(username, contraseña, rol);
			
		case "coordinador":
			String info = parts[3];
			return new Coordinador(username, contraseña, rol, info);
			
		case "estudiante":
			String rut = parts[0];
			String nombre = parts[1];
			String carrera = parts[2];
			int semestre = Integer.parseInt(parts[3]);
			String correo = parts[4];
			contraseña = parts[5];
			return new Estudiante(username, contraseña, rol, rut, nombre, carrera, semestre, correo);
		}
		
		return null;
	}

}
