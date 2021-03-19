package edu.escuelaing.arep.app;

/**
 * Clase Usuario que contiene la informacion del usuario a realizar el login en la aplicacion segura
 * @author Camilo
 *
 */
public class Usuario {
	
	public String correo;
	public String password;
	
	/**
	 * Constructor de la clase
	 * @param correo String correo
	 * @param password String password
	 */
	public Usuario (String correo, String password) {
		
		this.correo =  correo;
		this.password = password;
		
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
