package Factory;


import Logica.Administrador;
import Logica.Coordinador;
import Logica.Estudiante;
import Logica.Usuario;

public class UsuariosFactory {
	public Usuario buildUsuarios(String[] parts) {
		if (parts.length > 4) {
			String rut = parts[0];
			String nombre = parts[1];
			String carrera = parts[2];
			int semestre = Integer.parseInt(parts[3]);
			String correo = parts[4];
			String contraseña = parts[5];
			
			return new Estudiante(rut, contraseña, "Estudiante", rut, nombre, carrera, semestre, correo);
			
		} else {
			String username = parts[0];
			String contraseña = parts[1];
			String rol = parts[2];
			
			switch (rol.toLowerCase()) {
			case "admin":
				return new Administrador(username, contraseña, rol);
			case "coordinador":
				String info = parts[3];
				return new Coordinador(username, contraseña, rol, info);
			}
		}
		return null;
	}
}
