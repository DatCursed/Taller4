package Singleton;

import Factory.UsuariosFactory;
import Logica.Sistema;
import Logica.Usuario;

public class SistemaImpl implements Sistema {
	private static Sistema instance;
	
	public SistemaImpl() {
	}
	
	public static Sistema getInstance() {
		if (instance == null) {
			instance = new SistemaImpl();
		}
		return instance;
	}

	@Override
	public void buildUsuarios(String[] parts) {
		Usuario u = UsuariosFactory.buildUsuarios(parts);
		
	}

}
