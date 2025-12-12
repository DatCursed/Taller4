package Dominio;

public class Coordinador extends Usuario {
	private String area;

	public Coordinador(String username, String contraseña, String rol, String area) {
		super(username, contraseña, rol);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
}
