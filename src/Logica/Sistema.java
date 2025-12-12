package Logica;

public interface Sistema {

	void buildUsuarios(String[] parts);

	void buildCursos(String[] parts);

	void buildNotas(String[] parts);

	void buildCertificaciones(String[] parts);

	void buildAsignaciones(String[] parts);

	void buildRegistros(String[] parts);

	Usuario login(String usuario, String contraseña);

	void crearUsuario(Usuario u);

	Usuario buscarUsuario(String username);

	boolean eliminarUsuario(String username);

	boolean restablecerContraseña(String username, String contraseñaNueva);


}
