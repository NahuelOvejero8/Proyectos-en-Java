package modelo;

public class Cliente extends Persona {
	
	//ATRIBUTOS
	private boolean activo;

	//CONSTRUCTOR
	public Cliente(int idPersona, String nombre, String apellido, long dni, boolean activo) {
		super(idPersona, nombre, apellido, dni);
		this.activo = activo;
	}

	//GETTER Y SETTER
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	//REDEFINICION DEL TO STRING
	@Override
	public String toString() {
		return "\nCliente [activo=" + activo + ", idPersona=" + idPersona + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + "]";
	}



}
