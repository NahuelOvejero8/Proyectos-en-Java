package modelo;

public class Empleado extends Persona {
	
	
	//ATRIBUTOS
	private int sueldoBase;

	
	//CONSTRUCTOR
	public Empleado(int idPersona, String nombre, String apellido, long dni, int sueldoBase) {
		super(idPersona, nombre, apellido, dni);
		this.sueldoBase = sueldoBase;
	}

	
	//GETTER Y SETTER
	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	
	
	//REDEFINICION DEL TO STRING
	@Override
	public String toString() {
		return "\nEmpleado [sueldoBase=" + sueldoBase + ", idPersona=" + idPersona + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + "]";
	}

	
	//SOBRECARGA DE EQUALS
	public boolean equals(Empleado empleado)
	{
		return empleado.getDni() == this.dni;
	}

}
